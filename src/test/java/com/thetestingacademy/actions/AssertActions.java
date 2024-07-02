package com.thetestingacademy.actions;

import com.thetestingacademy.pojos.BookingResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

public class AssertActions {

   public void verifyResponseBody(String actual, String expected, String description){
       assertEquals(actual, expected, description);
   }

    public void verifyResponseBody(Integer actual, Integer expected, String description){
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(Double actual, Double expected, String description){
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(Boolean actual, Boolean expected, String description){
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(Float actual, Float expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCodeInvalidResponse(Response response){
       assertEquals(String.valueOf(response.getStatusCode()).startsWith("50"),true,
               "value of status code is: "+response.getStatusCode());
    }

    public void verifyStatusCode(Response response) {
       assertEquals(String.valueOf(response.getStatusCode()).startsWith("200"),true,
               "value of status code is: "+response.getStatusCode());
    }
}
