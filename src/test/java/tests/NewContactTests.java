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
        System.out.println("-->  addNewContct_success ");
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
        app.getHelperConact().getScreenshot("src/test/screenshots/screen_"+i+".png");
        app.getHelperConact().registrationSubmit();

        Assert.assertTrue(app.getHelperConact().isContactCreated(contact));
        Assert.assertTrue(app.getHelperConact().isContactCreated_lastElement(contact));
    }
    @Test
    public void addNewContct_successBlankDescription(){
        System.out.println("-->  addNewContct_successBlankDescription ");
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
        Assert.assertTrue(app.getHelperConact().isContactCreated_goToElPage(contact));
        Assert.assertTrue(app.getHelperConact().isContactCreated_goToElPage_Name(contact));
    }
    @Test
    public void addNewContct_negativeLName(){
        System.out.println("-->  addNewContct_negativeLName ");
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("No Last Name Here!!!!")
                .lastName("")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("Na 11o BM")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        Assert.assertFalse(app.getHelperConact().isContactCreated(contact));
    }
    @Test
    public void addNewContct_negativeName(){
        System.out.println("-->  addNewContct_negativeName ");
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("")
                .lastName("LName")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("TA Blond 11")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        Assert.assertFalse(app.getHelperConact().isContactCreated(contact));
    }

    @Test
    public void addNewContct_negativeAdress(){
        System.out.println("-->  addNewContct_negativeAdress ");
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("Nam")
                .lastName("LName")
                .phone("045"+i)
                .email("name@gmail.com")
                .address("")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        Assert.assertFalse(app.getHelperConact().isContactCreated(contact));
    }

    @Test
    public void addNewContct_negativePhone(){
        System.out.println("-->  addNewContct_negativePhone ");
        Contact contact = Contact.builder()
                .name("Nam")
                .lastName("LName")
                .phone("0")
                .email("name@gmail.com")
                .address("Pizza 60")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid"));
    }

    @Test(enabled = false, description = "Bug report #1234")
    public void addNewContct_negativeEmail(){
        System.out.println("-->  addNewContct_negativeEmail ");
        Random random = new Random();
        int i = random.nextInt(10000000)+456750;

        Contact contact = Contact.builder()
                .name("Nam")
                .lastName("LName")
                .phone("045"+i)
                .email("")
                .address("Na 11o BM")
                .description("")
                .build();
        app.getHelperConact().openLoginRegForm();
        app.getHelperConact().fillLoginRegForm(contact);
        app.getHelperConact().registrationSubmit();

        Assert.assertFalse(app.getHelperConact().isContactCreated(contact));
    }


    @AfterClass
    public void postCondition(){

    }

}
