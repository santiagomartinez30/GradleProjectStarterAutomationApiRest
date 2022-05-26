package co.com.gorest.tasks;

import co.com.gorest.models.UsersModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import java.util.Random;

import static co.com.gorest.enums.EndPoints.USERS;
import static co.com.gorest.enums.Token.ACCES_TOKEN;
import static co.com.gorest.enums.Values.CREATE_USER_EXISTING;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private final UsersModel usersModel;
    private final ObjectMapper objectMapper;
    private final int numeroEmail;

    public CreateUser(UsersModel usersModel) {
        this.usersModel = usersModel;
        this.objectMapper = new ObjectMapper();
        this.numeroEmail = new Random().nextInt(9999);
    }

    public static CreateUser withData(UsersModel usersModel) {
        return instrumented(CreateUser.class, usersModel);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        setUpData();
        String json = objectMapper.writeValueAsString(usersModel);
        actor.attemptsTo(
                Post.to(USERS.resource())
                        .with(request -> request
                                .auth().oauth2(ACCES_TOKEN.message())
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .body(json)
                        )
        );
    }

    private void setUpData() {
        if (Boolean.FALSE.equals(usersModel.getId().equals(CREATE_USER_EXISTING.text()))) {
            usersModel.setEmail(numeroEmail + usersModel.getEmail());
        }
    }
}
