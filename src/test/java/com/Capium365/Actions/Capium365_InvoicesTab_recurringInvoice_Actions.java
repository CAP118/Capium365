package com.Capium365.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.ExcelReader;
import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_InvoicesTab_recurringInvoice_Locators;

public class Capium365_InvoicesTab_recurringInvoice_Actions {

	Capium365_InvoicesTab_recurringInvoice_Locators recurringinvoices = null;
	 
	public Capium365_InvoicesTab_recurringInvoice_Actions() {
		this.recurringinvoices = new Capium365_InvoicesTab_recurringInvoice_Locators();
		PageFactory.initElements(HelperClass.getDriver(), recurringinvoices);
	}
 
	String RecurringFilePath = "D:\\Core Modules\\Capium365\\src\\test\\resources\\Files_Excel\\Recurring invoice (1).xlsx";
	String filePath = "C:\\Users\\user\\Downloads\\Capium logo.jpg";
	
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
 
	public void invoicestab() throws Exception {
		By receiptsTab = By.xpath("//span[text()='Invoices']//parent::a");
		WebElement element = HelperClass.waitUntilClickable(receiptsTab);
		element.click();
	}
 
	public void Arrowbutton() throws Exception {
		try {
			By arrowButton = By.xpath(
					"//div[contains(@class,'toggle-menu')]/mat-icon[normalize-space(text())='keyboard_arrow_right']");
			WebElement arrow = HelperClass.waitUntilClickable(arrowButton);
			HelperClass.scrollToElement(arrow);
			((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", arrow);
			Log.info("Clicked sidebar expand arrow.");
 
		} catch (Exception e) {
			Log.error("Failed to click sidebar expand arrow: ");
			e.printStackTrace();
		}
	}
 
	public void recurringinvoicetab() {
		By creditTab = By.xpath("//a[@mattooltip='Recurring']");
		WebElement credit = HelperClass.waitUntilClickable(creditTab);
		credit.click();
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Add Recurring Invoice']"));
		String expected = "Add Recurring Invoice";
		if (actualText.equals(expected)) {
			System.out.println("Add Recurring Invoice page verified");
		} else {
			System.out.println("Add Recurring Invoice page is not verified");
		}
	}
 
	public void addrecurringinvoicebutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[normalize-space()='Add Recurring Invoice']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='Add Recurring Invoice']/ancestor::button"));
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Add New Recurring Invoice']"));
		String expected = "Add New Recurring Invoice";
		if (actualText.equals(expected)) {
			System.out.println("Add New Recurring Invoice page verified");
		} else {
			System.out.println("Add New Recurring Invoice page is not verified");
		}
	}
 
	public void editbuttonincompanydetails() throws InterruptedException {
		Thread.sleep(1000);
		recurringinvoices.editbuttonincompanydetails.click();
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Edit Company Details']"));
		String expected = "Edit Company Details";
		if (actualText.equals(expected)) {
			System.out.println("Edit Company Details page verified");
		} else {
			System.out.println("Edit Company Details page is not verified");
		}
	}
 
	public void Clickonsavewithoutgivingmandatorydetailsincompanydetails() throws InterruptedException, IOException {
 
		HelperClass.clearField(HelperClass.getDriver(), recurringinvoices.addressincompanydetails);
		HelperClass.clearField(HelperClass.getDriver(), recurringinvoices.postalcodeincompanydetails);
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));
		HelperClass.captureScreenshot("mandatory fields required message verified");
	}
 
	public void Clickonsavewithgivingmandatorydetailsincomapanydetails() throws InterruptedException {
		HelperClass.clearField(HelperClass.getDriver(),
				By.xpath("//input[normalize-space(@formcontrolname)='address1']"));
 
		HelperClass.clearField(HelperClass.getDriver(),
				By.xpath("//input[normalize-space(@formcontrolname)='postalCode']"));
		Thread.sleep(3000);
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] companydetails = data[0];
		recurringinvoices.addressincompanydetails.sendKeys(companydetails[0]);
		recurringinvoices.postalcodeincompanydetails.sendKeys(companydetails[1]);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));
		Thread.sleep(3000);
		String actualtext = HelperClass.getText(By.xpath("(//div[normalize-space(@class)='mt-5'])[2]"));
		String expected = "612 manchester";
		if (actualtext.equals(expected)) {
 
			System.out.println("Address verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void cancelbuttonincompanydetails() {
		recurringinvoices.cancelbuttonincompanydetails.click();
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Add New Recurring Invoice']"));
		String expected = "Add New Recurring Invoice";
		if (actualText.equals(expected)) {
 
			System.out.println("Add New Recurring Invoice page verified");
		} else {
			System.out.println("Add New Recurring Invoice page is not verified");
		}
	}
 
	public void customernameaddbutton() {
		recurringinvoices.customernameaddbutton.click();
		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected = "Add New Customer";
		if (actualtext.equals(expected)) {
 
			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Add New Customer not verified");
		}
	}
 
	public void Fillallmandatorydetailsinaddnewcustomer() throws InterruptedException {
 
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//ng-select[@formcontrolname='title'])[1]",
				"Miss");
 
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] customer = data[0];
		recurringinvoices.fullnameincustomer.sendKeys(customer[2]);
		recurringinvoices.emailincustomer.sendKeys(customer[3]);
		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-button-wrapper'])[16]"));
		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space()='Back to Recurring Invoice'])[1]"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[1]"), "Lahari");
		Thread.sleep(4000);
 
		HelperClass.selectFirstSuggestedCustomer("Lahari");
 
	}
 
	public void Fillallnonmandatorydetailsinaddnewcustomer() throws InterruptedException, AWTException, IOException {
 
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='phoneCountryId']",
				"+91");
 
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] customer = data[0];
		recurringinvoices.phonenumberincustomer.sendKeys(customer[4]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[@formcontrolname='whatsAppCountryId']", "+91");
		recurringinvoices.whatappnumberincustomer.sendKeys(customer[5]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), ("//ng-select[@formcontrolname='addressType']"),
				"Postal");
		recurringinvoices.addressincustomer.sendKeys(customer[6]);
		recurringinvoices.cityincustomer.sendKeys(customer[7]);
		recurringinvoices.countyincustomer.sendKeys(customer[8]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("//ng-select[normalize-space(@formcontrolname)='country']"), "United Kingdom");
		recurringinvoices.postalcodeincustomer.sendKeys(customer[9]);
 
		WebDriver driver = HelperClass.getDriver();
		WebElement chooseFileButton = driver.findElement(By.xpath("//div[@class='attachFile']"));
		chooseFileButton.click();
		Thread.sleep(2000);
 
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
 
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), ("//ng-select[@formcontrolname='paymentDue']"),
				"On receipt");
 
		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-button-wrapper'])[16]"));
		HelperClass.captureScreenshot("mandatory fields required message verified");
	}
 
	public void selectcustomerandverify() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[1]"), "Sam");
		Thread.sleep(4000);
 
		HelperClass.selectFirstSuggestedCustomer("Sam");
	}
 
	public void addnewlineincontactdetails() throws InterruptedException {
		recurringinvoices.addnewlineincontactdetails.click();
		String actualText = HelperClass.getText(By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))
				.trim();
		if (HelperClass.isElementPresent(By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))) {
			System.out.println("Contact details line added successfully");
		} else {
			System.out.println("Contact details line not added: " + actualText);
		}
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//ng-select[@formcontrolname='title'])[3]",
				"Mr");
 
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] customer = data[1];
		recurringinvoices.fullnameincustomeraddnewline.sendKeys(customer[2]);
		recurringinvoices.emailincustomeraddnewline.sendKeys(customer[3]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("(//ng-select[@formcontrolname='phoneCountryId'])[2]"), "+255");
		recurringinvoices.phonenumberincustomeraddnewline.sendKeys(customer[4]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[@formcontrolname='whatsAppCountryId'])[2]", "+246");
		recurringinvoices.whatsappnumberincustomeraddnewline.sendKeys(customer[5]);
		HelperClass.clickUsingJS(By.xpath("(//mat-radio-button[@formcontrolname='isPrimary'])[2]"));
	}
 
public void addnewlinecrossbuttonincontactdetails() throws InterruptedException {
		Thread.sleep(2000);
		recurringinvoices.addnewlinecrossbuttonincontactdetails.click();
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//table[@aria-describedby='Add Customer Table']/tbody/tr[2]"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}
 
	}
 
	public void addnewlineinaddressdetails() throws InterruptedException {
		recurringinvoices.addnewlineinaddressdetails.click();
		String actualText = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]")).trim();
		if (HelperClass.isElementPresent(By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]"))) {
			System.out.println("Address details line added successfully");
		} else {
			System.out.println("Address details line not added: " + actualText);
		}
		HelperClass.scrollUntilElementVisible(HelperClass.getDriver(), recurringinvoices.addressincustomeraddnewline);
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] customer = data[1];
		recurringinvoices.addressincustomeraddnewline.sendKeys(customer[6]);
		recurringinvoices.cityincustomeraddnewline.sendKeys(customer[7]);
		recurringinvoices.countyincustomeraddnewline.sendKeys(customer[8]);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				("(//ng-select[normalize-space(@formcontrolname)='country'])[2]"), "United States");
		recurringinvoices.postalcodeincustomeraddnewline.sendKeys(customer[9]);
 
	}
 
	public void addnewlinecrossbuttoninaddressdetails() throws InterruptedException {
		Thread.sleep(1000);
		recurringinvoices.addnewlinecrossbuttoninaddressdetails.click();
		if (HelperClass.isElementPresentAndDisplayed(
				By.xpath("//table[@aria-describedby='Address details table']/tbody/tr[2]"))) {
			System.out.println("Element is still present");
		} else {
			System.out.println("Element is removed");
		}
	}
 
	public void Enteremail() {
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet1");
		String[] customer = data[0];
		recurringinvoices.emailincustomer.sendKeys(customer[3]);
	}
 
	public void cancelchangesinaddnewcustomer() {
		recurringinvoices.cancelchangesinaddnewcustomer.click();
		String actualText = HelperClass.getText(By.xpath("//input[@formcontrolname='email']")).trim();
		System.out.println(actualText);
		String expected = "";
		if (actualText.equals(expected)) {
			System.out.println("Email cleared successfully");
		} else {
			System.out.println("Email not cleared: " + actualText);
		}
 
	}
 
	public void clickonsettingsandsaveandverify() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(@fontset)='material-icons-outlined'])[11]"));
 
		Thread.sleep(2000);
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[10]"), "1000",
				By.xpath("//div[normalize-space(text())='1000-Sales']"));
		HelperClass.SearchAndSelectClientclear(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[11]"), "Cash",
				By.xpath("//div[normalize-space(text())='Cash Account']"));
		Thread.sleep(3000);
		HelperClass.SearchAndSelectClientclear(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[12]"), "Reduced",
				By.xpath("//span[normalize-space(text())='Reduced (5.0%)']"));
 
		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[3]"));
 
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));
 
	}
 
	public void selectduedateandverifyininvoices() throws TimeoutException, IOException, InterruptedException {
 
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='paymentDue']", "Net 7");
 
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("//input[normalize-space(@formcontrolname)='itemName']"), "PR004",
				By.xpath("//span[normalize-space(text())='PR004 - Item 2']"));
 
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='price']"), "100");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
		Thread.sleep(3000);
		HelperClass.captureScreenshot("due date verified");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//mat-icon[normalize-space(text())='receipt_long'])[2]")));
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='receipt_long'])[2]"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='search']"), "Sam");
 
		String actualText = HelperClass.getText(By.xpath("//div[normalize-space(text())='Sam']")).trim();
		String expected = "Sam";
 
		if (actualText.equals(expected)) {
			System.out.println("'Sam' name verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}
 
	public void checkrepeatinvoicecheckboxandverifyininvoice() throws InterruptedException, TimeoutException {
 
		Thread.sleep(2000);
 
		HelperClass.clickUsingJS(By.xpath("//mat-checkbox[normalize-space(@formcontrolname)='isRepeatInvoice']"));
 
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[4]"), "Daily",
				By.xpath("//span[normalize-space(text())='Daily']"));
 
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("//input[normalize-space(@formcontrolname)='itemName']"), "PR004",
				By.xpath("//span[normalize-space(text())='PR004 - Item 2']"));
 
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='price']"), "100");
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
 
		Thread.sleep(3000);
 
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//mat-icon[normalize-space(text())='receipt_long'])[2]")));
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='receipt_long'])[2]"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='search']"), "Sam");
 
		String actualText = HelperClass.getText(By.xpath("//div[normalize-space(text())='Sam']")).trim();
		String expected = "Sam";
 
		if (actualText.equals(expected)) {
			System.out.println("'Sam' name verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}
 
	public void clickondiscountoptionandverifyvalue() throws TimeoutException, InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("//input[normalize-space(@formcontrolname)='itemName']"), "PR004",
				By.xpath("//span[normalize-space(text())='PR004 - Item 2']"));
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='price']"), "100");
		Thread.sleep(2000);
		HelperClass.setValueUsingJS(By.xpath("//input[normalize-space(@formcontrolname)='discountValue']"), "10");
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//input[normalize-space(@formcontrolname)='netAmount']"));
		Thread.sleep(3000);
		String actualtext = HelperClass.getText(By.xpath("//input[normalize-space(@formcontrolname)='netAmount']"))
				.trim();
		String expected = "90.00";
		if (actualtext.equals(expected)) {
 
			System.out.println("Discount amount verified");
		} else {
			System.out.println("Not Matched:" + actualtext);
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
	}
 
	public void additemandverify() throws TimeoutException, InterruptedException {
 
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("//input[normalize-space(@formcontrolname)='itemName']"), "PR004",
				By.xpath("//span[normalize-space(text())='PR004 - Item 2']"));
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='price'])[1]"), "100");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='add'])[1]"));
		Thread.sleep(2000);
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("(//input[normalize-space(@formcontrolname)='itemName'])[2]"), "PR005",
				By.xpath("//span[normalize-space(text())='PR005 - Item 3']"));
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='price'])[2]"), "200");
 
		Thread.sleep(3000);
		String actualtext = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Invoices Basic Info Table']/tbody/tr[2]"));
		if (HelperClass
				.isElementPresent(By.xpath("//table[@aria-describedby='Invoices Basic Info Table']/tbody/tr[2]"))) {
			System.out.println("line added successfully");
		} else {
			System.out.println("line not added: " + actualtext);
		}
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
 
	}
 
	public void selectexistingitem() throws TimeoutException {
 
		HelperClass.SearchAndSelectClient(HelperClass.getDriver(), HelperClass.getWait(),
				By.xpath("//input[normalize-space(@formcontrolname)='itemName']"), "PR004",
				By.xpath("//span[normalize-space(text())='PR004 - Item 2']"));
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='price'])[1]"), "100");
 
	}
 
	public void clickonaddbankandentermandetails() throws InterruptedException, TimeoutException {
 
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Add new bank account']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//a[normalize-space(text())='Add New Line']"));
		Thread.sleep(2000);
		String[][] data = ExcelReader.getSheetData(RecurringFilePath, "Sheet2");
		String[] payment = data[0];
		try {
			WebElement lastEmptyAccountName = driver.findElement(By.xpath(
					"(//input[@formcontrolname='accountName' and not(@disabled) and normalize-space(@value)=''])[last()]"));
			lastEmptyAccountName.sendKeys(payment[0] + Keys.ENTER);
			HelperClass.sleep1(1000);
			WebElement lastEmptyAccountNumber = driver.findElement(
					By.xpath("(//input[@formcontrolname='accountNumber' and normalize-space(@value)=''])[last()]"));
			lastEmptyAccountNumber.sendKeys(payment[1] + Keys.ENTER);
			HelperClass.sleep1(1000);
			WebElement lastEmptyBranchCode = driver.findElement(
					By.xpath("(//input[@formcontrolname='branchCode' and normalize-space(@value)=''])[last()]"));
			lastEmptyBranchCode.sendKeys(payment[2] + Keys.ENTER);
			HelperClass.sleep1(1000);
			HelperClass.clickUsingJS(By.xpath("(//mat-radio-button[normalize-space(@name)='isDefault'])[5]"));
			HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']//parent::button"));
 
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Could not locate empty row to fill bank details", e);
		}
 
	}
 
	public void selectexistingbankaccount() throws InterruptedException, TimeoutException {
 
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='paymentDetail']", "RBL");
		Thread.sleep(2000);
 
	}
 
	public void Selectrepeatinvoicestatus() throws InterruptedException {
 
		Thread.sleep(4000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[4]"), "Daily");
		HelperClass.selectFirstSuggestedCustomer("Daily");
	}
 
	public void Clickonsaveandnewandverifyrecurringinvoice() throws InterruptedException {
 
		Thread.sleep(2000);
		WebElement recurringinvoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = recurringinvoiceField.getAttribute("value").trim();
		String modifiedInvoiceId = "R" + invoiceId;
		System.out.println("Modified Invoice ID: " + modifiedInvoiceId);
 
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='arrow_drop_down']"));
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//button[normalize-space(text())='Save and New']"));
		Thread.sleep(3000);
		String actualText = HelperClass
				.getText(By.xpath("(//span[normalize-space(text())='Add New Recurring Invoice'])[1]")).trim();
		String expected = "Add New Recurring Invoice";
 
		if (actualText.equals(expected)) {
			System.out.println("'Add New Recurring Invoice' page verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='close']"));
		Thread.sleep(2000);
		HelperClass.setValueUsingJS(By.xpath("//input[normalize-space(@placeholder)='Search here...']"), invoiceId);
		Thread.sleep(5000);
		String actualText1 = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Recurring invoices list table']/tbody/tr[1]/td[2]"))
				.trim();
		String expected2 = invoiceId;
 
		if (actualText1.equals(expected2)) {
			System.out.println("'Add New Recurring Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText1);
		}
	}
 
	public void Clickonsaveandcontinueandverifyrecurringinvoice() throws InterruptedException {
		WebElement recurringinvoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = recurringinvoiceField.getAttribute("value").trim();
		String modifiedInvoiceId = "R" + invoiceId;
		System.out.println("Modified Invoice ID: " + modifiedInvoiceId);
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Continue']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='close']"));
		Thread.sleep(2000);
		HelperClass.setValueUsingJS(By.xpath("//input[normalize-space(@placeholder)='Search here...']"), invoiceId);
		Thread.sleep(5000);
		String actualText1 = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Recurring invoices list table']/tbody/tr[1]/td[2]"))
				.trim();
		String expected2 = invoiceId;
 
		if (actualText1.equals(expected2)) {
			System.out.println("'Add New Recurring Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText1);
		}
	}
 
	public void Clickonsaveandexitandverifyrecurringinvoice() throws InterruptedException {
		WebElement recurringinvoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = recurringinvoiceField.getAttribute("value").trim();
		String modifiedInvoiceId = "R" + invoiceId;
		System.out.println("Modified Invoice ID: " + modifiedInvoiceId);
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='Save and Exit']/parent::button"));
		Thread.sleep(3000);
		HelperClass.setValueUsingJS(By.xpath("//input[normalize-space(@placeholder)='Search here...']"), invoiceId);
		Thread.sleep(5000);
		String actualText1 = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Recurring invoices list table']/tbody/tr[1]/td[2]"))
				.trim();
		String expected2 = invoiceId;
 
		if (actualText1.equals(expected2)) {
			System.out.println("'Add New Recurring Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText1);
		}
	}
 
	public void Clickoncancelchangesandverifydetails() throws InterruptedException, IOException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Cancel Changes']"));
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Cancel changes verified");
	}
 
	public void clickonaddnewrecurringinvoiceplusbuttonandverify() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(
				By.xpath("//table[@aria-describedby='Side List Details Table']/tbody/tr[1]/td[1]/div/div/a"));
		Thread.sleep(2000);
		HelperClass.clickUsingJS(
				By.xpath("//div[contains(@class,'side-list')]/a/mat-icon[contains(text(),'add_circle')]"));
		Thread.sleep(2000);
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Recurring Invoice']"))
				.trim();
		String expected = "Add New Recurring Invoice";
 
		if (actualText.equals(expected)) {
			System.out.println("'Add New Recurring Invoice' verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}
 
	public void checkthecheckboxandverifyoptionsareenabling() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
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
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[7]"))
				.isDisplayed());
		System.out.println("END button verified");
 
	}
 
	public void clickexporttoexcel() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='border_all']"));
		Thread.sleep(2000);
	}
 
	public void clickexporttocsv() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='description'])[1]"));
		Thread.sleep(2000);
	}
 
	public void clickexporttopdf() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='picture_as_pdf']"));
		Thread.sleep(2000);
	}
 
	public void enterrecurringinvoicenameandverify() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search here...']"), "RINV402");
		Thread.sleep(3000);
 
		String actualText = HelperClass
				.getText(By.xpath("//table[@aria-describedby='Recurring invoices list table']/tbody/tr[1]/td[2]"))
				.trim();
		String expected = "RINV402";
 
		if (actualText.equals(expected)) {
			System.out.println("'Recurring Invoice' id verified");
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
				"(//mat-select[@role='combobox']/div/div[contains(@class,'mat-select-arrow')])[1]", "Inactive(Paused)");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(),
				"//table/tbody/tr/td//span[normalize-space()='Inactive(Paused)']", "Inactive(Paused)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//mat-select[@role='combobox']/div/div[contains(@class,'mat-select-arrow')])[1]", "Inactive(Ended)");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(),
				"//table/tbody/tr/td//span[normalize-space()='Inactive(Ended)']", "Inactive(Ended)");
	}
 
	public void clickonalltimestatusandverify() throws TimeoutException, InterruptedException, IOException {
 
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "This Week");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This week invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Last Week");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last week invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "This Month");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This Month invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Last Month");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Month invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "This Quarter");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This Quarter invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Last Quarter");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Quarter invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "This Year");
		Thread.sleep(3000);
		HelperClass.captureScreenshot("This Year invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Last Year");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Year invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Custom");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Custom invoices are captured");
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "This Financial Year");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This Financial Year invoices are captured");
	}
 
	public void clickoninvoicecheckboxandverifyenablingoptions() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
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
		assertTrue(HelperClass.getDriver().findElement(By.xpath("(//button[normalize-space(@type)='button'])[7]"))
				.isDisplayed());
		System.out.println("END button verified");
 
	}
 
	public void clickonexportreportasexcel() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='border_all']"));
		Thread.sleep(2000);
 
	}
 
	public void clickonexportreportascsv() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='description'])[1]"));
		Thread.sleep(2000);
	}
 
	public void clickonexportreportaspdf() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='picture_as_pdf']"));
		Thread.sleep(2000);
 
	}
 
	public void clickonactions() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[text()='more_vert'])[1]"));
	}
 
	public void clickonactionsexportexcel() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='border_all']"));
		Thread.sleep(2000);
 
	}
 
	public void clickonactionsexportcsv() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='description'])[2]"));
		Thread.sleep(2000);
	}
 
	public void clickonactionsexportpdf() throws InterruptedException {
 
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='picture_as_pdf']"));
		Thread.sleep(2000);
 
	}
 
}
 
 
