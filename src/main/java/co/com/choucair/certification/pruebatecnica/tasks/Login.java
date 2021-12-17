package co.com.choucair.certification.pruebatecnica.tasks;

import co.com.choucair.certification.pruebatecnica.model.UserData;
import co.com.choucair.certification.pruebatecnica.userinterface.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Login implements Task {

    private String firstName;
    private String lastName;
    private String email;
    private String birthDay;
    private String birthMonth;
    private String birthYear;

    public Login(UserData user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthDay = user.getBirthDay();
        this.birthMonth = user.getBirthMonth();
        this.birthYear = user.getBirthYear();
    }

    public static Login onThePage(UserData user) {
        return Tasks.instrumented(Login.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo( Enter.theValue(firstName).into(RegisterPage.INPUT_FIRST_NAME),
                Enter.theValue(lastName).into(RegisterPage.INPUT_LAST_NAME),
                Enter.theValue(email).into(RegisterPage.INPUT_EMAIL),
                SelectFromOptions.byVisibleText(birthMonth).from(RegisterPage.INPUT_BIRTH_MONTH),
                SelectFromOptions.byVisibleText(birthDay).from(RegisterPage.INPUT_BIRTH_DAY),
                SelectFromOptions.byVisibleText(birthYear).from(RegisterPage.INPUT_BIRTH_YEAR),
                Click.on(RegisterPage.BUTTON_NEXT));
    }
}
