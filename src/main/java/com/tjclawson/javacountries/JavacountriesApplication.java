package com.tjclawson.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication {

    static CountryList myCountryList;
    public static void main(String[] args) {

        myCountryList = new CountryList();
        SpringApplication.run(JavacountriesApplication.class, args);
    }

}
