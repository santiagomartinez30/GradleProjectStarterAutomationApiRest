package co.com.gorest.steps;


import co.com.gorest.consequences.SeeThatCreateUser;
import co.com.gorest.factories.UserFactory;
import co.com.gorest.models.UsersModel;
import co.com.gorest.tasks.CreateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterUserSteps {
    private UsersModel userModel;

    @Given("que usuario {word} ingresa datos {word} de usuario")
    public void userSetData(String nameActor, String codeData) {
        userModel = UserFactory.with(codeData);
        theActorCalled(nameActor).wasAbleTo(
                CreateUser.withData(userModel)
        );
    }

    @When("el puede registrar usuario en la pagina")
    public void heCanRegisterUserIntoPage() {
        theActorInTheSpotlight().should(
                SeeThatCreateUser.correct(userModel)
        );

    }

    @When("el no puede registrar usuario en la pagina con datos incorrectos")
    public void heCanNotRegisterUserIntoPageWithDataIncorect() {
        theActorInTheSpotlight().should(
                SeeThatCreateUser.incorrect()
        );
    }

    @When("el no puede registrar usuario en la pagina con datos existentes")
    public void heCanNotRegisterUserIntoPageWithDataExisting() {
        theActorInTheSpotlight().should(
                SeeThatCreateUser.incorrect()
        );
    }
}
