package com.Capium365.Actions;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_InvoicesTab_CreditNotes_Locators;

public class Capium365_InvoicesTab_CreditNotes_Actions {

	Capium365_InvoicesTab_CreditNotes_Locators CreditNoteLocators = null;

	public Capium365_InvoicesTab_CreditNotes_Actions() {
		this.CreditNoteLocators = new Capium365_InvoicesTab_CreditNotes_Locators();
		PageFactory.initElements(HelperClass.getDriver(), CreditNoteLocators);

	}
	
	String filePath = "C:\\Users\\user\\Documents\\Receipt 2.pdf";

	WebDriverWait wait=HelperClass.getWait();
	WebDriver driver=HelperClass.getDriver();
			
	public void Clickoninvoicecreditnoteandverifypage() throws InterruptedException {
		By receiptsTab = By.xpath("//span[text()='Invoices']//parent::a");
		WebElement element = HelperClass.waitUntilClickable(receiptsTab);
		element.click();
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
		By creditTab = By.xpath("//a[@mattooltip='Credit Notes']");
		WebElement credit = HelperClass.waitUntilClickable(creditTab);
		credit.click();

		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='Add Credit Note']")).trim();
		String expected = "Add Credit Note";

		if (actualText.equals(expected)) {
			System.out.println("'Add Credit Note' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void getcustomerscountandvalidate() throws InterruptedException {

		Thread.sleep(3000);

		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='11']")).trim();
		String expected = "11";

		if (actualText.equals(expected)) {
			System.out.println("Customer Count verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void getinvoicecountandvalidate() throws InterruptedException {

		Thread.sleep(3000);

		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='189']")).trim();
		String expected = "189";

		if (actualText.equals(expected)) {
			System.out.println("Invoice Count verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void Verifytotalraisedcount() throws InterruptedException {

		Thread.sleep(3000);

		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='£ 516,637.01']")).trim();
		String expected = "£ 516,637.01";

		if (actualText.equals(expected)) {
			System.out.println("Raised Count verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void Clickonaddinvoicecreditnoteandverifypage() throws InterruptedException {

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Add Credit Note']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Add Credit Note']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Add New Invoice Credit Note']")));
		String actualText = HelperClass
				.getText(By.xpath("//span[normalize-space(text())='Add New Invoice Credit Note']")).trim();
		String expected = "Add New Invoice Credit Note";

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice Credit Note' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void Clickoneditcompanydetailswithoutgivingmandetailsandverify() throws InterruptedException, IOException {

		Thread.sleep(3000);

		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='edit']"));

		if (CreditNoteLocators.editcompanydetails.isDisplayed()) {
			System.out.println("Edit icon clicked successfully");
		}
		Thread.sleep(3000);

		HelperClass.clearField(HelperClass.getDriver(),
				By.xpath("//input[normalize-space(@formcontrolname)='address1']"));

		HelperClass.clearField(HelperClass.getDriver(), By.xpath("//input[normalize-space(@formcontrolname)='city']"));

		HelperClass.clearField(HelperClass.getDriver(),
				By.xpath("//input[normalize-space(@formcontrolname)='postalCode']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));

		HelperClass.captureScreenshot("mandatory fields required message verified");

	}

	public void Clickoneditcompanydetailswithgivingmandetailsandverify() throws InterruptedException {

		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='edit']"));

		if (CreditNoteLocators.editcompanydetails.isDisplayed()) {
			System.out.println("Edit icon clicked successfully");
		}
		Thread.sleep(3000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='address1']"), "612 manchester");

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='city']"), "manchester");

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='postalCode']"), "W1A 1HQ1");

		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));

		Thread.sleep(3000);

		if (CreditNoteLocators.manchester.isDisplayed()) {
			System.out.println("Address verified");
		} else {
			System.out.println("Address is not verified");
		}
	}

	public void clickonaddcustomerandverifypage() throws InterruptedException {

		Thread.sleep(2000);

		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(@fontset)='material-icons-outlined'])[11]"));

		Thread.sleep(2000);

		if (CreditNoteLocators.addnewcustomer.isDisplayed()) {
			System.out.println("add customer page is verified");
		} else {
			System.out.println("add customer page is not verified");
		}
	}

	public void Fillthemandatorydetailsandsave() throws InterruptedException {

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='fullName']"), "Ushaa");
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='email']"), "ushaa@gmail.com");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-button-wrapper'])[16]"));

	}

	public void Fillthemandatorydetailsandclickaddrowandsave() throws InterruptedException {

		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='fullName'])[1]"), "rani rani");

		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='email'])[1]"),
				"gowrii@gmail.com");

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//a[normalize-space(text())='Add New line']"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='name'])[2]"), "panduu");
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='email'])[2]"),
				"panduu@gmail.com");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath(
				"//button[@class='mat-focus-indicator action-button primary-button mr-1 mat-button mat-button-base']"));
		Thread.sleep(2000);
	}

	public void selectthecustomerandverifydetails() throws InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//input[normalize-space(@aria-autocomplete)='list'])[1]", "sriram");
		Thread.sleep(2000);
		// HelperClass.selectFirstSuggestedCustomer("sriram");

	}

	public void clickonsettingsandsaveandverify() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(@fontset)='material-icons-outlined'])[11]"));

		Thread.sleep(2000);

		if (CreditNoteLocators.customersettings.isDisplayed()) {
			System.out.println("Customer settings opened successfully");
		} else {
			System.out.println("Customer settings not opened ");
		}

		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[3]"));

		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));

	}

	public void selectduedateandverifyininvoices() throws TimeoutException, IOException, InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='paymentDue']", "Net 7");

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
		Thread.sleep(3000);
		HelperClass.captureScreenshot("due date verified");

	}

	public void clickondiscountoptionandverifyvalue() throws TimeoutException, InterruptedException {

		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[3]", "%");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");
		Thread.sleep(2000);
		HelperClass.setValueUsingJS(By.xpath("//input[normalize-space(@formcontrolname)='discountValue']"), "10");
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
		Thread.sleep(3000);
		String actualtext = HelperClass.getText(By.xpath("//input[normalize-space(@formcontrolname)='netAmount']"));
		String expected = "90.00";
		if (actualtext == expected) {

			System.out.println("discount amount verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void additemandverify() throws TimeoutException, InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='add'])[1]"));
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[5]", "PR003 - Item 1");

		Thread.sleep(2000);
		if (CreditNoteLocators.secondaddeditem.isDisplayed()) {
			System.out.println("newly added item verified");
		} else {
			System.out.println("Not Matched");
		}
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
		Thread.sleep(2000);

	}

	public void selectexistingitem() throws TimeoutException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");

	}

	public void clickonaddbankandentermandetails() throws InterruptedException, TimeoutException {

		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Add new bank account']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//a[normalize-space(text())='Add New Line']"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='accountName'])[6]"), "RBL");
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='accountNumber'])[6]"), "355532");
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='branchCode'])[6]"), "35");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));

		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='paymentDetail']", "RBL");
		Thread.sleep(3000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='RBL']"));
		String expected = "RBL";
		if (actualtext == expected) {

			System.out.println("RBL bank verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void selectexistingbankaccount() throws InterruptedException, TimeoutException {

		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='paymentDetail']", "RBL");
		Thread.sleep(2000);

	}

	public void Clickonsaveandnewandverifyinvoice() throws InterruptedException {

		Thread.sleep(2000);
		WebElement invoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = invoiceField.getAttribute("value").trim();
		System.out.println("Invoice ID captured: " + invoiceId);
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='arrow_drop_down']"));
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//button[normalize-space(text())='Save and New']"));
		Thread.sleep(3000);
		String actualText = HelperClass.getText(By.xpath("(//span[normalize-space(text())='Add New Invoice'])[1]"))
				.trim();
		String expected = "Add New Invoice";

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' page verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		// invoicecreditnotelocators.search.sendKeys(invoiceId);
		Thread.sleep(5000);
		String actualText1 = HelperClass
				.getText(By.xpath("//a[contains(@class,'d-flex') and contains(@class,'list-nam')]")).trim();
		String expected2 = invoiceId;

		if (actualText1.equals(expected2)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText1);
		}
	}

	public void Clickonsaveandcontinueandverifyinvoice() throws InterruptedException {
		WebElement invoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = invoiceField.getAttribute("value").trim();
		System.out.println("Invoice ID captured: " + invoiceId);
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Continue']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		// invoicelocators.search.sendKeys(invoiceId);
		Thread.sleep(5000);
		String actualText = HelperClass
				.getText(By.xpath("//a[contains(@class,'d-flex') and contains(@class,'list-nam')]")).trim();
		String expected = invoiceId;

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void Clickonsaveandexitandverifyinvoice() throws InterruptedException {
		WebElement invoiceField = HelperClass.getWait().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[normalize-space(@formcontrolname)='invoiceId']")));
		String invoiceId = invoiceField.getAttribute("value").trim();
		System.out.println("Invoice ID captured: " + invoiceId);
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		// invoicelocators.search.sendKeys(invoiceId);
		Thread.sleep(5000);
		String actualText = HelperClass
				.getText(By.xpath("//a[contains(@class,'d-flex') and contains(@class,'list-nam')]")).trim();
		String expected = invoiceId;

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void Clickoncancelchangesandverifydetails() throws InterruptedException, IOException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Cancel Changes']"));
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Cancel changes verified");
	}

	public void clickonaddnewinvoiceplusbuttonandverify() throws InterruptedException {

		Thread.sleep(2000);
//			HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
//			Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='add_circle'])[1]"));
		Thread.sleep(2000);
		String actualText = HelperClass
				.getText(By.xpath("//span[normalize-space(text())='Add New Invoice Credit Note']")).trim();
		String expected = "Add New Invoice Credit Note";

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	// duplicate record
	public void checkthecheckboxandverifyoptionsareenabling() throws InterruptedException {

//			Thread.sleep(2000);
//			HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
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

	}

	public void verifyexporttoexcel() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//p[normalize-space()='Excel']"));
		Thread.sleep(2000);
	}

	public void verifyexporttocsv() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='description'])[1]"));
		Thread.sleep(2000);
	}

	public void exporttopdf() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//p[normalize-space()='PDF']"));
		Thread.sleep(2000);
	}

	public void enterinvoicenameandverify() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search']"), "14835");
		Thread.sleep(3000);

		String actualText = HelperClass.getText(By.xpath("//a[normalize-space(text())='14835']")).trim();
		String expected = "14835";

		if (actualText.equals(expected)) {
			System.out.println("'Invoice credit note' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void clickonallstatusandverify() throws TimeoutException, InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Active");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Active']",
				"Active");
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Processing");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Processing']",
				"Processing");
		Thread.sleep(3000);

//			HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "//mat-select[normalize-space(@formcontrolname)='statusChange']", "Paid");
//			Thread.sleep(3000);
//	        HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Paid']", "Paid");
//			Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Duplicate");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Draft']",
				"Draft");
		Thread.sleep(3000);

	}

	public void clickonalltimestatusandverify() throws TimeoutException, InterruptedException, IOException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"This Week");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This week invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"Last Week");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last week invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"This Month");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This Month invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"Last Month");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Month invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"This Quarter");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("This Quarter invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"Last Quarter");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Quarter invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"This Year");
		Thread.sleep(3000);
		HelperClass.captureScreenshot("This Year invoices credit notes are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]",
				"Last Year");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Last Year invoices are captured");
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(), "(//div[@aria-haspopup='listbox'])[2]", "Custom");
		Thread.sleep(2000);
		HelperClass.captureScreenshot("Custom invoice credit notes are captured");
	}

	public void clickoninvoicecheckboxandverifyenablingoptions() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Copy']//parent::span//parent::button")).isDisplayed());
		System.out.println("Copy button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Delete']//parent::span//parent::button")).isDisplayed());
		System.out.println("Delete button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Excel']//parent::span//parent::button")).isDisplayed());
		System.out.println("EXCEL button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='CSV']//parent::span//parent::button")).isDisplayed());
		System.out.println("CSV button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='PDF']//parent::span//parent::button")).isDisplayed());
		System.out.println("PDF button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Print']//parent::span//parent::button")).isDisplayed());
		System.out.println("PRINT button verified");

	}

	public void clickonexportreportasexcel() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='border_all']"));
		Thread.sleep(2000);

	}

	public void clickonexportreportascsv() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//p[normalize-space()='CSV']"));
		Thread.sleep(2000);
	}

	public void clickonexportreportaspdf() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='picture_as_pdf']"));
		Thread.sleep(3000);

	}

	public void clickandselectpagenumber() throws TimeoutException, InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "10");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		String actualText = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected = "Records: 10";

		if (actualText.equals(expected)) {
			System.out.println("10 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "20");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		String actualText2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']")).trim();
		String expected2 = "Records: 20";

		if (actualText2.equals(expected2)) {
			System.out.println("20 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText2);
		}
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "50");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		String actualText3 = HelperClass.getText(By.xpath("//p[normalize-space(text())='50']")).trim();
		String expected3 = "Records: 50";

		if (actualText3.equals(expected3)) {
			System.out.println("50 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText3);
		}
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "100");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//input[normalize-space(@type)='checkbox'])[1]"));
		Thread.sleep(2000);
		String actualText4 = HelperClass.getText(By.xpath("//p[normalize-space(text())='100']")).trim();
		String expected4 = "Records: 100";

		if (actualText4.equals(expected4)) {
			System.out.println("100 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText4);
		}
	}

	public void clickandverifypreviousbutton() throws InterruptedException {

		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='2']"));
		Thread.sleep(2000);
		HelperClass.getDriver().findElement(By.xpath("//span[normalize-space(text())='Previous']")).isDisplayed();
		System.out.println("Previous button verified");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Previous']"));

	}

	public void clickandverifynextbutton() throws InterruptedException {

		HelperClass.getDriver().findElement(By.xpath("//span[normalize-space(text())='Next']")).isDisplayed();
		System.out.println("Next button verified");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Next']"));

	}

	public void Uploadthecreditnote() throws Exception {

		CreditNoteLocators.uploadcreditnotebutton.click();

		Thread.sleep(2000);
		CreditNoteLocators.chooseafilebutton.click();
		Thread.sleep(2000);

		Robot robot = new Robot();

		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(500);

		// Press ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		CreditNoteLocators.uploadcreditnotebutton2.click();
		Thread.sleep(5000);
	}

	public void ValidateuploadCreditnotecustomernameshouldDisplayinthegrid() {
		if (CreditNoteLocators.customername.isDisplayed()) {
			System.out.println("Credit note is uploaded successfully");
		} else {
			System.out.println("Credit note is not uploaded");
		}
	}

	public void Clickonpreviewinkebab() throws InterruptedException {
		Thread.sleep(2000);
		CreditNoteLocators.kebab.click();

		Thread.sleep(2000);
		CreditNoteLocators.preview.click();
		Thread.sleep(2000);
		if (CreditNoteLocators.previecreditnoteele.isDisplayed()) {
			System.out.println("Preview is clicked successfully");
		} else {
			System.out.println("Preview is not clicked");
		}
	}

	public void Clickonsentinkebab() throws InterruptedException {
		Thread.sleep(2000);
		CreditNoteLocators.kebab.click();

		Thread.sleep(2000);
		CreditNoteLocators.sent.click();
		Thread.sleep(2000);
		if (CreditNoteLocators.sendinvoicecreditnoteele.isDisplayed()) {
			System.out.println("Sent is clicked successfully");
		} else {
			System.out.println("Sent is not clicked");
		}
	}

	public void Clickonduplicateinkebab() throws InterruptedException {
		Thread.sleep(2000);
		CreditNoteLocators.kebab.click();

		Thread.sleep(2000);
		CreditNoteLocators.duplicate.click();
		Thread.sleep(2000);

	}

	public void Clickonhistoryinkebab() throws InterruptedException {
		Thread.sleep(2000);
		CreditNoteLocators.kebab.click();

		Thread.sleep(2000);
		CreditNoteLocators.history.click();
		Thread.sleep(2000);

		String actualText = HelperClass.getText(By.xpath("//span[normalize-space()='CRN201 History']")).trim();
		String expected = "History";

		if (actualText.contains(expected)) {
			System.out.println("History is clicked successfully ");
		} else {
			System.out.println("History is not clicked" + actualText);
		}
		CreditNoteLocators.closehistory.click();

	}

	public void Clickonkebebmenu() {
		HelperClass.waitUntilVisible(HelperClass.getWait(), CreditNoteLocators.topkebab);
		HelperClass.clickUsingJS(CreditNoteLocators.topkebab);

	}

	public void Clickonexporttoexcel() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(HelperClass.getWait(), CreditNoteLocators.exporttoexcel);
		HelperClass.clickUsingJS(CreditNoteLocators.exporttoexcel);
		Thread.sleep(2000);
	}

	public void Clickonexporttocsv() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(HelperClass.getWait(), CreditNoteLocators.exporttocsv);
		HelperClass.clickUsingJS(CreditNoteLocators.exporttocsv);
		Thread.sleep(2000);
	}

	public void Clickonexporttopdf() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(HelperClass.getWait(), CreditNoteLocators.exporttopdf);
		HelperClass.clickUsingJS(CreditNoteLocators.exporttopdf);
		Thread.sleep(2000);
	}

	public void clickongototextfiledandverify() throws InterruptedException {
		HelperClass.waitUntilVisible(HelperClass.getWait(), CreditNoteLocators.gotoTF);
		HelperClass.clickUsingJS(CreditNoteLocators.gotoTF);

		Thread.sleep(8000);
		CreditNoteLocators.gotoTF.clear();
		CreditNoteLocators.gotoTF.sendKeys("2");
		CreditNoteLocators.gotoTF.sendKeys(Keys.ENTER);
//			
		Thread.sleep(8000);
		CreditNoteLocators.gotoTF.clear();
		CreditNoteLocators.gotoTF.sendKeys("3");
		CreditNoteLocators.gotoTF.sendKeys(Keys.ENTER);
//		
		Thread.sleep(8000);
		CreditNoteLocators.gotoTF.clear();
		CreditNoteLocators.gotoTF.sendKeys("4");
		CreditNoteLocators.gotoTF.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void verifytherecordsaccordingtodropdown() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "10");
		Thread.sleep(3000);
		CreditNoteLocators.radiobutton.click();

		String actualText = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected = "Records: 10";

		if (actualText.equals(expected)) {
			System.out.println("10 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

		Thread.sleep(3000);
		CreditNoteLocators.crossmark.click();
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "20");
		Thread.sleep(3000);
		CreditNoteLocators.radiobutton.click();

		String actualText1 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']")).trim();
		String expected1 = "Records: 20";

		if (actualText.equals(expected)) {
			System.out.println("20 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='highlight_off']"));
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "100");

		Thread.sleep(3000);
		CreditNoteLocators.radiobutton.click();
		// HelperClass.ClickUsingJS(HelperClass.getDriver(),
		// By.xpath("//label[normalize-space(@for)='mat-checkbox-4-input']"));

		String actualText2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected2 = "Records: 100";

		if (actualText.equals(expected)) {
			System.out.println("100 records are there");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

		// banklocators.crossmark.click();
		Thread.sleep(3000);
	}

}
