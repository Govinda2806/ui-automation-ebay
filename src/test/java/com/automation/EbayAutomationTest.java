package com.automation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayAutomationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/govin/OneDrive/chromedriver-win64/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.get("https://www.ebay.com");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.name("_nkw"));
        searchBox.sendKeys("book");
        searchBox.submit();
        Thread.sleep(3000);

        WebElement firstItem = driver.findElement(By.cssSelector("ul.srp-results li.s-item a.s-item__link"));
        firstItem.click();
        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.id("atcRedesignId_btn"));
        addToCartButton.click();
        Thread.sleep(3000);

        WebElement cartCount = driver.findElement(By.id("gh-minicart-hover"));
        assertTrue(cartCount.getText().contains("1"), "Cart count is incorrect");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

