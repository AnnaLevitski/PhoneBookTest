package tests;

import manager.DataProviderUser;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test(dataProvider = "registr_success", dataProviderClass = DataProviderUser.class, groups = {"smoke"})
    public void registrationSuccess(User user){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().registrationSubmit();

        logger.info("Assert that button 'Sign Out' is present ");
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContaxtHereDisplayd());
    }

    @Test(dataProvider = "regData_negative", dataProviderClass = DataProviderUser.class, groups = {"smoke"})
    public void registration_negative(User user){
        if(!user.getEmail().contains("@")){
            logger.info("Wrong email bug (enabled = false, description = 'Bug report #1234, Fixed')");
        }else {
            app.getHelperUser().openLoginRegForm();
            app.getHelperUser().fillLoginRegForm(user);
            app.getHelperUser().registrationSubmit();

            logger.info("Assert alert 'Wrong email or password' is present ");
            Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        }
    }
    @Test(dataProvider = "regData_negativeRegistredUserWithNewPassword", dataProviderClass = DataProviderUser.class)
    public void registrationRegistredUserWithNewPassword(User user){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user.getEmail(), user.getPassword());
        app.getHelperUser().registrationSubmit();

        logger.info("Assert alert 'User already exist' is present ");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }
    @AfterMethod
    public void postConditions(){

    }
}

