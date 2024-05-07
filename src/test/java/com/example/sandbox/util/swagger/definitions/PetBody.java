package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Builder;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetBody {

   
    private int id;

   
    private Item category;

   
    private String name;

   
    @Singular
    private List<String> photoUrls;

   
    @Singular
    private List<Item> tags;

   
    private String status;

}
