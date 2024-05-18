package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ahsan Habib
 */
public class MainTest {
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MainTest() {
		System.out.println("MainTest");
	}
	
	
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s223798216";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "chandrakanth";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	private LoginForm loginForm;

    @Before
    public void setUp() {
        loginForm = new LoginForm();
    }

    @Test
    public void testValidLogin() {
        Assert.assertTrue(loginForm.authenticate("chandra98au@gmail.com", "Chandra@123"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(loginForm.authenticate("wrongemail@gmail.com", "Chandra@123"));
    }

    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(loginForm.authenticate("chandra98au@gmail.com", "wrongPassword"));
    }

    @Test
    public void testEmptyUsername() {
        Assert.assertFalse(loginForm.authenticate("", "Chandra@123"));
    }

    @Test
    public void testEmptyPassword() {
        Assert.assertFalse(loginForm.authenticate("chandra98au@gmail.com", ""));
    }

    @Test
    public void testNullUsername() {
        Assert.assertFalse(loginForm.authenticate(null, "Chandra@123"));
    }

    @Test
    public void testNullPassword() {
        Assert.assertFalse(loginForm.authenticate("chandra98au@gmail.com", null));
    }

    @Test
    public void testNullUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate(null, null));
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        Assert.assertFalse(loginForm.authenticate("", ""));
    }
	
	
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		driver.navigate().to("https://www.bunnings.com.au/login");
		sleep(5);
		WebElement ele = driver.findElement(By.id("okta-signin-username"));
		ele.clear();
		ele.sendKeys("chandra98au@gmail.com");
		ele = driver.findElement(By.id("okta-signin-password"));
		ele.clear();
		ele.sendKeys("Chandra@123");
		ele = driver.findElement(By.id("okta-signin-submit"));
		ele.submit();		
		sleep(5);
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
		driver.close();
	}
	 @Test
	    public void testLoginFailure() {
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.navigate().to("https://www.bunnings.com.au/login");

	        WebElement ele = driver.findElement(By.id("okta-signin-username"));
	        ele.clear();
	        ele.sendKeys("wrongemail@gmail.com");

	        ele = driver.findElement(By.id("okta-signin-password"));
	        ele.clear();
	        ele.sendKeys("wrongPassword");

	        ele = driver.findElement(By.id("okta-signin-submit"));
	        ele.submit();

	        sleep(5);
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertNotEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
			driver.close();
	    }

	    @Test
	    public void testEmptyUsername1() {
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.navigate().to("https://www.bunnings.com.au/login");

	        WebElement ele = driver.findElement(By.id("okta-signin-username"));
	        ele.clear();
	        ele.sendKeys("");

	        ele = driver.findElement(By.id("okta-signin-password"));
	        ele.clear();
	        ele.sendKeys("Chandra@123");

	        ele = driver.findElement(By.id("okta-signin-submit"));
	        ele.submit();

	        sleep(5);
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertNotEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
			driver.close();
	    }

	    @Test
	    public void testEmptyPassword1() {
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.navigate().to("https://www.bunnings.com.au/login");

	        WebElement ele = driver.findElement(By.id("okta-signin-username"));
	        ele.clear();
	        ele.sendKeys("chandra98au@gmail.com");

	        ele = driver.findElement(By.id("okta-signin-password"));
	        ele.clear();
	        ele.sendKeys("");

	        ele = driver.findElement(By.id("okta-signin-submit"));
	        ele.submit();

	        sleep(5);
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertNotEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
			driver.close();
	    }

	    @Test
	    public void testNullUsername1() {
	    	try {
	    		
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.navigate().to("https://www.bunnings.com.au/login");

	        WebElement ele = driver.findElement(By.id("okta-signin-username"));
	        ele.clear();
	        ele.sendKeys(null);

	        ele = driver.findElement(By.id("okta-signin-password"));
	        ele.clear();
	        ele.sendKeys("Chandra@123");

	        ele = driver.findElement(By.id("okta-signin-submit"));
	        ele.submit();
	        sleep(5);
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertNotEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
			driver.close();
	    	}catch(IllegalArgumentException e) {
	    		System.out.println("Username is null");
	    	}
	    }

	    @Test
	    public void testNullPassword1() {
	    	try {
	    		
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.navigate().to("https://www.bunnings.com.au/login");

	        WebElement ele = driver.findElement(By.id("okta-signin-username"));
	        ele.clear();
	        ele.sendKeys("chandra98au@gmail.com");

	        ele = driver.findElement(By.id("okta-signin-password"));
	        ele.clear();
	        ele.sendKeys(null);

	        ele = driver.findElement(By.id("okta-signin-submit"));
	        ele.submit();

	        sleep(5);
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertNotEquals(title, "Australia DIY, Garden & Hardware Store - Bunnings Australia");
			driver.close();
	    	}catch(IllegalArgumentException e) {
	    		System.out.println("Password is null");
	    	}
	    }
}
