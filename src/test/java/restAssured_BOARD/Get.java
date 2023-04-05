package restAssured_BOARD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
public class Get {

		
		@Test
		public void getMethodTest() {
			//set the base url
			RestAssured.baseURI = "https://reqres.in/api/users?page=2";
			//create request object
			RequestSpecification httpRequest=RestAssured.given();
			//create response object 
			Response myResponse=httpRequest.request(Method.GET);
			
			
			//PRINT #1
			System.out.println("This is the PRINT#1 mESSAGE : "+ myResponse.getBody().asString());
			//PRINT#2
			System.out.println("This is the PRINT#2 mESSAGE : "+ myResponse.then().log().all());
		     //PRINT#3
			System.out.println("This is the PRINT#3 mESSAGE : "+myResponse.prettyPrint());
			//validate status code
			System.out.println("status code is: ====" + myResponse.getStatusCode());
			Assert.assertEquals(myResponse.getStatusCode(), 200);

	}


}
