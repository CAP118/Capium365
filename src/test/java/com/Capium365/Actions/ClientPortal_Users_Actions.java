package com.Capium365.Actions;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.ExcelReader;
import com.Capium.Utilites.HelperClass;

public class ClientPortal_Users_Actions {

	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	public ClientPortal_Users_Actions() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Users']")
	public WebElement UsersMenu;

	@FindBy(xpath = "(//span[normalize-space()='Add User'])[2]")
	public WebElement AddUser;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	public WebElement FirstName;

	@FindBy(xpath = "(//input[@formcontrolname='email'])[1]")
	public WebElement Email;

	@FindBy(xpath = "//span[normalize-space()='Save and Exit']")
	public WebElement UserSaveandExitButton;

	@FindBy(xpath = "//input[@formcontrolname='middleName']")
	public WebElement MiddleName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	public WebElement LastName;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement Phone;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement Address;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement City;

	@FindBy(xpath = "//input[@formcontrolname='county']")
	public WebElement County;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	public WebElement PostalCode;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement SearchBar;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement Checkbox;

	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	public WebElement cancelbutton;

	@FindBy(xpath = "//p[normalize-space()='Delete']")
	public WebElement footerdeletebutton;

	@FindBy(xpath = "//label[normalize-space()='Delete by selecting the box']/parent::div")
	public WebElement deleteCheckBox;

	@FindBy(xpath = "//span[normalize-space()='Yes']")
	public WebElement Yesbutton;

	@FindBy(xpath = "//p[normalize-space()='Archive']")
	public WebElement FooterArchivebutton;

	@FindBy(xpath = "//p[normalize-space()='Restore']")
	public WebElement FooterRestorebutton;

	String FilePath = "D:\\Core Modules\\Capium365\\src\\test\\resources\\Files_Excel\\Add Client ClientPortal.xlsx";

	public void ClickonUserMenu() {
		HelperClass.safeClick(UsersMenu, "User Menu");
	}

	public void ValidateUserMainGrid() {
		String ActualUserPage = HelperClass
				.getText(By.xpath("(//span[normalize-space()='Add User'])[2]"));
		String ExpectedUserPage = "Add User";
		if (ActualUserPage.equals(ExpectedUserPage)) {
			System.out.println("User Main Grid is Displaying");
		} else {
			System.out.println("User Main Grid is not Displaying");
		}
	}

	public void ClickonAddUserBtton() {

		AddUser.click();
	}

	public void FillthemandatorydetailsinaddUserandsaveandexit()
	        throws InterruptedException, AWTException, IOException {

	    String[][] data = ExcelReader.getSheetData(FilePath, "Sheet3");
	    String[] Client = data[0];

	    String dynamicUserName = Client[0] + "_" + System.currentTimeMillis();
	    String EmailId="Dudf"+ "_" + System.currentTimeMillis()+"@gmail.com";
	    HelperClass.safeType(FirstName, dynamicUserName, "User name");
	    HelperClass.safeType(Email, EmailId, "User Email");
	    HelperClass.captureScreenshot("mandatory fields required message verified");
	}


	public void FilltheNonmandatorydetailsinaddUserandsaveandexit()
			throws InterruptedException, AWTException, IOException {
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet4");
		String[] Client = data[0];
		MiddleName.sendKeys(Client[0]);
		LastName.sendKeys(Client[1]);
		Phone.sendKeys(Client[2]);
		Address.sendKeys(Client[3]);
		City.sendKeys(Client[4]);
		County.sendKeys(Client[5]);
		PostalCode.sendKeys(Client[6]);
		UserSaveandExitButton.click();
		HelperClass.captureScreenshot("mandatory fields required message verified");
	}

	public void ValidateErrorMessage() {
		String ActualSuccessMessage = HelperClass
				.getText(By.xpath("//p[normalize-space(text())='Please fill in all the mandatory fields.']"));
		String ExpectedAddNewClientPage = "Please fill in all the mandatory fields.";
		if (ActualSuccessMessage.equals(ExpectedAddNewClientPage)) {
			System.out.println("Error Message is Displaying");
		} else {
			System.out.println("Error Message is not Displaying");
		}
	}

	public void ClickonSaveandExitUser() {
		HelperClass.safeClick(UserSaveandExitButton, "Save and Exit");
	}

	public void SearchUserName() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement searchBar = wait.until(ExpectedConditions.visibilityOf(SearchBar));
		searchBar.clear();
		searchBar.sendKeys("ituser");
		WebElement result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]/td[2]/div")));
	}

	public void ValidateUser() {
		String ActualUserPage = HelperClass.getText(By.xpath("//span[normalize-space()='ituser']"));
		String ExpectedUserPage = "ituser";
		if (ActualUserPage.equals(ExpectedUserPage)) {
			System.out.println("User is Displaying");
		} else {
			System.out.println("User is not Displaying");
		}
	}

	public void SelectStatusDropdownandVerify() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Invite");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td//div/a[contains(text(),'Invite')]",
				"Invite");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Active");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td//div/a[contains(text(),'Active')]",
				"Active");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Resend Invitation");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(),
				"//table/tbody/tr/td//div/a[contains(text(),'Resend Invitation')]", "Resend Invitation");

	}

	public void clickonusercheckbox() throws Throwable {
		Thread.sleep(2000);
		Checkbox.click();
	}

	public void clickoncancelbutton() throws Throwable {
		Thread.sleep(2000);
		cancelbutton.click();
	}

	public void ValidateEditPageshouldnotvisible() {
		String ActualUserPage = HelperClass.getText(By.xpath("//p[normalize-space()='Edit']"));
		String ExpectedUserPage = "Edit";
		if (ActualUserPage.equals(ExpectedUserPage)) {
			System.out.println("EditPage is Displaying");
		} else {
			System.out.println("EditPage  is not Displaying");
		}
	}

	public void ClickonFooterdeletebutton() throws Throwable {
		Thread.sleep(2000);
		footerdeletebutton.click();
	}

	public void ClickonDeleteCheckBox() throws Throwable {
		Thread.sleep(2000);
		deleteCheckBox.click();
	}

	public void ClickonYesbutton() throws Throwable {
		Thread.sleep(2000);
		Yesbutton.click();
	}

	public void ValidatedeleteMessage() {
		String ActualUserPage = HelperClass.getText(By.xpath("Record deleted successfully."));
		String ExpectedUserPage = "Record deleted successfully.";
		if (ActualUserPage.equals(ExpectedUserPage)) {
			System.out.println("Delete Message is Displaying");
		} else {
			System.out.println("Delete Message is not Displaying");
		}

	}

	public void ClickonFooterArchivebutton() throws Throwable {
		Thread.sleep(2000);
		FooterArchivebutton.click();
		Thread.sleep(2000);
		Yesbutton.click();
	}

	public void ValidateArchiveMessage() {
		String ActualArchiveMessage = HelperClass
				.getText(By.xpath("//p[normalize-space(text())='Record archived successfully.']"));
		String ExpectedArchiveMessage = "Record archived successfully.";
		if (ActualArchiveMessage.equals(ExpectedArchiveMessage)) {
			System.out.println("Archive Message is Displaying");
		} else {
			System.out.println("Archive Message is not Displaying");
		}
	}

	public void ClickonFooterRestorebutton() throws Throwable {
		Thread.sleep(2000);
		FooterRestorebutton.click();
		Thread.sleep(2000);
		Yesbutton.click();
	}

	public void ValidateRestoreMessage() {
		String ActualRestoreMessage = HelperClass
				.getText(By.xpath("//p[normalize-space(text())='Record restored successfully.']"));
		String ExpectedRestoreMessage = "Record restored successfully.";
		if (ActualRestoreMessage.equals(ExpectedRestoreMessage)) {
			System.out.println("Restore Message is Displaying");
		} else {
			System.out.println("Restore Message is not Displaying");
		}
	}
}
