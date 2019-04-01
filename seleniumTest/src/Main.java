import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//https://www.toolsqa.com/selenium-webdriver/http-proxy-authentication/
//https://www.toolsqa.com/git/git-terminologies/
//https://www.toolsqa.com/git/git-clients/


public class Main {


    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.gecko.driver", "C:/Users/A0671137/Desktop/selenium/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String baseURL = "https://www.otomoto.pl/osobowe/?search%5Bnew_used%5D=on";

        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("html.wf-verveine-n4-active.wf-active.wf-proximanova-n4-active.wf-proximanova-n7-active.wf-proximanova-n9-active body.otomotopl.offersview.standard.category-id-29.withCookiesDisclaimer div#siteWrap.site-wrap.slideout-panel div#form.categories-main.subpage div#searchbox.advanced-search div.container-fluid.container-fluid-sm form#mainTopSearch.search.row.rel.clr noindex fieldset#paramsList.paramsList.rel.clr ul.clr.multifilters li#param_price.grid-li.fblock.param.paramBoth div.filter-both-item div.filter-item.filter-item-from.rel.numeric-item.price span.select2.select2-container.select2-container--suggestions span.selection span.select2-selection.select2-selection--single span#select2-search[filter_float_price:from]_dd-17-container.select2-selection__rendered")).sendKeys("12");





        //LOGOWANIE
        /*
        driver.findElement(By.cssSelector("#sap-user")).sendKeys("IT_FC_ACE");
        driver.findElement(By.cssSelector("#sap-password")).sendKeys("Arc2018*");
        driver.findElement(By.cssSelector("#LOGON_BUTTON")).click();

        Actions act = new Actions(driver);
        act.pause(5000);
        act.click(driver.findElement(By.cssSelector("#C4_W16_V17_SM-CHANGE")));
        act.perform();
        //driver.wait();

        //driver.wait();
        //TWORZENIE CD
        //driver.findElement(By.cssSelector("#C5_W18_V19_SM-CD-DC > span:nth-child(2)")).click();
                                          //#C5_W18_V19_SM-CD-DC > span:nth-child(2)
        //driver.findElement(By.cssSelector("#C4_W16_V17_SM-CHANGE")).click();
        driver.findElement(By.cssSelector("#C25_W102_V103_SM-CD-SR")).click();
        //driver.close();

        //WYLOGOWANIE
        //driver.findElement(By.cssSelector("#LOGOFF")).click();
        driver.close();
        */

        System.out.println("Hello World!");
    }
}
