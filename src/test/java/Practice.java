import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	public class Practice {
	    public static void main(String[] args) {
	        // Disable automation detection to prevent bot detection
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        // Initialize WebDriver with Chrome options
	        WebDriver driver = new ChromeDriver(options);

	        // Open Cars24 website
	        driver.get("https://www.cars24.com/");

	        // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        try {
	            // WebDriverWait with 20 seconds timeout
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	            // Step 1: Switch to iframe if present
	            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	            if (!iframes.isEmpty()) {
	                driver.switchTo().frame(iframes.get(0)); // Switch to first iframe
	            }

	            // Step 2: Wait for "USE CURRENT LOCATION" button inside the iframe
	            By enableLocationButton = By.xpath("//button[contains(text(),'USE CURRENT LOCATION')]");
	            WebElement locationButton = wait.until(ExpectedConditions.elementToBeClickable(enableLocationButton));

	            // Step 3: Click the button (Use JavaScript if normal click fails)
	            try {
	                locationButton.click();
	            } catch (Exception e) {
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeScript("arguments[0].click();", locationButton);
	            }

	            // Step 4: Switch back to main content
	            driver.switchTo().defaultContent();

	            // Step 5: Continue with further actions
	            driver.findElement(By.xpath("//p[@class='sc-hURsLS gQujxu']")).click();
	            driver.findElement(By.xpath("//div[@class='styles_wrapper__b4UUV']//a[1]")).click();
	            driver.findElement(By.xpath("//button[normalize-space()='Book free test drive']")).click();

	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}


