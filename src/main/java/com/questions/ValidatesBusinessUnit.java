package com.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static com.ui.CommonTargetsPage.labelSearch;
import static com.utils.SessionVariables.BUSINESS_UNIT_NAME;

public class ValidatesBusinessUnit implements Question<String> {

    public static Question<String> wasCreate() {
        return new ValidatesBusinessUnit();
    }

    @Override
    @Step("{0} searches business unit name")
    public String answeredBy(Actor actor) {
        String unitName = actor.recall(BUSINESS_UNIT_NAME.toString());
        return labelSearch(unitName).resolveFor(actor).getText();
    }
}
