package com.utils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theWebSideHome() {
        return Task.where("{0} opens the website home page",
                Open.browserOn().the(OpensBrowserOn.class));
    }
}
