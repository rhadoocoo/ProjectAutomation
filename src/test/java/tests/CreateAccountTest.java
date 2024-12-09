package tests;

import org.testng.annotations.Test;
import sharedData.BaseTest;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createAccount(){
    helperMethods.click(homepageLocators.acceptConsent);
    helperMethods.click(homepageLocators.createAccountButton);
    helperMethods.completeField(createAccountLocators.firstNameField, getRandomFirstName);
    helperMethods.completeField(createAccountLocators.lastNameField,getRandomLastName);
    helperMethods.completeField(createAccountLocators.emailField, getRandomEmail);
    helperMethods.completeField(createAccountLocators.passwordField, getRandomPassword);
    helperMethods.completeField(createAccountLocators.passwordConfirmationField, getRandomPassword);
    helperMethods.click(createAccountLocators.submitButton);

    }

    //assert errors
    //complete process
    //click on create account button

}
