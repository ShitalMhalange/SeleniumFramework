package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import static io.restassured.RestAssured.*;

public class assert_API 
{
	@Test
	public void assert_pro()
	{
		RestAssured.baseURI="https://reqres.in";
		
						given()
						.queryParam("page", "2")
						.queryParam("line","6")
						.when()
						.get("/api/users") //io.restassured.path.json.JsonPath@337d0578
						.then()
						//.log().all()
						//.assertThat()
						.log().all();
						//.body("data.last_name",hasItem("Edwards"));
	
	}
}