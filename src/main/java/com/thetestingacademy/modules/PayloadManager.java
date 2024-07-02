package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingDates;
import com.thetestingacademy.pojos.BookingResponse;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Rohnan");
        booking.setLastname("Milan");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);

        BookingDates bookDates = new BookingDates();
        bookDates.setCheckin("2018-01-01");
        bookDates.setCheckout("2019-01-01");

        booking.setBookingdates(bookDates);
        booking.setAdditionalneeds("breakfast + Dinner");

        gson = new Gson();
        String gsontoJsonString = gson.toJson(booking);

        System.out.println("aa"+booking);
        return gsontoJsonString;
    }

    public String createInvalidPayloadBooking() {
        return "";
    }

    public String updateFullPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Milano");
        booking.setLastname("Nimuno");
        booking.setTotalprice(568);
        booking.setDepositpaid(true);

        BookingDates bookDates = new BookingDates();
        bookDates.setCheckin("2018-01-01");
        bookDates.setCheckout("2019-01-01");

        booking.setBookingdates(bookDates);
        booking.setAdditionalneeds("breakfast + chips");

        gson = new Gson();
        String gsontoJsonString = gson.toJson(booking);

        System.out.println(booking);
        return gsontoJsonString;
    }

    public BookingResponse bookingResponseJavaDeSerial(String response) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(response, BookingResponse.class);
        return bookingResponse;
    }


}
