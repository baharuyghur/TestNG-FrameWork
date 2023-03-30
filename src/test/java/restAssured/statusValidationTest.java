package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class statusValidationTest {
	
	String APIKey="dfe98679a9cb422fe637b28b6100f53e";
	String OAuthToken="ATTA5be84d11e7b599f42d7e67271a66ab357143b5506ce95719deaff0768d159e05E8B7906B";
	
	@Test
	public void validate() {
		RequestSpecification httpRequest= RestAssured.given();
		
		httpRequest.param("key", APIKey)
		.param("token", OAuthToken)
		.get("https://api.trello.com/1/members/me/boards")
		.then()
		.statusCode(200)
		.body("name", hasItems("BoardFromAPI"))
		.body("id", hasItems("6424607eb7e02d88ddb61fb4"));
		
		
	}
}