import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.STCPage;

public class STCTest {
WebDriver driver ;
STCPage STCPage;

    @BeforeTest
    public void beforeEveryMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"url", "expectedLitePrice","expectedClassicPrice","expectedPremiumPrice"})
    public void STCTest(String url, String expectedLitePrice, String expectedClassicPrice, String expectedPremiumPrice) throws InterruptedException {
        STCPage = new STCPage(driver);
        driver.get(url);
        driver.navigate().refresh();
        STCPage.validatePage(expectedLitePrice, expectedClassicPrice, expectedPremiumPrice);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



