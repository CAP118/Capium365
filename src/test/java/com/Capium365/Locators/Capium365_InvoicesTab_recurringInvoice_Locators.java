package com.Capium365.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Capium365_InvoicesTab_recurringInvoice_Locators {

	@FindBy(xpath = "//span[normalize-space()='Invoices']//parent::a")
	public WebElement invoicestab;
	
	@FindBy(xpath = "//mat-icon[text()='keyboard_arrow_right']")
	public WebElement arrowbutton;
	
	@FindBy(xpath = "//mat-icon[text()='library_books']")
	public WebElement recurringinvoicetab;
	
	@FindBy(xpath = "//span[normalize-space()='Add Recurring Invoice']/ancestor::button")
	public WebElement addrecurringinvoicebutton;
	
	@FindBy(xpath = "//mat-icon[normalize-space()='edit']")
	public WebElement editbuttonincompanydetails;
	
	@FindBy(xpath = "//input[normalize-space(@formcontrolname)='address1']")
	public WebElement addressincompanydetails;
	
	@FindBy(xpath = "//input[normalize-space(@formcontrolname)='postalCode']")
	public WebElement postalcodeincompanydetails;
	
	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[2]//parent::button")
	public WebElement cancelbuttonincompanydetails;
	
	@FindBy(xpath = "//span[normalize-space()='add_circle']")
	public WebElement customernameaddbutton;
	
	@FindBy(xpath ="//input[normalize-space(@formcontrolname)='fullName']")
	public WebElement fullnameincustomer;
	
	@FindBy(xpath ="//input[normalize-space(@formcontrolname)='email']")
	public WebElement emailincustomer;
	
	@FindBy(xpath ="//input[@formcontrolname='phone']")
	public WebElement phonenumberincustomer;
	
	@FindBy(xpath ="(//input[@formcontrolname='whatsAppNumber'])[1]")
	public WebElement whatappnumberincustomer;
	
	@FindBy(xpath ="//input[@formcontrolname='address']")
	public WebElement addressincustomer;
	
	@FindBy(xpath ="//input[@formcontrolname='city']")
	public WebElement cityincustomer;
	
	@FindBy(xpath ="//input[@formcontrolname='county']")
	public WebElement countyincustomer;
	
	@FindBy(xpath ="//input[@formcontrolname='postalCode']")
	public WebElement postalcodeincustomer;
	
	@FindBy(xpath ="(//input[normalize-space(@formcontrolname)='name'])[2]")
	public WebElement fullnameincustomeraddnewline;
	
	@FindBy(xpath ="(//input[normalize-space(@formcontrolname)='email'])[2]")
	public WebElement emailincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='phone'])[2]")
	public WebElement phonenumberincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='whatsAppNumber'])[2]")
	public WebElement whatsappnumberincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='address'])[2]")
	public WebElement addressincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='city'])[2]")
	public WebElement cityincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='county'])[2]")
	public WebElement countyincustomeraddnewline;
	
	@FindBy(xpath ="(//input[@formcontrolname='postalCode'])[2]")
	public WebElement postalcodeincustomeraddnewline;
	
	@FindBy(xpath = "(//span[normalize-space(@class)='mat-button-wrapper'])[16]")
	public WebElement savebuttoninaddnewcustomer;
	
	@FindBy(xpath = "(//span[normalize-space()='Cancel Changes'])[2]")
	public WebElement cancelchangesinaddnewcustomer;
	
	@FindBy(xpath ="//a[normalize-space()='Add New line']")
	public WebElement addnewlineincontactdetails;
	
	@FindBy(xpath ="(//mat-icon[normalize-space()='highlight_off'])[1]")
	public WebElement addnewlinecrossbuttonincontactdetails;
	
	@FindBy(xpath ="//a[normalize-space()='Add New Line']")
	public WebElement addnewlineinaddressdetails;
	
	@FindBy(xpath ="(//mat-icon[normalize-space()='highlight_off'])[2]")
	public WebElement addnewlinecrossbuttoninaddressdetails;
	
	@FindBy(xpath ="(//input[normalize-space(@formcontrolname)='accountName'])[7]")
	public WebElement accountnameinpaymentdetails;
	
	@FindBy(xpath ="(//input[normalize-space(@formcontrolname)='accountNumber'])[7]")
	public WebElement accountnumberinpaymentdetails;
	
	@FindBy(xpath ="(//input[normalize-space(@formcontrolname)='branchCode'])[7]")
	public WebElement branchcodeinpaymentdetails;
	
	@FindBy(xpath ="//mat-icon[normalize-space(text())='search']")
	public WebElement recurringinvoicesearch;
 
}
