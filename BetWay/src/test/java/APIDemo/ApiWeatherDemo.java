package APIDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*;

public class ApiWeatherDemo {

@Test
	public void GetWeatherDetails() { 
		
		//specify the base url to the RESTful web serive
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city"; 
		
		//Get the RequestSpecification of the request that you want to send to the server. The server is specified by the BaseUrI that we have specified in the above step
		RequestSpecification httpRequest = RestAssured.given(); 
		
		//Make a request to the server by specifying the method type and method URL. This will return the Response from the server. 
		//Store the response in a variable
		Response response = httpRequest.request(Method.GET,"/Gauteng"); 
		
		//Now let us print the body of the message to see the response we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is => "+ responseBody); 
		
	}
 	@Test
 	public void VerifyCityInJsonResponse() { 
 		
 		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
 		RequestSpecification httpRequest = RestAssured.given(); 
 		Response response = httpRequest.get("/Gauteng"); 
 		
 		//First get the JsonPath object instance from the Response interface 
 		JsonPath jsonPathEvaluator = response.jsonPath(); 
 		
 		//then query the JsonPath object to get a string value of the node.
 		//specified by JsonPath: city
 		String city = jsonPathEvaluator.get("City"); 
 		
 		//Let us print the city variable to see what we got
 		System.out.println("City received from response: " + city);
 		
 		//Validate the response
 		Assert.assertEquals(city, "Gauteng", "Correct city name received in the response");
 	}
 	
 	public class HTTPgetDemo { 
 		
 		@BeforeClass
 		public void setup() { 
 			RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; 
 		}	
 		
 		@Test
 		public void getRequest() { 
 			//The HTTP GET request is used to fetch a resource from a server
 			Response response = given() 
 					.contentType(ContentType.JSON)
 					.when()
 					.get("/posts")
 					.then()
 					.extract().response();
 					
 			Assert.assertEquals(response.statusCode(), 200);
 			Assert.assertEquals(response.jsonPath().getString("title[1]"),"qui est esse"); 
 					
 		}
 	}
 	
		@BeforeClass
		public void setup() { 
			RestAssured.baseURI = "https://bookstore.toolsqa.com/bookstore/v1/books"; 
		}	
		
//to get the JSON path, use jsonpathfinder.com
		@Test
		public void booksTest() { 
			given().
			when().
				get("https://bookstore.toolsqa.com/bookstore/v1/Books").
			then().
				assertThat().
				body("books[0].title",equalTo("Git Pocket Guide"));
		
					
		}
		
		@Test
		public void extractAll() { 
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().	
				statusCode(200); 
		}
		
		@Test
		public void pathTest() { 
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().
				assertThat().
				body("page",equalTo(2));
		}
		
		@Test
		public void testDataIDofData0() { 
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().
				assertThat().
				body("page",equalTo(2),
					"data[0].id", equalTo(7));
		}
		
		@Test
		public void booksTest2() { 
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().
				assertThat().
				body("page",equalTo(2),
					"data[5].first_name", equalTo("Rachel"));
				
		}
		
		@Test
		public void howManyDataElements() { 
			given().when().get("https://reqres.in/api/users?page=2")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()", equalTo(6)); 
		}
		
		@Test
		public void size() { 
			given().when().get("http://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
				.then()
				.assertThat()
				.statusCode(200)
				.body("results.size()", equalTo(100)); 
		}
		//used when testing pagination
		@Test
		public void queryParam() { 
			given().queryParam("limit", "100")
			.queryParam("offset","200")
			.when().get("http://pokeapi.co/api/v2/pokemon").then().log()
			.body();
		}
		
		@Test
		public void givenExample() { 
		given().queryParam("CUSTOMER_ID", "68195")	
		.queryParam("PASSWORD", "1234!")
		.queryParam("Account_No", "1")
		.when().get("http://demo.guru99.com/v4/sinkministatement.php").then().log()
		.body();
		}
		
		private static String requestBody = "{\n" +
		" \"title\": \"foo\", \n" +
		" \"body\": \"bar\", \n" +
		" \"userId\": \"2\" \n}";
		
		@Test
		public void Postrequest() { 
			

			RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; 
			//HTTP post request is used to post data or create a resource on a server
			
			Response response =
				given() 
						.header("Content-type", "application/json")
						.and().body(requestBody)
						.when()
						.post("/posts/103")
						.then().
						
					log().
					all().
					extract().
					response();
			
			Assert.assertEquals(201, response.statusCode());
			Assert.assertEquals("foo", response.jsonPath().getString("title"));
			Assert.assertEquals("bar", response.jsonPath().getString("body"));
			Assert.assertEquals("2", response.jsonPath().getString("userId")); 
			Assert.assertEquals("101", response.jsonPath().getString("id")); 
		}
	}
