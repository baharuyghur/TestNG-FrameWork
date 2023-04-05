package restAssured_BOARD;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHeaders {
	@Test
	public void testingHeaders() {
		
	//set the base url
	RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	//create request object
	RequestSpecification httpRequest=RestAssured.given();
	//create response object 
	Response myResponse=httpRequest.request(Method.GET);
	
	
	System.out.println("header content type: "+myResponse.getHeader("Content-Type"));

	
    Headers allHeaders=myResponse.getHeaders();
    for(Header eachHeader:allHeaders) {
    	System.out.println(eachHeader.getName()+ "=========="+ eachHeader.getValue());
    }
}
}