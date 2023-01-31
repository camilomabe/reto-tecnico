package com.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.ui.CommonTargetsPage.SEARCH_BY_NAME;
import static com.ui.CommonTargetsPage.labelSearch;
import static com.utils.SessionVariables.MEETING_NAME_VALUE;

public class ValidatesBusinessMeeting implements Question<String> {

    public static Question<String> wasCreate() {
        return new ValidatesBusinessMeeting();
    }

    @Override
    @Step("{0} searches meeting name")
    public String answeredBy(Actor actor) {
        String meetingName = actor.recall(MEETING_NAME_VALUE.toString());
        actor.attemptsTo(Enter.theValue(meetingName).into(SEARCH_BY_NAME));
        return labelSearch(meetingName).resolveFor(actor).getText();
    }
}
