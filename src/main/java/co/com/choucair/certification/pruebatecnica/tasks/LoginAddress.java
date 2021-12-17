package co.com.choucair.certification.pruebatecnica.tasks;

import co.com.choucair.certification.pruebatecnica.model.UserData;
import co.com.choucair.certification.pruebatecnica.userinterface.AddressPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class LoginAddress implements Task {

    private String city;
    private String zip;

    public LoginAddress(UserData user) {
        this.city = user.getCity();
        this.zip = user.getZip();
    }

    public static LoginAddress onThePAge(UserData user) {
        return Tasks.instrumented(LoginAddress.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(city).into(AddressPage.INPUT_CITY),
                Enter.theValue(zip).into(AddressPage.INPUT_POSTAL_CODE),
                Click.on(AddressPage.BUTTON_NEXT));

    }
}
