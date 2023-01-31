package com.stepsdefinitions;

import com.interactions.DeleteBusinessUnit;
import com.questions.ValidatesBusinessUnit;
import com.tasks.CreatesNewBusinessUnit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;

import static com.utils.SessionVariables.BUSINESS_UNIT_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NewUnitStepsDefinitions {

    @Given("^he creates new business unit as (.*)$")
    public void createNewBusinessUnit(String businessUnit) {
        theActorInTheSpotlight().attemptsTo(CreatesNewBusinessUnit.letsGo(businessUnit));
    }

    @When("^he should see the business unit name$")
    public void validatesBusinessUnitName() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessUnit.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(BUSINESS_UNIT_NAME.toString()))));
    }

    @Then("^he should delete business unit$")
    public void deleteBusinessUnit() {
        theActorInTheSpotlight().attemptsTo(DeleteBusinessUnit.letsGo());
    }

}
