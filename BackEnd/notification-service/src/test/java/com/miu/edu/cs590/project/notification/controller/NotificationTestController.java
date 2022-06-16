package com.miu.edu.cs590.project.notification.controller;


import com.miu.edu.cs590.project.notification.model.InformationTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class NotificationTestController {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8110);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneNotification() {

        InformationTest informationTest = new InformationTest("Samuel", "675-3456-2456", "sbartolome@miu.edu", "Credit Card", "1000 North 4St, MIU", "Double", "$34.50");

        // Adding Objects to the Database
        given()
                .contentType("application/json")
                .body(informationTest)
                .when().post("/notifications").then()
                .statusCode(200);

        // Test getting the InformationTest Object
        given()
                .when()
                .get("/notifications/sbartolome@miu.edu")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("customerName", hasItems("Samuel"))
                .body("customerPhoneNumber", hasItems("675-3456-2456"))
                .body("email", hasItems("sbartolome@miu.edu"))
                .body("typeOfPayment", hasItems("Credit Card"))
                .body("address", hasItems("1000 North 4St, MIU"))
                .body("roomType", hasItems("Double"))
                .body("price", hasItems("$34.50"));

        // Cleaning up
        given()
                .when()
                .delete("/notifications/sbartolome@miu.edu");
    }

    @Test
    public void testGetAllNotification() {
        InformationTest informationTest = new InformationTest("Samuel", "675-3456-2456", "sbartolome@mum.edu", "Credit Card", "1000 North 4St, MIU", "Double", "$34.50");
        InformationTest informationTest2 = new InformationTest("Jorge", "675-111-1212", "sbartolome@gmail.com", "Paypal", "Granville Avenue 23, MIU", "Single", "$20.50");

        // Adding Objects to the Database
        given()
                .contentType("application/json")
                .body(informationTest)
                .when().post("/notifications").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(informationTest2)
                .when().post("/notifications").then()
                .statusCode(200);

        // Test getting the InformationTest Object
        given()
                .when()
                .get("/notifications")
                .then()
                .and()
                .body("customerName", hasItems("Samuel","Jorge"))
                .body("customerPhoneNumber", hasItems("675-3456-2456", "675-111-1212"))
                .body("email", hasItems("sbartolome@mum.edu", "sbartolome@gmail.com"))
                .body("typeOfPayment", hasItems("Credit Card", "Paypal"))
                .body("address", hasItems("1000 North 4St, MIU","Granville Avenue 23, MIU"))
                .body("roomType", hasItems("Double", "Single"))
                .body("price", hasItems("$34.50", "$20.50"));

        // Cleaning up
        given()
                .when()
                .delete("/notifications/sbartolome@mum.edu");
        given()
                .when()
                .delete("/notifications/sbartolome@gmail.com");
    }

}
