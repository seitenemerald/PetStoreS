package com.example.sandbox.util;

import static com.example.sandbox.Endpoints.petId;

public class Tools {
    public static int generateRandomNumber(){
        return (int) (Math.random()*100);
    }

    public static String replacePetId(int id) {
        return petId.replace("{petId}", String.valueOf(id));
    }
}
