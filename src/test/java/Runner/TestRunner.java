package Runner;

import helper.ReportOpener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/feature/demo.feature",
        glue = {"stepdefinitions", "helper"},
        tags = "@Test1",
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @AfterSuite
        public void openReport() {
                try {
                        Thread.sleep(2000); // wait for file write
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

                ReportOpener.openReport();

        }
}