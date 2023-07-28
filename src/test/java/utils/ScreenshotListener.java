package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.WebDriverContainer.*;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(result.getName() + " failure screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
