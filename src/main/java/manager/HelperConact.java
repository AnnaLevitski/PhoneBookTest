package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperConact extends HelperBase{
    By buttonAdd = By.cssSelector("a[href='/add']");
    By inputName = By.cssSelector("input[placeholder='Name']");
    By inputLastName = By.cssSelector("input[placeholder='Last Name']");
    By inputPhone = By.cssSelector("input[placeholder='Phone']");
    By inputEmail = By.cssSelector("input[placeholder='email']");
    By inputAddress = By.cssSelector("input[placeholder='Address']");
    By inputDescription = By.cssSelector("input[placeholder='description']");
    By buttonSave = By.xpath("//button/b");
    public HelperConact(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(buttonAdd);
    }

    public void fillLoginRegForm(Contact contact) {
        findAndType(inputName, contact.getName());
        findAndType(inputLastName, contact.getLastName());
        findAndType(inputPhone, contact.getPhone());
        findAndType(inputEmail, contact.getEmail());
        findAndType(inputAddress, contact.getAddress());
        findAndType(inputDescription, contact.getDescription());
    }

    public void registrationSubmit() {
        click(buttonSave);

    }

    public boolean isContactCreated(Contact contact) {
        By num = By.xpath("//h3[text()='"+contact.getPhone()+"']");
        By name = By.xpath("//h2[text()='"+contact.getName()+"']");
        return isElPressent(num) && isElPressent(name);
    }
    public boolean isContactCreated_lastElement(Contact contact) {
        By el = By.xpath("//*[@class='contact-item_card__2SOIM'][last()]/h2");
        return getText(el).equals(contact.getName());
    }

    public boolean isContactCreated_goToElPage(Contact contact) {
        By el = By.xpath("//*[@class='contact-item_card__2SOIM'][last()]");
        click(el);
        By el_2 = By.xpath("//*[starts-with(@class, 'contact-page_rightdiv')]");
        return getText(el_2).contains(contact.getName()) && getText(el_2).contains(contact.getLastName()) &&
                getText(el_2).contains(contact.getPhone()) && getText(el_2).contains(contact.getEmail());
    }
    public boolean isContactCreated_goToElPage_Name(Contact contact) {
        By el = By.xpath("//*[@class='contact-item_card__2SOIM'][last()]");
        click(el);
        By el_2 = By.xpath("//*[starts-with(@class, 'contact-page_rightdiv')]//h2");
        return getText(el_2).equals(contact.getName()+" "+contact.getLastName());
    }
}
