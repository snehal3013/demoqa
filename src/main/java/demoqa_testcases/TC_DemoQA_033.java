package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_033 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_033");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,300)", "");

			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();
			Thread.sleep(2000);

			int countIframesInPage = driver.findElements(By.tagName(s.getCell(4, 0).getContents())).size();
			System.out.println("Number of Frames on a Page:" + countIframesInPage);

			WebElement frame1 = driver.findElement(By.id(s.getCell(5, 0).getContents()));

			driver.switchTo().frame(frame1);

			WebElement frame1Element = driver.findElement(By.tagName(s.getCell(6, 0).getContents()));

			String frame1Text = frame1Element.getText();
			System.out.println("Frame1 is :" + frame1Text);

			int countIframesInFrame1 = driver.findElements(By.tagName(s.getCell(7, 0).getContents())).size();
			System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);

			driver.switchTo().frame(0);

			int countIframesInFrame2 = driver.findElements(By.tagName(s.getCell(8, 0).getContents())).size();
			System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);

			WebElement frame1Element1 = driver.findElement(By.tagName(s.getCell(9, 0).getContents()));

			String frame1Text1 = frame1Element1.getText();

			System.out.println("Frame1 is :" + frame1Text1);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();

		}

	}

}
