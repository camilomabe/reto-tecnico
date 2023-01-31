package com.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.ui.MenuBarPage.AVATARS_USER;
import static com.ui.MenuBarPage.lblUserLogged;
import static com.utils.SessionVariables.USER;

public class ValidatesUser implements Question<String> {

    public static Question<String> displayed() {
        return new ValidatesUser();
    }

    @Override
    @Step("{0} searches user logged name")
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Click.on(AVATARS_USER));
        return lblUserLogged(actor.recall(USER.toString())).resolveFor(actor).getText();
    }
}
