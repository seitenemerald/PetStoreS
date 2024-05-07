package com.example.sandbox;

import io.restassured.response.Response;

import java.util.Map;

import static com.example.sandbox.util.Tools.replacePetId;
import static io.restassured.RestAssured.given;

public class Common extends Endpoints {

    //----------------------------------GET----------------------------------
    protected Response getUrl(int petId){


        return given()
                .relaxedHTTPSValidation()
                .and()
                .log().everything()
                .when()
                .get(baseUrl + newPet +  replacePetId(petId))
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response getUrl(String endpoint, Map<String, String> queryParam ){


        return given()
                .relaxedHTTPSValidation()
                .params(queryParam)
                .and()
                .log().everything()
                .when()
                .get(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response getUrl(String endpoint,Map<String, String> headers,Map<String, String> queryParam ){


        return given()
                .relaxedHTTPSValidation()
                .params(queryParam)
                .headers(headers)
                .and()
                .log().all()
                .when()
                .get(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }

    //----------------------------------POST----------------------------------
    protected Response postUrl(String endpoint){   //empty POST request


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .and()
                .log().everything()
                .when()
                .post(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response postUrl(String endpoint, Map<String, String> body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .and()
                .log().everything()
                .when()
                .post(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response postUrl(String endpoint, String body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .and()
                .log().everything()
                .when()
                .post(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response postUrl(String endpoint,Map<String, String> headers,Map<String, String> body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .headers(headers)
                .body(body)
                .and()
                .log().everything()
                .when()
                .post(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }

    //----------------------------------PUT----------------------------------
    protected Response putUrl(String endpoint, Map<String, String> body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .and()
                .log().everything()
                .when()
                .put(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response putUrl(String endpoint, String body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .body(body)
                .and()
                .log().everything()
                .when()
                .put(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }
    protected Response putUrl(String endpoint,Map<String, String> headers,Map<String, String> body){


        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json; charset=UTF-8")
                .headers(headers)
                .body(body)
                .and()
                .log().everything()
                .when()
                .put(baseUrl+endpoint)
                .then()
                .log()
                .all()
                .extract().response();

    }

    //----------------------------------DELETE----------------------------------
    protected Response deleteUrl(int petId){
        return given()
                .relaxedHTTPSValidation()
                .and()
                .log().everything()
                .when()
                .delete(baseUrl + newPet + replacePetId(petId))
                .then()
                .log()
                .all()
                .extract().response();
    }
}

