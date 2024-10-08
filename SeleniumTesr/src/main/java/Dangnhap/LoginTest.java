package Dangnhap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	public static void main(String[] args) {
		//Thiet lap ChromeDriver
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\webdriver\\chromedriver-win64\\chromedriver.exe");
		
		//Khoi tao ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		try {
			// Mo trang dang nhap
			driver.get("https://www.facebook.com/");
			
			// Khoi tao WebDriverWait voi thoi gian cho 2 phut (120 giay)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			
			// Nhap ten nguoi dung
			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))); // Su dung ID cua truong ten nguoi dung
			username.sendKeys("nguyenhuutra2k3@gmail.com");
			
			// Nhap mat khau
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))); // Su dung ID cua truong mat khau
			password.sendKeys("123");
			
			// Nhan nut dang nhap
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))); // Cap nhat selector chinh xac cho nut dang nhap
			loginButton.click();
			
			// Xac minh nguoi dung duoc chuyen huong den trang chinh
			wait.until(ExpectedConditions.urlContains("facebook.com")); // Kiem tra URL co chua "facebook.com"
			
			// Kiem tra co phai la trang chinh
			WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='banner']"))); // Thay doi selector thanh 1 phan tu noi bat
			if (dashboardElement.isDisplayed()) {
				System.out.println("Test Passed: User is redirected to the dashboard.");
			}else {
				System.out.println("Test Failed: User is not redirected to the dashboard.");
			}
		}catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
		}finally {
			// Dong trinh duyet
			driver.quit();
			}
		}
}