package tests;

import manager.DataProviderContact;
import manager.TestNGListener;
import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;
@Listeners(TestNGListener.class)
public class NewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        User user = new User().withEmail("dototo1223456@gmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().loginSubmit();
    }
    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContact.class)
    public void addNewContct_success(Contact contact){
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        logger.info("Assert new contact card is present ");
        Assert.assertTrue(app.getHelperConact().isContactCreated(contact));
        Assert.assertTrue(app.getHelperConact().isContactCreated_lastElement(contact));
    }

    @Test(dataProvider = "contact_negative", dataProviderClass = DataProviderContact.class)
    public void addNewContct_negativeContactIsNotCreated(Contact contact){
        if(!contact.getEmail().contains("@")){
            logger.info("Wrong email (enabled = false, description = 'Bug report #1234')");
        }
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        logger.info("Assert new contact card is not present ");
        Assert.assertFalse(app.getHelperConact().isContactCreated(contact));
    }

    @Test(dataProvider = "contact_negativeAlertPresent", dataProviderClass = DataProviderContact.class)
    public void addNewContct_negativeAlertPresent(Contact contact){
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        logger.info("Assert that alert 'Phone not valid' is present ");
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid"));
    }




    @AfterClass
    public void postCondition(){

    }

}
