package ApiTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GetRequestAutherization {
	
	@Test
	public void autherizationTest() {
		
		

		//Specify the base uri
		RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//basic Authentication
		PreemptiveBasicAuthScheme  authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setUserName("TestPassword");
		
		RestAssured.authentication =authscheme;
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/");
		
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//Status code validations
		int statusCode= response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode,200);
		
		
		
	}

}
