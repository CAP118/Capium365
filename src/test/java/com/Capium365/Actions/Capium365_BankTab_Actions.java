package com.Capium365.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium365.Locators.Capium365_BankTab_Locators;

public class Capium365_BankTab_Actions {
	
	Capium365_BankTab_Locators banklocators=null;
	
	WebDriver driver=HelperClass.getDriver();
	WebDriverWait wait=HelperClass.getWait();
	
	public Capium365_BankTab_Actions() {
		this.banklocators=new Capium365_BankTab_Locators();
		PageFactory.initElements(driver, banklocators);
	}
	
	public void clickonbanktab() throws Exception {
		 By receiptsTab = By.xpath("//span[text()='Bank']/ancestor::a");
			WebElement element = HelperClass.waitUntilClickable(receiptsTab);
			element.click();	
	}
	
	public void Verifybanktab() {
		wait.until(ExpectedConditions.visibilityOf(banklocators.addnewaccountbutn));
		banklocators.addnewaccountbutn.isDisplayed();
		System.out.println("Successfully navigated to bank tab");
	}
	
	public void Clickonexpandicon() throws Exception {
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
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
	
	public void Validatebankaccounts() {
		banklocators.bankaccounttab.isDisplayed();
		System.out.println("bank accounts tab is displaying succesfully");
	}
	
	public void Clickonaddnewaccount() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(banklocators.addnewaccountbutn));
		banklocators.addnewaccountbutn.click();
	}
	
	public void Continuewiththefollowingsteps() throws Exception {
		banklocators.bankTF.sendKeys("mock");
		banklocators.mockbankselection.click();
		banklocators.allowbutton.click();
		banklocators.truelayerusername.sendKeys("john");
		wait.until(ExpectedConditions.visibilityOf(banklocators.truelayerpassword));
		banklocators.truelayerpassword.sendKeys("doe");
		wait.until(ExpectedConditions.visibilityOf(banklocators.proceedbutton));
		banklocators.proceedbutton.click();
		banklocators.selectaccount.click();
		wait.until(ExpectedConditions.visibilityOf(banklocators.continuebutton));
		banklocators.continuebutton.click();
	}
	
	public void Deleteaccount() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(banklocators.deleteicon));
		banklocators.deleteicon.click();
		wait.until(ExpectedConditions.visibilityOf(banklocators.deletepopupyes));
		WebElement popup = HelperClass.waitUntilClickable(banklocators.deletepopupyes);
		popup.click();
		
			
	}
	
	public void EntertextinthesearchtextfieldandVerifydata() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(banklocators.searchTF));
		banklocators.searchTF.sendKeys("any");
		HelperClass.sleep1(2000);
		List<WebElement> referenceCells = HelperClass.getDriver().findElements(
			    By.xpath("//span[contains(text(), 'ANYVAN')]"));
			System.out.println(referenceCells);
 
			for (WebElement cell : referenceCells) {
			    String actual = cell.getText().trim();
			    if (actual.contains("ANYVAN")) {
			        System.out.println("Matched: " + actual);
			    } else {
			        System.out.println("Mismatch: " + actual);
			    }
			}
	}
	
	public void Clickondatedropdown() throws Exception {
		
		 HelperClass.selectFromStatusDropdown(HelperClass.getDriver(), "//ng-select[@panelclass='myPanelClass' and contains(@class,'w-170')]", "This Year");
	}
	
	//Export
	public void exportthreedotmenu() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='more_vert']/ancestor::button")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='more_vert']/ancestor::button"));
		
	}
	
	public void exporttoexcel(){
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Export to Excel']")));
		HelperClass.clickUsingJS(By.xpath("//button[normalize-space(text())='Export to Excel']"));
		
	}
		
	public void exporttocsv() throws Exception{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Export to CSV']")));
		HelperClass.clickUsingJS(By.xpath("//button[normalize-space(text())='Export to CSV']"));
	}
	
	public void exporttopdf(){
	
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Export to PDF']")));
		HelperClass.clickUsingJS(By.xpath("//button[normalize-space(text())='Export to PDF']"));
		
	}
	
	public void Clickonpaginationdropdownandverifytherecordsbasedondropdownvalue() throws Exception {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='10']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='10']"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/mat-checkbox"));
		
		String actualText = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected = "Records: 10";
 
		if (actualText.equals(expected)) {
		    System.out.println("10 records are there");
		} else {
		    System.out.println("Text not matched. Actual: " + actualText);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
			HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='10']")));
			HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='20']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/mat-checkbox")));
			HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/mat-checkbox"));
		
		String actualText1 = HelperClass.getText(By.xpath("//p[normalize-space(text())='20']")).trim();
		String expected1 = "Records: 20";
 
		if (actualText1.equals(expected1)) {
		    System.out.println("20 records are there");
		} else {
		    System.out.println("Text not matched. Actual: " + actualText);
		}
		
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
			HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
			HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='10']")));
			HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='100']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/mat-checkbox")));
			HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/mat-checkbox"));
		
		
		String actualText2 = HelperClass.getText(By.xpath("//p[normalize-space(text())='10']")).trim();
		String expected2 = "Records: 100";
 
		if (actualText2.equals(expected2)) {
		    System.out.println("100 records are there");
		} else {
		    System.out.println("Text not matched. Actual: " + actualText);
		}
		
		}
	
	
	
	public void Clickoneachpagenumber() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='2']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='2']//parent::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='3']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='3']//parent::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='4']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='4']//parent::button"));
	}
	
	public void verifyprevioudbuttonisdisabledwheneverthefirstpagenumberishighlighted() {
		
		WebElement previousButton = HelperClass.getDriver().findElement(
			    By.xpath("//button[normalize-space(@class)='mat-focus-indicator paginator-arrow paginator-previous mat-button mat-button-base previous-disabled']")
			);
 
			String classValue = previousButton.getAttribute("class");
			System.out.println(classValue);
			if (classValue.contains("disabled") || classValue.contains("next-disabled")) {
			    System.out.println("previous button is in disabled state");
			} else {
			    System.out.println("previous button is in enabled state");
			}
		
		
	}
	
	public void verifynextbuttonisdisabledwheneverthelastpagenumberishighlighted() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@panelclass='pagination']")));
		HelperClass.safeClick(By.xpath("//mat-select[@panelclass='pagination']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option/span[normalize-space()='100']")));
		HelperClass.safeClick(By.xpath("//mat-option/span[normalize-space()='100']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='5']//parent::button")));
		HelperClass.safeClick(By.xpath("//span[normalize-space()='5']//parent::button"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'paginator-next')]")));
		WebElement nextButton = HelperClass.getDriver().findElement(
			    By.xpath("//button[contains(@class, 'paginator-next')]")
			);
 
			String classValue = nextButton.getAttribute("class");
			System.out.println(classValue);
			if (classValue.contains("disabled") || classValue.contains("next-disabled")) {
			    System.out.println("Next button is in disabled state");
			} else {
			    System.out.println("Next button is in enabled state");
			}
 
 
		
	}
		
	public void clickongotoTFandchangethepage() throws Exception {
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		 HelperClass.waitUntilVisible(HelperClass.getWait(), banklocators.gotoTF);
		 HelperClass.clickUsingJS( banklocators.gotoTF);
		
		wait.until(ExpectedConditions.visibilityOf(banklocators.gotoTF));
		 banklocators.gotoTF.clear();
		 banklocators.gotoTF.sendKeys("2"+Keys.ENTER);
		// banklocators.gotoTF.sendKeys(Keys.ENTER);
		
		 wait.until(ExpectedConditions.visibilityOf(banklocators.gotoTF));
		 banklocators.gotoTF.clear();
		 banklocators.gotoTF.sendKeys("3"+Keys.ENTER);
		 //banklocators.gotoTF.sendKeys(Keys.ENTER);
		
		 wait.until(ExpectedConditions.visibilityOf(banklocators.gotoTF));
		 banklocators.gotoTF.clear();
		 banklocators.gotoTF.sendKeys("4"+Keys.ENTER);
		 //banklocators.gotoTF.sendKeys(Keys.ENTER);
		
	}
	
	public void gotosettingsandclickonbusiness() throws Exception {
		
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='settings_outline']/ancestor::a")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='settings_outline']/ancestor::a"));
		
		 banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='My Business']")));
		 HelperClass.safeClick(By.xpath("//button[normalize-space(text())='My Business']"));
		
	}
	
	public void Comparethebankaccountsinbanktabandbussinesstab() throws Exception {
		HelperClass.scrollToElement(By.xpath("//p[normalize-space()='Bank Details']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Bank Details']")));
		
		WebElement businessbankfield1 = HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[normalize-space(@formcontrolname)='accountName'])[1]")));
        String transactionaccountbusiness = businessbankfield1.getAttribute("value").trim();
        System.out.println("Transaction account captured: " + transactionaccountbusiness);
        
        WebElement businessbankfield2 = HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[normalize-space(@formcontrolname)='accountName'])[2]")));
        String sbibusiness = businessbankfield2.getAttribute("value").trim();
        System.out.println("sbi captured: " + transactionaccountbusiness);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Bank']/ancestor::a")));
        HelperClass.clickUsingJS( By.xpath("//span[text()='Bank']/ancestor::a"));
        HelperClass.sleep1(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='keyboard_arrow_right' and @data-mat-icon-type='font']")));
        HelperClass.clickUsingJS( By.xpath("//mat-icon[text()='keyboard_arrow_right' and @data-mat-icon-type='font']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='TRANSACTION ACCOUNT 1 (0000)']")));
        String actualText1 = HelperClass.getText(By.xpath("//span[@title='TRANSACTION ACCOUNT 1 (0000)']")).trim();
        String expected1 = transactionaccountbusiness;
 
        if (actualText1.contains(expected1)) {
        	System.out.println("'Transaction account1' matched");
        } else {
	    System.out.println("Transaction account1. Actual: " + actualText1);
        }
        
        String actualText2 = HelperClass.getText(By.xpath("//span[@title='sbi (3257)']")).trim();
        String expected2 = sbibusiness;
 
        if (actualText2.contains(expected2)) {
        	System.out.println("'sbi bank account' matched");
        } else {
	    System.out.println("sbi account. not matched Actual: " + actualText2);
        }
 
		
	}
	
	public void clickonrefreshaccount() throws Exception {
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		 HelperClass.waitUntilVisible(HelperClass.getWait(), banklocators.refreshaccount);
		 HelperClass.clickUsingJS( banklocators.refreshaccount);
	}
	
	public void verifyheaders() throws Exception {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'top-list')]")));
		String actualText = HelperClass.getText(By.xpath("//div[normalize-space(text())='Money In :']")).trim();
		String expected = "Money In";
 
		if (actualText.contains(expected)) {
		    System.out.println("'money in' header is there");
		} else {
		    System.out.println("Money in header is not there. Actual: " + actualText);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'top-list')]")));
		String actualText1 = HelperClass.getText(By.xpath("//div[normalize-space(text())='Money Out :']")).trim();
		String expected1 = "Money Out";
 
		if (actualText1.contains(expected1)) {
		    System.out.println("'Money out' header is there");
		} else {
		    System.out.println("Money out header is not there. Actual: " + actualText1);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'top-list')]")));
		String actualText2 = HelperClass.getText(By.xpath("//div[normalize-space(text())='Bank Balance :']")).trim();
		String expected2 = "Bank Balance";
 
		if (actualText2.contains(expected2)) {
		    System.out.println("'Bank Balance' header is there");
		} else {
		    System.out.println("Bank Balance header is not there. Actual: " + actualText2);
		}
	
	}
	
	public void Clickoncheckboxforidandexporttoexcel() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-describedby='Bankfeed Table']/tbody")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/mat-checkbox"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Excel']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//p[normalize-space()='Excel']/ancestor::button"));
		
	}
	
	public void Clickoncheckboxforidandexporttocsv() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='CSV']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//p[normalize-space()='CSV']/ancestor::button"));	
	}
	
	public void Clickoncheckboxforidandexporttopdf() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='PDF']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//p[normalize-space()='PDF']/ancestor::button"));
		
	}
	
	public void entertextinsearchtextfieldandverify() throws Exception {
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='search']/ancestor::a")));
		 HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='search']/ancestor::a"));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']/ancestor::mat-form-field[contains(@class,'mini')]")));
		 HelperClass.safeSendKeys(By.xpath("(//input[@placeholder='Search'])[1]"), "transac");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='TRANSACTION ACCOUNT 1 (0000)']")));
		 String actualText = HelperClass.getText(By.xpath("//span[@title='TRANSACTION ACCOUNT 1 (0000)']")).trim();
			String expected = "TRANSAC";
	
			if (actualText.contains(expected)) {
			    System.out.println("Found the bank");
			} else {
			    System.out.println("Text not matched. Actual: " + actualText);
			}
	}
	
	public void Clickoncrossmarkinsearchtextfieldandverifythedataiscleared() throws Exception {
		banklocators=PageFactory.initElements(HelperClass.getDriver(), Capium365_BankTab_Locators.class);
		 HelperClass.waitUntilVisible(HelperClass.getWait(), banklocators.searchiconinexpandarrow);
		 HelperClass.clickUsingJS( banklocators.searchiconinexpandarrow);
		 wait.until(ExpectedConditions.visibilityOf(banklocators.searchTFinexpandarrow));
		 banklocators.searchTFinexpandarrow.click();
		 wait.until(ExpectedConditions.visibilityOf(banklocators.searchTFinexpandarrow));
		 banklocators.searchTFinexpandarrow.sendKeys("transac");
		
		 String fieldValue = banklocators.searchTFinexpandarrow.getAttribute("value");
		    if (fieldValue.isEmpty()) {
		        System.out.println("Search field is empty after clearing.");
		    } else {
		        System.out.println("Search field is NOT empty. Value: " + fieldValue);
		    }
		}
	
	public void Clickoncheckboxandclcikoncrossmark() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-describedby='Bankfeed Table']/tbody")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/thead/tr/th/div/mat-checkbox")));
		HelperClass.safeClick(By.xpath("//table/thead/tr/th/div/mat-checkbox"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button")));
		HelperClass.safeClick(By.xpath("//mat-icon[normalize-space()='highlight_off']/ancestor::button"));
	}
}
 
 
