package com.cydeo.tests;

import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwagLabTest {

    @Test
    public void Test(){
        AppiumDriver<MobileElement> driver = Driver.getDriver();

        System.out.println(driver.getDeviceTime());

        Assertions.assertEquals("android",driver.getPlatformName());
        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();

        // to scroll down we are using a method like in Selenium we had JSE
        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");

       driver.closeApp();
    }
}
