package starter.ui.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ItemPage {
    public static Target itemWithName(String itemName) {
        return Target.the("article with name " + itemName).located(By.xpath("//div[@class='inventory_item_name' and contains(text(), '" + itemName + "')]/following::div[2]/button[contains(text(), 'Add to cart')]"));
    }
    public static Target ITEM_DESCRIPTION = Target.the("item description").located(By.xpath("//div[@class='inventory_item_desc']"));
    public static Target ITEM_PRICE = Target.the("item price").located(By.xpath("//div[@class='inventory_item_price']"));
    public static Target SHOPPING_CART_BUTTON = Target.the("shopping cart button").located(By.xpath("//a[@class='shopping_cart_link']"));
    public static Target SHOPPING_CART_BADGE = Target.the("shopping cart badge button").located(By.xpath("//a[@class='shopping_cart_badge']"));
}
