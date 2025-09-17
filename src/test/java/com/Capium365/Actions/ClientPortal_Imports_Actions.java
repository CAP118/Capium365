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

	WebDriver driver=HelperClass.getDriver();
	WebDriverWait wait=HelperClass.getWait();
	
	public ClientPortal_Imports_Actions() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Imports']")  
    public WebElement ImportsMenu;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")  
    public WebElement ClientsCheckbox;
	
	@FindBy(xpath = "//span[normalize-space()='Next']")  
    public WebElement importNextbutton;
	
	@FindBy(xpath = "(//input[@class='mdc-checkbox__native-control'])[2]")  
    public WebElement importSuccessListCheckBox;
	
	@FindBy(xpath = "//span[normalize-space()='Save And Next']")  
    public WebElement importSaveandNextbutton;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")  
    public WebElement userscheckbox;
	
	public void ClickonImportsMenu() throws Throwable {
		Thread.sleep(2000);
		HelperClass.safeClick(ImportsMenu, null);
	}
	public void ClickonClientCheckBox() throws Throwable {
		Thread.sleep(2000);
		HelperClass.safeClick(ClientsCheckbox, null);
	}
	public void ClickonImportNextbutton() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement nextBtn = wait.until(
		    ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[normalize-space()='Next']]"))
		);
		nextBtn.click();
 
	}
	public void uploadExcelWithRobot() throws Exception {
		WebElement browseButton = driver.findElement(By.xpath("//button[@class='file-upload-button primary-button cursor-pointer']"));
		browseButton.click();
		Thread.sleep(2000);
 
		String filePath = "C:\\Users\\user\\Downloads\\Clients_04092025_0825.xlsx";

		Robot robot = new Robot();

		StringSelection selection = new StringSelection(filePath);
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
	    	String ActualSuccessListText= HelperClass
		            .getText(By.xpath("//span[normalize-space()='Success List (1)']"));
		        String ExpectedSuccessListText= "Success List (1)";
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
		Thread.sleep(3000);
		importSuccessListCheckBox.click();
		Thread.sleep(3000);
		importSaveandNextbutton.click();
	}
	public void ValidateClientImportedornot() {
		String ActualClientImportCount= HelperClass
	            .getText(By.xpath("//p[normalize-space()='Clients Imported (1)']"));
	        String ExpectedClientImportCount= "Clients Imported (1)";
	        if (ActualClientImportCount.equals(ExpectedClientImportCount)) {
	            System.out.println("Client count is Displaying");
	        } else {
	            System.out.println("Client count is not Displaying");
	        }
	}

	public void ValidateDuplicateImportuser() {
		String ActualDuplicateListText= HelperClass
	            .getText(By.xpath("//span[normalize-space()='Duplicate List (1)']"));
	        String ExpectedDuplicateListText= "Duplicate List (1)";
	        if (ActualDuplicateListText.equals(ExpectedDuplicateListText)) {
	            System.out.println("Duplicate count is Displaying");
	        } else {
	            System.out.println("Duplicate count is not Displaying");
	        }
	}
	public void uploadExceluserWithRobot() throws Exception {
		// Click on the Choose File button
		WebElement browseButton = driver.findElement(By.xpath("//button[@class='file-upload-button primary-button cursor-pointer']"));
		browseButton.click();
		Thread.sleep(2000);
		String filePath = "C:\\Users\\user\\Downloads\\Users_04092025_1158.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filePath);
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
		Thread.sleep(2000);
		userscheckbox.click();
	}

}
