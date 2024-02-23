package practice;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class FileUploadByusingRestassured 
{
@Test
public void  FileUpload()
{
	String path=System.getProperty("user.dir")+"\\src\\resources\\download (1).jpg";
	File image=new File(path);
	RestAssured.baseURI="https://the-internet.herokuapp.com";
	given()
	.multiPart("file", image)
	.log().all()
	.when()
	.post("/upload")
	.then()
	.log().all();
}
}



