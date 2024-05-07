package com.example.sandbox.Tests.businessProcesses;

import com.example.sandbox.Common;
import com.example.sandbox.util.swagger.definitions.PetBody;
import com.example.sandbox.util.swagger.definitions.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.Builder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.constans.Tags.REGRESSION;
import static com.example.sandbox.util.constans.TestData.photoUrls;

public class PetLifeCycleTest extends Common {



    @Test(groups = {REGRESSION}, description = "pet life cycle test")
    @Builder
    public void postPet1() throws JsonProcessingException {
        int id = generateRandomNumber();

        PetBody petBody = PetBody.builder()
                .id(id)
                .category(Item.builder().id(1).name("Category").build())
                .name("petName")
                .photoUrls(photoUrls)
                .tags(List.of(Item.builder().id(1).name("Tag1").build(), Item.builder().id(2).name("Tag2").build()))
                .status("available")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(petBody);
        Response addPetResponse = postUrl(newPet, body);
        Assert.assertEquals(addPetResponse.getStatusCode(), 200, "Invalid response code");

        petBody.setStatus("sold)");
        body = mapper.writeValueAsString(petBody);

        Response updatePetResponse = putUrl(newPet, body);
        Assert.assertEquals(updatePetResponse.getStatusCode(), 200, "Invalid response code");

        Response deletePetResponse = deleteUrl(id);
        Assert.assertEquals(deletePetResponse.getStatusCode(), 200, "Invalid response code");

    }
}
