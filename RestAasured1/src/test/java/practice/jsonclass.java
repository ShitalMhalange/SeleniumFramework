package practice;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonclass 
{
	@Test
	public void jsonclass_program()
	{
	/*	String json_converted_ToString="{\"dashboard\":{\"purchaseAmount\":910,"
				+ "\"website\":\"www.abc.com\"},"
				+ "\"courses\":[{\"title\":\"SeleniumPython\","
				+ "\"price\":50,"
				+ "\"copies\":6},"
				+ "{\"title\":\"Cypress\","
				+ "\"price\":40,"
				+ "\"copies\":4},"
				+ "{\"title\":\"RPA\","
				+ "\"price\":45,\"copies\":10}]}";
		//int total=0;
		JsonPath json=new JsonPath(json_converted_ToString);
		System.out.println(json);
		Object total;
		for(int i=0;i<json.getInt("courses.size");i++) {
			total=total+(json.getInt("courses["+i+"].price"))*json.getInt("courses["+i+"].copies");
			if((json.getString("courses["+i+"].title")).equals("RPA")) 
			{System.out.println(json.getString("courses["+i+"].copies"));}
			
		System.out.println("courses="+(json.getString("courses["+i+"].title"))+"	"
				+ "price="+(json.getString("courses["+i+"].price")));	
		}
		System.out.println(total);*/
	}
}

