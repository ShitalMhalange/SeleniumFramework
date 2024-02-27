package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Get_Responce_1 {

	@Test
	public void GetUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		Response responce= given()
							.when()
							.log()
							.all()
							.get("/api/users?page=2")
							.then()
							//.log().all()
							.extract()
							.response();
		Headers header=responce.headers();
		System.out.println(header.get("Age"));
		/*String string_response=responce.asPrettyString();
		System.out.println(string_response);*/
	}

}
