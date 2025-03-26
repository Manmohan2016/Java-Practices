import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.http.ContentType;

public class FirstTest {

	public static void main(String[] args) {
		String req= "{ \"email\": \"manmohan.tutree@gmail.com\"}";
		
		Response res= given()
				      .contentType(ContentType.JSON)
				      .body(req)
				      .post("https://apilive.deenbytes.com/api/User/userSignUp");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.asPrettyString());
		
		
		
		

	}

}
