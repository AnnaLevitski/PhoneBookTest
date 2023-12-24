package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        // int d = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User().withEmail("dototo"+i+"@gmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().registrationSubmit();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContaxtHereDisplayd());
    }
    @Test(description = "Bug report #1234, Fixed") //enabled = false - делает тест нерабочим
    public void registrationWrongEmail(){
        User user = new User().withEmail("dototogmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().registrationSubmit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withEmail("dototo"+i+"@gmail.com").withPassword("Mmar123456");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().registrationSubmit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationRegistredUserWithNewPassword(){

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("mara@gmail.com", "Xcj123456$");
        app.getHelperUser().registrationSubmit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }
    @AfterMethod
    public void postConditions(){

    }
}

