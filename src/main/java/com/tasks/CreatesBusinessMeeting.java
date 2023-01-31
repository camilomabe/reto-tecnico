package com.tasks;

import com.interactions.GoesMeeting;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static com.ui.CommonTargetsPage.SAVE_AND_CLOSE_BUTTON;
import static com.ui.MeetingPage.*;
import static com.utils.Constants.*;
import static com.utils.SessionVariables.BUSINESS_UNIT_NAME;
import static com.utils.SessionVariables.MEETING_NAME_VALUE;


public class CreatesBusinessMeeting implements Task {

    private final Map<String, String> meetingInfo;

    public CreatesBusinessMeeting(Map<String, String> meetingInfo) {
        this.meetingInfo = meetingInfo;
    }

    public static Performable letsGo(Map<String, String> meetingInfo) {
        return Tasks.instrumented(CreatesBusinessMeeting.class, meetingInfo);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {
        String unitName = actor.recall(BUSINESS_UNIT_NAME.toString());
        actor.remember(MEETING_NAME_VALUE.toString(), meetingInfo.get(MEETING_NAME));
        actor.attemptsTo(GoesMeeting.letsGo());
        actor.attemptsTo(Click.on(NEW_MEETING));
        actor.attemptsTo(Enter.theValue(meetingInfo.get(MEETING_NAME)).into(TXT_MEETING_NAME));
        actor.attemptsTo(Click.on(LIST_MEETING_TYPE));
        actor.attemptsTo(Click.on(lblMeetingOptions(MEETING_TYPE, meetingInfo.get(MEETING_TYPE))));
        actor.attemptsTo(Type.theValue(meetingInfo.get(MEETING_NUMBER)).into(TXT_MEETING_NUMBER));
        actor.attemptsTo(Click.on(LIST_LOCATION));
        actor.attemptsTo(Click.on(lblMeetingOptions(MEETING_LOCATION, meetingInfo.get(MEETING_LOCATION))));
        actor.attemptsTo(Click.on(LIST_UNIT));
        actor.attemptsTo(Click.on(lblMeetingOptions(MEETING_UNIT, unitName)));
        actor.attemptsTo(Click.on(LIST_ORGANIZED_BY));
        actor.attemptsTo(Click.on(lblMeetingOptions(ORGANIZED_BY, meetingInfo.get(ORGANIZED_BY))));
        actor.attemptsTo(Click.on(LIST_REPORT));
        actor.attemptsTo(Click.on(lblMeetingOptions(REPORTER, meetingInfo.get(REPORTER))));
        actor.attemptsTo(Click.on(LIST_ATTENDEE));
        actor.attemptsTo(Click.on(lblMeetingOptions(ATTENDEE_LIST, meetingInfo.get(ATTENDEE_LIST))));
        actor.attemptsTo(Click.on(SAVE_AND_CLOSE_BUTTON));
    }
}
