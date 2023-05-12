package com.cydeo.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static URL url;

    private Driver() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        String platform = ConfigurationReader.getProperty("platform");
        if (Objects.isNull(driver)) {
            switch (platform) {
                case "android":
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities);
                    break;
                case "android-remote":
                    DesiredCapabilities caps = new DesiredCapabilities();

                    // Set your access credentials
                    caps.setCapability("browserstack.user", "testuser_1PhU8f");
                    caps.setCapability("browserstack.key", "qxU7LUK78o8BK1ki799f");

                    // Set URL of the application under test
                    caps.setCapability("app", "bs://e0ce6dfd61f8f7d9fd9c4fb11c746b65fd1d79f1");

                    // Specify device and os_version for testing
                    caps.setCapability("device", "OnePlus 8");
                    caps.setCapability("os_version", "10.0");
                    caps.setCapability("realMobile", "true");

                    // Set other BrowserStack capabilities
                    caps.setCapability("project", "My test appium automation");
                    caps.setCapability("build", "Java Android");
                    caps.setCapability("name", "Regression");

                    // Initialise the remote Webdriver using BrowserStack remote URL
                    // and desired capabilities defined above
                    try {
                        driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "swagLab":
                    DesiredCapabilities desiredCapabilities2 = new DesiredCapabilities();
                    desiredCapabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    desiredCapabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
                    desiredCapabilities2.setCapability(MobileCapabilityType.APP, "/Users/oscar/IdeaProjects/EU10_AppiumAutomation/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    // for most of the applications, you need to tell Appium, app package (location, in mobile phone), app Activity for it
                    desiredCapabilities2.setCapability("appPackage","com.swaglabsmobileapp");
                    desiredCapabilities2.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<>(url, desiredCapabilities2);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.closeApp();
            driver = null;
        }
    }
}