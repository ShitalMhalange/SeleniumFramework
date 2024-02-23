package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class JSONforpostrequestmocking_coplexJson 
{
@Test
public void coplexjson_mock()
{
	List<Integer> ArrayofId=new ArrayList<Integer>();
	ArrayofId.add(5);
	ArrayofId.add(9);
	
	HashMap<String,Object> BatterMap1=new HashMap<String,Object>();
	BatterMap1.put("id", "1001");
	BatterMap1.put("type", "Regular");
	
	HashMap<String,Object> BatterMap2=new HashMap<String,Object>();
	BatterMap2.put("id", ArrayofId);
	BatterMap2.put("type", "Chocolate");
	
	List<HashMap<String, Object>> BatterList=new ArrayList<HashMap<String, Object>>();
	BatterList.add(BatterMap1);
	BatterList.add(BatterMap2);
	
	HashMap<String, List<HashMap<String, Object>>>  BattersLIst=new HashMap<String, List<HashMap<String, Object>>>();
	BattersLIst.put("batter", BatterList);
	
	HashMap<String,Object> topping1=new HashMap<String,Object>();
	topping1.put("id", "5001");
	topping1.put("type", "None");
	
	HashMap<String,Object> topping2=new HashMap<String,Object>();
	topping1.put("id", "5002");
	topping1.put("type", "Glazed");
	
	HashMap<String,Object> topping3=new HashMap<String,Object>();
	topping1.put("id", "5005");
	topping1.put("type", "Sugar");
	
	List<HashMap<String, Object>> toppingsList=new ArrayList<HashMap<String, Object>>();
	toppingsList.add(topping1);
	toppingsList.add(topping2);
	toppingsList.add(topping3);
	
	HashMap<String,Object> json=new HashMap<String,Object>();
	//LinkedHashMap<String,Object> json=new LinkedHashMap<String, Object>();
	  json.put("id", "0001");
	  json.put("type", "donut");
	  json.put("name", "Cake");
	  json.put("name", "Cake");
	  json.put("ppu", 0.55);
	  json.put("batters",BatterList);
	  json.put("topping", toppingsList);
	  
	  RestAssured.baseURI="https://6235aaff-dae4-49cf-a479-bce2740699b9.mock.pstmn.io";
		given()
		.headers("x-mock-match-request-body","true")
		.headers("Content-Type","application/json")
		.body(json)
		.log().all()
		.when()
		.post("/postcall")
		.then()
		.log().all();
}
}
