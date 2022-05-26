package co.com.gorest.tasks;

import co.com.gorest.models.UsersModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.openqa.selenium.NotFoundException;

import java.util.Arrays;

import static co.com.gorest.enums.EndPoints.USERS;

import static co.com.gorest.enums.Keys.ID_USER_TO_ELIMINATED;
import static co.com.gorest.enums.Token.ACCES_TOKEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    public static GetUsers random() {
        return instrumented(GetUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(USERS.resource())
                        .with(request -> request
                                .auth().oauth2(ACCES_TOKEN.message())
                        )
        );
        actor.remember(ID_USER_TO_ELIMINATED.value(), Arrays.stream(SerenityRest.lastResponse().as(UsersModel[].class))
                .filter(user -> user.getStatus().equals("active"))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("data %s not found", "active"))));
    }
}
