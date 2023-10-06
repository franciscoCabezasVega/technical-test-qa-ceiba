package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.dashboard.ItemPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddItem implements Task {
    private final String itemName;

    public AddItem(String itemName) {
        this.itemName = itemName;
    }

    public static Performable withItemName(String itemName) {
        return instrumented(AddItem.class, itemName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ItemPage.itemWithName(itemName))
        );
    }
}
