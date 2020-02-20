package core;

import api.android.Android;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.NoSuchElementException;

public class UiObject {

    private String locator;

    UiObject(String locator) {
        this.locator = locator;
        System.out.println(this.locator);
    }

    private boolean isXpath() {
        return !locator.contains("UiSelector");
    }

    public boolean exists() {
        try {
            WebElement element;
            if (isXpath()) element = Android.driver.findElementByXPath(locator);
            else element = Android.driver.findElementByAndroidUIAutomator(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isChecked() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checkable").equals("true");
    }

    public boolean isEnabled() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("longClickable").equals("true");
    }

    public boolean isSelected() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("selected").equals("true");
    }

    public Point getLocation() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getLocation();
    }

    public String getText() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("name");
    }

    public String getResourceId() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("resourceId");
    }

    public String getClassName() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("className");
    }

    public String getContentDesc() {
        WebElement element;
        if (isXpath()) element = Android.driver.findElementByXPath(locator);
        else element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText() {
        if (isXpath()) Android.driver.findElementByXPath(locator);
        else Android.driver.findElementByAndroidUIAutomator(locator).clear();
        return this;
    }

    public UiObject typeText(String value) {
        if (isXpath()) Android.driver.findElementByXPath(locator).sendKeys(value);
        else Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
        return this;
    }

    public UiObject tap(String value) {
        if (isXpath()) Android.driver.findElementByXPath(locator).click();
        else Android.driver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public UiObject scrollTo() {
        TouchActions action = new TouchActions(Android.driver);
        if (isXpath()) {
            action.scroll(Android.driver.findElementByXPath(locator), 10, 100);
            action.perform();
        } else {
            action.scroll(Android.driver.findElementByAndroidUIAutomator(locator), 10, 100);
            action.perform();
        }
        return this;
    }

    public UiObject waitToAppear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if(exists()) break;
        if(timer.expired(seconds) && !exists()) throw new AssertionError("Element "+locator+" failed to appear within "+seconds+" seconds");
        return this;
    }

    public UiObject waitToDisappear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) if(exists()) break;
        if(timer.expired(seconds) && !exists()) throw new AssertionError("Element "+locator+" failed to disappear within "+seconds+" seconds");
        return this;
    }


}


