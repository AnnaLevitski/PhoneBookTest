package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    HelperUser helperUser;
    HelperConact helperConact;

    public void init(){
        wd = new ChromeDriver();
        logger.info("Browser "+((RemoteWebDriver)wd).getCapabilities().getBrowserName());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        wd.navigate().to("https://telranedu.web.app/");
        logger.info("Link " + wd.getCurrentUrl() +"\n\n");

        helperUser = new HelperUser(wd);
        helperConact = new HelperConact(wd);
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperConact getHelperConact() {
        return helperConact;
    }

    public void stop(){
        wd.quit();
    }

}
