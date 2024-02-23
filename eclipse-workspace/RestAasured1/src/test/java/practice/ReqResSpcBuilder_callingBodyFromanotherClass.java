package practice;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ReqResSpcBuilder_callingBodyFromanotherClass 
{
	@BeforeClass
	public void ReqResbuilder()
	{
		RequestSpecBuilder ReqspcBuil=new RequestSpecBuilder();
				ReqspcBuil.setBaseUri("https://api.getpostman.com");
				ReqspcBuil.log(LogDetail.ALL);
		requestSpecification=ReqspcBuil.build();
		
		ResponseSpecBuilder ResponBuil=new ResponseSpecBuilder();
				ResponBuil.expectStatusCode(200);
				ResponBuil.expectContentType(ContentType.JSON);
				ResponBuil.log(LogDetail.ALL);
		responseSpecification=ResponBuil.build();	
	}
	String idvalue;
	String idvalue1;
	@Test(priority=1)
	public void createUser()
	{
		Response response=given()
						.spec(requestSpecification)
						.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
						.body(SeprateBodyClass.body())
						.when()
						.post("/workspaces")
						.then()
						.spec(responseSpecification)
						.extract()
						.response();
		JsonPath js=response.jsonPath();
	
		idvalue=js.getString("workspace.id");
		System.out.println("Id value is : "+idvalue);
	}
	
	@Test(priority=2)
	public void getuserdetails()
	{
		Response response1=given()
				.spec(requestSpecification)
				.header("x-api-key","PMAK-65b6040d566dd70001896534-dccee74a4c8dd8c3784d3f15de37eb8c51")
				.pathParam("id",idvalue)
				.when()
				.get("/workspaces/{id}")
				.then()
				.spec(responseSpecification)
				.extract()
				.response();
		JsonPath js1=response1.jsonPath();
		idvalue1=js1.getString("workspace.id");
		System.out.println("Id1 value is : "+idvalue1);
		Assert.assertEquals(idvalue,idvalue1);
		
	}
	
	
	
	
	
}
