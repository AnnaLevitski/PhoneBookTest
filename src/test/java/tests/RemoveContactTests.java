package tests;

import model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.io.IOException;

public class RemoveContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        User user = new User().withEmail("dototo1223456@gmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().loginSubmit();
    }

    @BeforeMethod
    public void bm(){
        app.getHelperConact().openContactsForm();
        app.getHelperConact().addContact();
    }
    @Test
    public void removeOneContact(){
        //Assert size list less by  one
        int size = app.getHelperConact().howMuchContactItems();
        app.getHelperConact().removeOneContact();
        System.out.println("app _- "+ app.getHelperConact().howMuchContactItems());
        logger.info("Assert check that list of contacts decreased by one ");
        logger.info("Was "+size +" now "+app.getHelperConact().howMuchContactItems());
        Assert.assertTrue(size-app.getHelperConact().howMuchContactItems()==1);



    }
    @Test
    public void removeAllContacts(){
        System.out.println("removeAllContacts");
        app.getHelperConact().removeAllContacts();
        logger.info("Assert check is div 'No Contacts Here' present ");
        Assert.assertTrue(app.getHelperConact().isNoContactsHereH1Present());
    }


}
