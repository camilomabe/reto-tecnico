package com.stepsdefinitions;

import com.questions.ValidatesUser;
import com.tasks.LogIn;
import com.utils.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepsDefinitions {

    @Before
    public void startsPage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens the browser in the home page$")
    public void opensBrowserOnHomePage(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theWebSideHome());
    }

    @When("^he enters his credentials, (.*) and (.*)$")
    public void entersTheCredentials(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(LogIn.forLoginIn(user, pass));
    }

    @Given("^he should see the (.*) in the login home$")
    public void validatesTheTextInThePaymentForm(String user) {
        theActorInTheSpotlight().should(seeThat(ValidatesUser.displayed(), CoreMatchers.equalTo(user)));
    }

}
