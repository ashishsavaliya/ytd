package tEstCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import uTilities.TestBase;

public class TC_01_Homepage extends TestBase
{
	@Parameters({ "projectURL" })
	@Test(priority = 1)
	public void TC01(String projectURL)
	{
		String Exp_Title = "Welcome, Please Sign Up!";
		objSeleutils.openURL(projectURL);
		objSeleutils.click(objHomepage.registration);

		String text_message = objSeleutils.getText(objHomepage.homepage_title);

		objSeleutils.pageVerify(text_message, Exp_Title, "Title does not match");
		objSeleutils.click(objHomepage.btn_customer_register);

		objSeleutils.implicitWait();

	}

	@Test(priority = 2)
	public void TC02() throws Exception
	{
		String Exp_Title = "Customer Registration";
		String Customer_title_message = objSeleutils.getText(objCust_Registration.Customer_registration_title);
		System.out.println(Customer_title_message);
		objSeleutils.pageVerify(Customer_title_message, Exp_Title, "Title does not match");

		objSeleutils.click(objCust_Registration.Customer_male);
		objSeleutils.entertext(objCust_Registration.Customer_fname, "Nielsh");
		objSeleutils.entertext(objCust_Registration.Customer_lname, "Patel");
		objSeleutils.entertext(objCust_Registration.Customer_phone, "9876543210");

		objSeleutils.dateofbirth(objCust_Registration.Customer_dob_dd, "20", null, 0);
		objSeleutils.dateofbirth(objCust_Registration.Customer_dob_mm, null, "December", 0);
		objSeleutils.dateofbirth(objCust_Registration.Customer_dob_yyyy, null, null, 1);

		String email1 = objExcelUtils.ReadExcel("Customer_Registation", 0, 0);
		String email2 = objExcelUtils.ReadExcel("Customer_Registation", 0, 1);
		System.out.println("name" + email1 + "Last name" + email2);
		String email_enter = (email1 + email2 + "@malinator.com");

		objExcelUtils.WriteExcel("Customer_Registration", 0, 6, email_enter);

		// objSeleutils.entertext(objCust_Registration.Customer_email, );

	}
}
