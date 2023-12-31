package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void findAndType(By locator, String text){
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        if(text!=null){
            el.sendKeys(text);
        }
    }
    public void clickBaseWait(By locator, int time){
        WebDriverWait wait = new WebDriverWait(wd, time);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (Exception e){

        }
    }
    public boolean isClickable_Wait(By locator, int time){
        WebDriverWait wait = new WebDriverWait(wd, time);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void click(By locator){
        WebElement el = wd.findElement(locator);
        el.click();
    }
    public boolean isElPressent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
    public String getText(By locator){
        WebElement el = wd.findElement(locator);
        return el.getText();
    }
}
