package com.stepsdefinitions;

import com.questions.ValidatesBusinessMeeting;
import com.tasks.CreatesBusinessMeeting;
import com.tasks.DeletesSchedules;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.CoreMatchers;

import java.util.Map;

import static com.utils.SessionVariables.MEETING_NAME_VALUE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ScheduleStepsDefinitions {

    @And("^he schedules a business meeting$")
    public void scheduleAMeet(Map<String, String> meetingInfo) {
        theActorInTheSpotlight().attemptsTo(CreatesBusinessMeeting.letsGo(meetingInfo));
    }

    @Then("^he should see the business meeting$")
    public void validatesBusinessMeeting() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessMeeting.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(MEETING_NAME_VALUE.toString()))));
    }

    @And("^he should delete meeting and unit$")
    public void cleanSchedules() {
        theActorInTheSpotlight().attemptsTo(DeletesSchedules.letsGo());
    }

}
