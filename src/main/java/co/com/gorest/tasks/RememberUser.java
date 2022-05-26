package co.com.gorest.tasks;

import co.com.gorest.models.UsersModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.gorest.enums.Keys.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RememberUser implements Task {

    public static RememberUser created() {
        return instrumented(RememberUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(USER.value(), SerenityRest.lastResponse().as(UsersModel.class));
    }
}
