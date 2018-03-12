package com.api.tests.module1;

import static org.hamcrest.Matchers.containsString;
import org.hamcrest.*;
import org.testng.annotations.Test;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.*;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module1Test {
  
	
  public void Test1() {
		
		given().get("http://services.groupkt.com/country/get/all").then().statusCode(200).log().all();
		//given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name*.length().sum()", Matchers.greaterThan(5000));
		//given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name*.length().sum()", Matchers.greaterThan(50));
		//given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name", Matchers.hasItem("Afaghanistan"));
  }

  
public void Test2() {
		
		// given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name[0]",Matchers.equalTo("Afghanistan"));
		// given().get("http://services.groupkt.com/country/get/all").then().root("RestResponse.result").body("name[0]",Matchers.equalTo("Afghanistan"));
		given().get("http://services.groupkt.com/country/get/all").then().root("RestResponse.result").body("name[0]",Matchers.equalTo("Afghanistan")).detachRoot("result").body("result.name[0]", Matchers.equalTo("Afghanistan"));
		System.out.println(get("http://services.groupkt.com/country/get/all").toString().length());
}


public void Test3() {
		
		given().param("param", "param1").header("header","header1").when().
		post("http://services.groupkt.com/country/get/all")
		.then().statusCode(401).log().all();
}


public void Test4() {
		
		//given().get("http://services.groupkt.com/country/get/all").then().log().all();
		HashMap str = given().get("http://services.groupkt.com/country/get/all").then().extract().path(DEFAULT_PATH, "name[1]");
		
		System.out.println("Extracted Value is " + str.get("RestResponse"));
}


public void Test5() {
	
	//given().get("http://services.groupkt.com/country/get/all").then().log().all();
	Response response =  given().get("http://services.groupkt.com/country/get/all").then().extract().response();
	
	System.out.println("Status Code is " + response.getStatusCode());
}


public void Test6() {
	
	//given().get("http://services.groupkt.com/country/get/all").then().log().all();
	String response =  given().get("http://services.groupkt.com/country/get/all").then().extract().response().asString();
	List<String> ls = from(response).getList("RestResponse.result.findAll {it.name.length() > 50 }.name");
	System.out.println(ls);
	List<String> value = from(response).getList("RestResponse.result.name");
	System.out.println(value.size());
}


public void Test7() {
	
	//given().get("http://services.groupkt.com/country/get/all").then().log().all();
	String response =  given().get("http://services.groupkt.com/country/get/all").then().extract().response().asString();
	JsonPath jsonpath = new JsonPath(response).setRoot("RestResponse.result");
	List<String> value = jsonpath.get("name");
	System.out.println(value.size());
}


public void Test8() {
	Response response =  given().get("http://services.groupkt.com/country/get/all");
	System.out.println(response.getHeader("Connection"));
	
	for(Header header:response.getHeaders()){
		System.out.println(header.getName() + "    " + header.getValue());
	}
}
	
	public void Test9() {
		Response response =  given().get("http://services.groupkt.com/country/get/all");
		
		Map<String, String> cookies = response.getCookies();
		for(Map.Entry<String, String> entry : cookies.entrySet()){
			System.out.println(entry.getKey() + "    " + entry.getValue());
		}
		
		Cookies Dcookies = response.getDetailedCookies();
		for(Cookie Dcookie : Dcookies){
			System.out.println(Dcookie.hasExpiryDate());
		}
	}

	
	public void Test10() {
		when().request("CONNECT","http://services.groupkt.com/country/get/all").then().statusCode(400);
	}
	
	
	public void Test11() {
		given().queryParam("A", "arg1").when().get("http://services.groupkt.com/country/get/all").
		then().statusCode(200);
	}
	
	
	public void Test12() {
		given().formParam("A", "arg1").when().post("http://services.groupkt.com/country/get/all").
		then().statusCode(200);
	}
	
	
	public void Test13() {
		given().param("A", "arg1").when().get("http://services.groupkt.com/country/get/all").
		then().statusCode(200);
	}
	
	
	public void Test14() {
		given().param("A", "arg1").when().post("http://services.groupkt.com/country/get/all").
		then().statusCode(200);
	}
	
	
	public void Test15() {
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		given().param("A", list).when().post("http://services.groupkt.com/country/get/all").
		then().statusCode(200);
	}
	
	public void Test16() {
		given().pathParam("key1", "value1").pathParam("key2", "value2").
		when().post("http://services.groupkt.com/{key1}/{key2}/all").
		then().statusCode(200);
	}
	
	
	public void Test17() {
		given().cookie("key1", "value1").
		when().get("http://services.groupkt.com/{key1}/{key2}/all").
		then().statusCode(200);
		
		given().cookie("key1", "value1", "value");
		Cookie cookie1 = new Cookie.Builder("key1", "value1").setSecured(true).setComment("comment").build();
		Cookie cookie2 = new Cookie.Builder("key2", "value2").setSecured(true).setComment("comment").build();
		
		Cookies cookies = new Cookies(cookie1, cookie2);
		given().cookies(cookies).
		when().get("http://services.groupkt.com/{key1}/{key2}/all").
		then().statusCode(200);
	}
	
	
	public void Test18() {
		given().pathParam("key1", "value1").pathParam("key2", "value2").
		when().get("http://services.groupkt.com/{key1}/{key2}/all").
		then().assertThat().statusCode(400);
		
		given().pathParam("key1", "value1").pathParam("key2", "value2").
		when().get("http://services.groupkt.com/{key1}/{key2}/all").
		then().assertThat().statusLine("HTTP/1.2");
		
		given().pathParam("key1", "value1").pathParam("key2", "value2").
		when().get("http://services.groupkt.com/{key1}/{key2}/all").
		then().assertThat().statusLine(containsString("ok"));
	}
	
	@Test
	public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {
	        
	    given().auth().preemptive().basic("username", "password").
	    when().get("http://path.to/basic/secured/api").
	    then().assertThat().statusCode(200);
	}
	
	@Test
	public void test_APIWithOAuth2Authentication_ShouldBeGivenAccess() {
	        
	    given().auth().oauth2("YOUR_AUTHENTICATION_TOKEN_GOES_HERE").
	    when().get("http://path.to/oath2/secured/api").
	    then().assertThat().statusCode(200);
	}
}
