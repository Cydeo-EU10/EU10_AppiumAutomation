package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyAppTest {
    AppiumDriver<MobileElement> driver;
    @Test
    public void Test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        // key and value: setUp for appium
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk" );

        // for most of the applications, you need to tell Appium, app package (location, in mobile phone), app Activity for it
        caps.setCapability("appPackage","com.etsy.android");
        caps.setCapability("appActivity","com.etsy.android.ui.user.auth.SignInActivity");
        //set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");

        //launch appiumDriver
        driver = new AndroidDriver<MobileElement>(url, caps);

        System.out.println(driver.getDeviceTime());

        driver.findElement(By.id("com.etsy.android:id/btn_sign_in_dialog")).click(); // sign-in button
        Thread.sleep(2000);

        driver.findElement(By.id("com.etsy.android:id/clg_text_input")).sendKeys("areatha@uspeakw.com");
        Thread.sleep(2000);

        driver.hideKeyboard();  // to hide keyboard of application, it is preventing continue button
        Thread.sleep(2000);

        driver.findElement(By.id("com.etsy.android:id/sign_in_button_email")).click(); // continue button

       // driver.closeApp();
    }

}
