package com.demo;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Tests_localhostRun {

    @Test
    public void test_get(){
        baseURI="http://localhost:3000/";
        given()
                 .param("name","Automation")
                 .get("/subjects")
//                 .get("/users").
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_post2(){

        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Hardy");
        request.put("subjectId", 1);

        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Tyoe","application/json").
                body(request.toJSONString()).
        when().
                 post("/users").
        then().
                statusCode(201).
                log().all();

    }

    @Test
    public void test_patch(){

        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Moody");
        request.put("subjectId", 1);

        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Tyoe","application/json").
                body(request.toJSONString()).

        when().
                patch("/users/4").
        then().
                statusCode(200).
                log().all();

    }

    @Test
    public void test_put02(){

        JSONObject request = new JSONObject();
        request.put("firstName", "Hardy");
        request.put("lastName", "Sandhu");
        request.put("subjectId", 2);

        baseURI="http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Tyoe","application/json").
                body(request.toJSONString()).

        when().
                put("/users/6").

        then().
                statusCode(200).
                log().all();

    }

    @Test
    public void delete(){

        baseURI="http://localhost:3000/";


                when().
                     delete("/users/4").

                then().
                        statusCode(200).
                        log().all();

    }
}
