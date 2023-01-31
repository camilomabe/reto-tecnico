package com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.ui.MenuMeetingPage.LINK_MEETING;
import static com.ui.MenuMeetingPage.LINK_MEETINGS;

public class GoesMeeting implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesMeeting.class);
    }

    @Override
    @Step("{0} is going to meeting")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_MEETING));
        actor.attemptsTo(Click.on(LINK_MEETINGS));
    }
}
