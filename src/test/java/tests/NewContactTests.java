package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class NewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        User user = new User().withEmail("dototo1223456@gmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm(user);
        app.getHelperUser().loginSubmit();
    }
    @Test
    public void addNewContct_success(){
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("Name")
                .lastName("LName")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("TA Blond 11")
                .description("Kisa")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();
        Assert.assertTrue(app.getHelperConact().isContactCreated(contact));
        Assert.assertTrue(app.getHelperConact().isContactCreated_lastElement(contact));


    }
    @Test
    public void addNewContct_successBlankDescription(){
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("Joan")
                .lastName("LName")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("TA Blond 11")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();
        Assert.assertTrue(app.getHelperConact().isContactCreated(contact));
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getHelperConact().isContactCreated_goToElPage(contact));
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(app.getHelperConact().isContactCreated_goToElPage_Name(contact));
    }

    @AfterClass
    public void postCondition(){

    }

}
