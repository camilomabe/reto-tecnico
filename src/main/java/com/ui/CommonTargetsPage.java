package com.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonTargetsPage extends PageObject {

    public static final Target SEARCH_BY_NAME = Target.the("search by name").located(By.xpath("//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']"));
    public static final Target ICON_DELETE = Target.the("icon delete").located(By.xpath("//div[@class='tool-button delete-button icon-tool-button']"));
    public static final Target BTN_YES = Target.the("confirm delete").located(By.xpath("//button[@class='btn btn-primary']"));
    public static final Target SAVE_AND_CLOSE_BUTTON = Target.the("save icon").located(By.xpath("//div[@class='tool-button save-and-close-button icon-tool-button']"));

    public static final Target labelSearch(String searchName) {
        return Target.the("search name").located(By.xpath("//a[contains(text(),'" + searchName + "')]"));
    }

}