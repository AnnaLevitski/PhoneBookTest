package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public void click(By locator){
        WebElement el = wd.findElement(locator);
        el.click();
    }
    public boolean isElPressent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
}
