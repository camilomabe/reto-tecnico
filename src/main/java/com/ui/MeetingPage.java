package com.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MeetingPage extends PageObject {

    public static final Target NEW_MEETING = Target.the("new meeting").located(By.xpath("//i[@class='fa fa-plus-circle text-green']"));
    public static final Target TXT_MEETING_NAME = Target.the("Meeting Name").located(By.id("Serenity_Pro_Meeting_MeetingDialog10_MeetingName"));
    public static final Target LIST_MEETING_TYPE = Target.the("Meeting type").located(By.xpath("//span[@id='select2-chosen-6']"));
    public static final Target TXT_MEETING_NUMBER = Target.the("Meeting number").located(By.xpath("//*[@id='Serenity_Pro_Meeting_MeetingDialog10_MeetingNumber']"));
    public static final Target LIST_LOCATION = Target.the("Location").located(By.id("select2-chosen-7"));
    public static final Target LIST_UNIT = Target.the("Unit").located(By.id("select2-chosen-8"));
    public static final Target LIST_ORGANIZED_BY = Target.the("Organized By").located(By.id("select2-chosen-9"));
    public static final Target LIST_REPORT = Target.the("Report").located(By.id("select2-chosen-10"));
    public static final Target LIST_ATTENDEE = Target.the("List Attendee").located(By.id("select2-chosen-12"));

    public static Target lblMeetingOptions(String meeting, String meetingType) {
        return Target.the(meeting).located(By.xpath("//div[@class='select2-result-label' and contains(text(),'" + meetingType + "')]"));
    }

}