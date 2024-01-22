package tests;

import manager.DataProviderUser;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
            logger.info("Before method finished logout");
        }
    }

    @Test(dataProvider = "login_fromFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessTest_User(User user){
       // logger.info("`loginSuccessTest_User`");
        logger.info("login data: `"+user.getEmail()+"`, `"+user.getPassword()+"`");
        //User user = new User().withEmail(email).withPassword(password);

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().loginSubmit();

        logger.info("Assert check is button 'Sign Out' present ");
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccessTest(String email, String password){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(email, password);
        app.getHelperUser().loginSubmit();

        logger.info("Assert check is button 'Sign Out' present ");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test(dataProvider = "loginData_negative", dataProviderClass = DataProviderUser.class)
    public void login_negative(User user){
       // logger.info("Start `loginWrongEmail`");
        logger.info("Test data: `"+user.getEmail()+"`, `"+user.getPassword()+"`");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user.getEmail(), user.getPassword());
        app.getHelperUser().loginSubmit();

        logger.info("Assert alert 'Wrong email or password' present");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @AfterMethod
    public void postConditions(){

    }
}
