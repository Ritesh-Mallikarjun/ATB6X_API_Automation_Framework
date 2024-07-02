package com.thetestingacademy.Utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    Faker faker;
    public String getfirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }
}
