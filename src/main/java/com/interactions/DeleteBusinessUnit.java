package com.interactions;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.ui.CommonTargetsPage.SEARCH_BY_NAME;
import static com.ui.CommonTargetsPage.labelSearch;
import static com.utils.SessionVariables.BUSINESS_UNIT_NAME;

public class DeleteBusinessUnit implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(DeleteBusinessUnit.class);
    }

    @SneakyThrows
    @Override
    @Step("{0} delete business unit")
    public <T extends Actor> void performAs(T actor) {
        String unitName = actor.recall(BUSINESS_UNIT_NAME.toString());
        actor.attemptsTo(Enter.theValue(unitName).into(SEARCH_BY_NAME));
        actor.attemptsTo(Click.on(labelSearch(unitName)));
        actor.attemptsTo(RemovesEvents.delete());
    }
}
