
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;



import org.openqa.selenium.*;

public class Quiz2Test{

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chrome);

        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();

        WebElement StartStopButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/button"));
        StartStopButton.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
        System.out.println("100%");


    }



        @Test
        public void SecondTest() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chrome = new ChromeOptions();
            chrome.addArguments("--headless");
            WebDriver driver = new ChromeDriver(chrome);

            driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
            driver.manage().window().maximize();

            Select select = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/select")));
            select.selectByValue("java");

            List<WebElement> test = driver.findElements(By.xpath("//div[@id='checkboxes']/label"));

            for (WebElement selectedOption : test) {
                if (!selectedOption.isSelected())
                    selectedOption.click();
            }

            WebElement yellowButton = driver.findElement(By.cssSelector("input[value='yellow']"));
            yellowButton.click();

            Select fruits = new Select(driver.findElement(By.id("fruit-selects")));
            WebElement orange = null;
            for (WebElement selectedOption : fruits.getOptions()) {
                if (selectedOption.getText().contains("Orange")) {
                    orange = selectedOption;
                    break;
                }
            }

            if (orange != null) {
                System.out.println(orange.isEnabled());
            }
    }

    @Test
    public void ThirddTest(){  WebDriverManager.chromedriver().setup();
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chrome);

        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);

        WebElement input = driver.findElement(By.id("tinymce"));
        input.clear();
        input.sendKeys("Here Goes");

        driver.switchTo().defaultContent();

        WebElement alignCenterButton = driver.findElement(By.cssSelector("button[title='Align center']"));
        alignCenterButton.click();
    }
}
