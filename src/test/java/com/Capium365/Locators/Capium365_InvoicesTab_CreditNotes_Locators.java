package com.Capium365.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Capium365_InvoicesTab_CreditNotes_Locators {

	@FindBy(xpath="//mat-icon[normalize-space()='credit_score']")
	@CacheLookup
	public WebElement creditnotescreen;
	
	@FindBy(xpath="//mat-icon[normalize-space()='keyboard_arrow_right']")
	@CacheLookup
	public WebElement expandarrow;
	
	@FindBy(xpath="//span[normalize-space()='Edit Company Details']")
	@CacheLookup
	public WebElement editcompanydetails;
	
	@FindBy(xpath="(//div[normalize-space(@class)='mt-5'])[2]")
	@CacheLookup
	public WebElement manchester;
	
	@FindBy(xpath="//span[normalize-space(text())='Add New Customer']")
	@CacheLookup
	public WebElement addnewcustomer;
	
	@FindBy(xpath="//span[normalize-space()='Upload Credit Notes']")
	@CacheLookup
	public WebElement uploadcreditnotebutton;
	
	@FindBy(xpath="//span[normalize-space()='Choose a File']")
	@CacheLookup
	public WebElement chooseafilebutton;
	
	@FindBy(xpath="(//span[normalize-space()='Upload Credit Notes'])[1]")
	@CacheLookup
	public WebElement uploadcreditnotebutton2;
	
	@FindBy(xpath="(//div[@title='M'][normalize-space()='M'])[1]")
	@CacheLookup
	public WebElement customername;
	
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='more_vert'])[2]")
	@CacheLookup
	public WebElement kebab;
	
	@FindBy(xpath="//button[@title='Preview']")
	@CacheLookup
	public WebElement preview;
	
	@FindBy(xpath="//span[normalize-space()='Preview Invoice Credit Note']")
	@CacheLookup
	public WebElement previecreditnoteele;
	
	@FindBy(xpath="//button[@title='Send']")
	@CacheLookup
	public WebElement sent;
	
	@FindBy(xpath="//span[normalize-space()='Send this Invoice Credit Note']")
	@CacheLookup
	public WebElement sendinvoicecreditnoteele;
	
	@FindBy(xpath="//button[@title='Duplicate']")
	@CacheLookup
	public WebElement duplicate;
	
	@FindBy(xpath="//button[@title='History']")
	@CacheLookup
	public WebElement history;
	
	@FindBy(xpath="//span[normalize-space()='CRN197 History']")
	@CacheLookup
	public WebElement historyele;
	
	@FindBy(xpath="//mat-icon[normalize-space()='close']")
	@CacheLookup
	public WebElement closehistory;
	
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='more_vert'])[1]")
	@CacheLookup
	public WebElement topkebab;
	
	@FindBy(xpath="(//div[@class='mat-ripple mat-menu-ripple'])[1]")
	@CacheLookup
	public WebElement exporttoexcel;
	
	@FindBy(xpath="(//div[@class='mat-ripple mat-menu-ripple'])[2]")
	@CacheLookup
	public WebElement exporttocsv;
	
	@FindBy(xpath="(//div[@class='mat-ripple mat-menu-ripple'])[3]")
	@CacheLookup
	public WebElement exporttopdf;
	
	@FindBy(xpath="(//mat-form-field[normalize-space(@appearance)='fill'])[5]")
	@CacheLookup
	public WebElement secondaddeditem;
	
	@FindBy(xpath="//h2[normalize-space()='sriram']")
	@CacheLookup
	public WebElement customersettings;
	
	@FindBy(xpath="(//th[@style='top: 0px; z-index: 100;'])[1]")
	@CacheLookup
	public WebElement radiobutton;
	
	
	@FindBy(xpath="//mat-icon[normalize-space(text())='highlight_off']")
	@CacheLookup
	public WebElement crossmark;
	
	@FindBy(xpath="//input[@type='number']")
	@CacheLookup
	public WebElement gotoTF;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper' and text()= ' 2 ']")
	@CacheLookup
	public WebElement twohighlightgotoTF;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper' and text()= ' 3 ']")
	@CacheLookup
	public WebElement threehighlightgotoTF;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper' and text()= ' 4 ']")
	@CacheLookup
	public WebElement fourhighlightgotoTF;
}
