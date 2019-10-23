        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidElement;
        import io.appium.java_client.remote.MobileCapabilityType;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.testng.Assert;
        import java.net.MalformedURLException;
        import java.net.URL;

        public class Calculator {
            public static void main(String args []) throws MalformedURLException {
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                dc.setCapability("platformName", "android");
                dc.setCapability("appPackage", "com.google.android.calculator");
                dc.setCapability("appActivity", "com.android.calculator2.Calculator");

                AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

                try {

                    Thread.sleep(5000);

                MobileElement el2 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_9");
                el2.click();
                MobileElement el4 = (MobileElement) ad.findElementById("com.google.android.calculator:id/op_mul");
                el4.click();
                MobileElement el6 = (MobileElement) ad.findElementById("com.google.android.calculator:id/digit_5");
                el6.click();
                MobileElement el7 = (MobileElement) ad.findElementById("com.google.android.calculator:id/eq");
                el7.click();

                Assert.assertEquals(ad.findElementById("com.google.android.calculator:id/result_final").getText(), "45", "Test Failed");
                ad.closeApp();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
            }

        }
