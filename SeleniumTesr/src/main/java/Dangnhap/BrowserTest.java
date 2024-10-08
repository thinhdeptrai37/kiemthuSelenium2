package Dangnhap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	public static void main(String[] args) {
		//Thiet lap ChromeDriver
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\webdriver\\chromedriver-win64\\chromedriver.exe");
		
		//Khoi tao ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		try {
			// 1- Toi da hoa cua so trinh duyet
			driver.manage().window().maximize();
			
			// 2-Dieu huong den URL
			driver.navigate().to("https://anhtester.com");
			
			// 3-Lay tieu de va in ra console
			System.out.println(driver.getTitle());
			
			// 4-Thoat ban trinh duyet
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		
		//Dam bao rang trinh duyet duoc dong neu co loi
		if (driver !=null) {
			driver.quit();
			}
				}

	}
}