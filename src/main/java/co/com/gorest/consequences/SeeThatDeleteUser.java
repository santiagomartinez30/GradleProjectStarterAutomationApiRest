package co.com.gorest.consequences;

import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.hamcrest.CoreMatchers;

import static co.com.gorest.enums.Values.BODY_EMPTY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatDeleteUser {
    private SeeThatDeleteUser() {

    }

    public static Consequence[] correct() {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(204)),
                seeThat("Body",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getBody().asString(), CoreMatchers.equalTo(BODY_EMPTY.text()))
        };
    }
}
