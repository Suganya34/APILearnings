package com.learning;

import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APILearnings {


    @Test
    public void weatherApiGetCall() {


        Response apiresponse =
                given()
                        .param("search", "Mumbai").auth().none()
                        .when().get("https://freetestapi.com/api/v1/weathers");


//        System.out.println("The Status Code is " + apiresponse.getStatusCode());
        System.out.println("The Response Time is " + apiresponse.getTime());
//        System.out.println("The City " + apiresponse.body().path("city"));
//        System.out.println("The country " + apiresponse.body().path("country"));
//        System.out.println("The temparature " + apiresponse.body().path("temperature"));

        apiresponse.then().log().all();
        Assert.assertEquals(200, apiresponse.getStatusCode());
        Assert.assertTrue(apiresponse.getTime() <= 1000);
        Assert.assertEquals("Mumbai", apiresponse.body().path("[0].city"));
        Assert.assertEquals("India", apiresponse.jsonPath().get("[0].country"));
    }
}
