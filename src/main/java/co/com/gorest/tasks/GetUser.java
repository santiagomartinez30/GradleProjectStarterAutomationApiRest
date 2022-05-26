package co.com.gorest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.gorest.enums.EndPoints.USER_FOR_ID;
import static co.com.gorest.enums.Token.ACCES_TOKEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {

    private final String id;


    public GetUser(String id) {
        this.id = id;
    }

    public static GetUser withData(String id) {
        return instrumented(GetUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(USER_FOR_ID.resource().concat(id))
                        .with(
                                request -> request
                                        .auth().oauth2(ACCES_TOKEN.message())
                        )
        );
    }
}
