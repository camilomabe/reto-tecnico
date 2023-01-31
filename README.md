### Formación técnica, Reto automatización Screenplay

- Contains `Java`, `Gherkin`, `Cucumber`, `Screenplay`, `Serenity`

1. Feature's Statement

```Gherkin
Feature: Suite serenity demos Login, Business Unit and Meeting
  As a user of the Serenity Demos website
  I want to sing in, create a Business Unit and a Meeting
  To verify that the operations are correct	
```

2. It's runs at the start of each scenario
```Gherkin
Background: Opens the browser in serenity demo page
  Given Camilo opens the browser in the home page
  When he enters his credentials, admin and serenity
```

3. The user logs in with their valid credentials
```Gherkin
@Login
Scenario: Login with correct credentials
  Then he should see the admin in the login home
```
4. Scenario for login
```Gherkin
@Unit
Scenario Outline: Create Business unit
  Given he creates new business unit as <businessUnits>
  Examples:
  | businessUnits |
  | Business Unit |
```
5. TestRunner class executes the login test
```Java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = {"com/stepsdefinitions"},
        tags = "@Login")
public class TestRunner {}
```