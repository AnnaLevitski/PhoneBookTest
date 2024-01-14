package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
            logger.info("Before method finished logout");
        }
    }

    @Test
    public void loginSuccessTest_User(){
       // logger.info("`loginSuccessTest_User`");
        logger.info("Test data: `mara@gmail.com`, `Mmar123456$`");
        User user = new User().withEmail("mara@gmail.com").withPassword("Mmar123456$");

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().loginSubmit();

        logger.info("Assert check is button 'Sign Out' present ");
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginSuccessTest(){
       // logger.info("Start `loginSuccessTest`");
        logger.info("Test data: `mara@gmail.com`, `Mmar123456$`");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        logger.info("Assert check is button 'Sign Out' present ");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessTest1(){

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmail(){
       // logger.info("Start `loginWrongEmail`");
        logger.info("Test data: `maragmail.com`, `Mmar123456$`");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("maragmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        logger.info("Assert alert 'Wrong email or password' present");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        //logger.info("Start `loginWrongPassword`");
        logger.info("Test data: `mara@gmail.com`, `Mmar123456`");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Mmar123456");
        app.getHelperUser().loginSubmit();

        logger.info("Assert alert 'Wrong email or password' present");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginUnregistredUser(){
        //logger.info("Start `loginUnregistredUser`");
        logger.info("Test data: `notMaria@gmail.com`, `Mmar123456$`");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("notMaria@gmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        logger.info("Assert alert 'Wrong email or password' present ");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @AfterMethod
    public void postConditions(){

    }
}
