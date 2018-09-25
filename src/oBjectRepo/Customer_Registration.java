package oBjectRepo;

import org.openqa.selenium.By;

public class Customer_Registration
{
	public By Customer_registration_title = By.xpath("//div[@class='page-title']");
	public By Customer_male = By.xpath("//input[@id='gender-male']");
	public By Customer_fname = By.id("FirstName");
	public By Customer_lname = By.id("LastName");
	public By Customer_phone = By.id("PhoneNumber");
	public By Customer_dob_dd = By.name("DateOfBirthDay");
	public By Customer_dob_mm = By.name("DateOfBirthMonth");
	public By Customer_dob_yyyy = By.name("DateOfBirthYear");
	public By Customer_email = By.id("Email");

}
