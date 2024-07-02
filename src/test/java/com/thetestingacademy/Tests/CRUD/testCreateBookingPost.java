package com.thetestingacademy.Tests.CRUD;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class testCreateBookingPost extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Ritesh")
    @Severity(SeverityLevel.NORMAL)
    @Description("#TC1, verify if the booking is created")
    public void testCreateBooking() {
        rspec.basePath(APIConstants.CREATE_AND_UPDATE_URL);
        rspec.body(payloadManager.createPayloadBookingAsString());

        response = rspec.when().log().all().post();

        //Get response in the form of string
        String jsonaStringResponse = response.asString();
        System.out.println(jsonaStringResponse); //printing the response

        vr = response.then().log().all();

        //Validatable Assertion
        vr.statusCode(200);

        //De-Serialization
        BookingResponse bookingResponse = payloadManager.bookingResponseJavaDeSerial(jsonaStringResponse);
        assertEquals(response.getStatusCode(),200);
        assertNotNull(bookingResponse.getBookingid());
        assertEquals(bookingResponse.getBooking().getFirstname(), "Rohnan");

        //TestNG Asserstions
        assertActions.verifyStatusCode(response);
    }

    @Test(groups = "smoke")
    @Owner("Ritesh")
    @Severity(SeverityLevel.NORMAL)
    @Description("#TC2, verify if the booking is created")
    public void testCreateNegativeBooking(){
      rspec.basePath(APIConstants.CREATE_AND_UPDATE_URL);
      rspec.body(payloadManager.createInvalidPayloadBooking());

      response= rspec.when().log().all().post();

        String jsonaStringResponse = response.asString();
        System.out.println(jsonaStringResponse); //printing the response

        vr = response.then().log().all();

        //Validatable Assertion
        vr.statusCode(500);

        assertActions.verifyStatusCodeInvalidResponse(response);

    }


}
