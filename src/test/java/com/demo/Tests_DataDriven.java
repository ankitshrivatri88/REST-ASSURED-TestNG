package com.demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.lwawt.macosx.CSystemTray;

import static io.restassured.RestAssured.*;

public class Tests_DataDriven extends DataForTest {


        @Test(dataProvider = "dataPosting")
    public void test_postDataDriven(String firstName, String lastName, int subjectId) {

        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";
        given().
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    header("Content-Tyoe", "application/json").
                    body(request.toJSONString()).

                when().
                    post("/users").

                then().
                    statusCode(201).
                    log().all();

    }

    @Test(dataProvider = "DeleteDataIds")
    public void deleteDataDrivenTest(int userId){

        baseURI="http://localhost:3000/";
        when().
                delete("/users/"+userId).
        then().
                statusCode(200).
                log().all();
    }

//    @Parameters({"userId"})
//    @Test
//    public void delete2(int userId){
//        System.out.println("Value for Userid is" +userId);
//        baseURI="http://localhost:3000/";
//        when().
//                delete("/users/"+userId).
//                then().
//                statusCode(200).
//                log().all();
//    }

}

