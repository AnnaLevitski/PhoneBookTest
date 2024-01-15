package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;

    HelperUser helperUser;
    HelperConact helperConact;

    public void init(){
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("Browser "+(wd).getCapabilities().getBrowserName()+"\n\n");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        wd.navigate().to("https://telranedu.web.app/");
        logger.info("Link " + wd.getCurrentUrl() +"\n\n");

        helperUser = new HelperUser(wd);
        helperConact = new HelperConact(wd);
        wd.register(new ListenerWD());
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
