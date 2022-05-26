package co.com.gorest.consequences;

import co.com.gorest.models.UsersModel;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatModifyUser {
    private SeeThatModifyUser() {

    }

    public static Consequence[] correct(UsersModel usersModel) {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(200)),
                seeThat("schema user validation",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/consult_users.json")),
                seeThat("name value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UsersModel.class).getName(),
                        equalTo(usersModel.getName())),
                seeThat("status value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UsersModel.class).getStatus(),
                        equalTo(usersModel.getStatus()))
        };
    }
}
