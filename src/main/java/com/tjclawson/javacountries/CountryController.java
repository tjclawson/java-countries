package com.tjclawson.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/countries")
public class CountryController {

    //localhost:2019/countries/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {

        return new ResponseEntity<>(alphabetizeCountryList(JavacountriesApplication.myCountryList.countryList), HttpStatus.OK);
    }

    //localhost:2019/countries/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter) {

        ArrayList<Country> returnCountries = JavacountriesApplication.myCountryList
                .findCountries((country -> country.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter)));

        return new ResponseEntity<>(alphabetizeCountryList(returnCountries), HttpStatus.OK);
    }

    //localhost:2019/countries/names/size/{number}
    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable int number) {

        ArrayList<Country> returnCountries = JavacountriesApplication.myCountryList
                .findCountries((country -> country.getName().length() == number));

        return new ResponseEntity<>(alphabetizeCountryList(returnCountries), HttpStatus.OK);
    }

    //localhost:2019/countries/population/size/{people}
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable long people) {
         ArrayList<Country> returnCountries = JavacountriesApplication.myCountryList
                 .findCountries((country -> country.getPopulation() >= people));

         return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    //localhost:2019/countries/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLowestPopulation() {

        JavacountriesApplication.myCountryList
                .countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/countries/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithHighestPopulation() {

        JavacountriesApplication.myCountryList
                .countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/countries/population/median
    @GetMapping(value = "/population/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMedianPopulation() {

        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        int medianPosition;
        medianPosition = (JavacountriesApplication.myCountryList.countryList.size() + 1) / 2;

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(medianPosition), HttpStatus.OK);
    }

    //localhost:2019/countries/age/age/{age}
    @GetMapping(value = "/age/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age) {

        ArrayList<Country> returnCountries = JavacountriesApplication.myCountryList
                .findCountries((country -> country.getMedianAge() >= age));

        return new ResponseEntity<>(alphabetizeCountryList(returnCountries), HttpStatus.OK);

    }

    //localhost:2019/countries/age/min
    @GetMapping(value = "/age/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLowestMedianAge() {

        JavacountriesApplication.myCountryList
                .countryList.sort((c1, c2) -> c1.getMedianAge() - c2.getMedianAge());

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/countries/age/max
    @GetMapping(value = "/age/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithHighestMedianAge() {

        JavacountriesApplication.myCountryList
                .countryList.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //localhost:2019/countries/age/median
    @GetMapping(value = "/age/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMedianMedianAge() {

        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> c1.getMedianAge() - c2.getMedianAge());

        int medianPosition;
        medianPosition = (JavacountriesApplication.myCountryList.countryList.size() + 1) / 2;

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(medianPosition), HttpStatus.OK);
    }

    private static ArrayList<Country> alphabetizeCountryList(ArrayList<Country> countries) {
        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return countries;
    }
}
