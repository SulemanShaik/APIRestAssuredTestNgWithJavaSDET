
  package datadriventesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddnewEmployee {
  
	//passing the hard coded data values
	/*
	 * @Test void postNewEmployees() {
	 * 
	 * //Specify the base uri
	 * RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	 * 
	 * RequestSpecification httpRequest=RestAssured.given();
	 * 
	 * //Here we created data which we can send along with the post request
	 * JSONObject requestParams = new JSONObject();
	 * 
	 * requestParams.put("name", "sam123"); requestParams.put("salary", "30000");
	 * requestParams.put("age", "25");
	 * 
	 * //Addd a header starting the request body is a JSON
	 * httpRequest.header("Content-Type","application/json");
	 * 
	 * //Add the Json to the body of the request
	 * httpRequest.body(requestParams.toJSONString());
	 * 
	 * //POST Request Response response=httpRequest.request(Method.POST,"/create");
	 * 
	 * //capture response body to perform validations String
	 * responseBody=response.getBody().asString();
	 * Assert.assertEquals(responseBody.contains("sam123"), true);
	 * Assert.assertEquals(responseBody.contains("30000"), true);
	 * Assert.assertEquals(responseBody.contains("25"), true);
	 * 
	 * int statuscode=response.getStatusCode(); Assert.assertEquals(statuscode,
	 * 200); }
	 */
	
	//passing the mutiple values
	@Test(dataProvider="empdataprovider")
	  void postNewEmployees(String ename, String eage, String esal) {
		  
			//Specify the base uri
				RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
				
				RequestSpecification httpRequest=RestAssured.given();
				
				//Here we created data which we can send along with the post request
				JSONObject requestParams = new JSONObject();
				
				requestParams.put("name", "ename");
				requestParams.put("salary", "eage");
				requestParams.put("age", "esal");
				
				//Addd a header starting the request body is a JSON
				httpRequest.header("Content-Type","application/json");
				
			  //Add the Json to the body of the request
				httpRequest.body(requestParams.toJSONString());
				
				//POST Request
				Response response=httpRequest.request(Method.POST,"/create");
				
				//capture response body to perform validations
				String responseBody=response.getBody().asString();
				
				System.out.println("Response body is :"+responseBody);
				 Assert.assertEquals(responseBody.contains("ename"), true);
				 Assert.assertEquals(responseBody.contains("eage"), true);
				 Assert.assertEquals(responseBody.contains("esal"), true);
				 
				 int statuscode=response.getStatusCode();
				 Assert.assertEquals(statuscode, 200);
		  }
		  
		  
	  
	  
	  @DataProvider(name="empdataprovider") 
        String [][] getEmpData() throws IOException{
		 //Read data from excel 
		//String  path=System.getProperty("user.dir")+"src/test/java/datadriventesting/DataDrivenEmpDataforRestAssured.xlsx";
    	String path="C:\\Users\\ASIF SHAIK\\Desktop\\Suleman\\RestAssuredAPITestingJavawithTestNG_SDET\\src\\test\\java\\datadriventesting\\DataDrivenEmpDataforRestAssured.xlsx";
		  int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		//String empdata[][]= { {"abc123","30000","40"},{"xyz123","40000","50"},{"abcd123","60000","60"}};
       
		String empdata[][]= new String [rownum][colcount];
		//1st loop for will increment the rows
				//2nd loop for will increment the columns
		for(int i= 1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return(empdata);
    }
  
  }
