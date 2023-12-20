package manager;

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
    public void loginSubmit(){
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElPressent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean getAlertPresent(String message) {
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
}
