package com.Capium365.Actions;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.ExcelReader;
import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_InvoicesTab_Customers_Locators;

public class Capium365_InvoicesTab_Customers_Actions {

	Capium365_InvoicesTab_Customers_Locators customerLocators = null;
	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	String FilePath = "D:\\Core Modules\\Capium365\\src\\test\\resources\\Files_Excel\\Add customers 1.xlsx";
	String imgpath = "D:\\Core Modules\\Capium365\\src\\test\\resources\\Images\\Capium logo.jpg";

	public Capium365_InvoicesTab_Customers_Actions() {
		this.customerLocators = new Capium365_InvoicesTab_Customers_Locators();
		PageFactory.initElements(driver, customerLocators);
	}

	public void invoicestab() throws Exception {
		By receiptsTab = By.xpath("//span[text()='Invoices']//parent::a");

		WebElement element = driver.findElement(receiptsTab);
		wait.until(ExpectedConditions.visibilityOf(element));
		HelperClass.safeClick(element);
	}

	public void Arrowbutton() throws Exception {
		Thread.sleep(2000);
		customerLocators = PageFactory.initElements(HelperClass.getDriver(),
				Capium365_InvoicesTab_Customers_Locators.class);
		HelperClass.waitUntilVisible(wait, customerLocators.arrowbutton);
		HelperClass.clickUsingJS(customerLocators.arrowbutton);
		String actualText = HelperClass.getText(By.xpath("//mat-icon[normalize-space()='keyboard_arrow_left']")).trim();
		String expected = "keyboard_arrow_left";
		if (actualText.equals(expected)) {
			System.out.println("Arrow button verified");
		} else {
			System.out.println("Arrow button not verified: " + actualText);
		}
	}

	public void customerstab() throws InterruptedException {
		By customerTab = By.xpath("//mat-icon[normalize-space()='person_outline']//parent::div");
		WebElement element = HelperClass.waitUntilClickable(customerTab);
		element.click();
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Add Customer']"));
		String expected = "Add Customer";
		if (actualText.equals(expected)) {
			System.out.println("Add Customer page verified");
		} else {
			System.out.println("Not Matched: " + actualText);
		}
	}

	public void addcustomerbutton() {
		HelperClass.clickUsingJS(customerLocators.addcustomerbutton);
		// customerLocators.addcustomerbutton.click();
		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected = "Add New Customer";
		if (actualtext.equals(expected)) {
			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Add New Customer not verified");
		}
	}

	public void Fillthemandatorydetailsandsave() throws InterruptedException {
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//ng-select[@formcontrolname='title'])[1]",
				"Miss");
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet1");
		String[] customer = data[0];
		customerLocators.fullnametextbox.sendKeys(customer[0]);
		customerLocators.enteremail.sendKeys(customer[1]);
		customerLocators.savebutton.click();
		customerLocators.addnewcustomersearch.click();
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@data-placeholder)='Search']"), "Sam");
		Thread.sleep(3000);
		String actualText = HelperClass.getText(By.xpath("//a[normalize-space(text())='Sam']")).trim();
		String expected = "Sam";
		if (actualText.equals(expected)) {
			System.out.println("Customer name added successfully");
		} else {
			System.out.println("Customer name not added: " + actualText);
		}
	}

	public void Fillthenonmandatorydetailsinaddcustomerandsaveandexit()
			throws InterruptedException, AWTException, IOException {
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='phoneCountryId']",
				"+91");
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet2");
		String[] customer = data[0];
		customerLocators.enterphnumber.sendKeys(customer[0]);
		customerLocators.enterwhatsappnumber.sendKeys(customer[1]);
		customerLocators.enteraddress.sendKeys(customer[2]);
		customerLocators.entercity.sendKeys(customer[3]);
		customerLocators.entercounty.sendKeys(customer[4]);
		customerLocators.enterpostcode.sendKeys(customer[5]);
		// upload file
		WebDriver driver = HelperClass.getDriver();
		WebElement chooseFileButton = driver.findElement(By.xpath("//div[@class='attachFile']"));
		chooseFileButton.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(imgpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), ("//ng-select[@formcontrolname='paymentDue']"),
				"On receipt");
		customerLocators.saveandexitbutton.click();
		HelperClass.captureScreenshot("mandatory fields required message verified");
	}

	public void Enteremail() {
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet1");
		String[] customer = data[0];
		customerLocators.enteremail.sendKeys(data[1]);
	}

	public void cancelchangesbutton() {
		customerLocators.cancelchangesbutton.click();
		String actualText = HelperClass.getText(By.xpath("//input[@formcontrolname='email']")).trim();
		System.out.println(actualText);
		String expected = "";
		if (actualText.equals(expected)) {
			System.out.println("Email cleared successfully");
		} else {
			System.out.println("Email not cleared: " + actualText);
		}
	}

	public void Entercontactdetails() {
		customerLocators.contactdetailsaddnewline.click();
		String actualText = HelperClass.getText(By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))
				.trim();
		if (HelperClass.isElementPresent(By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))) {
			System.out.println("Contact details line added successfully");
		} else {
			System.out.println("Contact details line not added: " + actualText);
		}
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), ("(//ng-select[@formcontrolname='title'])[3]"),
				"Ms");
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet2");
		String[] customer = data[0];
		customerLocators.contactdetailsname.sendKeys(customer[0]);
		customerLocators.email.sendKeys(customer[1]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("(//ng-select[@formcontrolname='phoneCountryId'])[2]"), "+255");
		customerLocators.phonenumber.sendKeys(customer[2]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[@formcontrolname='whatsAppCountryId'])[2]", "+246");
		customerLocators.whatsappnumber.sendKeys(customer[3]);
		customerLocators.primaryradiobutton.click();
	}

	public void contactdetailscrossbutton() {
		customerLocators.contactdetailscrossbutton.click();
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}
	}

	public void Enteraddressdetails() {
		customerLocators.addressdetailsaddnewline.click();
		String actualText = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]")).trim();
		if (HelperClass.isElementPresent(By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]"))) {
			System.out.println("Address details line added successfully");
		} else {
			System.out.println("Address details line not added: " + actualText);
		}
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("(//ng-select[@formcontrolname='addressType'])[2]"), "Business");
		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet2");
		String[] customer = data[1];
		customerLocators.address.sendKeys(customer[2]);
		customerLocators.city.sendKeys(customer[3]);
		customerLocators.county.sendKeys(customer[4]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("(//ng-select[normalize-space(@formcontrolname)='country'])[2]"), "United States");
		customerLocators.postcode.sendKeys(customer[5]);
	}

	public void addressdetailscrossbutton() {
		customerLocators.addressdetailscrossbutton.click();
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}

	}

	public void uploadfile() throws InterruptedException, AWTException {
		WebDriver driver = HelperClass.getDriver();
		WebElement chooseFileButton = driver.findElement(By.xpath("//div[@class='attachFile']"));
		chooseFileButton.click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		StringSelection selection = new StringSelection(imgpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		String actualText = HelperClass.getText(By.xpath("//a[normalize-space(text())='Delete Photo']")).trim();
		String expected = "Delete Photo";
		if (actualText.equals(expected)) {
			System.out.println("File uploaded successfully");
		} else {
			System.out.println("File not uploded: " + actualText);
		}
	}

	public void deletefile() {
		customerLocators.deletephoto.click();
		String actualText = HelperClass.getText(By.xpath("//mat-icon[normalize-space(text())='cloud_upload']")).trim();
		String expected = "cloud_upload";
		if (actualText.equals(expected)) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("File not deleted: " + actualText);
		}
	}

	public void addnewcustomercrossbutton() {
		customerLocators.addnewcustomercrossbutton.click();
		String actualText = HelperClass.getText(By.xpath("(//span[normalize-space(text())='Add Customer'])[1]"));
		String expected = "Add Customer";
		if (actualText.equals(expected)) {
			System.out.println("Add Customer page verified");
		} else {
			System.out.println("Not Matched: " + actualText);
		}

	}

	public void addnewcustomersearch() throws InterruptedException {
		Thread.sleep(2000);
		customerLocators.addnewcustomersearch.click();
		String actualText = HelperClass.getText(By.xpath("//mat-icon[text()='search']")).trim();
		String expected = "search";

		if (actualText.equals(expected)) {
			System.out.println("Search box is displayed");
		} else {
			System.out.println("Search box is not displayed");
		}
	}

	public void entercustomernameinsearchtextbox() throws InterruptedException {
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@data-placeholder)='Search']"), "monzo");
		Thread.sleep(3000);
		String actualText = HelperClass.getText(By.xpath("//a[normalize-space(text())='monzo']")).trim();
		String expected = "monzo";

		if (actualText.equals(expected)) {
			System.out.println("'monzo' name verified");
		} else {
			System.out.println("'monzo' name is not verified" + actualText);
		}

	}

	public void searchcrossbutton() {
		customerLocators.searchcrossbutton.click();
		String actualText = HelperClass.getText(By.xpath("//input[normalize-space(@placeholder)='Search']")).trim();
		if (HelperClass.isElementPresentAndDisplayed(By.xpath("//input[normalize-space(@placeholder)='Search']"))) {
			System.out.println("Customer name erased");
		} else {
			System.out.println("Customer name is not erased: " + actualText);
		}

	}

	public void customeraddbutton() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//table[@aria-describedby='Side List Table']/tbody/tr[1]/td[1]/div/div/a"));
		Thread.sleep(3000);
		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='Edit Customer']"));
		String expected = "Edit Customer";
		if (actualtext.equals(expected)) {

			System.out.println("Edit Customer verified");
		} else {
			System.out.println("Edit Customer not verified");
		}
		customerLocators.customeraddbutton.click();
		Thread.sleep(2000);
		String actualtext1 = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected1 = "Add New Customer";
		if (actualtext1.equals(expected1)) {

			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Add New Customer not verified");
		}
	}

	public void Clickthecheckboxandverifyoptionsareenabling() throws InterruptedException {
		Thread.sleep(2000);
		customerLocators.customercheckboxinaddnewcustomer.click();
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[1]"))
				.isDisplayed());
		System.out.println("Copy button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[2]"))
				.isDisplayed());
		System.out.println("Delete button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[3]"))
				.isDisplayed());
		System.out.println("EXCEL button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[4]"))
				.isDisplayed());
		System.out.println("CSV button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[5]"))
				.isDisplayed());
		System.out.println("PDF button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[6]"))
				.isDisplayed());
		System.out.println("PRINT button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[7]"))
				.isDisplayed());
		System.out.println("ARCHIVE button verified");
	}

	public void cancelrecord() throws InterruptedException {
		Thread.sleep(2000);
		customerLocators.cancelrecord.click();
		String actualtext1 = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected1 = "Add New Customer";
		if (actualtext1.equals(expected1)) {

			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Add New Customer not verified");
		}
	}

	public void exportexcel() {
		customerLocators.exportexcel.click();
	}

	public void exportcsv() {
		customerLocators.exportcsv.click();
	}

	public void exportpdf() {
		customerLocators.exportpdf.click();
	}

	public void cross() {
		customerLocators.cross.click();
		String actualtext1 = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected1 = "Add New Customer";
		if (actualtext1.equals(expected1)) {

			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Add New Customer not verified");
		}
	}

	public void customername() throws InterruptedException {
		customerLocators.customersearchbutton.click();
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search']"), "CASHBACK");
		Thread.sleep(3000);
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space(text())='CASHBACK']")).trim();
		String expected = "CASHBACK";

		if (actualText.equals(expected)) {
			System.out.println("'CASHBACK' name verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void selectallstatusandvalidate() throws InterruptedException {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//span[normalize-space()='All Status']",
				"Active");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td//span[normalize-space()='Active']",
				"Active");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//mat-select[@role='combobox']/div/div[contains(@class,'mat-select-arrow')])[1]", "Archived");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(),
				"//table/tbody/tr/td//span[normalize-space()='Archived']", "Archived");
	}

	public void exporttoexcel() {
		customerLocators.actions.click();
		customerLocators.exporttoexcel.click();
	}

	public void exporttocsv() {
		customerLocators.actions.click();
		customerLocators.exporttocsv.click();
	}

	public void exporttopdf() {
		customerLocators.actions.click();
		customerLocators.exporttopdf.click();
	}

	public void customercheckboxes() throws InterruptedException {
		customerLocators.customeridcheckbox.click();
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[1]"))
				.isDisplayed());
		System.out.println("Copy button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[2]"))
				.isDisplayed());
		System.out.println("Delete button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[3]"))
				.isDisplayed());
		System.out.println("EXCEL button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[4]"))
				.isDisplayed());
		System.out.println("CSV button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[5]"))
				.isDisplayed());
		System.out.println("PDF button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[6]"))
				.isDisplayed());
		System.out.println("PRINT button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[7]"))
				.isDisplayed());
		System.out.println("ARCHIVE button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[8]"))
				.isDisplayed());
		System.out.println("RESTORE button verified");
	}

	public void recordcancel() throws InterruptedException {
		customerLocators.recordcancel.click();
		Thread.sleep(2000);
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//mat-icon[normalize-space()='highlight_off']//parent::span"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}
	}

	public void exportexcelinselecteditem() {
		customerLocators.exportexcelinselecteditem.click();
	}

	public void exportcsvinselecteditem() {
		customerLocators.exportcsvinselecteditem.click();
	}

	public void exportpdfinselecteditem() {
		customerLocators.exportpdfinselecteditem.click();
	}

	public void customercheckbox() {
		customerLocators.customercheckbox.click();
	}

	public void selecteditemsarchiveyesbutton() throws InterruptedException {
		String actualText = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td/div/a")).trim();
		customerLocators.selecteditemsarchivebutton.click();
		String actualText1 = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Archive']")).trim();
		String expected2 = "Confirm Archive";
		if (actualText1.equals(expected2)) {
			System.out.println("'Confirm Archive' page verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		Thread.sleep(2000);
		customerLocators.selecteditemsarchiveyesbutton.click();
		Thread.sleep(3000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search']"), actualText);
		Thread.sleep(2000);
		String expected = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td[6]/div/div/div/span"));
		if (expected.equals("Archived")) {
			System.out.println("'Status verified as Archived'");
		} else {
			System.out.println("Text not matched. Actual: ");
		}

	}

	public void selecteditemsarchivenobutton() throws InterruptedException {
		String actualText = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td/div/a")).trim();
		String activeText = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td[6]/div/div/div/span"));
		customerLocators.selecteditemsarchivebutton.click();
		String actualText1 = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Archive']")).trim();
		String expected1 = "Confirm Archive";
		if (actualText1.equals(expected1)) {
			System.out.println("'Confirm Archive' page verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		Thread.sleep(2000);
		customerLocators.selecteditemsarchivenobutton.click();
		Thread.sleep(3000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search']"), actualText);
		Thread.sleep(2000);
		String expected = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td[6]/div/div/div/span"));
		if (activeText.equals(expected)) {
			System.out.println("'Status verified as Same'");
		} else {
			System.out.println("Text not matched. Actual: ");
		}
	}

	public void selecteditemcrossbutton() {
		customerLocators.selecteditemcrosssbutton.click();
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//mat-icon[normalize-space()='highlight_off']//parent::span"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}
	}

	public void addcustomerarrow() {
		customerLocators.addcustomerarrow.click();
		String actualText = HelperClass.getText(By.xpath("//mat-icon[normalize-space()='keyboard_arrow_up']")).trim();
		String expected = "keyboard_arrow_up";

		if (actualText.equals(expected)) {
			System.out.println("Arrow action verified");
		} else {
			System.out.println("Arrow action not verified: " + actualText);
		}
	}

	public void SelctToReviewOption() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='myPanelClass']")));
		By dropdown = By.xpath("//mat-select[@panelclass='myPanelClass']");
		WebElement element = driver.findElement(dropdown);
		HelperClass.clickUsingJS(element);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Active']//parent::mat-option")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='Active']//parent::mat-option"));
	}

	public void mousehoveredit() throws InterruptedException {
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='edit']/ancestor::button"));
		Thread.sleep(1000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//ng-select[@formcontrolname='title'])[1]",
				"Mr");
		String actualText = HelperClass.getText(By.xpath("(//span[normalize-space(text())='Miss'])[1]")).trim();
		String expected = "Mr";
		if (actualText.equals(expected)) {
			System.out.println("Title edited successfully");
		} else {
			System.out.println("Title not edited: " + actualText);
		}
		customerLocators.saveandexitbutton.click();

	}

	public void mousehoverdelete() throws InterruptedException {
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='delete_outline']/ancestor::button"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Delete']")).trim();
		String expected = "Confirm Delete";

		if (actualText.equals(expected)) {
			System.out.println("'Confirm Delete' page verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void mousehoverdeleteyesbutton() throws InterruptedException {
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='delete_outline']/ancestor::button"));
		HelperClass.clickUsingJS(By.xpath("//span[text()=' Yes ']"));
		Thread.sleep(1000);
		String actualText = HelperClass.getText(By.xpath(
				"//div[@class='ngx-spinner-overlay ng-tns-c77-0 ng-trigger ng-trigger-fadeIn ng-star-inserted ng-animating']"))
				.trim();
		String expected = "The record has been deleted successfully";

		if (actualText.equals(expected)) {
			System.out.println("The record has been deleted successfully");
		} else {
			System.out.println("The record has not deleted");
		}
	}

	public void mousehoverdeletenobutton() throws InterruptedException {
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='delete_outline']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='delete_outline']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' No ']")));
		HelperClass.clickUsingJS(By.xpath("//span[text()=' No ']"));
		Thread.sleep(2000);
		// customerLocators.mousehoverdeletenobutton.click();
	}

	public void mousehoverarchive() {
		WebElement element = driver.findElement(By.xpath("//mat-select[@panelclass='myPanelClass']"));
		HelperClass.clickDropdown(element);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Active']//ancestor::mat-option")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='Active']//ancestor::mat-option"));
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='archive']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='archive']/ancestor::button"));
		// customerLocators.mousehoverarchive.click();

	}

	public void ClickonPagiantionDropdownandValidteCount() throws Exception {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='10']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='10']"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/div/mat-checkbox"));

		String actualText = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected = "Records: 10";

		if (actualText.equals(expected)) {
			System.out.println("10 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='10']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='20']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/div/mat-checkbox"));

		String actualText1 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']")).trim();
		String expected1 = "Records: 20";

		if (actualText1.equals(expected1)) {
			System.out.println("20 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='50']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='50']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/div/mat-checkbox"));

		String actualText2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='50']")).trim();
		String expected2 = "Records: 50";

		if (actualText2.equals(expected2)) {
			System.out.println("50 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='100']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='100']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/div/mat-checkbox"));

		String actualText3 = HelperClass.getText(By.xpath("//p[normalize-space(text())='100']")).trim();
		String expected3 = "Records: 100";

		if (actualText3.equals(expected3)) {
			System.out.println("100 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void nextpageincustomer() {
		customerLocators.nextpageincustomer.click();
	}

	public void previouspageincustomer() {
		customerLocators.previouspageincustomer.click();
	}

	public void mousehoverarchiveyesbutton() {
		customerLocators.mousehoverarchiveyesbutton.click();
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Yes']//parent::button"));
		String actualText1 = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been archived successfully.']"))
				.trim();
		String expected1 = "The record has been archived successfully.";
		try {
			if (actualText1.equals(expected1)) {
				System.out.println("The record has been archived successfully.");
			} else {
				System.out.println("The record has been not archived." + actualText1);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Archived: " + e.getMessage());
		}
	}

	public void mousehoverarchivenobutton() {
		customerLocators.mousehoverarchivenobutton.click();
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='No']//parent::button"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Archive']")).trim();
		String expected = "Confirm Archive";
		try {
			if (HelperClass.isElementPresentAndDisplayed(By.xpath("//h2[normalize-space(text())='Confirm Archive']"))) {
				System.out.println("Confirm Archive verified");
			} else {
				System.out.println("Confirm Archive should not display" + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public boolean isPageHighlighted(String pageNumber) {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String activePageXpath = "//div[contains(@class,'paginator-pages-count')]"
				+ "//button[contains(@class,'active')]" + "//span[@class='mat-button-wrapper' and normalize-space()='"
				+ pageNumber + "']";

		try {
			WebElement activePage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(activePageXpath)));
			return activePage.isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void VerifyGoTopageNumber() {

		WebElement goToInput = driver.findElement(By.xpath("//input[@type='number']"));
		goToInput.clear();
		goToInput.sendKeys("2", Keys.ENTER);

		if (isPageHighlighted("2")) {
			System.out.println("Page 2 is highlighted successfully.");
		} else {
			System.out.println("Page 2 highlight check failed.");
		}

	}

	public void Clickoncopybuttoninaddnewcustomer() {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[1]"));
		String actualText = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been copied successfully.']")).trim();
		String expected = "The record has been copied successfully.";
		try {
			if (actualText.equals(expected)) {
				System.out.println("The record has been copied successfully.");
			} else {
				System.out.println("The record not copied: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Copy: " + e.getMessage());
		}
	}

	public void Clickondeleteyesbuttoninaddnewcustomer() {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[2]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Delete']")).trim();
		String expected = "Confirm Delete";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Yes']//parent::button"));
		String actualText1 = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been deleted successfully.']")).trim();
		String expected1 = "The record has been deleted successfully.";
		try {
			if (actualText1.equals(expected1)) {
				System.out.println("The record has been deleted successfully.");
			} else {
				System.out.println("Unable to delete, Customers are in use." + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public void Clickondeletenobuttoninaddnewcustomer() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[2]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Delete']")).trim();
		String expected = "Confirm Delete";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='No']//parent::button"));
		Thread.sleep(3000);
		try {
			if (HelperClass.isElementPresentAndDisplayed(By.xpath("//h2[normalize-space(text())='Confirm Delete']"))) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete should not display" + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public void Clickonarchiveyesbuttoninaddnewcustomer() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[7]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Archive']")).trim();
		String expected = "Confirm Archive";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Archive verified");
			} else {
				System.out.println("Confirm Archive not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Yes']//parent::button"));
		Thread.sleep(3000);
		String actualText1 = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been archived successfully.']"))
				.trim();
		String expected1 = "The record has been archived successfully.";
		try {
			if (actualText1.equals(expected1)) {
				System.out.println("The record has been archived successfully.");
			} else {
				System.out.println("The record has been not archived." + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Archived: " + e.getMessage());
		}
	}

	public void Clickonarchivenobuttoninaddnewcustomer() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[7]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Archive']")).trim();
		String expected = "Confirm Archive";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Archive verified");
			} else {
				System.out.println("Confirm Archive not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='No']//parent::button"));
		Thread.sleep(3000);
		try {
			if (HelperClass.isElementPresentAndDisplayed(By.xpath("//h2[normalize-space(text())='Confirm Archive']"))) {
				System.out.println("Confirm Archive verified");
			} else {
				System.out.println("Confirm Archive should not display" + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public void Clickonselecteditemscopybutton() {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[1]"));
		String actualText = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been copied successfully.']")).trim();
		String expected = "The record has been copied successfully.";
		try {
			if (actualText.equals(expected)) {
				System.out.println("The record has been copied successfully.");
			} else {
				System.out.println("The record not copied: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Copy: " + e.getMessage());
		}
	}

	public void Clickonselecteditemsdeleteyesbutton() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[2]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Delete']")).trim();
		String expected = "Confirm Delete";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Yes']//parent::button"));
		String actualText1 = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been deleted successfully.']")).trim();
		String expected1 = "The record has been deleted successfully.";
		try {
			if (actualText1.equals(expected1)) {
				System.out.println("The record has been deleted successfully.");
			} else {
				System.out.println("Unable to delete, Customers are in use." + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public void Clickonselecteditemsdeletenobutton() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[2]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Delete']")).trim();
		String expected = "Confirm Delete";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='No']//parent::button"));
		Thread.sleep(3000);
		try {
			if (HelperClass.isElementPresentAndDisplayed(By.xpath("//h2[normalize-space(text())='Confirm Delete']"))) {
				System.out.println("Confirm Delete verified");
			} else {
				System.out.println("Confirm Delete should not display" + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Delete: " + e.getMessage());
		}
	}

	public void Clickoncustomercheckboxincustomer() {
		customerLocators.customercheckboxincustomer.click();
	}

	public void selecteditemsrestoreyesbutton() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[8]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Restore']")).trim();
		String expected = "Confirm Restore";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Restore verified");
			} else {
				System.out.println("Confirm Restore not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Restore: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Yes']//parent::button"));
		Thread.sleep(3000);
		String actualText1 = HelperClass
				.getText(By.xpath("//div[normalize-space(text())='The record has been restored successfully.']"))
				.trim();
		String expected1 = "The record has been restored successfully.";
		try {
			if (actualText1.equals(expected1)) {
				System.out.println("The record has been restored successfully.");
			} else {
				System.out.println("The record has been not restored." + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Restore: " + e.getMessage());
		}
	}

	public void selecteditemsrestorenobutton() throws InterruptedException {
		HelperClass.clickUsingJS(By.xpath("(//button[normalize-space(@type)='button'])[8]"));
		String actualText = HelperClass.getText(By.xpath("//h2[normalize-space(text())='Confirm Restore']")).trim();
		String expected = "Confirm Restore";
		try {
			if (actualText.equals(expected)) {
				System.out.println("Confirm Restore verified");
			} else {
				System.out.println("Confirm Restore not verified: " + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Restore: " + e.getMessage());
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='No']//parent::button"));
		Thread.sleep(3000);
		try {
			if (HelperClass.isElementPresentAndDisplayed(By.xpath("//h2[normalize-space(text())='Confirm Restore']"))) {
				System.out.println("Confirm Restore verified");
			} else {
				System.out.println("Confirm Restore should not display" + actualText);
			}
		} catch (Exception e) {
			System.out.println("An error occurred while verifying Confirm Restore: " + e.getMessage());
		}
	}

}
