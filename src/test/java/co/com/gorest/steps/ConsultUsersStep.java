package co.com.gorest.steps;

import co.com.gorest.consequences.SeeThatConsultUser;
import co.com.gorest.enums.EndPoints;
import co.com.gorest.tasks.GetUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultUsersStep {

    private String idUser;

    @Given("que usuario {word} consulta un usuario por id {word}")
    public void consultUserForId(String nameActor, String id) {
        idUser = id;
        theActorCalled(nameActor).wasAbleTo(
                GetUser.withData(idUser)
        );
    }

    @Then("el puede obtener información de usuario")
    public void obtainUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatConsultUser.correct(idUser)
        );
    }

    @Then("el no puede obtener información de usuario")
    public void canNotobtainUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatConsultUser.incorrect()
        );
    }
}
