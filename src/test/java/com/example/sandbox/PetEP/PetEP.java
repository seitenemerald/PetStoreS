package com.example.sandbox.PetEP;

import com.example.sandbox.Common;
import com.example.sandbox.util.Tools;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetEP extends Common {

    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void findByStatus1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

    }

    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void findByStatus2() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "notavailable");  //not a valid query

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 400, "Invalid response code");

    }

    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void postPet1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Map<String, String> body = new TreeMap<>();

        body = response.jsonPath().getMap("[0]");   //1st search result used for POST
        Response response2 = postUrl(newPet, body);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

    }

    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void postPet2() {
        Response response = postUrl(newPet);
        Assert.assertEquals(response.getStatusCode(), 405, "Invalid response code");

    }

    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void petId1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
        int id = response.jsonPath().get("[0].id");      //1st search result used for GET

        Response response2 = getUrl(petById(id));
        Assert.assertEquals(response2.getStatusCode(), 200, "Invalid response code");
    }


    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    public void petId2() {
        int id = Tools.generateRandomNumber();
        Response response = getUrl(petById(id));
        Assert.assertEquals(response.getStatusCode(), 404, "Invalid response code");

    }
}
