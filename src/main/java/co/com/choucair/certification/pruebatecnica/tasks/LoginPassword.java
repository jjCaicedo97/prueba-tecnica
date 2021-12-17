package co.com.choucair.certification.pruebatecnica.tasks;

import co.com.choucair.certification.pruebatecnica.model.UserData;
import co.com.choucair.certification.pruebatecnica.userinterface.PasswordPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginPassword implements Task {
    private String password;
    private String confirmedPassword;

    public LoginPassword(UserData user) {
        this.password = user.getPassword();
        this.confirmedPassword = user.getConfirmedPassword();
    }

    public static LoginPassword onThePage(UserData user) {
        return Tasks.instrumented(LoginPassword.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(password).into(PasswordPage.INPUT_PASSWORD),
                Enter.theValue(confirmedPassword).into(PasswordPage.INPUT_CONFIRM_PASSWORD),
                Click.on(PasswordPage.CHECK_TERMS_OF_USE),
                Click.on(PasswordPage.CHECK_PRIVACY),
                Click.on(PasswordPage.BUTTON_COMPLETE));

    }
}
