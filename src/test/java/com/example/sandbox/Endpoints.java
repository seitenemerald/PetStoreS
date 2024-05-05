package com.example.sandbox;

public class Endpoints {

    static final String baseUrl = "https://petstore.swagger.io/v2";

    //-------------------------pet-------------------------

    public static final String findByStatus = "/pet/findByStatus";
    public static String uploadImage(String petId){
        return ("/pet/"+petId+"/uploadImage");
    }
    public static final String newPet = "/pet";             //PUT,POST
    public static String petById(int petId){
        return ("/pet/"+petId);
    }

    //-------------------------store-------------------------

    public static final String order = "/store/order";
    public static final String inventory = "/store/inventory";

    //-------------------------user-------------------------

    public static final String createWithArray = "/user/createWithArray";
    public static final String createWithList = "/user/createWithList";
    public static String user(String username) {
        return ("/user/"+username);
    }
    public static final String login = "/user/login";
    public static final String logout = "/user/logout";


}
