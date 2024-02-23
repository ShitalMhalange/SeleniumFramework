package practice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class MockServer 
{
@Test
public void MockServer_pro()
{
	HashMap<String,String> Hm1=new HashMap<String, String>();
	Hm1.put("id", "200");
	Hm1.put("type", "grains");
	
	HashMap<String,String> Hm2=new HashMap<String, String>();
	Hm2.put("id", "400");
	Hm2.put("type", "beverage");
	
	List<HashMap<String,String>> jsonobject=new ArrayList<HashMap<String,String>>();
	jsonobject.add(Hm1);
	jsonobject.add(Hm2);
	
	RestAssured.baseURI="https://6235aaff-dae4-49cf-a479-bce2740699b9.mock.pstmn.io";
					given()
					.headers("x-mock-match-request-body","true")
					.headers("Content-Type","application/json")
					.body(jsonobject)
					.log().all()
					.when()
					.post("/postcall")
					.then()
					.log().all();
}
	
}
