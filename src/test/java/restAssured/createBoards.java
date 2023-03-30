package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createBoards {
	
	
	
	String APIKey="dfe98679a9cb422fe637b28b6100f53e";
	String OAuthToken="ATTA5be84d11e7b599f42d7e67271a66ab357143b5506ce95719deaff0768d159e05E8B7906B";
	String boardName="restAssuredBoard";
	
	@Test
	public void createBoard() {
		//set the base url
				RestAssured.baseURI = "https://api.trello.com/1/boards";
				//create request object
				RequestSpecification httpRequest=RestAssured.given();	
				httpRequest.header("Content-Type","application/json");
				
				Response myResponse=httpRequest.post(RestAssured.baseURI+"/?name="+boardName+"&key="+APIKey+"&token="+OAuthToken);
			
				int statusCode=myResponse.getStatusCode();
				Assert.assertEquals(statusCode,200);
				
				
				System.out.println("test passed and board created with status code- "+statusCode);
		
	}

}
