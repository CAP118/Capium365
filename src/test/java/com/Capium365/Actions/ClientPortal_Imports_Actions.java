package com.Capium365.Actions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;

public class ClientPortal_Imports_Actions {

	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	public ClientPortal_Imports_Actions() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Imports']")
	public WebElement ImportsMenu;

	@FindBy(xpath = "//h2[normalize-space()='Clients']//ancestor::div[@class='import-card']//mat-radio-button")
	public WebElement ClientsCheckbox;

	@FindBy(xpath = "//span[normalize-space()='Next']//parent::button")
	public WebElement importNextbutton;

	@FindBy(xpath = "//table[@aria-describedby='Import Success List']/tbody/tr/td//mat-checkbox")
	public WebElement importSuccessListCheckBox;

	@FindBy(xpath = "//span[normalize-space()='Save And Next']")
	public WebElement importSaveandNextbutton;

	@FindBy(xpath = "//h2[normalize-space()='Users']//ancestor::div[@class='import-card']//mat-radio-button")
	public WebElement userscheckbox;

	String ClientPath = "C:\\Users\\user\\Downloads\\Clients_04092025_0825.xlsx";
	String UserPath = "C:\\Users\\user\\Downloads\\Users_04092025_1158 1.xlsx";

	public void ClickonImportsMenu() throws Throwable {
		HelperClass.safeClick(ImportsMenu, null);
	}

	public void ClickonClientCheckBox() throws Throwable {
		HelperClass.safeClick(ClientsCheckbox, null);
	}

	public void ClickonImportNextbutton() throws Throwable {
		HelperClass.safeClick(importNextbutton, "Next button");

	}

	public void uploadExcelWithRobot() throws Exception {
		WebElement browseButton = driver
				.findElement(By.xpath("//button[@class='file-upload-button primary-button cursor-pointer']"));
		browseButton.click();
		Thread.sleep(2000);

		Robot robot = new Robot();

		StringSelection selection = new StringSelection(ClientPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void ValidatteUploadSuccessList() {
		String ActualSuccessListText = HelperClass.getText(By.xpath("//span[normalize-space()='Success List (1)']"));
		String ExpectedSuccessListText = "Success List (1)";
		if (ActualSuccessListText.equals(ExpectedSuccessListText)) {
			System.out.println("SuccessList is Displaying");
		} else {
			System.out.println("SuccessList is not Displaying");
		}
	}

	public void selectImportclientCheckBox() throws Throwable {
		Thread.sleep(2000);
		importSuccessListCheckBox.click();
	}

	public void ClickonSaveandNextbutton() throws Throwable {
		HelperClass.safeClick(importSuccessListCheckBox, "Import Success");
		HelperClass.safeClick(importSaveandNextbutton, "Save and Exit");
	}

	public void ValidateClientImportedornot() {
		String ActualClientImportCount = HelperClass.getText(By.xpath("//p[normalize-space()='Clients Imported (1)']"));
		String ExpectedClientImportCount = "Clients Imported (1)";
		if (ActualClientImportCount.equals(ExpectedClientImportCount)) {
			System.out.println("Client count is Displaying");
		} else {
			System.out.println("Client count is not Displaying");
		}
	}

	public void validateDuplicateImportUser() {
	    String duplicateText = HelperClass.getText(By.xpath("(//span[contains(normalize-space(),'Duplicate List')])[last()]"));
	    if (duplicateText.startsWith("Duplicate List")) {
	        String countStr = duplicateText.replaceAll("[^0-2]", ""); 
	        int count = countStr.isEmpty() ? 0 : Integer.parseInt(countStr);
	        if (count > 0) {
	            System.out.println("Duplicate list is displayed with count: " + count);
	        } else {
	            System.out.println("Duplicate list is displayed but count is 0");
	        }
	    } else {
	        System.out.println("Duplicate list is not displayed");
	    }
	}


	public void uploadExceluserWithRobot() throws Exception {
		// Click on the Choose File button
		WebElement browseButton = driver
				.findElement(By.xpath("//button[@class='file-upload-button primary-button cursor-pointer']"));
		browseButton.click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		StringSelection selection = new StringSelection(UserPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void ClickonuserscheckBox() throws Throwable {
		HelperClass.safeClick(userscheckbox, "User Click");
	}

}
