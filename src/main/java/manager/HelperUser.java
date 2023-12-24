package manager;

import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public  void openLoginRegForm(){
        click(By.cssSelector("a[href='/login']"));
    }
    public void fillLoginRegForm(String email, String password){
        findAndType(By.name("email"), email);
        findAndType(By.name("password"), password);
    }
    public void fillLoginRegForm(User user){
        findAndType(By.name("email"), user.getEmail());
        findAndType(By.name("password"), user.getPassword());
    }
    public void loginSubmit(){
        click(By.xpath("//button[text()='Login']"));
    }
    public void registrationSubmit(){
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isLogged() {
        return isElPressent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert!=null && alert.getText().contains(message)){
            alert.accept();
            return true;
        }
        return false;
            //click ok
            // click cancel --> alert.dismiss();
            // type in alert --> alert.sendKeys();
    }

    public boolean isNoContaxtHereDisplayd() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        return wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),
                "No Contacts here!"));
    }
}
