package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.PageElement;
import starter.ui.dashboard.CheckoutPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmOrder implements Task {
    private final String firstname;
    private final String lastname;
    private final String zipcode;

    public ConfirmOrder(String firstname, String lastname, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
    }

    public static Performable withCheckoutInformation(String firstname, String lastname, String zipcode) {
        return instrumented(ConfirmOrder.class, firstname, lastname, zipcode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstname).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastname).into(CheckoutPage.LAST_NAME),
                Enter.theValue(zipcode).into(CheckoutPage.ZIP_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Ensure.that(PageElement.locatedBy(".title")).hasText("Checkout: Overview"),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}
