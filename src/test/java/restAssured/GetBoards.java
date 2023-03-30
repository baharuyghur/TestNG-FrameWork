package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBoards {
	
	String APIKey="dfe98679a9cb422fe637b28b6100f53e";
	String OAuthToken="ATTA5be84d11e7b599f42d7e67271a66ab357143b5506ce95719deaff0768d159e05E8B7906B";
	
	@Test
	public void getBoards() {
		
		//set the base url
		RestAssured.baseURI = "https://api.trello.com/1/members/me/boards";
		//create request object
		RequestSpecification httpRequest=RestAssured.given();	
		
		Response myResponse=httpRequest.get(RestAssured.baseURI+"?key="+APIKey+"&token="+OAuthToken);
		
		System.out.println(myResponse.prettyPrint());
		Assert.assertEquals(myResponse.getStatusCode(), 200);
		
	}

}
