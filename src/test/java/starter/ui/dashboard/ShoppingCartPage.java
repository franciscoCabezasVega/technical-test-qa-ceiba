package starter.ui.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage {
    public static Target CONFIRM_ORDER_BUTTON = Target.the("confirm order button").located(By.id("checkout"));
    public static Target REMOVE_BUTTON = Target.the("remove button").located(By.xpath("//button[contains(text(), 'Remove')]"));
    public static Target RETURN_BUTTON = Target.the("return button").located(By.id("continue-shopping"));
}
