package com.jleber.simple.bin.validator.controller;

import com.jayway.restassured.RestAssured;
import com.jleber.simple.bin.validator.config.ApiConfig;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by jleber on 17/06/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiConfig.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class BinValidatorControllerTest {

    private String visa;
    private String master;
    private String elo;
    private String hiper;
    private String amex;
    private String diners;
    private String discover;


    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        visa =   "4556454850809418";
        master = "5157464252636343";
        elo = "6362970000457013";
        hiper = "6062825624254001";
        amex = "340899955982792";
        diners ="30399970577763";
        discover = "6011674863327579";

        RestAssured.port = port;
    }

    @Test
    public void shouldFetchVisa() {
        RestAssured.when().
                get("/bin/check/{number}", visa).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Visa")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("16"));
    }

    @Test
    public void shouldFetchMaster() {
        RestAssured.when().
                get("/bin/check/{number}", master).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Mastercard")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("16"));
    }

    @Test
    public void shouldFetchElo() {
        RestAssured.when().
                get("/bin/check/{number}", elo).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Elo")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("16"));
    }

    @Test
    public void shouldFetchHiper() {
        RestAssured.when().
                get("/bin/check/{number}", hiper).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Hipercard")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("19"));
    }

    @Test
    public void shouldFetchAmex() {
        RestAssured.when().
                get("/bin/check/{number}", amex).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Amex")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("15"));
    }

    @Test
    public void shouldFetchDiners() {
        RestAssured.when().
                get("/bin/check/{number}", diners).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Diners")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("14"));
    }

    @Test
    public void shouldFetchDiscover() {
        RestAssured.when().
                get("/bin/check/{number}", discover).
                then().
                statusCode(HttpStatus.SC_OK).
                body("brand", Matchers.is("Discover")).
                body("cvv", Matchers.is("3")).
                body("length", Matchers.is("19"));
    }

}
