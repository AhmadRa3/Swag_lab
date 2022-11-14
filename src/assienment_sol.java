import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assienment_sol {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "G:\\\\MyNewDriver\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();

		String userName = "standard_user";
		String password = "secret_sauce";

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
/////////////////////////////////////////////////////////////////////////////////////////
		// driver.findElements(By.className(btn btn_primary btn_small btn_inventory));
		// multiple classes we must choose one of them
////////////////////////////////////////////////////////////////////////////////////////
		driver.findElements(By.className("btn"));//just one className

		List<WebElement> myButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myButtons.size(); i++) {
			myButtons.get(i).click();
		}

		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();

		System.out.println(actualItemsAdded);

		int expectedItemAdded = 4;

		// convert from string to integer
		int realNumber = Integer.parseInt(actualItemsAdded);
///////////////////////////////////////////////////////////////////
		Assert.assertEquals(realNumber, expectedItemAdded);

	}

}
