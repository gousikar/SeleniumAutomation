package Testee;

import base.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logintest extends Basics {

    //add explicit wait to wait for the element to be visible before interacting with it
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void testLogin() {
        // Test login functionality
        driver.findElement(By.className("search-keyword")).sendKeys("Brinjal");
        driver.findElement(By.className("search-button")).click();

        String expectedText = "Brinjal - 1 Kg";
        String actualText = driver.findElement(By.className("product-name")).getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Test Passed: Product found - " + actualText);
        } else {
            System.out.println("Test Failed: Expected - " + expectedText + ", Actual - " + actualText);
        }
    }

        @Test
                // Add product to cart
        public void testAddToCart() {
            driver.findElement(By.className("search-keyword")).sendKeys("Brinjal");
            driver.findElement(By.className("search-button")).click();
            driver.findElement(By.xpath("//button[@type='button' and text()='ADD TO CART']")).click();

            String expectedCartCount = "1";
            String actualCartCount = driver.findElement(By.className("cart-count")).getText();
            if (actualCartCount.equals(expectedCartCount)) {
                System.out.println("Test Passed: Product added to cart. Cart count - " + actualCartCount);
            } else {
                System.out.println("Test Failed: Expected cart count - " + expectedCartCount + ", Actual cart count - " + actualCartCount);
            }
        }

            @Test

            // Verify cart contents
            public void testVerifyCartContents() {
                driver.findElement(By.className("cart-icon")).click();
                String expectedProductName = "Brinjal - 1 Kg";
                String actualProductName = driver.findElement(By.className("product-name")).getText();
                if (actualProductName.equals(expectedProductName)) {
                    System.out.println("Test Passed: Cart contains the correct product - " + actualProductName);
                } else {
                    System.out.println("Test Failed: Expected product - " + expectedProductName + ", Actual product - " + actualProductName);
                }


            }
        }