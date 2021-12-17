package co.com.choucair.certification.pruebatecnica.stepdefinitions;

import co.com.choucair.certification.pruebatecnica.model.UserData;
import co.com.choucair.certification.pruebatecnica.model.WelcomeText;
import co.com.choucair.certification.pruebatecnica.questions.Answer;
import co.com.choucair.certification.pruebatecnica.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UTestRegisterStepDefinitions {

    int index = 0;

    @Before
    public void setStage (){
        setTheStage(new OnlineCast());
    }

    @Given("^Brandon is a new user$")
    public void brandonIsANewUser() {
        // Write code here that turns the phrase above into concrete actions
        theActorCalled("Brandon").wasAbleTo(OpenUp.thePage());
    }

    @When("^Brandon fill out the form for getting its paid testing project list$")
    public void brandonFillOutTheFormForGettingItsPaidTestingProjectList(List<UserData> userData) throws Exception {

        theActorInTheSpotlight().attemptsTo(
                Login.onThePage(userData.get(index)),
                (LoginAddress.onThePAge(userData.get(index))),
                (LoginDevices.onThePage()),
                (LoginPassword.onThePage(userData.get(index)))
        );

    }

    @Then("^should be shown the text$")
    public void aWelcomeTextShouldBeShown(List<WelcomeText> welcomeText) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(welcomeText.get(index))));
    }
}
