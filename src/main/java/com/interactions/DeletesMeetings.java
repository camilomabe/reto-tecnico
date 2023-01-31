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
import static com.utils.SessionVariables.MEETING_NAME_VALUE;

public class DeletesMeetings implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(DeletesMeetings.class);
    }

    @SneakyThrows
    @Override
    @Step("{0} deletes meetings")
    public <T extends Actor> void performAs(T actor) {
        String meetings = actor.recall(MEETING_NAME_VALUE.toString());
        actor.attemptsTo(Enter.theValue(meetings).into(SEARCH_BY_NAME));
        actor.attemptsTo(Click.on(labelSearch(meetings)));
        actor.attemptsTo(RemovesEvents.delete());
    }
}
