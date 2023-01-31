package com.tasks;

import com.interactions.GoesBusinessUnits;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.ui.BusinessUnitsPage.NEW_BUSINESS_UNITS;
import static com.ui.BusinessUnitsPage.TXT_NEW_BUSINESS_UNITS_NAME;
import static com.ui.CommonTargetsPage.SAVE_AND_CLOSE_BUTTON;
import static com.ui.CommonTargetsPage.SEARCH_BY_NAME;
import static com.utils.SessionVariables.BUSINESS_UNIT_NAME;


public class CreatesNewBusinessUnit implements Task {

    private final String nameBusinessUnit;

    public CreatesNewBusinessUnit(String nameBusinessUnit) {
        this.nameBusinessUnit = nameBusinessUnit;
    }

    public static Performable letsGo(String nameBusinessUnit) {
        return Tasks.instrumented(CreatesNewBusinessUnit.class, nameBusinessUnit);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(BUSINESS_UNIT_NAME.toString(), nameBusinessUnit);
        actor.attemptsTo(GoesBusinessUnits.letsGo());
        actor.attemptsTo(Click.on(NEW_BUSINESS_UNITS));
        actor.attemptsTo(Enter.theValue(nameBusinessUnit).into(TXT_NEW_BUSINESS_UNITS_NAME));
        actor.attemptsTo(Click.on(SAVE_AND_CLOSE_BUTTON));
        actor.attemptsTo(Enter.theValue(nameBusinessUnit).into(SEARCH_BY_NAME));
    }
}
