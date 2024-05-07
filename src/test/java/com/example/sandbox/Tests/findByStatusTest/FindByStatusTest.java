package com.example.sandbox.Tests.findByStatusTest;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class FindByStatusTest extends Common {

    @Test(groups = {SMOKE}, description = "smoke")
    public void findByStatus1() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "available");

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

    }

    @Test(groups = {SMOKE}, description = "smoke")
    public void findByStatus2() {
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status", "notavailable");  //not a valid query

        Response response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(), 400, "Invalid response code");
        System.out.println("fine");

    }
 }
