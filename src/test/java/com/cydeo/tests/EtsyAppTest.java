package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyAppTest {
    AppiumDriver<MobileElement> driver;
    @Test
    public void Test() throws MalformedURLException {

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

        driver.closeApp();
    }

}
