package testsuit;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        setBaseUrl();

    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        /**
         * * Enter “standard_user” username
         * * Enter “secret_sauce” password
         * * Click on ‘LOGIN’ button
         * * Verify the text “PRODUCTS”
         */
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement loginPageHeader = driver.findElement(By.xpath("//span[text() = 'Products']"));
        String headerText = loginPageHeader.getText();
        Assert.assertEquals("The text is not as expected","Products",headerText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.get(baseUrl);
        //Enter “standard_user” username
        //* Enter “secret_sauce” password
        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Locate the products on the page
        //Verify that six products are displayed on page
       List<WebElement> products = driver.findElements(By.tagName("a"));
        System.out.println("The number of products : " + products.size());
        // for each method
        for (WebElement element: products){
            System.out.println(element.getText());
        }


    }
    }
