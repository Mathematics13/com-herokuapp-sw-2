package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    @Before
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
       WebElement userName =  driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password =  driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);

        WebElement loginButton=  driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        Thread.sleep(2000);

        String expectedText = "Secure Area";
        WebElement actualText = driver.findElement(By.xpath("//h2"));
        String actualResult = actualText.getText();
        Assert.assertEquals(expectedText  , actualResult);
    }
      @Test
    public void userNameErrorMessage() throws InterruptedException
      {
          driver.navigate().back();

          WebElement userName1 =  driver.findElement(By.name("username"));
          userName1.sendKeys("tomsmith1");
          Thread.sleep(2000);

          WebElement password1 =  driver.findElement(By.name("password"));
          password1.sendKeys("SuperSecretPassword!");
          Thread.sleep(2000);

          WebElement loginButton1=  driver.findElement(By.xpath("//button[@class='radius']"));
          loginButton1.click();
          Thread.sleep(2000);

          String expectedText = "Your username is invalid!";
          WebElement actualText = driver.findElement(By.id("flash"));
          String actualResult = actualText.getText();
          Assert.assertEquals(expectedText , actualResult);
      }
      @After
      public void verifyThePasswordErrorMessage() throws InterruptedException
      {
          driver.navigate().back();

          WebElement userName2 =  driver.findElement(By.id("username"));
          userName2.sendKeys("tomsmith");
          Thread.sleep(2000);

          WebElement password2 =  driver.findElement(By.xpath("//input[@type='password']"));
          password2.sendKeys("SuperSecretPassword");
          Thread.sleep(2000);

          WebElement loginButton2=  driver.findElement(By.xpath("//button[@type='submit']"));
          loginButton2.click();
          Thread.sleep(2000);

          String expectedResult = "Your password is invalid!";
          WebElement actualText = driver.findElement(By.className("flash error"));
          String actualResult = actualText.getText();
          Assert.assertEquals(expectedResult  ,  actualResult );
      }
}
