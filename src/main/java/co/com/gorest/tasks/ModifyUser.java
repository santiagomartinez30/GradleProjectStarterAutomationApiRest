package co.com.gorest.tasks;

import co.com.gorest.models.UsersModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import org.apache.http.HttpHeaders;

import static co.com.gorest.enums.EndPoints.USER_FOR_ID;
import static co.com.gorest.enums.Keys.USER;
import static co.com.gorest.enums.Token.ACCES_TOKEN;
import static co.com.gorest.enums.Values.NEW_NAME_USER;
import static co.com.gorest.enums.Values.NEW_STATUS_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ModifyUser implements Task {
    private final ObjectMapper objectMapper;
    private final UsersModel usersModel;

    public ModifyUser() {
        this.objectMapper = new ObjectMapper();
        this.usersModel = theActorInTheSpotlight().recall(USER.value());
    }

    public static ModifyUser withDataDefault() {
        return instrumented(ModifyUser.class);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        setUpData();
        actor.remember(USER.value(), usersModel);
        String json = objectMapper.writeValueAsString(usersModel);
        actor.attemptsTo(
                Patch.to(USER_FOR_ID.resource().concat(usersModel.getId()))
                        .with(request -> request
                                .auth().oauth2(ACCES_TOKEN.message())
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .body(json)
                        )
        );
    }

    public void setUpData() {
        usersModel.setName(NEW_NAME_USER.text());
        usersModel.setStatus(NEW_STATUS_USER.text());
    }
}
