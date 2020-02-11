import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "H9AXHM01P645XNH");
        caps.setCapability("platformName", "Android");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app", "C:\\xampp\\htdocs\\Phoenix-drogon-gradle\\AppRelease\\app-release02-10-20.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        //Login driver
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Business Type\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Phoenix Petroleum\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Username\")").sendKeys("pp.sa");
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Password\")").sendKeys("P@ssw0rd123");
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"LOG IN\")").click();
        Thread.sleep(3000);

        //Click menu var
        WebElement nav = driver.findElement(By.xpath("//android.widget.ImageView[@index='1']"));
        nav.click();

        //Select My Deliveries page
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"My Deliveries\")").click();
        Thread.sleep(1000);

        //Click menu var
        nav.click();

        //Select My Status
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"My Status\")").click();
        Thread.sleep(1000);

        //Click menu var
        nav.click();

        //Select Report a Problem
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Report a Problem\")").click();
        Thread.sleep(1000);


        //Logout
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Welcome, Super Admin PP\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Logout\")").click();
        Thread.sleep(1000);



    }
}
