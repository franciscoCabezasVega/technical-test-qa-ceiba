package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.PageElement;
import starter.navigation.NavigateTo;
import starter.questions.ConfirmationData;
import starter.tasks.AddItem;
import starter.tasks.ConfirmOrder;
import starter.tasks.DoLogin;
import starter.ui.dashboard.ItemPage;
import starter.ui.dashboard.ShoppingCartPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConfirmOrderStepDefinitions {
    @Given("{actor} am on the login page")
    public void i_am_on_the_login_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.theLoginPage());
    }

    @When("{actor} log in with valid credentials")
    public void i_log_in_with_valid_credentials(Actor actor) {
        actor.attemptsTo(
                NavigateTo.theLoginPage(),
                DoLogin.withCredential("standard_user", "secret_sauce")
        );
    }

    @And("{actor} add the {string} to the shopping cart")
    public void i_add_the_to_the_shopping_cart(Actor actor, String item) {
        actor.attemptsTo(
                AddItem.withItemName(item)
        );
    }

    @And("{actor} confirm the order in my shopping cart")
    public void i_confirm_the_order_in_my_shopping_cart(Actor actor) {
        actor.attemptsTo(
                Click.on(ItemPage.SHOPPING_CART_BUTTON),
                Ensure.that(PageElement.locatedBy(".title")).hasText("Your Cart"),
                Click.on(ShoppingCartPage.CONFIRM_ORDER_BUTTON),
                Ensure.that(PageElement.locatedBy(".title")).hasText("Checkout: Your Information"),
                ConfirmOrder.withCheckoutInformation("John", "Doe", "007")
        );
    }

    @Then("{actor} should see a confirmation message")
    public void i_should_see_a_confirmation_message(Actor actor) {
        theActorInTheSpotlight().should(
                seeThat("The displayed confirmation message", ConfirmationData.confirmationMessage(), equalTo("Thank you for your order!"))
        );

        actor.attemptsTo(
                Ensure.that(PageElement.locatedBy(".title")).hasText("Checkout: Complete!")
        );
    }

    @When("{actor} log in with problem user")
    public void i_log_in_with_problem_user(Actor actor) {
        actor.attemptsTo(
                NavigateTo.theLoginPage(),
                DoLogin.withCredential("problem_user", "secret_sauce")
        );
    }

    @When("{actor} log in with locked out user")
    public void i_log_in_with_locked_out_user(Actor actor) {
        actor.attemptsTo(
                NavigateTo.theLoginPage(),
                DoLogin.withCredential("locked_out_user", "secret_sauce")
        );
    }

    @When("{actor} log in with glitch user")
    public void i_log_in_with_glitch_user(Actor actor) {
        actor.attemptsTo(
                NavigateTo.theLoginPage(),
                DoLogin.withCredential("performance_glitch_user", "secret_sauce")
        );
    }
}