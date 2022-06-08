package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginPage   {

    By username_field=By.xpath("//*[@id=\"user-name\"]");
    By password_field=By.xpath("//*[@id=\"password\"]");
    By login_button=By.xpath("//*[@id=\"login-button\"]");
    By title=By.xpath("//*[@class=\"title\"]");
    Duration duration = Duration.ofSeconds(20);
    By errorr=By.xpath("//*[@data-test=\"error\"]");

    public void setUsername(String username,WebDriver driver)  {
          /*function that set user name uses web driver wait to handle bad network */

        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_field)).sendKeys(username);
    }

    public void setpassword(String password,WebDriver driver)
    {
        /*function that set user password no need to p wait as if user name loaded so the whole page loaded */
        driver.findElement(password_field).sendKeys(password);
    }

    public void pressLogin(WebDriver driver)
    {
        /*function that press on lohin button */
        driver.findElement(login_button).click();

    }
    public String titleassert(WebDriver driver)
    {
     /* function that make sure that user logged in successfully */
        String titlee;
        WebDriverWait wait = new WebDriverWait(driver, duration);
            titlee = wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();

            return titlee;
        }
        public String handle (WebDriver driver)
        {
            String error;
            WebDriverWait wait=new WebDriverWait(driver,duration);
            error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorr)).getText();
           return error;
        }

    }
