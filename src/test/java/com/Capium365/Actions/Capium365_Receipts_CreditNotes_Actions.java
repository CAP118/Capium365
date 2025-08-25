package com.Capium365.Actions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_Receipts_CreditNotes_Locators;

public class Capium365_Receipts_CreditNotes_Actions {
	Capium365_Receipts_CreditNotes_Locators CNLocator = null;

	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	public Capium365_Receipts_CreditNotes_Actions() {
		this.CNLocator = new Capium365_Receipts_CreditNotes_Locators();
		PageFactory.initElements(HelperClass.getDriver(), CNLocator);
	}

	public void ClickonCreditNotesMenu() {

		By ReceiptsInsideSidebar = By.xpath("//a[@mattooltip='Credit Notes']");
		HelperClass.isElementPresent(ReceiptsInsideSidebar);
		HelperClass.clickUsingJS(ReceiptsInsideSidebar);
		HelperClass.sleep1(3000);

	}

	public void ClickonKEyBoardErrorRight() {
		try {
			By arrowButton = By.xpath(
					"//div[contains(@class,'toggle-menu')]/mat-icon[normalize-space(text())='keyboard_arrow_right']");
			WebElement element = HelperClass.waitUntilClickable(arrowButton);
			HelperClass.scrollToElement(element);
			((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", element);
			Log.info("Clicked sidebar expand arrow.");

		} catch (Exception e) {
			Log.error("Failed to click sidebar expand arrow: ");
			e.printStackTrace();
		}

	}

	public void VerifyCreditNotesMainGrid() {

		String ActualCreditNotesMaiGrid = HelperClass
				.getText(By.xpath("//span[normalize-space()='Upload Credit Notes']"));

		String ExpectedCreditNotesMainGrid = "Upload Credit Notes";

		if (ActualCreditNotesMaiGrid.equals(ExpectedCreditNotesMainGrid)) {

			System.out.println("CreditNotes Main grid is Displying");

		}

		else {

			System.out.println("CreditNotes Main grid not Displying");

		}

	}

	public void validatenoofsuppliersCreditNotes() throws Throwable {

		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space(.)='9']"));

		String expected = "9";

		if (actualtext.equals(expected)) {

			System.out.println("Verified no of suppliers");

		} else {

			System.out.println("not matched no of suppliers. Found: " + actualtext);

		}

	}

	public void ValidatenoofCreditnotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='30']"));
		String expected = "30";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Creditnotes");
		} else {
			System.out.println("not matched no of Creditnotes. Found: " + actualtext);
		}
	}

	public void ValidatenoofTotalAmountCrediNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='£ 1,170,370.30']"));
		String expected = "£ 1,170,370.30";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of TotalAmount");
		} else {
			System.out.println("not matched no of TotalAmount. Found: " + actualtext);
		}
	}

	public void ValidatenoofProcessingCreditNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='0'])[1]"));
		String expected = "0";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Processing");
		} else {
			System.out.println("not matched no of Processing. Found: " + actualtext);
		}
	}

	public void ValidatenoofToReviewCreditNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='21'])[1]"));
		String expected = "21";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of ToReview");
		} else {
			System.out.println("not matched no of ToReview. Found: " + actualtext);
		}
	}

	public void ValidatenoofToSuccessCreditNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='3']"));
		String expected = "3";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Success");
		} else {
			System.out.println("not matched no of Success. Found: " + actualtext);
		}
	}

	public void ValidatenoofArchivedCreditNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("(//span[normalize-space()='0'])[2]"));
		String expected = "0";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Archived");
		} else {
			System.out.println("not matched no of Archived. Found: " + actualtext);
		}
	}

	public void ValidatenoofDuplicateCreditNotes() throws Throwable {
		Thread.sleep(2000);

		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='3']"));
		String expected = "3";

		if (actualtext.equals(expected)) {
			System.out.println("Verified no of Duplicate");
		} else {
			System.out.println("not matched no of Duplicate. Found: " + actualtext);
		}
	}

	public void uploadFileForCreditNotesWithRobot() throws Exception {
		WebElement chooseFileButton = driver.findElement(By.xpath("//span[normalize-space()='Choose a File']"));
		chooseFileButton.click();
		Thread.sleep(2000);

		String filePath = "C:\\Users\\user\\Documents\\Receipt 2.pdf";

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

	public void ClickonUploadCreditNotesButton() throws Throwable {
		CNLocator.UploadCreditNotesButton.click();
		Thread.sleep(10000);
	}

	public void ClickonUploadCreditNotes2Button() throws InterruptedException {
		CNLocator.UploadCreditNotes2Button.click();
		Thread.sleep(10000);
	}

	public void ClickOnCancelButtonUploadPurchaseInvoice() throws Throwable {
		CNLocator.UploadCreditNoteCancelButton.click();
		Thread.sleep(1000);
	}

	public void ValidateChooseFilePage() {
		String actualtext = HelperClass.getText(By.xpath("//span[normalize-space()='Choose a File']"));
		String expected = "Choose a File";

		if (actualtext.equals(expected)) {
			System.out.println("Verified ChooseFile Page");
		} else {
			System.out.println("not matched ChooseFilePage. Found: " + actualtext);
		}
	}

	// Search code for CreditNotes
	public void SearchAndValidateCredinoteNumber() {
		// Enter credit note number into search bar
		CNLocator.SearchBarCreditnote.sendKeys("849385");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Wait until the searched credit note number appears in the DOM
			WebElement resultElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[normalize-space()='849385'])[1]")));

			// Validate the result text
			String actualCreditnoteNumber = resultElement.getText();
			String expectedCreditNoteNumber = "INV007";

			if (actualCreditnoteNumber.equals(expectedCreditNoteNumber)) {
				System.out.println("✅ Records found: " + actualCreditnoteNumber);
			} else {
				System.out.println("❌ Record text mismatch. Found: " + actualCreditnoteNumber);
			}

		} catch (Exception e) {
			System.out.println("❌ Search result not found or timed out.");
			e.printStackTrace();
		}
	}

	public void SelectDropdownandVerify() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "To Review");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='To Review']",
				"To Review");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Success");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Success']",
				"Success");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Archived");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Archived']",
				"Archived");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//ng-select[normalize-space(@formcontrolname)='statusChange']", "Duplicate");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Duplicate']",
				"Duplicate");
	}

	public void VerifySupplierNameInCreditNotesMainGrid() {
		String actualSuppliername = HelperClass
				.getText(By.xpath("(//span[normalize-space()='MR JOHN SMITH']//parent::td)[2]"));
		String expectedSuppliername = "MR JOHN SMITH";

		if (actualSuppliername.equals(expectedSuppliername)) {
			System.out.println("Supplier name is displaying");
		} else {
			System.out.println("SupplierNameis not Displying. Found: " + actualSuppliername);
		}

	}

	public void validateDuplicateLogo() {
		WebElement duplicateLogo = HelperClass.getDriver().findElement(By.xpath("(//img[@alt='Duplicate'])[1]"));
		String actualAltValue = duplicateLogo.getAttribute("alt");
		String expectedAltValue = "Duplicate";

		if (actualAltValue.equals(expectedAltValue)) {
			System.out.println("Duplicate Logo is Displying in the Grid");
		} else {
			System.out.println("Duplicate logo is not Displying . Found: " + actualAltValue);
		}
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

	public void validateLinkIsDisabled() {
		WebElement link = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[3]/div/div")));

		String classAttr = link.getAttribute("class");

		if (classAttr != null && classAttr.contains("link-disable")) {
			System.out.println("Link is disabled (class contains 'link-disable').");
		} else {
			System.out.println("Link is enabled.");
		}
	}

	public void ClickonThreeDot() {
		HelperClass.waitForSpinnerToDisappear(driver);

		WebElement element = CNLocator.Threedoticon;

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Hover to activate if needed
		new Actions(driver).moveToElement(element).pause(Duration.ofMillis(300)).perform();

		// JavaScript click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void ClickonExcelbutton() {
//		    	CNLocator.ExporttoExcel.click();
		HelperClass.clickUsingJS(By.xpath("//button[@role='menuitem']"));
	}

	public void ClickonCSVbutton() {
//		    	CNLocator.Exporttocsv.click();
		HelperClass.clickUsingJS(By.xpath("((//button[@role='menuitem'])[2])"));
	}

	public void ClickonPDFbutton() throws Throwable {
//		    	CNLocator.Exporttopdf.click();
		HelperClass.clickUsingJS(By.xpath("((//button[@role='menuitem'])[3])"));
		Thread.sleep(10000);
	}

	public void clickOnReceiptsMenu() throws Throwable {
		waitForSpinnerToDisappear();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// Re-locate element freshly to avoid stale issue
		By receiptsBtnLocator = By.xpath("//span[contains(text(), 'Receipts')]"); // Replace with actual unique text
		WebElement receiptsBtn = wait.until(ExpectedConditions.elementToBeClickable(receiptsBtnLocator));

		receiptsBtn.click();

		// Replace hard wait with wait for page content
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Upload Purchase Invoices')]"))); // Adjust

	}

	public void waitForSpinnerToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));
	}

	public void clickonDuplicatelogo() {
		CNLocator.DuplocateLogo.click();
	}

	public void hoverAndClickActionOnRow(int rowIndex, String actionType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions = new Actions(driver);

		// Wait for overlay spinner to disappear (if applicable)
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
		} catch (Exception e) {
			System.out.println("No spinner overlay found or disappeared quickly.");
		}

		// Wait for table to be visible
		WebElement table = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-describedby='Purchase Table']")));

		// Check that rows exist
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		if (rows.isEmpty()) {
			throw new IllegalStateException("Purchase Table has no rows. Cannot perform action.");
		}

		if (rowIndex >= rows.size()) {
			throw new IllegalArgumentException("Row index out of range. Requested: " + rowIndex
					+ ", but table has only: " + rows.size() + " rows.");
		}

		boolean success = false;
		int retries = 0;

		while (!success && retries < 3) {
			try {
				// Re-locate rows freshly each retry to avoid stale elements
				rows = table.findElements(By.tagName("tr"));
				WebElement targetRow = rows.get(rowIndex);

				actions.moveToElement(targetRow).perform();

				By buttonLocator;

				switch (actionType.toLowerCase()) {
				case "edit":
					buttonLocator = By.xpath("//button[@title='Edit']");
					break;
				case "delete":
					buttonLocator = By.xpath("//button[@title='Delete']");
					break;
				case "archive":
					buttonLocator = By.xpath("(//button[@title='Archive'])[1]");
					break;
				case "restore":
					buttonLocator = By.xpath("//button[@title='unarchive']");
					break;
				case "menu":
					buttonLocator = By.xpath("(//button[@aria-haspopup='menu'])[2]");
					break;
				default:
					throw new IllegalArgumentException("Unsupported action: " + actionType);
				}

				List<WebElement> buttons = targetRow.findElements(buttonLocator);

				if (buttons.isEmpty()) {
					System.out.println("Action '" + actionType + "' is not visible for row index " + rowIndex + ".");
					return;
				}

				WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
				actionButton.click();

				success = true;

			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element detected. Retrying...");
				retries++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					// ignore
				}
			} catch (TimeoutException e) {
				System.out.println("Timed out waiting for button to be clickable. Retrying...");
				retries++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					// ignore
				}
			}
		}

		if (!success) {
			throw new RuntimeException(
					"Failed to click action button '" + actionType + "' on row index " + rowIndex + " after retries.");
		}
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

	public void MousehoverandclickonDeleteIcon() {
		HelperClass.mouseHoverAndPerformActionn("Purchase Credit Note Table", 1, "Delete");
		;
	}

	public void ClickonCrossButtonEditPurchaseCrditNoteScreen() {
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
	}

	public void ClickDeleteCheckBox() {
		CNLocator.ClickonselectCheckBox.click();
	}

	public void ClickonyesButton() {
		CNLocator.CreditNoteYeButton.click();
	}

	public void ClickonNoButon() {
		CNLocator.CreditNoteNoButton.click();
	}

	public void MousehoverandclickonArchiveIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='archive']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='archive']"));
	}

	public void MousehoverandclickonRestoreIcon() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='statusChange']")));
		By dropdown = By.xpath("//ng-select[@formcontrolname='statusChange']");
		WebElement element = driver.findElement(dropdown);
		HelperClass.selectDivOptionDropdownValue(element, "Archived");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element1 = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element1);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='unarchive']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='unarchive']"));
	}

	public void MousehoverandclickonThreeDotIcon() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='statusChange']")));
		By dropdown = By.xpath("//ng-select[@formcontrolname='statusChange']");
		WebElement element = driver.findElement(dropdown);
		HelperClass.selectDivOptionDropdownValue(element, "To Review");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element1 = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.hoverOverElement(element1);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[1]//td//mat-icon[normalize-space()='more_vert']")));
		HelperClass.clickUsingJS(By.xpath("//tr[1]//td//mat-icon[normalize-space()='more_vert']"));

	}

	public void ValdiateArchivedStatus() {
		String ActualArchiveStatus = HelperClass.getText(By.xpath("//span[normalize-space()='Archived']"));
		String ExpectedArchivedStatus = "Archived";
		if (ActualArchiveStatus.equals(ExpectedArchivedStatus)) {
			System.out.println("Archived Status is Displying");
		} else {
			System.out.println("Archived Status is not Displying");
		}
	}

	public void ValdiateToReviewStatus() {
		String ActualToReviewStatus = HelperClass.getText(By.xpath("(//a[normalize-space()='To Review'])[1]"));
		String ExpectedToReviewStatus = "To Review";
		if (ActualToReviewStatus.equals(ExpectedToReviewStatus)) {
			System.out.println("To Review Status is Displying");
		} else {
			System.out.println("To Review Status is not Displying");
		}
	}

	public void ClickOnPreviewButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Preview']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='Preview']//parent::button"));
		// CNLocator.PreviewButton.click();
	}

	public void ValidatePreviewPurchaseCreditNotes() {
		String ActualPreviewCreditNotesMainGrid = HelperClass
				.getText(By.xpath("//span[normalize-space()='Preview Purchase Credit Notes']"));
		String ExpectedPreviewCreditNotesMainGrid = "Preview Purchase Credit Notes";
		if (ActualPreviewCreditNotesMainGrid.equals(ExpectedPreviewCreditNotesMainGrid)) {
			System.out.println(" preview purchase CreditNotes Page is Displying");
		} else {
			System.out.println(" Preview Purchase CreditNote is not Displying");
		}
	}

	public void ClickOnHistoryButton() {
		CNLocator.HistoryButton.click();
	}

	public void ValidateHistoryPopUp() {
		String ActualHistoryPopUp = HelperClass.getText(By.xpath("//span[normalize-space()='PCRN023 History']"));
		String ExpectedHistoryPOpUP = "PCRN023 History";
		if (ActualHistoryPopUp.equals(ExpectedHistoryPOpUP)) {
			System.out.println(" History popup is Displying");
		} else {
			System.out.println(" History popup is not Displying");
		}
	}

	public void clickonHstoryCloseButton() {
		wait.until(ExpectedConditions.visibilityOf(CNLocator.HistoryCloseButton));
		HelperClass.clickUsingJS(CNLocator.HistoryCloseButton);
	}

	public void ClickonPDFIcon() {

		CNLocator.ReceiptLogo.click();
	}

	public void ValidateCreditNoteFile() {
		String ActualPDFLogo = HelperClass.getText(By.xpath("//h2[normalize-space()='PCRN023']"));
		String ExpectedPDFLogo = "PCRN023";
		if (ActualPDFLogo.equals(ExpectedPDFLogo)) {
			System.out.println("CrediNotePDFFile is Dsiplying");
		} else {
			System.out.println("CrediNotePDFFile is not Displying");
		}
	}

	public void validateFileIconIsEnableorNot() {
		WebElement icon = driver.findElement(By.xpath("//mat-icon[normalize-space()='description']"));

		if (icon.isDisplayed() && icon.isEnabled()) {
			System.out.println("File icon is enabled.");
		} else {
			System.out.println("File icon is disabled.");
		}

	}

	public void clickonreciptID() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='statusChange']")));
		By dropdown = By.xpath("//ng-select[@formcontrolname='statusChange']");
		WebElement element = driver.findElement(dropdown);
		HelperClass.selectDivOptionDropdownValue(element, "To Review");
		HelperClass.sleep1(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[3]/div/div")));
		HelperClass.clickUsingJS(By.xpath("//tbody/tr[1]/td[3]/div/div"));
		
	}

	public void validateEditPurchaseCreditNotePage() {
		String ActualEditPurchaseCreditNotePage = HelperClass
				.getText(By.xpath("//h2[normalize-space()='Edit Purchase Credit Note']"));
		String ExpecteEditPurchaseCreditNtePage = "Edit Purchase Credit Note";
		if (ActualEditPurchaseCreditNotePage.equals(ExpecteEditPurchaseCreditNtePage)) {
			System.out.println("Edit Purchase CreditNote page  is Dsiplying");
		} else {
			System.out.println("Edit Purchase CreditNote Page is not Displying");
		}
	}

	public void ClickonCalendorButton() {
		CNLocator.calendrorbutton.click();
	}

	public void ValidateSuppplierDropdownEditPurchaseCreditNotePage() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"Your Company Name");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"EDF ENERGY");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"E.ON NEXT");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"AMAZON PLC");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"NUDE FINANCE");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"TSB CLEVELEYS");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"E&L INSURANCE");
		Thread.sleep(2000);
	}

	public void ClickonSaveandExitbutton() {
		CNLocator.SaveandExitButton.click();
	}

	public void ValidateSupplierNameIntheMainGrid() {
		String ActualSupplierNameIntheGrid = HelperClass
				.getText(By.xpath("(//span[normalize-space()='E&L INSURANCE'])[2]"));
		String ExpecteSupplierNameIntheGrid = "E&L INSURANCE";
		if (ActualSupplierNameIntheGrid.equals(ExpecteSupplierNameIntheGrid)) {
			System.out.println("SupplierName is Displying in the Grid");
		} else {
			System.out.println("SupplierName is not Displying in the Grid");
		}
	}

	public void ClickonSettingsIcon() {
		HelperClass.sleep1(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"ABC Design");
		HelperClass.sleep1(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='settings_suggest']//parent::span//parent::button")));
		HelperClass
				.safeClick(By.xpath("//mat-icon[normalize-space()='settings_suggest']//parent::span//parent::button"));
	}

	public void ValidateSettingsPopUp() {
		String ActualSettingpopup = HelperClass.getText(By.xpath("//h2[normalize-space()='E&L INSURANCE']"));
		String ExpecteSettingspopup = "E&L INSURANCE";
		if (ActualSettingpopup.equals(ExpecteSettingspopup)) {
			System.out.println("Settings popup is Displaying");
		} else {
			System.out.println("Settings Popup Is not Displaying");
		}
	}

	public void ClickOnClosebuttonSettingsIcon() {
		CNLocator.closebuttonsetiingspopup.click();
	}

	public void ClickonVATRateDropdownSettingsIcon() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Exempt(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Zero-Rated (0%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Reduced (5.0%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Standard (20%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"No VAT(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Custom VAT");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"No VAT registered(0.00%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Reverse Charge(20%)");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='vatTaxId']",
				"Standard (20%)");

	}

	public void ClickonSaveButtonSettingspopup() {
		CNLocator.savebuttonsettingsIcon.click();
	}

	public void ValidateVATrateDropdowninproductDetails() throws InterruptedException {
		String ActualVATRateName = HelperClass.getText(By.xpath("(//span[normalize-space()='Standard (20%)'])"));
		String ExpectedVATRateName = "Standard (20%)";
		if (ActualVATRateName.equals(ExpectedVATRateName)) {
			System.out.println(" VAT rate is Displaying");
		} else {
			System.out.println("VAT Rate Is not Displaying");
		}
	}

	public void ClickonPlusbutton() {
		CNLocator.PlusICon.click();
	}

	public void ValidateAddNewSupplierPage() {
		String ActualAddNewSupplierPage = HelperClass.getText(By.xpath("//span[normalize-space()='Add New Supplier']"));
		String ExpectedAddNewSupplierPage = "Add New Supplier";
		if (ActualAddNewSupplierPage.equals(ExpectedAddNewSupplierPage)) {
			System.out.println(" Supplier Page is Displaying");
		} else {
			System.out.println("Supplier Page Is not Displaying");
		}
	}

	public void EnterSupplierField() {
		CNLocator.SupplierField.sendKeys("sahailrana1");
	}

	public void ValidateEditSupplierPage() {
		String ActualEditSupplierPage = HelperClass.getText(By.xpath("//span[normalize-space()='Edit Supplier']"));
		String ExpectedEditSupplierPage = "Edit Supplier";
		if (ActualEditSupplierPage.equals(ExpectedEditSupplierPage)) {
			System.out.println("Edit Supplier Page is Displaying");
		} else {
			System.out.println("Edit Supplier Page Is not Displaying");
		}
	}

	public void ClickonSaveButtonn() {
		CNLocator.SaveButtonnn.click();
	}

	public void ClickonEditButton() throws Throwable {
		HelperClass.sleep1(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@formcontrolname='supplierId']",
				"ABC Design");
		HelperClass.sleep1(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-icon[normalize-space()='edit']//parent::span//parent::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='edit']//parent::span//parent::button"));
	}

	public void ValidateEditSupplierPageDiaplayed() {
		String ActualEditSupplierPageee = HelperClass.getText(By.xpath("//span[normalize-space()='Edit Supplier']"));
		String ExpectedEditSupplierPageee = "Edit Supplier";
		if (ActualEditSupplierPageee.equals(ExpectedEditSupplierPageee)) {
			System.out.println("Edit Supplier Page is Displaying");
		} else {
			System.out.println("Edit Supplier Page Is not Displaying");
		}
	}

	public void ClickonProcessDuplicateYesButton() {
		CNLocator.ProcessDuplicatePopupYesButton.click();
	}

	public void ClickonProcessDuplicateNoButton() {
		CNLocator.ProcessDuplicatePopupNoButton.click();
	}

	public void ValidateProcessDuplicateUploadd() {
		String ActualProcessDuplicateUpload = HelperClass
				.getText(By.xpath("//h2[normalize-space()='Process Duplicate Upload']"));
		String ExpectedProcessDuplicateUpload = "Process Duplicate Upload";
		if (ActualProcessDuplicateUpload.equals(ExpectedProcessDuplicateUpload)) {
			System.out.println("Process Duplicate upload popup Displying ");
		} else {
			System.out.println("Process Duplicate upload is not Displying");
		}
	}

	public void ClickonCreditNoteCheckBox() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]")));
		WebElement element = driver.findElement(
				By.xpath("//tbody/tr[1]/td/div/mat-checkbox/label/span[contains(@class,'mat-checkbox-inner')]"));
		HelperClass.clickUsingJS(element);
	}
}
