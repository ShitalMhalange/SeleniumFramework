package api_endpoints;



import static io.restassured.RestAssured.*;

import api_payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints 
{
	
	public static Response createUser(UserPayload payload)
	{
		Response Response=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
							.when()
							.post(Routes.post_url);
		return Response;
	}
	public static Response Readuser(String uname)
	{
		Response Response=given()
							.pathParam("username",uname)
							.when()
							.get(Routes.get_url);
		return Response;
	}
	public static Response UpdateUser(String username,UserPayload payload)
	{
		Response Response=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.pathParam("username", username)
							.body(payload)
							.when()
							.put(Routes.update_url);
		return Response;
	}
	public static Response deleteuser(String uname)
	{
		Response Response=given()
							.pathParam("username",uname)
							.when()
							.delete(Routes.delete_url);
		return Response;
	}
}
