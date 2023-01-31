package com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.ui.CommonTargetsPage.BTN_YES;
import static com.ui.CommonTargetsPage.ICON_DELETE;

public class RemovesEvents implements Interaction {

    public static Performable delete() {
        return Tasks.instrumented(RemovesEvents.class);
    }

    @Override
    @Step("{0} delete schedule")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ICON_DELETE));
        actor.attemptsTo(Click.on(BTN_YES));
    }
}
