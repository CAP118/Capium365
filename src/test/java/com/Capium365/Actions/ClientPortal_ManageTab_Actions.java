package com.Capium365.Actions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

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

public class ClientPortal_ManageTab_Actions {

	
	WebDriver driver=HelperClass.getDriver();
	WebDriverWait wait=HelperClass.getWait();
	
	public ClientPortal_ManageTab_Actions() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[normalize-space()='Add Client'])[2]")  
    public WebElement AddClient;
 
    @FindBy(xpath = "//input[@formcontrolname='companyName']") 
    public WebElement EnterCompanyName;

    @FindBy(xpath = "//input[@formcontrolname='name']") 
    public WebElement EnterName;

    @FindBy(xpath = "//input[@formcontrolname='email']") 
    public WebElement EnterEmail;

    @FindBy(xpath = "//span[normalize-space()='Save and Exit']") 
    public WebElement SaveandExit;

    @FindBy(xpath = "//p[normalize-space(text())='The operation completed Successfully!']")
    public WebElement SuccessMessage;

    @FindBy(xpath = "//span[normalize-space()='Save & Send Invite to 365']")
    public WebElement SaveandsendInviteto365;

    @FindBy(xpath = "(//span[normalize-space()='Yes, proceed and invite'])[2]")
    public WebElement ClickonYesProceedandInvite;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement SearchBar;

    @FindBy(xpath = "(//span[normalize-space()='yuoo'])[1]")
    public WebElement ContactName;

    @FindBy(xpath = "//mat-dialog-container//mat-checkbox/div//div[@class='mdc-checkbox']")
    public WebElement Deletecheckbox;

    @FindBy(xpath = "//span[normalize-space()='Yes']")
    public WebElement Yesbutton;
    
    String FilePath="D:\\Core Modules\\Capium365\\src\\test\\resources\\Files_Excel\\Add Client ClientPortal.xlsx";
    
    public void ClickonAddClientButton() {

	    By spinner = By.cssSelector("div.ngx-spinner-overlay");

	    By AddClientLocator = By.xpath("(//span[normalize-space()='Add Client'])[2]");

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));


	    WebElement AddClientbtn = wait.until(ExpectedConditions.elementToBeClickable(AddClientLocator));


	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddClientbtn);


	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddClientbtn);

	}
 
 
     

    public void VerifyAddNewClientPage() {

        String ActualAddNewClientPage = HelperClass

            .getText(By.xpath("//h2[normalize-space()='Add New Client']"));

        String ExpectedAddNewClientPage = "Add New Client";

        if (ActualAddNewClientPage.equals(ExpectedAddNewClientPage)) {

            System.out.println("Add New Client Page is Displaying");

        } else {

            System.out.println("Add New Client Page is not Displaying");

        }

    }

    public void FillthemandatorydetailsinaddClientandsaveandexit()

			throws InterruptedException, AWTException, IOException {

		String[][] data = ExcelReader.getSheetData(FilePath, "Sheet2");

		String[] Client = data[0];

		EnterCompanyName.sendKeys(Client[0]);

		EnterName.sendKeys(Client[1]);

		EnterEmail.sendKeys(Client[2]);
		SaveandExit.click();

		HelperClass.captureScreenshot("mandatory fields required message verified");

	}

    public void ValidateSuccessMessage() {

    	 String ActualSuccessMessage = HelperClass
    	            .getText(By.xpath("//app-custom-notifications/div/p")).trim();
    	        String ExpectedAddNewClientPage = "The operation was completed successfully!";
    	        if (ActualSuccessMessage.equals(ExpectedAddNewClientPage)) {
    	            System.out.println("Success Message is Displaying");
    	        } else {
    	            System.out.println("Succes Message is not Displaying"+ActualSuccessMessage);
    	        }

    }
    
    public void SendInvite() {
    	HelperClass.safeClick(SaveandsendInviteto365, "Invite");
    }

    public void ClickonSaveandSendInviteTo365() throws Throwable {

    	SaveandsendInviteto365.click();

    	Thread.sleep(2000);

    	ClickonYesProceedandInvite.click();

    }

    public void ValidateThreeSixtyFiveStatus() throws Throwable {

    	String Actual365Status = HelperClass

	            .getText(By.xpath("(//a[normalize-space()='Resend Invitation'])[1]"));

	        String Expected365Status = "Resend Invitation";

	        if (Actual365Status.equals(Expected365Status)) {

	            System.out.println("ResendInvitation is Displaying");

	        } else {

	            System.out.println("ResendInvitation is not Displaying");

	        }

    }

 
    public void validateSearchandNaviagteto365() throws Throwable {
    	Thread.sleep(4000);
    	SearchBar.sendKeys("Bank_Rule_By_LImited_Client");
    	Thread.sleep(2000);
    	HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='search']"));
    	
        HelperClass.sleep1(5000);
        HelperClass.hoverOverElement(By.xpath("//table[@aria-describedby='Invited to 365 list Table']/tbody/tr[1]"));
        HelperClass.sleep1(2000);
        HelperClass.clickUsingJS(By.xpath("//mat-icon[text()='login']/parent::button"));
        HelperClass.sleep1(5000);
    }
 
public void Validate365DashBoardMainGrid() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Invoices'])[2]")));
    	String Actual365DashBoard = HelperClass
	            .getText(By.xpath("(//span[normalize-space()='Invoices'])[2]"));
	        String Expected365DashBaord = "Invoices";
	        if (Actual365DashBoard.equals(Expected365DashBaord)) {
	            System.out.println("365DashBoard is Displaying");
	        } else {
	            System.out.println("365DashBoard is not Displaying");
	        }
    }
    
    
    public void ClickonEditIcon() throws Throwable {
    	Thread .sleep(10000);
    	HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
    	HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='edit']"));
    }
    
    public void ClickonArchivebutton() throws Throwable {
    	Thread .sleep(10000);
    	HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
    	HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='archive']"));
    }
    
    public void ValidateEditDetailsPage() {
    	String ActualEditDetailsPage = HelperClass
	            .getText(By.xpath("(//span[normalize-space()='Details'])[2]"));
	        String ExpectedEditDetailsPage = "Details";
	        if (ActualEditDetailsPage.equals(ExpectedEditDetailsPage)) {
	            System.out.println("EditDetails Page is Displaying");
	        } else {
	            System.out.println("EditDetails Page is not Displaying");
	        }
    }
    
    public void ClickonMoreVertOptions() throws Throwable {
    	Thread .sleep(10000);
    	HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
    	HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='more_vert']"));
    	//Thread .sleep(10000);
    	//HelperClass.mouseHoverAndPerformActionnClientPortal("Invited to 365 list Table",0, "more_vert");
    }
    public void mousehoverandClickonDeleteIcon() throws Throwable {
    	Thread.sleep(10000);
    	HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
    	HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='delete_outline']"));
    }
    
    public void ClickonnArchivebutton() throws Throwable {
    	    Thread.sleep(5000); 
    	    HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
    	    List<WebElement> threeDot = driver.findElements(By.xpath("//tr[1]//mat-icon[normalize-space()='more_vert']"));
 
    	    if (!threeDot.isEmpty()) {
    	        HelperClass.clickUsingJS(threeDot.get(0));
    	        HelperClass.clickUsingJS(By.xpath("(//span[normalize-space()='Archive'])[2]"));
    	        System.out.println("Clicked archive via three-dot menu");
    	    } else {
    	        HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='archive']"));
    	        System.out.println("Clicked direct archive icon");
    	    }
    	}
 
    
    
    
    public void SelectStatusDropdownandVerify() throws Throwable {
    	Thread.sleep(10000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Invite");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Invite']",
				"Invite");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Active");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Active']",
				"Active");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Resend Invitation");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Resend Invitation']",
				"Resend Invitation");
		Thread.sleep(2000);
		HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
				"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[1]", "Imported");
		Thread.sleep(2000);
		HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Imported']",
				"Imported");
	}
    
    
   public void ValidateStatusdrodown() throws Throwable {
	   Thread.sleep(10000);
			HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
					"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Active");
			Thread.sleep(2000);
			HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Invite']/following-sibling::td[1]",
					"Active");
			Thread.sleep(2000);
			HelperClass.selectFromStatusDropdown(HelperClass.getDriver(),
					"(//ng-select[normalize-space(@panelclass)='myPanelClass'])[2]", "Archived");
			Thread.sleep(2000);
			HelperClass.verifyStatusTypes(HelperClass.getDriver(), "//table/tbody/tr/td[normalize-space()='Invite']/following-sibling::td[1]",
					"Archived");
   }
   
   public void ClickonContactLink() {
	    ContactName.click();
   }
   
   public void ValidateConctactDetails() {
	   String ActualContactNameDeatisl= HelperClass
	            .getText(By.xpath("//strong[normalize-space()='Contact Details']"));
	        String ExpectedContactNameDeatils = "Contact Details";
	        if (ActualContactNameDeatisl.equals(ExpectedContactNameDeatils)) {
	            System.out.println("Contact Deatails PopUp is Displaying");
	        } else {
	            System.out.println("Conatct Details PopUp is not Displaying");
	        }
   }
    
   public void ClickonThreedotthenArchivebutton() throws Throwable {
	
	    	Thread .sleep(10000);
	    	HelperClass.hoverOverElement(By.xpath("//table/tbody/tr[1]"));
	    	HelperClass.clickUsingJS(By.xpath("//tr[1]//mat-icon[normalize-space()='more_vert']"));
	    	HelperClass.clickUsingJS(By.xpath("(//span[normalize-space()='Archive'])[2]"));
	    	//Thread .sleep(10000);
	    	//HelperClass.mouseHoverAndPerformActionnClientPortal("Invited to 365 list Table",0, "more_vert");
	    }
   
   public void ValidateConfirmArchivePopup() {
	   String ActualConirmArchivepopup= HelperClass
	            .getText(By.xpath("//h2[normalize-space()='Confirm Archive']"));
	        String ExpectedConfirmArchivepopup = "Confirm Archive";
	        if (ActualConirmArchivepopup.equals(ExpectedConfirmArchivepopup)) {
	            System.out.println("Archive PopUp is Displaying");
	        } else {
	            System.out.println("Archive PopUp is not Displaying");
	        }
   }
   
   public void selectcheckboxdelete() throws Throwable {
	   Thread.sleep(2000);
	   Deletecheckbox.click();
	   Thread.sleep(2000);
	   Yesbutton.click();
   }
   
   
   
   public void ValidateDeleteSuccessMessage() {
	   String ActualDeleteSuccessMessage = HelperClass.getText(By.xpath("//p[normalize-space(text())='Record deleted successfully."));
	        String ExpectedDeleteAddNewClientPage = "Record deleted successfully.";
	        if (ActualDeleteSuccessMessage.equals(ExpectedDeleteAddNewClientPage)) {
	            System.out.println("Delete Success Message is Displaying");
	        } else {
	            System.out.println("Delete Succes Message is not Displaying");
	        }   }
   
	
}
