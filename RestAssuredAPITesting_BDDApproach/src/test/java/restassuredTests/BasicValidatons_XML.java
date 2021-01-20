package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidatons_XML
{

	/*1) Verifying Single Content in XML Response
	2) Verifying Multiple Contents in XML Response
	3) Verifying all the Content in XML Response in one go
	4) XPath with text() function
    5) Find values using XML path in XML Response*/

	
	// Verifying Single Content in XML Response
	
	
	
	@Test(priority=1)
	void testSingleContent()
    { 
		given()
		 .when()
		       .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		 .then()
		 .body("CUSTOMER.ID", equalTo("15"))
		 .log().all();
	}
	
	
	//Verifying Multiple Contents in XML Response
	
	@Test(priority=2)
	void testMultipleContent()
    { 
		given()
		 .when()
		       .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		 .then()
		 .body("CUSTOMER.ID", equalTo("15"))
		 .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		 .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		 .body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		 .body("CUSTOMER.CITY", equalTo("Seattle"));
		
	}
	
	//Verifying all the Content in XML Response in one go
	
	@Test(priority=3)
	void testMultipleContentINOneGo()
	{
		given()
		.when()
		    .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		
		.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	
	//Find values using XML path in XML Response
	
	
	@Test(priority=4)
	void testUsingXPath1()
	{
		given()
		.when()
		    .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
	}
	
	@Test(priority=5)
	void testUsingXpath2()
	{
		given()
		.when()
		    .get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
		    .body(hasXPath("/INVOICEList/INVOICE[text()='28']"))
		    .log().all();
	}
}
