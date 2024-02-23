package practice;

import org.apache.http.util.Asserts;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class deleteWorkspace 
{
 @Test
 public void DeleteWorkSpace()
 {
	 RestAssured.baseURI="https://api.getpostman.com";
	 Response response=given()
			 			.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
			 			.when()
			 			.delete("/workspaces/bf803ba9-7315-4ed6-90da-b3354c96b541")
			 			.then()
			 			.extract()
			 			.response();
	 System.out.println(response.asPrettyString());
	 Assert.assertEquals(200, response.getStatusCode());
 }
 
}
