package com.thetestingacademy.base;

import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

//Single level inheritance
public class BaseTest {
    public RequestSpecification rspec;
    public Response response;
    public PayloadManager payloadManager;
    public AssertActions assertActions;
    public ValidatableResponse vr;
    public JsonPath jsonPath;

    @BeforeTest
    public void setConfig(){
        System.out.println("Before Test, before running any testcases");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        rspec= RestAssured.given().baseUri(APIConstants.BASE_URL).contentType(ContentType.JSON).log().all();
    }

    public String getToken(){
        return "";
    }
}
