package restAssured_LIST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createANewList {
	
	
	
	String APIKey="dfe98679a9cb422fe637b28b6100f53e";
	String OAuthToken="ATTA5be84d11e7b599f42d7e67271a66ab357143b5506ce95719deaff0768d159e05E8B7906B";
	String BoardId="641c70058290bdeebca19b95";
	String newListName="New List ";
	
	@Test
	public void createANewList() {
		//set the base url
				RestAssured.baseURI = "https://api.trello.com/1";
				//create request object
				RequestSpecification httpRequest=RestAssured.given();	
				httpRequest.header("Content-Type","application/json");
				
				Response myResponse=httpRequest.post(RestAssured.baseURI+"/lists?name="+newListName+"&idBoard="+BoardId+"&key="+APIKey+"&token="+OAuthToken);
			
				int statusCode=myResponse.getStatusCode();
				Assert.assertEquals(statusCode,200);
				
				
				System.out.println("test passed and a new list is created with status code- "+statusCode);
				
				
		
	}

}
