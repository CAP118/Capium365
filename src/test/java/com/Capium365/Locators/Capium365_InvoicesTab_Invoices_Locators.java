package com.Capium365.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Capium365_InvoicesTab_Invoices_Locators {

	@FindBy(xpath = "//input[normalize-space(@placeholder)='Search']")
	@CacheLookup
	public WebElement search;
}
