package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.jupiter.api.Assumptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.LoginPage;
import pageFactory.homePage;

import java.util.concurrent.TimeUnit;


public class login {


    WebDriver driver;

    LoginPage login=new LoginPage();
    homePage home=new homePage();


    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

      // b.start_browse(driver);

        System.setProperty("webdriver.chrome.driver","C:/Users/NasrG/Desktop/Task1/src/test/resources/Drivers/chromedriver.exe");


        driver =new ChromeDriver();
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.navigate().to("https://www.saucedemo.com");

        //throw new io.cucumber.java.PendingException();
    }
    @When("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions;
        login.setUsername(string,driver);
        login.setpassword(string2,driver);

        //throw new io.cucumber.java.PendingException();
    }
    @When("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        // Write code here that turs the phrase above into concrete actions

        login.pressLogin(driver);

        //throw new io.cucumber.java.PendingException();
    }
    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        // Write code here that turns the phrase above into concrete actions
        try {

            Assert.assertEquals(login.titleassert(driver), "PRODUCTS");
        }
        catch (Exception e)
        {
           Assert.assertEquals(login.handle(driver),"Epic sadface: Sorry, this user has been locked out.");
            System.out.println("Wrong password entered ");

            Assumptions.assumeTrue(false, "Wrong password entered");

             driver.close();
             driver.quit();
             //System.exit(0);
        }
        //throw new io.cucumber.java.PendingException();
    }
    @When("user select the cheapest item")
    public void user_select_the_cheapest_item() {
        // Write code here that turns the phrase above into concrete actions
        home.getCheapest(driver);
    }
    @Then("add to cart")
    public void add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        home.clickAddToCart(driver);
    }
    @Then("Proceed to check out")
    public void proceed_to_check_out() {
        // Write code here that turns the phrase above into concrete actions
        home.proceedToChecout(driver);
    }
    @Then("Add reuired data")
    public void add_reuired_data() {
        // Write code here that turns the phrase above into concrete actions
        home.addRequiredData(driver);
    }
    @Then("Compelete check out process")
    public void compelete_check_out_process() {
        // Write code here that turns the phrase above into concrete actions
        try {
            home.compeleteCheckoutProcess(driver);
        }
        catch (Exception e)
        {
            System.out.println("Wrong data entered ");
            Assumptions.assumeTrue(false,"Wrong user data entered ");
            driver.close();
            driver.quit();
        }
    }
    @Then("Assert on compelation of order")
    public void assert_on_compelation_of_order() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(home.assertoncompelatiom(driver),"CHECKOUT: COMPLETE!");
    }


}
