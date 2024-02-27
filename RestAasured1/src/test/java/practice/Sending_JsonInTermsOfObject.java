package practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Sending_JsonInTermsOfObject {
@Test
public void createUser()
{
	HashMap<String, String> innerMap=new HashMap<String, String>();
	innerMap.put("name","Sharvari");
	innerMap.put("type","personal");
	innerMap.put("description","null");
	HashMap<String,HashMap<String,String>> Map=new HashMap<String,HashMap<String,String>>();
	
	Map.put("workspace",innerMap);
	
	RestAssured.baseURI="https://api.getpostman.com";
	Response response=given()
					.body(Map)
					.headers("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
					.when()
					.post("/workspaces")
					.then()
				//	.assertThat()
				//	.statusCode(200)
					.log().all()
					.extract()
					.response();
	System.out.println(response.asPrettyString());
					
					
	
	
}

}
