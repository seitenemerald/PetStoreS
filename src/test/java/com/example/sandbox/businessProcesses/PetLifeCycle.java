package com.example.sandbox.businessProcesses;

import com.example.sandbox.Common;
import com.example.sandbox.util.Tools;
import com.example.sandbox.util.swagger.definitions.PetBody;
import com.example.sandbox.util.swagger.definitions.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Builder;
import lombok.Singular;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetLifeCycle extends Common {



    @Test(enabled = true, groups = {SMOKE}, description = "smoke")
    @Builder
    public void postPet1() throws JsonProcessingException {


        PetBody petBody = PetBody.builder()
                .id(578587578)
                .category(Item.builder().id(1).name("Category").build())
                .name("petName")
                .photoUrls(List.of("photo1", "photo2"))
                .tags(List.of(Item.builder().id(1).name("Tag1").build(), Item.builder().id(2).name("Tag2").build()))
                .status("available")
                .build();


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(petBody);
        Map<String, String> body = mapper.readValue(json, Map.class);

        Response response = postUrl(newPet, body);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

        body.put("status", "sold");

        Response response2 = putUrl(newPet, body);
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

        Response response3 = deleteUrl(petById(578587578));
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");

    }
}
