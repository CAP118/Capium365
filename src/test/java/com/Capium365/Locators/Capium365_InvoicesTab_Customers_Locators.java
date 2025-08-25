package com.Capium365.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Capium365_InvoicesTab_Customers_Locators {

	@FindBy(xpath = "//span[normalize-space()='Invoices']//parent::a")
	public WebElement invoicestab;
 
	@FindBy(xpath = "//mat-icon[text()='keyboard_arrow_right']")
	public WebElement arrowbutton;
	
	@FindBy(xpath = "//mat-icon[text()='person_outline']//parent::div")
	public WebElement cutomerstab;
	
	@FindBy(xpath = "//span[normalize-space()='Add Customer']/ancestor::button")
	public WebElement addcustomerbutton;
	
	@FindBy(xpath = "//input[@formcontrolname='fullName']")
	public WebElement fullnametextbox;
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement enteremail;
	
	@FindBy(xpath = "//span[text()=' Save ']")
	public WebElement savebutton;
 
	@FindBy(xpath ="//span[text()= ' Save and Exit ' ]")
	public WebElement saveandexitbutton;
	
	@FindBy(xpath ="//span[text()=' Cancel Changes ']")
	public WebElement cancelchangesbutton;
	
	@FindBy(xpath ="//input[@formcontrolname='phone']")
	public WebElement enterphnumber;
	
	@FindBy(xpath="//input[normalize-space(@formcontrolname)='whatsAppNumber']")
	public WebElement enterwhatsappnumber;
 
	@FindBy(xpath ="//input[@formcontrolname='address']")
	public WebElement enteraddress;
	
	@FindBy(xpath ="//input[@formcontrolname='city']")
	public WebElement entercity;
	
	@FindBy(xpath ="//input[@formcontrolname='county']")
	public WebElement entercounty;
	
	@FindBy(xpath ="//input[@formcontrolname='postalCode']")
	public WebElement enterpostcode;
	
	@FindBy(xpath ="//input[@formcontrolname='logo']")
	public WebElement choosefiletoupload;
	
	@FindBy(xpath="//a[normalize-space(text())='Add New line']")
	public WebElement contactdetailsaddnewline;
 
	@FindBy(xpath="(//input[@formcontrolname=\"name\"])[2]")
	public WebElement contactdetailsname;
	
	@FindBy(xpath="(//input[@formcontrolname='email'])[2]")
	public WebElement email;
	@FindBy(xpath="(//input[@formcontrolname='phone'])[2]")
	public WebElement phonenumber;
	@FindBy(xpath="(//input[normalize-space(@formcontrolname)='whatsAppNumber'])[2]")
	public WebElement whatsappnumber;
	@FindBy(xpath="(//input[@name='isPrimary']//parent::span)[2]")
	public WebElement primaryradiobutton;
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='highlight_off'])[1]")
	public WebElement contactdetailscrossbutton;
	@FindBy(xpath="//a[text()='Add New Line']")
	public WebElement addressdetailsaddnewline;
	@FindBy(xpath="(//input[@formcontrolname='address'])[2]")
	public WebElement address;
	@FindBy(xpath="(//input[@formcontrolname='city'])[2]")
	public WebElement city;
	@FindBy(xpath="(//input[@formcontrolname='county'])[2]")
	public WebElement county;
	@FindBy(xpath="(//input[@formcontrolname='postalCode'])[2]")
	public WebElement postcode;
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='highlight_off'])[2]")
	public WebElement addressdetailscrossbutton;
	@FindBy(xpath="//a[text()='Delete Photo']")
	public WebElement deletephoto;
 
	@FindBy(xpath="(//mat-icon[text()='close'])[1]")
	public WebElement searchcrossbutton;
	@FindBy(xpath="//mat-icon[text()='search']")
	public WebElement addnewcustomersearch;
 
	@FindBy(xpath="//div[contains(@class,'side-list')]/a/mat-icon[contains(text(),'add_circle')]")
	public WebElement customeraddbutton;
 
	@FindBy(xpath ="//mat-icon[text()='close']")
	public WebElement addnewcustomercrossbutton;
	@FindBy(xpath="(//input[normalize-space(@type)='checkbox'])[1]//parent::span")
	public WebElement customercheckboxinaddnewcustomer;
	@FindBy(xpath="//a[text()='Cancel']")
	public WebElement cancelrecord;
	@FindBy(xpath="//mat-icon[text()='border_all']")
	public WebElement exportexcel;
	@FindBy(xpath="(//mat-icon[text()='description'])[1]")
	public WebElement exportcsv;
	@FindBy(xpath="//mat-icon[text()='picture_as_pdf']")
	public WebElement exportpdf;
	@FindBy(xpath="//mat-icon[text()='highlight_off']")
	public WebElement cross;
	@FindBy(xpath="//mat-icon[text()='search']")
	public WebElement customersearchbutton;
	@FindBy(xpath="//mat-icon[text()='more_vert']")
	public WebElement actions;
 
	@FindBy(xpath="(//input[normalize-space(@type)='checkbox'])[1]//parent::span")
	public WebElement customeridcheckbox;
	@FindBy(xpath="//mat-icon[text()='border_all']")
	public WebElement exporttoexcel;
	@FindBy(xpath="(//mat-icon[text()='description'])[2]")
	public WebElement exporttocsv;
	@FindBy(xpath="//mat-icon[text()='picture_as_pdf']")
	public WebElement exporttopdf;
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	public WebElement recordcancel;
	@FindBy(xpath="//mat-icon[text()='border_all']")
	public WebElement exportexcelinselecteditem;
	@FindBy(xpath="(//mat-icon[text()='description'])[1]")
	public WebElement exportcsvinselecteditem;
	@FindBy(xpath="//mat-icon[text()='picture_as_pdf']//parent::span")
	public WebElement exportpdfinselecteditem;
	@FindBy(xpath="//table[@aria-describedby='Client List Table']/tbody/tr/td/div/mat-checkbox")
	public WebElement customercheckbox;
	@FindBy(xpath="//p[text()='Archive']//parent::span//parent::button")
	public WebElement selecteditemsarchivebutton;
	@FindBy(xpath="//span[normalize-space()='Yes']//parent::button")
	public WebElement selecteditemsarchiveyesbutton;
	@FindBy(xpath="//span[text()=' No ']")
	public WebElement selecteditemsarchivenobutton;
	@FindBy(xpath="//mat-icon[text()='highlight_off']")
	public WebElement selecteditemcrosssbutton;
	@FindBy(xpath="//mat-icon[text()='keyboard_arrow_down']")
	public WebElement addcustomerarrow;
 
	@FindBy(xpath="(//button[@title='Edit'])[1]")
	public WebElement mousehoveredit;
	@FindBy(xpath="(//mat-icon[normalize-space(text())='delete_outline'])[1]")
	public WebElement mousehoverdelete;
	@FindBy(xpath="//span[text()=' Yes ']")
	public WebElement mousehoverdeleteyesbutton;
	@FindBy(xpath="//span[text()=' No ']")
	public WebElement mousehoverdeletenobutton;
	@FindBy(xpath="(//mat-icon[text()='archive'])[1]")
	public WebElement mousehoverarchive;
	@FindBy(xpath="//mat-select[normalize-space(@panelclass)='pagination']")
	public WebElement selectpaginationdropdown;
	@FindBy(xpath="//span[text()='Next']")
	public WebElement nextpageincustomer;
	@FindBy(xpath="//span[text()='Previous']")
	public WebElement previouspageincustomer;
 
	@FindBy(xpath="//span[text()=' Yes ']")
	public WebElement mousehoverarchiveyesbutton;
	@FindBy(xpath="//span[text()=' No ']")
	public WebElement mousehoverarchivenobutton;
	
	@FindBy(xpath="(//input[normalize-space(@type)='checkbox'])[2]//parent::span")
	public WebElement customercheckboxincustomer;
	
}
