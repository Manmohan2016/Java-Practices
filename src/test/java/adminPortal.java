
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class adminPortal {

	    public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        // Open admin portal
	        driver.get("https://admin.deenbytes.com/");

	        // Enter credentials and login
	        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("sk19810848@gmail.com");
	        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Tester@123");
	        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

	     // Execute JavaScript to click the button
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click();", loginButton);

	        // ✅ Wait until dashboard is fully loaded
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlContains("dashboard")); // Modify this based on actual URL change

	        // ✅ Refresh the page after ensuring login success
	        driver.navigate().refresh();

	        // ✅ Get window handle and print page title
	        String currentWindow = driver.getWindowHandle();
	        System.out.println("Current Window Handle: " + currentWindow);
	        System.out.println("Page Title: " + driver.getTitle());
	        Thread.sleep(2000);

	        // ✅ Wait for "View All" button to be clickable
	        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/user-status?type=Active']//span[contains(text(),'View all')]")));
	        viewAllButton.click();
	        Thread.sleep(5000);
	    /*    WebElement dropdownElement = driver.findElement(By.id("demo-simple-select"));
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText("25");    */
	        
	     // ✅ Click the dropdown to open options
	        WebElement dropdownElement = driver.findElement(By.id("demo-simple-select"));
	        dropdownElement.click();

	        // ✅ Wait for the option to appear and select "25"
	        WebElement option25 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='25']")));
	        option25.click();
	        
	        driver.findElement(By.xpath("//input[@placeholder='Search Here…']")).sendKeys("amanfordeenbytes@gmail.com");
	        Thread.sleep(5000);
	        
	        driver.findElement(By.xpath("//div[@class='d-block']//span[contains(text(),'Courses')]")).click();
	        driver.findElement(By.xpath("//div[@id='root']//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-1cbf1l2']//a[1]")).click();
	        driver.findElement(By.xpath("//a[@href=\"/courses/add-course\"]")).click();
	        Thread.sleep(2000);
	        WebElement select = driver.findElement(By.xpath("//select[@id=\"teacherId\"]"));
	        Select dropdown = new Select(select);
	        dropdown.selectByVisibleText("Shadi Alsuleiman");
	        Thread.sleep(2000);

	        // ✅ Close the browser
	        driver.quit();
	    }
	}


