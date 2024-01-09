package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemiveContactTests extends TestBase{
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
        System.out.println("removeOneContact");
        //Assert size list less by  one
        int size = app.getHelperConact().howMuchContactItems();
        System.out.println("size _- "+ size);
        app.getHelperConact().removeOneContact();
        System.out.println("app _- "+ app.getHelperConact().howMuchContactItems());
        Assert.assertTrue(size-app.getHelperConact().howMuchContactItems()==1);


    }
    @Test
    public void removeAllContacts(){
        System.out.println("removeAllContacts");
        app.getHelperConact().removeAllContacts();
        Assert.assertTrue(app.getHelperConact().isNoContactsHereH1Present());

    }
}
