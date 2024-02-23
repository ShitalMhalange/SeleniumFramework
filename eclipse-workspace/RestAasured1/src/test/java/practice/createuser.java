package practice;

import org.testng.annotations.Test;

public class createuser 
{
@Test(priority = 1)
public void createanUser()
{
	pojoclass pj=new pojoclass();
	pj.setId(0);
	pj.setUsername("ATTSerialization");
	pj.setFirstName("Serialization");
	pj.setLastName("Deserialization");
	pj.setEmail("att@att.com");
	pj.setPassword("Test@1234");
	pj.setPhone("9876543210");
	pj.setUserStatus(0);

}
}
