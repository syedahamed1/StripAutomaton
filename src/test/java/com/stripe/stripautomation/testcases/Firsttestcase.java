package com.stripe.stripautomation.testcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.strip.stripeautomation.setup.Baseclass;
import com.stripe.stripautomation.utils.Configproperty;
import com.stripe.stripautomation.utils.Dataprovider1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Firsttestcase extends Baseclass{

	@Test(dataProviderClass=Dataprovider1.class,dataProvider ="dp")
	public void postm(Hashtable<String, String> data) {
		
		RequestSpecification spec = reqestspec().formParam("email",data.get("email") ).formParam("account_balance", data.get("accountbalance")).formParam("description", data.get("description"));
		Response resp = spec.request("POST","customers");
		JsonPath json = new JsonPath(resp.asString());
		
		  System.out.println(json.get("email"));
		  System.out.println(json.get("invoice_settings.custom_fields"));
		 
		resp.prettyPrint();
		
	}
	
}
