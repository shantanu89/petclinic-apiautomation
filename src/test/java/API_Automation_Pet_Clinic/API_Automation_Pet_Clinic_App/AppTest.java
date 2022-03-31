package API_Automation_Pet_Clinic.API_Automation_Pet_Clinic_App;

import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void validateURLTest1()
    {
    	Response response = RestAssured.get("http://20.239.27.227/petclinic/api/owners");
     // url="http://localhost:8080/petclinic/api/owners";
    	System.out.println("Status Code="+response.statusCode());
//		System.out.println(response.asString());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.statusLine());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
    }
    
    @Test
    public void checkSubmitFormTest2()
    {
        RequestSpecification request = RestAssured.given();
        
        request.header("Content-Type","application/json");
        
        JSONObject json = new JSONObject();
        
        json.put("address","sampleAdd");
        json.put("city","Hydrabad");
        json.put("firstName","TestFName");
        json.put("id","0");
        json.put("lastName","TestLName");
        json.put("telephone","1234561235");
        
        request.body(json.toJSONString());
        
        Response response = request.post("http://20.239.27.227/petclinic/api/owners");
        int code = response.getStatusCode();
        System.out.println("Status Code="+code);
        
        Assert.assertEquals(code, 201);  
    }
  

}
