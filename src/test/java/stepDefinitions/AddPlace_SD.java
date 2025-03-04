package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;
import resources.Api_Resources_Enum;
import resources.TestData;
import resources.Utils;

public class AddPlace_SD extends Utils {
	
	TestData testdata=new TestData();
	ResponseSpecification responsebuild;
   RequestSpecification requestsepcification,Deleteplacespecification;
   DeletePlace dp=new DeletePlace();
	String response1;
	
	Response response;
	static String placeid;
	JsonPath js;
	
	/*
	@Given("Add place payload")
	public void add_place_payload() throws IOException {
		//RestAssured.baseURI="https://rahulshettyacademy.com";
 	
		requestsepcification=given().spec(requestbuilder()).body(testdata.AddPlacePayload());
	}
	*/
	@When("User calls {string} with {string} Http request")
	public void user_calls_with_http_request(String resource, String httpmethod) throws IOException {
		Api_Resources_Enum resource1=Api_Resources_Enum.valueOf(resource);
		//Create Request specification for request formation.
		switch (httpmethod)
		{
		case"POST":
		
			response=requestsepcification.when().post(resource1.getresource()).then().extract().response();
			response1=response.asString();
	
			js=new JsonPath(response1);
			break;
			
		case"GET":
			
			response=given().spec(requestbuilder()).queryParams("place_id",placeid).when().get(resource1.getresource()).then().extract().response();
			response1=response.asString();
			
			js=new JsonPath(response1);
			break;
		case"DELETE":
			
			response=requestsepcification.when().post(resource1.getresource()).then().extract().response();
			response1=response.asString();
			
			js=new JsonPath(response1);
			break;
		}
		
	}
	@Then("Status code is {int}")
	public void status_code_is(Integer int1) {
	
		
		responsebuilderforstatuscode(int1);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String element, String value) {
	String actual=js.get(element);
	
	Assert.assertEquals(element, value, actual);
	placeid=js.get("place_id");
	}


@Given("Add place payload with {string} {string} {string}")
public void add_place_payload_with(String name, String address, String language) throws IOException {
	requestsepcification=given().spec(requestbuilder()).body(testdata.AddPlacePayload(name, address, language));
}
@Then("Using placeid verify the {string} is equals to {string}")
public void using_placeid_verify_the_is_equals_to(String element, String expectedvalue) {
	System.out.println(expectedvalue);
	String actualvalue=js.get(element);

	Assert.assertEquals(expectedvalue, actualvalue);
	}
	@Given("Setup Delete Payload") 
	public void setup_delete_payload() throws IOException {
System.out.println(placeid);
dp.setPlace_id(placeid);
requestsepcification=given().spec(requestbuilder()).body(dp);
	}
	
	@Then("Using placeid verify the {string} is equals to message{string}")
	public void using_placeid_verify_the_is_equals_to_message_expectedmsg(String element,String expectedvalue) {
		System.out.println(expectedvalue);
		String actualvalue=js.get(element);

		Assert.assertEquals(expectedvalue, actualvalue);
	}
	

}
