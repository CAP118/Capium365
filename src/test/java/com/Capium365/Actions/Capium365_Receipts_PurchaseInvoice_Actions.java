package com.Capium365.Actions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_Receipts_PurchaseInvoice_Locators;

public class Capium365_Receipts_PurchaseInvoice_Actions {

	Capium365_Receipts_PurchaseInvoice_Locators purchaseInvoice = null;
	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	public Capium365_Receipts_PurchaseInvoice_Actions() {
		this.purchaseInvoice = new Capium365_Receipts_PurchaseInvoice_Locators();
		PageFactory.initElements(HelperClass.getDriver(), purchaseInvoice);
	}

	String filePath = "C:\\Users\\user\\Documents\\Receipt 2.pdf";
	public void clickOnReceiptsMenu() throws Throwable {
		By receiptsBtnLocator = By.xpath("//span[contains(text(), 'Receipts')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(receiptsBtnLocator));
		WebElement receiptsBtn = wait.until(ExpectedConditions.elementToBeClickable(receiptsBtnLocator));
		HelperClass.safeClick(receiptsBtn);
	}

	public boolean isPurchaseInvoicePageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement header = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[text()='Upload Purchase Invoices']")));
			return header.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void ClickonUploadPurchaseInvoiceButton() throws Throwable {
		purchaseInvoice.UploadPurchaseInvoiceButton.click();
		Thread.sleep(2000);
	}

	public void ClickonUploadpurchaseInvoice2Button() throws InterruptedException {
		purchaseInvoice.UploadPurchasesInvoice2Button.click();
		Thread.sleep(5000);
	}

	// SearchBar and Validatingdata
	public void Clickonsearchbarandenterdata() throws Throwable {
		purchaseInvoice.SearchBar.sendKeys("PUR0055");
		Thread.sleep(5000);
	}

	public void Verifydata() {
		purchaseInvoice.SearchBar.sendKeys("PUR055");
		String actualtext = HelperClass.getText(By.xpath("//a[text()='PUR055']"));
		String expected = "PUR055";
		if (actualtext == expected) {

			System.out.println("Records found");

		} else {

			System.out.println("No records found");
		}

	}

	public void CLickonThreedot() {
		purchaseInvoice.Threedoticon.click();

	}

	// Export to Excel
	public void ExporttoExcel() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		purchaseInvoice.ExporttoExcel.click();

	}

	// Export to csv
	public void ExporttoCSV() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		purchaseInvoice.Exporttocsv.click();

	}

	// Export to pdf
	public void ExporttoPDF() throws Throwable {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		purchaseInvoice.Exporttopdf.click();
		Thread.sleep(5000);
	}

	public void selectOneStatus(WebElement statusElement) throws Throwable {
		HelperClass.waitUntilClickable(purchaseInvoice.StatusDropdown);
		purchaseInvoice.StatusDropdown.click();

		HelperClass.waitUntilClickable(statusElement);
		statusElement.click();

		// Wait for grid refresh if needed
		Thread.sleep(2000);
	}

	/**
	 * Method 2: Click the Delete button
	 */
	public void clickDeleteButton() throws Throwable {
		// Hover over first row
		HelperClass.hoverOverElement(purchaseInvoice.InvoiceRow);

		// Wait for delete icon to be clickable
		// HelperClass.waitUntilClickable(wait,
		// purchaseInvoice.DeleteAllStatusButton).click();

		// Optional: handle confirmation modal
		// HelperClass.waitUntilClickable(wait, purInv.ConfirmDeleteBtn).click();

		Thread.sleep(2000);
	}

	public void validatenoofsuppliers() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(.)='19']"));
		String expected = "19";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of suppliers");
		} else {
			System.out.println("not matched no of suppliers. Found: " + actualtext);
		}
	}

	public void ValidatenoofpurchaseInvoices() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='128']"));
		String expected = "128";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of PurchaseInvoices");
		} else {
			System.out.println("not matched no of PurchaseInvoices. Found: " + actualtext);
		}
	}

	public void ValidatenoofTotalAmount() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='£ 108,483.17']"));
		String expected = "£ 108,483.17";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of TotalAmount");
		} else {
			System.out.println("not matched no of TotalAmount. Found: " + actualtext);
		}
	}

	public void ValidatenoofProcessing() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='0'])[1]"));
		String expected = "0";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Processing");
		} else {
			System.out.println("not matched no of Processing. Found: " + actualtext);
		}
	}

	public void ValidatenoofToReview() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='66'])[1]"));
		String expected = "66";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of ToReview");
		} else {
			System.out.println("not matched no of ToReview. Found: " + actualtext);
		}
	}

	public void ValidatenoofToSuccess() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='62']"));
		String expected = "66";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Success");
		} else {
			System.out.println("not matched no of Success. Found: " + actualtext);
		}
	}

	public void ValidatenoofArchived() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='0'])[2]"));
		String expected = "0";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Archived");
		} else {
			System.out.println("not matched no of Archived. Found: " + actualtext);
		}
	}

	public void ValidatenoofDuplicate() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='51']"));
		String expected = "51";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Duplicate");
		} else {
			System.out.println("not matched no of Duplicate. Found: " + actualtext);
		}
	}

	// mouse hover and Click on Archive Button
	public void MousehoverAndClickonArchiveButton() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement hoverIcon = driver.findElement(
				By.xpath("(//mat-icon[@class='mat-icon notranslate material-icons-outlined mat-icon-no-color'])[5]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(hoverIcon).perform();

		WebElement archiveButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[.//mat-icon[normalize-space()='archive']]")));
		archiveButton.click();
		Thread.sleep(4000);
	}

	public void ClickonYesButton() {
		purchaseInvoice.ArchiveYesButton.click();
	}

	public void ClickonNoButton() {
		purchaseInvoice.ArchiveNoButton.click();
	}

//	    public void MousehoverAndClickonArchiveButton() {
//	    	HelperClass.hoverAndClick(
//	    		    By.xpath("(//mat-icon[@class='mat-icon notranslate material-icons-outlined mat-icon-no-color'])[5]"),
//	    		    By.xpath("//button[.//mat-icon[normalize-space()='archive']]")
//	    		);
//	    }

	public void ArchivedStatus() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(
				By.xpath("(//span[contains(@class,'white-space-nowrap') and contains(@class,'archived')])[1]"));
		String expected = "Archived";

		if (actualtext.equals(expected)) {
			System.out.println("Verified Archived Status");
		} else {
			System.out.println("Not Verified Archived Status. Found: " + actualtext);

		}
	}

	public void Clickonstatusdropdown() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "All Status");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Processing");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "To Review");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Success");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Archived");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Duplicate");
		Thread.sleep(2000);

	}

	public void ClickonDateDropdown() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "All Time");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "This Week");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Last Week");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "This Month");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Last Month");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "This Quarter");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Last Quarter");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "This Year");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Last Year");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Custom");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "This Financial Year");
		Thread.sleep(2000);
	}

	public void mousehoverandClickonDeleteIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='delete_outline']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='delete_outline']"));
	}

	public void SelctToReviewOption() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='statusChange']")));
		By dropdown = By.xpath("//ng-select[@formcontrolname='statusChange']");
		WebElement element = driver.findElement(dropdown);
		HelperClass.selectDivOptionDropdownValue(element, "To Review");
	}

	public void MousehoverandclickonEditIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='edit']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='edit']"));
	}

	public void MousehoverandclickonArchivebutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='archive']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='archive']"));
	}

	public void MousehoverandClickonRestorebutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='edit']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='edit']"));
	}

	public void MousehoverandClickonMorevertbutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='edit']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='more_vert']"));
	}

	public void ClickonPreviewButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Preview']//parent::button")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='Preview']//parent::button"));

	}

	public void clickonClosebuttonPreviewpage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='close']")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='close']"));
	}

	public void clickonHistoryButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Preview']//parent::button")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='History']//parent::button"));
	}

	public void ClickonFileIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td/div/mat-icon")));
		HelperClass.clickUsingJS(By.xpath("//tbody/tr[1]/td/div/mat-icon"));
	}

	public void ClickonDownloadFileIcon() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='file_download']")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='file_download']"));
	}

	public void ClickonSelectCheckBox() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		HelperClass.clickUsingJS(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
	}

	public void ClickonSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[normalize-space()='Save']//parent::button")));
		HelperClass.clickUsingJS(By.xpath("//span[normalize-space()='Save']//parent::button"));
	}

	public void uploadFileWithRobot() throws Exception {
		// Click on the Choose File button
		WebElement chooseFileButton = driver.findElement(By.xpath("//span[normalize-space()='Choose a File']"));
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
	}

	// Pagination Code
	public void ClickonPagiantionDropdownandValidteCount() throws Exception {

		Thread.sleep(3000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "10");
		Thread.sleep(3000);
		purchaseInvoice.SelectCheckBox.click();

		String actualtext = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']"));
		String expected = "Records: 10";
		if (actualtext.equals(expected)) {

			System.out.println("10 records are there");

		} else {
			System.out.println("10 records are not there");
		}
		Thread.sleep(3000);
		purchaseInvoice.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "20");
		Thread.sleep(3000);
		purchaseInvoice.SelectCheckBox.click();

		String actualtext2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']"));
		String expected2 = "Records: 20";
		if (actualtext2.equals(expected2)) {

			System.out.println("20 records are there");

		} else {
			System.out.println("20 records are not there");
		}
		Thread.sleep(3000);
		purchaseInvoice.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "50");

		Thread.sleep(3000);
		purchaseInvoice.SelectCheckBox.click();

		String actualtext3 = HelperClass.getText(By.xpath("//p[normalize-space(text())='50']"));
		String expected3 = "Records: 50";
		if (actualtext3.equals(expected3)) {

			System.out.println("50 records are there");

		} else {
			System.out.println("50 records are not there");
		}

		purchaseInvoice.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "100");

		Thread.sleep(3000);
		purchaseInvoice.SelectCheckBox.click();

		String actualtext4 = HelperClass.getText(By.xpath("//p[normalize-space(text())='100']"));
		String expected4 = "Records: 100";
		if (actualtext3.equals(expected3)) {

			System.out.println("100 records are there");

		} else {
			System.out.println("100 records are not there");
		}

		purchaseInvoice.CrossButton.click();
		Thread.sleep(3000);

	}

	public void ClickonCrossButtonEditPurchaseInvoiceCrossScreen() {
		try {
			By arrowButton = By.xpath(
					"//div[contains(@class,'toggle-menu')]/mat-icon[normalize-space(text())='keyboard_arrow_left']");
			WebElement element = HelperClass.waitUntilClickable(arrowButton);
			HelperClass.scrollToElement(element);
			((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", element);
			Log.info("Clicked sidebar expand arrow.");

		} catch (Exception e) {
			Log.error("Failed to click sidebar expand arrow: ");
			e.printStackTrace();
		}
		HelperClass.scrollToElement(By.xpath("//mat-icon[normalize-space()='close']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='close']")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='close']"));
		// purchaseInvoice.EditScreenCrossButton.click();
	}

	public void ClickonArchiveYesButton() {
		purchaseInvoice.ArchiveYesButton.click();
	}

	public void ClickonID() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table//tbody/tr[1]/td[3]/div/div")));
		HelperClass.clickUsingJS(By.xpath("//table//tbody/tr[1]/td[3]/div/div"));
	}

	public void ValidateEditPurchaseInvoicepage() {
		String actualtext1 = HelperClass.getText(By.xpath("//h2[normalize-space()='Edit Purchase Invoices']"));
		String expected1 = "Edit Purchase Invoices";
		if (actualtext1.equals(expected1)) {

			System.out.println("Edit Purchase Invoice page is Displaying");

		} else {
			System.out.println("Edit Purchase Invoice page is not Displaying");
		}
	}

	public void ClickonEditpurchaseInvoiceCloseButton() {
		purchaseInvoice.CloseButton.click();
	}

	public void clickonsaveandExitbutton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Save and Exit']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='Save and Exit']//parent::button"));
	}

	public void cickonsavebuttonineditpurchaseinvoicepeg() {
		purchaseInvoice.editpurchaseinvoicesavebutton.click();
	}

	public void ClickonCurrencyDropdown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-ui-overlay")));

		By dropdownLocator = By.xpath("(//div[@class='ng-select-container ng-has-value'])[3]");

		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

	}

	public void clickonsettingsIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-ui-overlay")));
		purchaseInvoice.SettingsIcon.click();
	}

	public void validatesettingspopup() {
		String actualtext1 = HelperClass.getText(By.xpath("//h2[normalize-space()='Certsure LLP']"));
		String expected1 = "Certsure LLP";
		if (actualtext1.equals(expected1)) {

			System.out.println("Settings popup is Displaying");

		} else {
			System.out.println("Settings popup is not Displaying");
		}
	}

	public void ValidateUploadProcessingStatus() {
		String ActualProcessingStatus = HelperClass.getText(By.xpath("//span[normalize-space()='Processing']"));
		String ExpectedProcessingStatus = "Processing";
		if (ActualProcessingStatus.equals(ExpectedProcessingStatus)) {
			System.out.println("Processing Status Displying ");
		} else {
			System.out.println("Processing Status is not Displying");
		}
	}

	public void AccountNameDropdown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-ui-overlay")));

		By dropdownLocator = By.xpath("(//ng-select[@bindlabel='fullName'])[2]");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'cdk-overlay-pane')]")));

		By optionLocator = By.xpath(
				"//span[contains(@class, 'ng-option-label') and normalize-space(.)='4171-Computer Equipment  Leased - Additions - Cost']");

	}

	public void ClickonAddSupplierButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// 2. Wait for spinner to disappear (if you have one)
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-ui-overlay")));
		purchaseInvoice.AddSupplierButton.click();

	}

	public void EnterSupplierName() throws Throwable {
		purchaseInvoice.SuuplierName.sendKeys("Sushant9");
		Thread.sleep(2000);
	}

	public void ClickonSaveButtoninAddSuppplierPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Press ESC to dismiss any open menus
		new Actions(driver).sendKeys(Keys.ESCAPE).perform();

		By saveBtn = By.xpath("//button[contains(.,'Save')]");

		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		wait.until(ExpectedConditions.elementToBeClickable(button));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickonCancelchangesbutton() throws Throwable {
		HelperClass.clearField(driver, By.xpath("//input[@formcontrolname='supplierName']"));
		Thread.sleep(1000);
		HelperClass.safeSendKeys(By.xpath("//input[@formcontrolname='supplierName']"), "sahailrana190");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By cancelchangesbtn = By.xpath("//span[normalize-space()='Cancel Changes']");

		WebElement button1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelchangesbtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button1);
		wait.until(ExpectedConditions.elementToBeClickable(button1));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button1);

	}

	public void ClickonBackToPurchaseInvocesLink() {
		purchaseInvoice.BackToPurchaseInvoicesLink.click();
	}

	public void ValdateEditPurchaseInvoicePage() {
		String Actualres4 = HelperClass.getText(By.xpath("//h2[normalize-space()='Edit Purchase Invoices']"));
		String Expectedres = "Edit Purchase Invoices";
		if (Actualres4.equals(Expectedres)) {
			System.out.println("Edit Purchase Invoice Page is Displaying");
		} else {
			System.out.println("Edit Purchase Invoice Page is not Displying");
		}
	}

	public void ValdateAddSupplierPage() {
		String ActualAddSupplier = HelperClass.getText(By.xpath("//span[normalize-space()='Add Supplier']"));
		String ExpectedAddsupplier = "Add Supplier";
		if (ActualAddSupplier.equals(ExpectedAddsupplier)) {
			System.out.println("Add Supplier Page is Displaying");
		} else {
			System.out.println("Add Supplier Page is not Displying");
		}
	}

	public void ClickonEditSupplierButton() throws InterruptedException {
		HelperClass.sleep1(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"ABC Design");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='edit']")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='edit']"));
		// purchaseInvoice.EditSupplierButton.click();

	}

	public void ValdateEditSupplierPage() {
		String ActualrEditSupplier = HelperClass.getText(By.xpath("//span[normalize-space()='Edit Supplier']"));
		String ExpectedEditSupplier = "Edit Supplier";
		if (ActualrEditSupplier.equals(ExpectedEditSupplier)) {
			System.out.println("Edit Supplier Page is Displaying");
		} else {
			System.out.println("Edit Supplier Page is not Displying");
		}
	}

	public void ClickonHistoryTab() {
		purchaseInvoice.HistoryTab.click();
	}

	public void validateHistoryPage() {
		String ActualHistoryText = HelperClass.getText(
				By.xpath("//span[normalize-space()='Created a new supplier \"Certsure LLP\" by Richard Williams']"));
		String ExpectedHistoryText = "Created a new supplier \"Certsure LLP\" by Richard Williams";
		if (ActualHistoryText.equals(ExpectedHistoryText)) {
			System.out.println("History Page is Displying");
		} else {
			System.out.println("History Page is not Displying");
		}
	}

	public void ClickonAddanotherItem() {
		HelperClass.sleep1(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"ABC Design");
		HelperClass.sleep1(2000);
		purchaseInvoice.AddAnotherItem.click();
	}

	public void ValidateCancelLinkInFooter() {
		String ActualCancelLink = HelperClass.getText(By.xpath("//a[normalize-space()='Cancel']"));
		String ExpecteCancelLink = "Cancel";
		if (ActualCancelLink.equals(ExpecteCancelLink)) {
			System.out.println("CancelLink is Displying");
		} else {
			System.out.println("Cancel Link  is not Displying");
		}
	}

	public void ClickonCancelLinkInFooter() {
		purchaseInvoice.CancelLinkFooter.click();
	}


	public void ClickonBulkEditButton() {
		purchaseInvoice.BulkEditButton.click();
	}

	public void ValidateBulkEdit() {
		String ActualBulkEditpopup = HelperClass.getText(By.xpath("//h2[normalize-space()='Bulk Edit']"));
		String ExpecteBulkEditpopup = "Bulk Edit";
		if (ActualBulkEditpopup.equals(ExpecteBulkEditpopup)) {
			System.out.println("Bulk Edit popup is Displying");
		} else {
			System.out.println("Bulk Edit popup is not Displying");
		}
	}

	public void ValidateSupplierDropdown() throws Throwable {

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"Your Company Name");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"EDF ENERGY");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"E.ON NEXT");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"AMAZON PLC");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"NUDE FINANCE");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"E&L INSURANCE");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplier']",
				"Your Company Name");
	}

	public void ClickonBulkEditPopupSaveButton() throws Throwable {
		purchaseInvoice.BulkEditSaveButton.click();
		Thread.sleep(3000);
	}

	public void ValidateSupplierNameMainGrid() {
		String ActualSupplierName = HelperClass.getText(By.xpath("(//span[normalize-space()='Your Company Name'])[1]"));
		String ExpectedSuppierName = "Your Company Name";
		if (ActualSupplierName.equals(ExpectedSuppierName)) {
			System.out.println("SupplierName is Displying");
		} else {
			System.out.println("SupplierName is not Displying");
		}
	}

	public void ValidateVATRateDropdownBulkEdit() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Exempt(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Zero-Rated (0%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Reduced (5.0%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Standard (20%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "No VAT(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Custom VAT");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "No VAT registered(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//div[@class='ng-select-container ng-has-value'])[4]", "Reverse Charge(20%)");

	}

	public void ClickonCloseButtoninBulkEditPopup() {
		purchaseInvoice.BulkEditPopupInCloseButton.click();
	}

	public void ValidatePurchaseInvoiceMainGrid() {
		String ActualPurchaseInvoiceMainGrid = HelperClass
				.getText(By.xpath("//span[normalize-space()='Upload Purchase Invoices']"));
		String ExpectedPurhaseInvoiceMainGrid = "Upload Purchase Invoices";
		if (ActualPurchaseInvoiceMainGrid.equals(ExpectedPurhaseInvoiceMainGrid)) {
			System.out.println("PurchaseInvoice Main grid is Displying");
		} else {
			System.out.println("PurchaseInvoice is not Displying");
		}
	}

	public void ClickonFooterDeleteButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Delete']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//p[normalize-space()='Delete']/ancestor::button"));
	}

	public void ValidateDeletepopup() {
		String ActualConfirmDeletePopUp = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Delete']"));
		String ExpectedConfirmDeletePopup = "Confirm Delete";
		if (ActualConfirmDeletePopUp.equals(ExpectedConfirmDeletePopup)) {
			System.out.println("Confirm Delete popup is Displying");
		} else {
			System.out.println("Confirm Delere popup is not Displying");
		}
	}

	public void ClickonFooterExcelButton() {
		purchaseInvoice.FooterExcelButton.click();
	}

	public void ClickonFooterCSVButton() {
		purchaseInvoice.FooterCSVButton.click();
	}

	public void ClickonFooterPDFButton() {
		purchaseInvoice.FooterPDFButton.click();
	}

	public void CliconFooterArcivebutton() {
		purchaseInvoice.FooterArchiveButton.click();
	}

	public void ValidateConfirmArchivepopup() {
		String ActualConfirmArchivePopUp = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Archive']"));
		String ExpectedConfirmArchivePopup = "Confirm Archive";
		if (ActualConfirmArchivePopUp.equals(ExpectedConfirmArchivePopup)) {
			System.out.println("Confirm Archive popup is Displying");
		} else {
			System.out.println("Confirm Archive popup is not Displying");
		}
	}

	public void ValidateArchivedStatus() {
		String ActualArchivepopup = HelperClass.getText(By.xpath("(//span[normalize-space()='Archived'])[1]"));
		String ExpectedArchivepopup = "Archived";
		if (ActualArchivepopup.equals(ExpectedArchivepopup)) {
			System.out.println("Status is displaying as Archived");
		} else {
			System.out.println("Status is not displying unarchived");
		}
	}

	public void ClickonFooterRestoreButton() {
		purchaseInvoice.FooterRestoreButton.click();
	}

	public void ValidateConfirmRestorepopup() {
		String ActualRestorepopup = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Restore']"));
		String ExpectedRestorePopup = "Confirm Restore";
		if (ActualRestorepopup.equals(ActualRestorepopup)) {
			System.out.println("Restore popup is Displying");
		} else {
			System.out.println("Restorepopup is not Displying");
		}
	}

	public void FooterStatusToReviewForFooter() {
		String ActualToreviewStatus = HelperClass.getText(By.xpath("(//a[normalize-space()='To Review'])[1]"));
		String ExpectedToreviewStatus = "To Review";
		if (ActualToreviewStatus.equals(ExpectedToreviewStatus)) {
			System.out.println("To Review Status is Displying");
		} else {
			System.out.println("To Review Status not Displying");
		}
	}

	public void validateUploadPurchaseInvoiceSupplierName() {
		String ActualSupplierNameIntheGrid = HelperClass
				.getText(By.xpath("//span[normalize-space()='MR JOHN SMITH']//parent::td"));
		String ExpectedSuplierNameInthgrid = "MR JOHN SMITH";
		if (ActualSupplierNameIntheGrid.equals(ExpectedSuplierNameInthgrid)) {
			System.out.println("SupplierName is Displying in the Grid");
		} else {
			System.out.println("SupplierName is not Displying in the Grid");
		}
	}

	public void validateDuplicateLogo() {
		WebElement duplicateLogo = HelperClass.getDriver()
				.findElement(By.xpath("//tr[1]//span[normalize-space()='Duplicate']//parent::button"));
		String actualTextValue = duplicateLogo.getText(); // Use getText(), not getAttribute()

		String expectedTextValue = "Duplicate";

		if (actualTextValue != null && actualTextValue.equals(expectedTextValue)) {
			System.out.println("Duplicate Logo is Displaying in the Grid");
		} else {
			System.out.println("Duplicate logo is not Displaying. Found: " + actualTextValue);
		}
	}

	public void ClickonDuplicateLogo() {
		purchaseInvoice.DuplocateLogo.click();
	}

	public void ValidateProcessDuplicateUpload() {
		String ActualProcessDuplicateUpload = HelperClass
				.getText(By.xpath("//h2[normalize-space()='Process Duplicate Upload']"));
		String ExpectedProcessDuplicateUpload = "Process Duplicate Upload";
		if (ActualProcessDuplicateUpload.equals(ExpectedProcessDuplicateUpload)) {
			System.out.println("Process Duplicate upload popup Displying ");
		} else {
			System.out.println("Process Duplicate upload is not Displying");
		}
	}

	public void ClickonProcessDuplicateYesButton() {
		purchaseInvoice.ProcessDuplicatePopupYesButton.click();
	}

	public void ClickonProcessDuplicateNoButton() {
		purchaseInvoice.ProcessDuplicatePopupNoButton.click();
	}
}
