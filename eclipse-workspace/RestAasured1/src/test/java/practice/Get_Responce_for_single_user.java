package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Get_Responce_for_single_user 
{
	@Test
	public void Get_responceForSingleUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response response=given()
				.when()
				.get("/api/users/3")
				.then()
				.extract()
				.response();//PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51
				System.out.println(response.prettyPrint()+  +response.getStatusCode()+	+response.getTime());	
	}
}
		
