package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccessTest(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

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
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("maragmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        Assert.assertTrue(app.getHelperUser().getAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Mmar123456");
        app.getHelperUser().loginSubmit();

        Assert.assertTrue(app.getHelperUser().getAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginUnregistredUser(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("notMaria@gmail.com", "Mmar123456$");
        app.getHelperUser().loginSubmit();

        Assert.assertTrue(app.getHelperUser().getAlertPresent("Wrong email or password"));
    }
    @AfterMethod
    public void postConditions(){

    }
}
