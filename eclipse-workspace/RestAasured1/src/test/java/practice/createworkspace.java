package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class createworkspace 
{
	@Test
	public void Create_workspace()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		Response response=given()
						 // .body("{\"workspace\":{\"name\":\"Shital5\",\"type\":\"personal\",\"description\":null}}")
						  .header("x-api-key", "PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
						  .when()
						  .get("/workspaces")
						  .then()
						  .extract()
						  .response();
		System.out.println(response.getStatusCode()+"++++++++++"+response.asPrettyString());
		
		
	}
}
