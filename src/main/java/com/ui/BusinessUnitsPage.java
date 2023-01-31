package com.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusinessUnitsPage extends PageObject {

    public static final Target NEW_BUSINESS_UNITS = Target.the("new business units").located(By.xpath("//i[@class='fa fa-plus-circle text-green']"));
    public static final Target TXT_NEW_BUSINESS_UNITS_NAME = Target.the("business units name").located(By.id("Serenity_Pro_Organization_BusinessUnitDialog3_Name"));

}

