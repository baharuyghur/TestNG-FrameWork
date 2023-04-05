package restAssured_LIST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetListsFromBoard {
	
	String APIKey="dfe98679a9cb422fe637b28b6100f53e";
	String OAuthToken="ATTA5be84d11e7b599f42d7e67271a66ab357143b5506ce95719deaff0768d159e05E8B7906B";
	String BoardID="641cfce7bf691a0a8c6eb390";
	
	@Test
	public void getLists() {
		
		//set the base url
		RestAssured.baseURI = "https://api.trello.com/1/boards";
		//create request object
		RequestSpecification httpRequest=RestAssured.given();	
		
		Response myResponse=httpRequest.get(RestAssured.baseURI+"/"+BoardID+"/lists?key="+APIKey+"&token="+OAuthToken);
		
		System.out.println(myResponse.prettyPrint());
		Assert.assertEquals(myResponse.getStatusCode(), 200);
		
	}

}
