package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class STCPage {
    WebDriver driver;
    WebDriverWait wait;
    String packageName,packagePrice;

    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//strong[@id='name-premium']"))
    public WebElement premiumPackage;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//strong[@id='name-classic']"))
    public WebElement classicPackage;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//strong[@id='name-lite']"))
    public WebElement litePackage;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//div[@id='currency-lite']"))
    public WebElement litePrice;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//div[@id='currency-premium']"))
    public WebElement premiumPrice;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//div[@id='currency-classic']"))
    public WebElement classicPrice;

    public STCPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void validatePage(String expectedLitePrice,String expectedClassicPrice,String expectedPremiumPrice) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(premiumPackage));
        packageName = premiumPackage.getText().toLowerCase();
        Assert.assertEquals(packageName, "premium");
        packagePrice = premiumPrice.getText();
        Assert.assertEquals(packagePrice, expectedPremiumPrice);
        packageName = classicPackage.getText().toLowerCase();
        Assert.assertEquals(packageName, "classic");
        packagePrice = classicPrice.getText();
        Assert.assertEquals(packagePrice, expectedClassicPrice);
        packageName = litePackage.getText().toLowerCase();;
        Assert.assertEquals(packageName, "lite");
        packagePrice = litePrice.getText();
        Assert.assertEquals(packagePrice, expectedLitePrice);
        Thread.sleep(5000);
    }

}
