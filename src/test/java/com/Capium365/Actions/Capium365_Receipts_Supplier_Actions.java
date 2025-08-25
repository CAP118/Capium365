package com.Capium365.Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.Capium365.Locators.Capium365_Receipts_Supplier_Locators;

public class Capium365_Receipts_Supplier_Actions {

	Capium365_Receipts_Supplier_Locators supplierLocators = null;

	public Capium365_Receipts_Supplier_Actions() {
		this.supplierLocators = new Capium365_Receipts_Supplier_Locators();
		PageFactory.initElements(HelperClass.getDriver(), supplierLocators);
	}

	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();

	public void ClickonKeyBoardErrowRight() {
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

	public void ClickonSupplersMenu() {
		By ReceiptsInsideSidebar = By.xpath("//a[@mattooltip='Suppliers']");
		HelperClass.isElementPresent(ReceiptsInsideSidebar);
		HelperClass.clickUsingJS(ReceiptsInsideSidebar);
		HelperClass.sleep1(3000);

	}

//    public void clickonAddsupplierButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//    	SupLocator.AddSupplier.click();
//    }
	public void clickonAddsupplierButton() {
		By addSupplierButtonBy = By.xpath("(//span[@class='mat-button-wrapper'])[14]");

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(addSupplierButtonBy)).click();
	}

	public void ValidateAddNewSupplierPage() {
		String actualAddSupplier = HelperClass.getText(By.xpath("//span[normalize-space()='Add New Supplier']"));
		String expectedAddSupplier = "Add New Supplier";
		if (actualAddSupplier.equals(expectedAddSupplier)) {

			System.out.println("Add New Supplier is Displaying");

		} else {
			System.out.println("Add New Supplier is not Displaying");
		}
	}

	public void EnterSupplierField() throws InterruptedException {
		String baseName = "sahailrana190";
		int randomNumber = (int) (Math.random() * 9000) + 1000;
		String uniqueSupplierName = baseName + "_" + randomNumber;

		HelperClass.clearField(driver, By.xpath("//input[@formcontrolname='supplierName']"));
		HelperClass.safeSendKeys(By.xpath("//input[@formcontrolname='supplierName']"), uniqueSupplierName);

		System.out.println("Entered unique supplier name: " + uniqueSupplierName);
	}

	public void ValidatePaymentAccountDropdown() throws Throwable {
		String dropdownXpath = "//ng-select[@formcontrolname='bankDetailId']/div";
		WebDriver driver = HelperClass.getDriver();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ng-select[@formcontrolname='bankDetailId']/div")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
		HelperClass.clickUsingJS(By.xpath(dropdownXpath));
		Thread.sleep(1000);

		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));

		if (options.isEmpty()) {
			System.out.println("No options found in the payment account dropdown.");
			return;
		}

		System.out.println("Found " + options.size() + " options in the dropdown.");

		for (WebElement option : options) {
			try {
				String optionText = option.getText().trim();
				System.out.println("Selecting option: " + optionText);

				HelperClass.clickUsingJS(By.xpath(dropdownXpath));
				Thread.sleep(1000);

				WebElement currentOption = driver
						.findElement(By.xpath("//div[@role='option' and text()='" + optionText + "']"));
				HelperClass.clickUsingJS(currentOption);
				Thread.sleep(2000);

			} catch (Exception e) {
				System.out.println("Failed to select option: " + e.getMessage());
			}
		}
	}

	public void ValidateVATRateDropdown() throws Throwable {

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

	}

	public void ValidateDateDropdownInAddSupplierPage() throws Throwable {
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"All Time");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"This Week");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"Last Week");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"This Month");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"Last Month");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"This Quarter");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"Last Quarter");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"This Year");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"Last Year");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"Custom");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass']",
				"This Financial Year");
		Thread.sleep(2000);

	}

	public void CLickonThreedot() {
		supplierLocators.Threedoticon.click();

	}

//Export to Excel
	public void ExporttoExcel(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		supplierLocators.ExporttoExcel.click();

	}

//Export to csv
	public void ExporttoCSV(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		supplierLocators.Exporttocsv.click();

	}

//Export to pdf
	public void ExporttoPDF(WebDriver driver) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		supplierLocators.Exporttopdf.click();
		Thread.sleep(5000);
	}

//searchBar
	public void Clickonsearchbarandenterdata() throws Throwable {
		supplierLocators.SearchBar.sendKeys("sahilrana");
		Thread.sleep(5000);
	}

	public void SearchAndVerifydata() {
		// SupLocator.SearchBar.clear();
		supplierLocators.SearchBar.sendKeys("sahilrana");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Wait until the searched data is visible in the table/list
			WebElement resultElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='sahilrana']")));

			String actualText = resultElement.getText();
			String expected = "sahilrana";

			if (actualText.equals(expected)) {
				System.out.println("Records found");
			} else {
				System.out.println("No records found");
			}

		} catch (Exception e) {
			System.out.println("Search result not found or timed out.");
		}
	}

	public void mousehoverandPerformActions(int rowIndex, String actionType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions = new Actions(driver);

		// Wait for overlay spinner to disappear (if applicable)
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
		} catch (Exception e) {
			System.out.println("No spinner overlay found or disappeared quickly.");
		}

		// Wait for table to be visible
		WebElement table = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@aria-describedby='Suppiler List Table']")));

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

	public void ClickonCrossButtonEditsupplierScreen() {
		supplierLocators.CrossButtonEditSupplier.click();
	}

	public void ClickonYesButton() {
		supplierLocators.YesButton.click();
	}

	public void ClickonNoButton() {
		supplierLocators.NoButton.click();
	}

//Pagination Code
	public void ClickonPagiantionDropdownandValidteCount() throws Exception {

		Thread.sleep(3000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "10");
		Thread.sleep(3000);
		supplierLocators.SelectCheckBox.click();

		String actualtext = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']"));
		String expected = "Records: 10";
		if (actualtext.equals(expected)) {

			System.out.println("10 records are there");

		} else {
			System.out.println("10 records are not there");
		}
		Thread.sleep(3000);
		supplierLocators.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "20");
		Thread.sleep(3000);
		supplierLocators.SelectCheckBox.click();

		String actualtext2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']"));
		String expected2 = "Records: 20";
		if (actualtext2.equals(expected2)) {

			System.out.println("20 records are there");

		} else {
			System.out.println("20 records are not there");
		}
		Thread.sleep(3000);
		supplierLocators.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "50");

		Thread.sleep(3000);
		supplierLocators.SelectCheckBox.click();

		String actualtext3 = HelperClass.getText(By.xpath("//p[normalize-space(text())='50']"));
		String expected3 = "Records: 50";
		if (actualtext3.equals(expected3)) {

			System.out.println("50 records are there");

		} else {
			System.out.println("50 records are not there");
		}

		supplierLocators.CrossButton.click();
		Thread.sleep(3000);

		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"//mat-select[normalize-space(@panelclass)='pagination']", "100");

		Thread.sleep(3000);
		supplierLocators.SelectCheckBox.click();

		String actualtext4 = HelperClass.getText(By.xpath("//p[normalize-space(text())='100']"));
		String expected4 = "Records: 100";
		if (actualtext4.equals(expected4)) {

			System.out.println("100 records are there");

		} else {
			System.out.println("100 records are not there");
		}

		supplierLocators.CrossButton.click();
		Thread.sleep(3000);

	}

	public void ValidateNextButton() {
		HelperClass.navigateUntilEnd(HelperClass.getDriver(), "//button[contains(@class,'paginator-next')]",
				"next-disabled", "Next");
	}

	public void ValidatePreviousButton() {
		HelperClass.navigateUntilEnd(HelperClass.getDriver(), "//button[contains(@class,'paginator-previous')]",
				"previous-disabled", "Previous");
	}

	public void ClickonIDCheckBox() {
		supplierLocators.SelectCheckBox.click();
	}

	public void ClickonCancelbutton() {
		supplierLocators.CancelButton.click();
	}

	public void ClickonSupplierIDCheck() {
		supplierLocators.SupplierIDCheckBox.click();
	}

	public void ClickonFooterDeleteButton() {
		supplierLocators.FooterDeleteButtton.click();
	}

	public void ValidateConfirmDeletepopup() {
		String actualConfirmDeletepopup = HelperClass.getText(By.xpath("//h2[normalize-space()='Confirm Delete']"));
		String expectedConfirmDeletepopup = "Confirm Delete";
		if (actualConfirmDeletepopup.equals(expectedConfirmDeletepopup)) {

			System.out.println("Confirm Delete popup is Displaying");

		} else {
			System.out.println("Confirm Delete popup is not Displaying");
		}
	}

	public void ClickonFooterExcelButton() {
		supplierLocators.FooterExcelButton.click();
	}

	public void ClickonFooterCsvButton() {
		supplierLocators.FooterCsvButton.click();
	}

	public void ClickonFooterPdfButton() {
		supplierLocators.FooterPdfButton.click();
	}

	public void ClickonFooterCrossBtton() {
		supplierLocators.FooterCrossButton.click();
	}

	// Calling for Search and Click Edit Icon By ID
	String beforeCopyText;

	public void clickEditForPurchaseInvoice() {
		beforeCopyText = HelperClass.getText(By.xpath("//table/tbody/tr[1]/td[1]/div/a"));
		HelperClass.safeSendKeys(By.xpath("//input[@formcontrolname='search']"), beforeCopyText);
		HelperClass.sleep1(3000);
		HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='edit']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='edit']/ancestor::button"));
		HelperClass.sleep1(2000);
	}

	public void ClickonSupplierID() {
		supplierLocators.SupplierID.click();
	}

	public void ClickonInsideSupplierCheckBox() {
		supplierLocators.InsideEditSupplierCheckBox.click();
	}

	public void ValidateSupplierCountCheckBoxRecords() {
		String actualConfirmDeletepopup = HelperClass.getText(By.xpath("//p[@class='font-size-18 fw-bold']"));
		String expectedConfirmDeletepopup = "Records:";
		if (actualConfirmDeletepopup.equals(expectedConfirmDeletepopup)) {

			System.out.println("Records is Displaying");

		} else {
			System.out.println("Records is not Displaying");
		}
	}

	public void ValidateHistoryTabLogo() {
		String actualHistoryLogo = HelperClass.getText(By.xpath("//span[normalize-space()='GF']"));
		String expectedHistoryLogo = "GF";
		if (actualHistoryLogo.equals(expectedHistoryLogo)) {

			System.out.println("History is Displaying");

		} else {
			System.out.println("History is not Displaying");
		}
	}

	public void ClickonHistoryTabCloseButton() {
		supplierLocators.HistoryTabCloseButton.click();
	}

	public void clickOnReceiptsMenuuu() throws Throwable {
		waitForSpinnerToDisappear();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// Re-locate element freshly to avoid stale issue
		By receiptsBtnLocator = By.xpath("//span[contains(text(), 'Receipts')]"); // Replace with actual unique text
		WebElement receiptsBtn = wait.until(ExpectedConditions.elementToBeClickable(receiptsBtnLocator));

		receiptsBtn.click();

		// Replace hard wait with wait for page content
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Upload Purchase Invoices')]"))); // Adjust
																												// based
																												// on
																												// your
																												// page
	}

	public void waitForSpinnerToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));
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
}
