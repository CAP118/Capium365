package com.Capium365.Actions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium365.Locators.Capium365_InvoicesTab_Invoices_Locators;

public class Capium365_InvoicesTab_Invoices_Actions {

	Capium365_InvoicesTab_Invoices_Locators InvoiceLocators = null;

	public Capium365_InvoicesTab_Invoices_Actions() {
		this.InvoiceLocators = new Capium365_InvoicesTab_Invoices_Locators();
		PageFactory.initElements(HelperClass.getDriver(), InvoiceLocators);
	}

	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	public void Clickoninvoiceandverifypage() throws InterruptedException {

		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(text())='Invoices'])[1]"));

		Thread.sleep(3000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space(text())='Add Invoice'])[1]"));
		String expected = "Add Invoice";
		if (actualtext == expected) {

			System.out.println("Add Invoice page verified");
		} else {
			System.out.println("Not Matched");
		}

	}

	public void getcustomerscountandvalidate() throws InterruptedException {

		Thread.sleep(3000);

		String actualtext = HelperClass
				.getText(By.xpath("(//span[normalize-space(@class)='fw-bold pl-5 ng-tns-c305-21'])[1]"));
		String expected = "26";
		if (actualtext == expected) {

			System.out.println("Number of customers verified");
		} else {
			System.out.println("Not Matched");
		}

	}

	public void getinvoicecountandvalidate() throws InterruptedException {

		Thread.sleep(3000);

		String actualtext = HelperClass
				.getText(By.xpath("(//span[normalize-space(@class)='fw-bold pl-5 ng-tns-c305-21'])[2]"));
		String expected = "450";
		if (actualtext == expected) {

			System.out.println("Number of invoices verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void Verifytotalraisedcount() throws InterruptedException {

		Thread.sleep(3000);

		String actualtext = HelperClass
				.getText(By.xpath("(//span[normalize-space(@class)='fw-bold pl-5 ng-tns-c305-21'])[3]"));
		String expected = " £ 676,192.58";
		if (actualtext == expected) {

			System.out.println("Total raised count verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void Verifytotalrecievedcount() throws InterruptedException {

		Thread.sleep(3000);

		String actualtext = HelperClass
				.getText(By.xpath("(//span[normalize-space(@class)='fw-bold pl-5 ng-tns-c305-21'])[4]"));
		String expected = " £ 1,444.00 ";
		if (actualtext == expected) {

			System.out.println("Total recieved count verified");
		} else {
			System.out.println("Not Matched");
		}

	}

	public void Verifytotalduecount() throws InterruptedException {

		Thread.sleep(3000);

		String actualtext = HelperClass
				.getText(By.xpath("(//span[normalize-space(@class)='fw-bold pl-5 ng-tns-c305-21'])[5]"));
		String expected = "  £ 674,748.58";
		if (actualtext == expected) {

			System.out.println("Total due count verified");
		} else {
			System.out.println("Not Matched");
		}

	}

	public void Clickonaddinvoiceandverifypage() throws InterruptedException {

		Thread.sleep(3000);

		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(text())='Add Invoice'])[1]"));

		Thread.sleep(3000);
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Invoice']")).trim();
		String expected = "Add New Invoice";

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void Clickoneditcompanydetailswithoutgivingmandetailsandverify() throws InterruptedException, IOException {

		Thread.sleep(3000);

		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='edit']"));

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

		Thread.sleep(3000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='address1']"), "612 manchester");

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='city']"), "manchester");

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='postalCode']"), "W1A 1HQ1");

		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));

		Thread.sleep(3000);

		String actualtext = HelperClass.getText(By.xpath("(//div[normalize-space(@class)='mt-5'])[2]"));
		String expected = " 612 manchester ";
		if (actualtext == expected) {

			System.out.println("Address verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void clickonaddcustomerandverifypage() throws InterruptedException {

		Thread.sleep(2000);

		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(@fontset)='material-icons-outlined'])[11]"));

		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Customer']"));
		String expected = "Add New Customer";
		if (actualtext == expected) {

			System.out.println("Add New Customer verified");
		} else {
			System.out.println("Not Matched");
		}
	}

	public void Fillthemandatorydetailsandsave() throws InterruptedException {

		Thread.sleep(2000);

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='fullName']"), "Sriram");

		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@formcontrolname)='email']"),
				"rajasekhar.sriram@capium.com");

		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-button-wrapper'])[16]"));

	}

	public void Fillthemandatorydetailsandclickaddrowandsave() throws InterruptedException {

		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='fullName'])[1]"), "Raja");

		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='email'])[1]"),
				"rajasekharsriram56@gmail.com");

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//a[normalize-space(text())='Add New line']"));
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='name'])[2]"), "Rajasekhar");
		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@formcontrolname)='email'])[2]"),
				"rajasekharsriram33@gmail.com");

		HelperClass.clickUsingJS(By.xpath("(//span[normalize-space(@class)='mat-button-wrapper'])[16]"));

	}

	public void selectthecustomerandverifydetails() throws InterruptedException {

		HelperClass.safeSendKeys(By.xpath("(//input[normalize-space(@aria-autocomplete)='list'])[1]"), "sriram");
		Thread.sleep(2000);

		HelperClass.selectFirstSuggestedCustomer("sriram");

	}

	public void clickonsettingsandsaveandverify() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='settings_suggest']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='settings_suggest']/ancestor::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='category']")));
		WebElement radioBtn = driver.findElement(By.xpath("//ng-select[@formcontrolname='category']"));
		radioBtn.click();
		//HelperClass.clickUsingJS(By.xpath("//ng-select[@formcontrolname='category']"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='1000-Sales']")));
		HelperClass.clickUsingJS(By.xpath("//div[normalize-space(text())='1000-Sales']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[@class='mat-radio-label-content' and normalize-space(text())='Save these values only for this record']")));
		HelperClass.clickUsingJS(By.xpath(
				"//span[@class='mat-radio-label-content' and normalize-space(text())='Save these values only for this record']"));

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

	public void checkrepeatinvoicecheckboxandverifyinvoice() throws InterruptedException, TimeoutException {

		Thread.sleep(2000);

		HelperClass.clickUsingJS(By.xpath("//mat-checkbox[normalize-space(@formcontrolname)='isRepeatInvoice']"));

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));

		Thread.sleep(3000);

		String actualtext = HelperClass.getText(By.xpath("//div[normalize-space(text())='sriram']"));
		String expected = "sriram";
		if (actualtext == expected) {

			System.out.println("recurring invoice verified");
		} else {
			System.out.println("Not Matched");
		}
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
		String actualtext = HelperClass.getText(By.xpath("(//mat-form-field[normalize-space(@appearance)='fill'])[5]"));
		String expected = "PR003 - Item 1";
		if (actualtext == expected) {

			System.out.println("newly added item verified");
		} else {
			System.out.println("Not Matched");
		}

		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save and Exit']"));	
	}

	public void selectexistingitem() throws TimeoutException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"(//mat-form-field[normalize-space(@appearance)='fill'])[4]", "PR003 - Item 1");

	}

	public void clickonaddbankandentermandetails() throws InterruptedException, TimeoutException {

		try {
			HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Add new bank account']"));
			Thread.sleep(3000);
			HelperClass.clickUsingJS(By.xpath("//a[normalize-space(text())='Add New Line']"));
			WebElement lastEmptyAccountName = driver.findElement(By.xpath(
					"(//input[@formcontrolname='accountName' and not(@disabled) and normalize-space(@value)=''])[last()]"));
			lastEmptyAccountName.sendKeys("RBL" + Keys.ENTER);
			HelperClass.sleep1(1000);
			WebElement lastEmptyAccountNumber = driver.findElement(
					By.xpath("(//input[@formcontrolname='accountNumber' and normalize-space(@value)=''])[last()]"));
			lastEmptyAccountNumber.sendKeys("355532" + Keys.ENTER);
			HelperClass.sleep1(1000);
			WebElement lastEmptyBranchCode = driver.findElement(
					By.xpath("(//input[@formcontrolname='branchCode' and normalize-space(@value)=''])[last()]"));
			lastEmptyBranchCode.sendKeys("35" + Keys.ENTER);
			HelperClass.sleep1(1000);
			HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Save']"));
//			WebElement payment=driver.findElement(By.xpath("//ng-select[@formcontrolname='paymentDetail']"));
//			payment.click();
//			HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='RBL']"));
//
//			String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(text())='RBL']"));
//			String expected = "RBL";
//			if (actualtext == expected) {
//
//				System.out.println("RBL bank verified");
//			} else {
//				System.out.println("Not Matched");
//			}
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
		//HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		InvoiceLocators.search.sendKeys(invoiceId);
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
		//HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		InvoiceLocators.search.sendKeys(invoiceId);
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
		//HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(3000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='search']"));
		Thread.sleep(3000);
		InvoiceLocators.search.sendKeys(invoiceId);
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
//		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='add_circle'])[1]"));
		Thread.sleep(2000);
		String actualText = HelperClass.getText(By.xpath("//span[normalize-space(text())='Add New Invoice']")).trim();
		String expected = "Add New Invoice";

		if (actualText.equals(expected)) {
			System.out.println("'Add New Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}
	}

	public void checkthecheckboxandverifyoptionsareenabling() throws InterruptedException {

		Thread.sleep(2000);
		//HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='keyboard_arrow_right']"));
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

	public void verifywxporttoexcel() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='border_all']"));
		Thread.sleep(2000);
	}

	public void verifyexporttocsv() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("(//mat-icon[normalize-space(text())='description'])[1]"));
		Thread.sleep(2000);
	}

	public void exporttopdf() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space(text())='picture_as_pdf']"));
		Thread.sleep(2000);
	}

	public void enterinvoicenameandverify() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.safeSendKeys(By.xpath("//input[normalize-space(@placeholder)='Search']"), "INV309");
		Thread.sleep(3000);

		String actualText = HelperClass.getText(By.xpath("//a[normalize-space(text())='INV309']")).trim();
		String expected = "INV309";

		if (actualText.equals(expected)) {
			System.out.println("'Invoice' id verified");
		} else {
			System.out.println("Text not matched. Actual: " + actualText);
		}

	}

	public void clickclickonallstatusandverify() throws TimeoutException, InterruptedException {

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@formcontrolname)='statusChange']", "Draft");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Draft']",
				"Draft");
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@formcontrolname)='statusChange']", "Awaiting Payment");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(),
				"//table/tbody/tr/td[normalize-space()='Awaiting Payment']", "Awaiting Payment");
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@formcontrolname)='statusChange']", "Paid");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Paid']", "Paid");
		Thread.sleep(3000);

		HelperClass.selectFromCustomDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@formcontrolname)='statusChange']", "Duplicate");
		Thread.sleep(3000);
		HelperClass.verifyClientTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Draft']",
				"Draft");
		Thread.sleep(3000);

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
	}

	public void clickoninvoicecheckboxandverifyenablingoptions() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//tbody/tr[1]/td[1]/div/mat-checkbox/label/span[contains(@class,'inner')]"));
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Copy']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("Copy button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Delete']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("Delete button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Excel']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("EXCEL button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='CSV']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("CSV button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='PDF']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("PDF button verified");
		Thread.sleep(2000);
		assertTrue(HelperClass.getDriver().findElement(By.xpath("//p[normalize-space()='Print']//parent::span//parent::button"))
				.isDisplayed());
		System.out.println("PRINT button verified");

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
		System.out.println("Previous button verified");
		Thread.sleep(2000);
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space(text())='Next']"));

	}
}
