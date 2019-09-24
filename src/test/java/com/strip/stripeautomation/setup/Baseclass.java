package com.strip.stripeautomation.setup;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

import com.stripe.stripautomation.utils.Configproperty;
import com.stripe.stripautomation.utils.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	public static Configproperty configprop;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx");
	
	@BeforeSuite
	public void setup() {
		configprop = ConfigFactory.create(Configproperty.class);
	
		
		//RestAssured.baseURI="https://api.stripe.com/";
		//RestAssured.basePath="v1/";
		RestAssured.baseURI=configprop.baseURI();
		
		RestAssured.basePath=configprop.basePATH();

	}
	
	@BeforeMethod
	public void beformethod(Method method) {
		System.out.println("Successfully executing"+method.getName());
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) {
		if(result.getStatus()==result.SUCCESS) {
			System.out.println(result.getName() + "Testcase is passed ");
		}
		if(result.getStatus()==result.FAILURE) {
			System.out.println(result.getName() + "Testcase is Failed ");
		}
		if(result.getStatus()==result.SKIP) {
			System.out.println(result.getName() + "Testcase is Skipped ");
		}
	}
	
	@AfterSuite
	public void teardown() {
		
	}
	
	public static RequestSpecification reqestspec() {
		
		RequestSpecification spec = given().auth().basic(configprop.authkey(), "");
		return spec;
		
		
	}

}
