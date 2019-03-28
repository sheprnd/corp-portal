package ru.usetech.qa.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.usetech.qa.appmanager.ApplicationManager;
import ru.yandex.qatools.allure.annotations.Attachment;

import static ru.usetech.qa.tests.TestBase.app;

public class MyTestListener implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
/*
        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        TestBase.app.takeScreenshot();
        saveScreenshot(TestBase.app.takeScreenshot());
*/
    }

/*
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
*/

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
