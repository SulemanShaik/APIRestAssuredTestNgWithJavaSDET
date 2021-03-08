package ApiTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PostRequest {
	
	@Test
	void getweatherDetails() {
		
		//Specify the base uri
		RestAssured.baseURI="";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending with post request
		JSONObject requestParams= new JSONObject ();
		requestParams.put("FirstName", "Millerxyz");
		requestParams.put("LirstName", "Millerxyze");
		requestParams.put("UserName", "Millerxyzere");
		requestParams.put("Password", "Millerxyeez");
		requestParams.put("Email", "Millerxyz@gmail.com");
		
		httpRequest.header("Content-Type", "application/Json");
		httpRequest.body( requestParams.toJSONString());   //attach above data to the request
		
		//Response object
		Response response=httpRequest.request(Method.POST,"/register");
		
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//Status code validations
		int statusCode= response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode,201);
		
		//success code validation
		String successCode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION-SUCCESS");
		
		
	}
}
