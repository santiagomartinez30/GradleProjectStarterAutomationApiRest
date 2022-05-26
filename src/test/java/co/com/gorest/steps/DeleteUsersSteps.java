package co.com.gorest.steps;

import co.com.gorest.consequences.SeeThatDeleteUser;
import co.com.gorest.tasks.EliminateUser;
import co.com.gorest.tasks.GetUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.gorest.enums.Keys.ID_USER_TO_ELIMINATED;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUsersSteps {
    @Given("que usuario {word} obtiene aleatoreamente un usuario a eliminar")
    public void userGetRandomClienToEliminate(String nameActor) {
        theActorCalled(nameActor).wasAbleTo(
                GetUsers.random()
        );
    }

    @When("elimina el usuario")
    public void eliminateUser() {
        theActorInTheSpotlight().attemptsTo(
                EliminateUser.withId(theActorInTheSpotlight().recall(ID_USER_TO_ELIMINATED.value()))
        );

    }

    @Then("el puede confirmar la eliminación del usuario")
    public void heCanConfirmUserEliminated() {
        theActorInTheSpotlight().should(
                SeeThatDeleteUser.correct()
        );
    }
}
