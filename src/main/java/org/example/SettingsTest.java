package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingsTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("11")
                .setDeviceName("R5CN80F9PSP")  // Tên thiết bị thực tế
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings")
                .setAutomationName("UiAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @Test
    public void openLocationSettings() throws InterruptedException {
        System.out.println("Mở ứng dụng Settings thành công!");

        // Sử dụng UiScrollable để cuộn xuống và tìm "Location"
        WebElement locationElement = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Location\"))"
                )
        );

        // Nhấn vào Location
        locationElement.click();

        System.out.println("Đã mở tính năng Location");
        Thread.sleep(3000); // chờ quan sát
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
