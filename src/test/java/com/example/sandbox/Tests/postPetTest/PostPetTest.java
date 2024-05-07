package com.example.sandbox.Tests.postPetTest;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PostPetTest extends Common {


    @Test(groups = {SMOKE}, description = "smoke")
    public void postPet1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Map<String, String> body = response.jsonPath().getMap("[0]");   //1st search result used for POST
        Response response2 = postUrl(newPet, body);
        Assert.assertEquals(response2.getStatusCode(), 200, "Invalid response code");

    }

    @Test(groups = {SMOKE}, description = "smoke")
    public void postPet2() {
        Response response = postUrl(newPet);
        Assert.assertEquals(response.getStatusCode(), 405, "Invalid response code");

    }
}
