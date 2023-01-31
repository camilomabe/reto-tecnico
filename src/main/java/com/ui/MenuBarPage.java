package com.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuBarPage extends PageObject {

    public static final Target AVATARS_USER = Target.the("avatar's user").located(By.xpath("//i[@class='s-sidebar-band-icon fa fa-user']"));

    public static Target lblUserLogged(String user) {
        return Target.the("label user logged").located(By.xpath("//*/text()[normalize-space(.)='" + user + "']/parent::*"));
    }

}