package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Header_Method 
{
	@Test
	public void Header_method()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		Response response=given()
						  .header("x-api-key", "PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
						  .when()
						  .get("/workspaces")
						  .then()
						  .extract()
						  .response();
		JsonPath json=new JsonPath(response.asPrettyString());
		System.out.println(json.get("workspaces.name"));
//		System.out.println(response.asPrettyString());
//		System.out.println(response.statusCode());
	}
}
