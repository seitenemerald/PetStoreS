package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Builder;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.testng.ITestResult;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetBody {

    private int id;
    private Item category;
    private String name;
    @Singular()
    private List<String> photoUrls;
    @Singular()
    private List<Item> tags;
    private String status;

}
