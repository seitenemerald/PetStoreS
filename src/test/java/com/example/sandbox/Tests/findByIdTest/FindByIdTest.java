package com.example.sandbox.Tests.findByIdTest;

import com.example.sandbox.Common;
import com.example.sandbox.util.Tools;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class FindByIdTest extends Common {


    @Test(groups = {SMOKE}, description = "smoke")
    public void petId1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
        int id = response.jsonPath().get("[0].id");      //1st search result used for GET
        Response response2 = getUrl(id);
        Assert.assertEquals(response2.getStatusCode(), 200, "Invalid response code");
    }


    @Test(groups = {SMOKE}, description = "smoke")
    public void petId2() {
        int id = 1000 * Tools.generateRandomNumber();
        Response response = getUrl(id);
        Assert.assertEquals(response.getStatusCode(), 404, "Invalid response code");

    }
}
