package com.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.ui.LoginHomePage.*;
import static com.utils.SessionVariables.USER;


public class LogIn implements Task {

    private final String user;
    private final String pass;

    public LogIn(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static Performable forLoginIn(String user, String pass) {
        return Tasks.instrumented(LogIn.class, user, pass);
    }

    @Override
    @Step("{0} is going to log in with a user")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(USER.toString(), user);
        actor.attemptsTo(Enter.theValue(user).into(TXT_USER));
        actor.attemptsTo(Enter.theValue(pass).into(TXT_PASSWORD));
        actor.attemptsTo(Click.on(BTN_LOGIN));
    }
}
