package api_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api_endpoints.UserEndPoints;
import api_payload.UserPayload;
import io.restassured.response.Response;


public class UserTest1
{	
	Faker faker;
	UserPayload userpayload;
	
	@BeforeClass
	public void setupData()
	{
		 faker=new Faker();
		 userpayload=new UserPayload();
		 userpayload.setId(12);
		 userpayload.setUsername("shitalMhalange");
		 userpayload.setFirstName("shital");
		 userpayload.setLastName("Mhalange");
		 userpayload.setEmail("mhalange1912@gmail.com");
		 userpayload.setPassword("jfj15435");
		 userpayload.setPhone("632548925");
		 
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		System.out.println(userpayload+"====");
	Response response=UserEndPoints.createUser(userpayload);
	
	response.then().log().all();
	Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		Response response=UserEndPoints.Readuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		 userpayload.setFirstName("shitalMHalange");
		 userpayload.setLastName("MHalange");
		 userpayload.setEmail("avinash");
		 
	Response response=UserEndPoints.UpdateUser(this.userpayload.getUsername(),userpayload);
	response.then().log().all();
	System.out.println(this.userpayload.getUsername()+userpayload.getFirstName()+userpayload.getEmail());
	System.out.println(response.statusCode());
	Assert.assertEquals(response.statusCode(),200);
	
	Response responseAfterUpdate=UserEndPoints.Readuser(this.userpayload.getUsername());
	Assert.assertEquals(response.statusCode(), 200); 	
	}
	
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		Response response=UserEndPoints.deleteuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}

}
