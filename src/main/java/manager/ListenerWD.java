package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerWD extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(ListenerWD.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
        logger.info("NavigateTo"+ url);
    }

//    @Override
//    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        super.beforeFindBy(by, element, driver);
//        logger.info("Start FindBy: " + by);
//    }
//
//    @Override
//    public void afterFindBy(By by, WebElement element, WebDriver driver) {
//        super.afterFindBy(by, element, driver);
//        logger.info("Done FindBy: " + by);
//    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("!Exception: "+ throwable.getMessage());
        //logger.info("--->"+throwable.fillInStackTrace().toString());
        HelperBase helperBase = new HelperBase(driver);
        int i = (int)(System.currentTimeMillis()/1000%3600);
        String link = "src/test/screenshots/screen-"+i+".png";
        helperBase.getScreenshot(link);
        logger.info("Link to screenshot: " + link);
    }


    public ListenerWD() {
        this.logger = logger;
    }
}
