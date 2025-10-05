import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserAction {
    WebDriver driver;

    @Test
    public void FirstTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        navigation("https://www.cartlow.com/uae/en");
        maximize();
        WebElement account = driver.findElement(By.xpath("//span[contains(@class,'icon-users') and @role='button']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(account)
                .pause(Duration.ofMillis(1000))
                .perform();
        driver.findElement(By.xpath("//a[contains(@href,'/customer/login') and normalize-space()='Sign In']")).click();

        WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("identifier")));
        input.sendKeys("mohamedalii7405@gmail.com");

        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit' and contains(@class,'primary-button')]")));
        loginButton.click();

        input = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        input.sendKeys("Honeywell@2003");

        loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit' and contains(@class,'primary-button')]")));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement laptopsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/laptops' and @title='Laptops']")));
        laptopsLink.click();

        String term = "Dell Latitude 7490 Intel Core i7-8650U 14\" FHD Display, 16GB RAM 512GB SSD, Windows 10 Pro";

        WebElement in = new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.elementToBeClickable(By.name("query")));
        in.clear();
        in.sendKeys(term);

        By product = By.xpath("//a[.//p[contains(normalize-space(.),'Dell Latitude 7490')]]");
        WebElement prod = new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.elementToBeClickable(product));
        prod.click();

        // Wait for "Add To Cart" button and click it via JavaScript
        WebElement addToCart = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add To Cart')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCart);
        Thread.sleep(1000); // wait a moment after scroll

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);

        Thread.sleep(1000);
        WebElement logo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//img[@alt='Logo' and contains(@src,'QzpZDMMb9wsDbWSjL0pdXckpK0R43DPnVeCxNJh8.png')]")
                ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logo);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement smartwatches = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/smartwatches' and normalize-space()='Smartwatches']")));
        smartwatches.click();

        new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@href, '/apple-watch-series-6-gps-cellular-44mm-silver')]")
                ))
                .click();

        WebElement increaseQty = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[contains(@class,'icon-plus') and @role='button']")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", increaseQty);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", increaseQty);

        WebElement addToCartBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(@class,'secondary-button') and contains(text(),'Add To Cart')]")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartBtn);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo({top: 0, behavior: 'smooth'});");
        Thread.sleep(1500);

        WebElement cartIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'icon-cart') and @role='button']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);

        Thread.sleep(1000);

        WebElement viewCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@href,'/checkout/cart') and normalize-space()='View Cart']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy({top: 400, behavior: 'smooth'});");
        Thread.sleep(1500);

        WebElement removeBtnForDell = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[contains(normalize-space(),'Dell Latitude 7490')]"
                                + "/ancestor::div[contains(@class,'main-1')]"
                                + "//span[contains(@class,'cursor-pointer') and .//span[normalize-space()='Remove']]")
                ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", removeBtnForDell);
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtnForDell);
        Thread.sleep(2000);

        WebElement agreeBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'primary-button') and normalize-space()='Agree']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeBtn);

        Thread.sleep(1500);
        driver.findElement(By.cssSelector("a.primary-button[href*='/checkout/onepage']")).click();

        Thread.sleep(3000);
        quit();
    }

    public void navigation(String url) {
        driver.navigate().to(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void quit() {
        driver.quit();
    }

}
