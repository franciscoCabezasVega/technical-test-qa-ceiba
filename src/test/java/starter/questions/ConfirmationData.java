package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.dashboard.CheckoutPage;

public class ConfirmationData {
    public static Question<String> confirmationMessage() {
        return actor -> TextContent.of(CheckoutPage.CONFIRM_MESSAGE).answeredBy(actor).trim();
    }
}
