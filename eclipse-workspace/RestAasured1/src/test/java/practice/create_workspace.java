package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class create_workspace 
{
@Test
public void createWorkspace()
{
	RestAssured.baseURI="https://reqres.in/";
	Response responce=given()
			//.body("{\"workspace\":{\"name\":\"shital18\",\"type\":\"personal\",\"description\":null}}")
			//.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
			.when()
			.get("/api/users?page=2")
			.then()
			.extract()
			.response();
	System.out.println(responce.getStatusCode());
	System.out.println(responce.asPrettyString());
	JsonPath js=responce.jsonPath();
	System.out.println(js.getInt("total"));
	for(int i=0;i<6;i++)
	{
	System.out.println(js.get("data["+i+"].email"));
	}
}
}
