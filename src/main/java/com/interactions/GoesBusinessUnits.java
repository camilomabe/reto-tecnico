package com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.ui.MenuOrganizationPage.LINK_BUSINESS_UNITS;
import static com.ui.MenuOrganizationPage.LINK_ORGANIZATION;

public class GoesBusinessUnits implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesBusinessUnits.class);
    }

    @Override
    @Step("{0} is going to new business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_ORGANIZATION));
        actor.attemptsTo(Click.on(LINK_BUSINESS_UNITS));
    }
}
