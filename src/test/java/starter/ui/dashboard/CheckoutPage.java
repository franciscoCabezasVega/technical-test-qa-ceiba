package starter.ui.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static Target FIRST_NAME = Target.the("fill first name").located(By.id("first-name"));
    public static Target LAST_NAME = Target.the("fill last name").located(By.id("last-name"));
    public static Target ZIP_CODE = Target.the("fill zip code").located(By.id("postal-code"));
    public static Target CANCEL_BUTTON = Target.the("cancel button").located(By.id("cancel"));
    public static Target CONTINUE_BUTTON = Target.the("continue button").located(By.id("continue"));
    public static Target FINISH_BUTTON = Target.the("finish button").located(By.id("finish"));
    public static Target CONFIRM_MESSAGE = Target.the("finish button").located(By.xpath("//h2[@class='complete-header']"));;
}
