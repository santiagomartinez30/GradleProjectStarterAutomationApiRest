package co.com.gorest.steps;


import co.com.gorest.consequences.SeeThatModifyUser;
import co.com.gorest.factories.UserFactory;
import co.com.gorest.tasks.CreateUser;
import co.com.gorest.tasks.ModifyUser;
import co.com.gorest.tasks.RememberUser;
import io.cucumber.java.en.*;

import static co.com.gorest.enums.Keys.USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ModifyUsersSteps {

    @Given("que usuario {word} registra usuario con datos {word} en la pagina")
    public void userRegisterClientWithCorrectData(String nameActor, String code) {
        theActorCalled(nameActor).wasAbleTo(
                CreateUser.withData(UserFactory.with(code)),
                RememberUser.created()
        );
    }

    @When("modifica correctamente los datos del usuario")
    public void modifyUserWithCorrectData() {
        theActorInTheSpotlight().attemptsTo(
                ModifyUser.withDataDefault()
        );
    }

    @Then("el puede actualizar la información del usuario")
    public void heCanUpdateUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatModifyUser.correct(theActorInTheSpotlight().recall(USER.value()))
        );
    }
}
