package pageFactory;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class homePage {

By pricetags= By.xpath("//*[@class=\"inventory_item_price\"] ");
By addTocart=By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"] ");
    By cart=By.xpath("//*[@class=\"shopping_cart_container\"] ");
    By checkout=By.xpath("//*[@class=\"btn btn_action btn_medium checkout_button\"] ");
    By firstname=By.xpath("//*[@class=\"input_error form_input\"][1]");
    By lastname=By.xpath("//*[@id=\"last-name\"]");
    By zipcode=By.xpath("//*[@id=\"postal-code\"]");
    By continuee=By.xpath("//*[@id=\"continue\"]");
    By finissh=By.xpath("//*[@id=\"finish\"]");
    String first_name="gihad";
    String last_name="magdy";
    String zip_code="11235";
    By title=By.xpath("//*[@class=\"title\"]");


    Duration duration = Duration.ofSeconds(2);
    List <String> value=new ArrayList<>();
    List <String> nvalue=new ArrayList<>();
    List <Integer> mitrytogetmin=new ArrayList<Integer>();
    // String to List of Integer
/**
 * Function that convert from string list to int list
 */

    public static <T, U> List<U>
    convertStringListToIntList(List<T> listOfString,
                               Function<T, U> function)
    {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }

/**
* aFunction That get pricetags  as web elements
 * get Add cart button into a list too as price tag
 * */

    public void getCheapest(WebDriver driver)
   {


             List<WebElement> listofelement=driver.findElements(pricetags);
             List<WebElement> listofbutton=driver.findElements(addTocart);

             for (int i=0;i<listofelement.size();i++)                                         /* for loop to get the values of price tags as a string */
             {
                 value.add(listofelement.get(i).getText());
             }
             System.out.println(value);

       nvalue = value.stream().map(s -> s.replaceAll("\\W", ""))                 /*New list to put the pervious list without ","*/
               .collect(Collectors.toList());
       System.out.println(nvalue);

       mitrytogetmin = convertStringListToIntList(
               nvalue,
               Integer::parseInt);                                                               /*New lst which hold the values of the list in int */

       int minIdx = IntStream.range(0,mitrytogetmin.size())
               .reduce((i,j) -> mitrytogetmin.get(i) > mitrytogetmin.get(j) ? j : i)
               .getAsInt();                                                                        /*Minindx is an integer which contain the index of the minmium value in list */

       System.out.println(minIdx);

            listofbutton.get(minIdx).click();                                              /*the we use the index in the list of add cart buttons after finding the lowest value  of price tag list */
   }



    public void clickAddToCart(WebDriver driver)
    {

/*           function that click on the cart logo from the top right of screen */
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).click();
    }
    public  void addRequiredData (WebDriver driver)
    {

              /*function that enter user data using pwait to handle performance isuues */
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys(first_name);
        driver.findElement(lastname).sendKeys(last_name);
        driver.findElement(zipcode).sendKeys(zip_code);

    }
    public void proceedToChecout(WebDriver driver)
    {
        /*function click o procced to checkout */
        driver.findElement(checkout).click();
    }

    public void compeleteCheckoutProcess(WebDriver driver)
    {
         /*function that compelete your order */
        WebDriverWait wait = new WebDriverWait(driver,duration);
        driver.findElement(continuee).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finissh)).click();
    }

    public String  assertoncompelatiom(WebDriver driver)
    {

        /*Assertion function to make sure that order placed successfully */
        String titlee;
        WebDriverWait wait=new WebDriverWait(driver,duration);
        titlee=wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
        return titlee;
    }

}
