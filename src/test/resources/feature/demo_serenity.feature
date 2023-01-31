Feature: Suite serenity demos Login, Business Unit and Meeting

  As a user of the Serenity Demos website
  I want to sing in, create a Business Unit and a Meeting
  To verify that the operations are correct

  Background: Opens the browser in serenity demo page
    Given Camilo opens the browser in the home page
    When he enters his credentials, admin and serenity

  @Login @Regression
  Scenario: Login with correct credentials
    Then he should see the admin in the login home

  @Unit @Regression
  Scenario Outline: Create Business unit
    Given he creates new business unit as <businessUnits>
    When he should see the business unit name
    Then he should delete business unit

    Examples:
      | businessUnits |
      | Business Unit |

  @Schedule @Regression
  Scenario Outline: Schedule a meeting
    Given he creates new business unit as <businessUnits>
    And he schedules a business meeting
      | Meeting Name   | <businessMeeting> |
      | Meeting Type   | <meetingType>     |
      | Meeting Number | <meetingNumber>   |
      | Location       | <location>        |
      | Organized By   | <organizedBy>     |
      | Reporter       | <organizedBy>     |
      | Attendee List  | <organizedBy>     |
    Then he should see the business meeting
    And he should delete meeting and unit

    Examples:
      | businessUnits | businessMeeting  | meetingType | meetingNumber | location | organizedBy  |
      | Business Unit | Business Meeting | Customer    | 28112022      | HQ-01    | Adam Edwards |