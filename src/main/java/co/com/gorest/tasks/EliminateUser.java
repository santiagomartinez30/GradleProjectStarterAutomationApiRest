package co.com.gorest.tasks;

import co.com.gorest.models.UsersModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.gorest.enums.EndPoints.USER_FOR_ID;
import static co.com.gorest.enums.Token.ACCES_TOKEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminateUser implements Task {

    private final UsersModel usersModel;

    public EliminateUser(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public static EliminateUser withId(UsersModel usersModel) {
        return instrumented(EliminateUser.class, usersModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USER_FOR_ID.resource().concat(usersModel.getId()))
                        .with(request -> request
                                .auth().oauth2(ACCES_TOKEN.message())
                        )
        );
    }
}
