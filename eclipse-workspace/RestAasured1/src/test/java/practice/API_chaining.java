package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class API_chaining 
{
	String idvalue; 
	
	@Test(priority=1)
	public void ApiChaning()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		Response response=given()
						.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
						.body("{\r\n" + 
								"    \"workspace\": {\r\n" + 
								"        \"name\": \"Avinash_Landge \",\r\n" + 
								"        \"type\": \"personal\",\r\n" + 
								"        \"description\": null\r\n" + 
								"    }\r\n" + 
								"}")
						.log()
						.all()
						.when()
						.post("/workspaces")
						.then()
						.log()
						.all()
						.extract()
						.response();
		JsonPath json=response.jsonPath();
		idvalue=json.getString("workspace.id");
		System.out.println(idvalue);
	}
	@Test(priority=2)
	public void getworkspaceDetail()
	{
		RestAssured.baseURI="https://api.getpostman.com";
				Response responce = given()
							.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
							.pathParam("id", idvalue)
							.when()
							.get("/workspaces/{id}")
							.then()
							.extract()
							.response();
				JsonPath js=responce.jsonPath();
				System.out.println(idvalue);
				System.out.println(js.getString("workspace.id"));
				Assert.assertEquals(idvalue, js.getString("workspace.id"));
			
	
	}
	

}
