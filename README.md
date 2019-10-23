# Appium

Requirements to run this test.  You must have an appium server running and an android emulator.
Environment requirements:

Verify paths

Cmd > set

ANDROID_HOME=C:\Users\liwallace\AppData\Local\Android\Sdk
PATH contains
                C:\Users\liwallce\AppData\Local\Android\Sdk\platform-tools

Cmd > adb devices
                Shows list of connected devices with IDs, this is needed for the “deviceName” below

Appium

Appium -> Start server with all defaults, now a client can connect (scripting or Appium itself)

Appium -> New session Window -> Custom -> Desired Capabilities to construct JSON
{
    platformName: "Android",
    deviceName: "emulator-5554",
    app: "https://github.com/appium/appium/raw/master/sample-code/apps/ApiDemos-debug.apk"     < -- This can also be a path on hard drive such as C:\something\app.apk”
  }

Specific cases

Here is the code to connect to an existing app on the device, the file manager in this case

{
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "appPackage": "com.android.documentsui",
  "appActivity": "com.android.documentsui.files.FilesActivity",
  "noReset": "true"
}

You can get the appPackage and appActivity by doing the following

-	Open app on device
-	Cmd -> adb shell
-	Dumpsys window windows | grep mObscuringWindow     (online said something different but this is the only thing I could get to work)
-	
generic_x86:/ $ dumpsys window windows | grep mObscuringWindow
  mObscuringWindow=Window{a14543e u0 com.android.documentsui/com.android.documentsui.files.FilesActivity}
generic_x86:/ $

-	So for the above output the appPackage is whatever is before the / and appActivity is after


Here is the json settings to connect inspector session via Appium

{
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "appPackage": "com.android.documentsui",
  "appActivity": "com.android.documentsui.files.FilesActivity",
  "noReset": true
}

port for Appium is 4723

Installed Android SDK

Created a Virtual Device and ran it via the Android Virtual Device Manager

Pixel API 29 1080x1920:420dpi Android 10.0(Google Play0 X86 9.6 GB

Confirm that device is online and can be located with command:

adb devices

C:\Users\liwallace>adb devices
List of devices attached
emulator-5554   device

See code to see how to programmatically  connect to the emulator device.

You can choose selector in upper bar first arrow in box then select the item on the display for the connected emulated device.  Select tap which will send the command to the connected device and give all of the element details. For example id Xpath element id.

The recorder option can be used to record the interaction with the screen and will output Java Junit code that can be ported into code.

At times the screen won't refresh to the refresh button should reload the emulator for viewing and interaction.

Dependencies for Appium install include the following:

Here is a step by step guide to setting up the environment and installing the correct modules and building your first test.
https://www.youtube.com/watch?v=i1tQ1pjEFWw



