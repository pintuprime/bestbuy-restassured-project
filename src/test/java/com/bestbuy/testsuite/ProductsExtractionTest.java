package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);


    }

//21. Extract the limit
@Test
public void test21() {

    int limit =  response.extract().path("limit");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " + limit);
    System.out.println("------------------End of Test---------------------------");
}
//22. Extract the total
@Test
public void test22() {

    int total =  response.extract().path("total");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The total is: " + total);
    System.out.println("------------------End of Test---------------------------");
}

//23. Extract the name of 5th product
@Test
public void test23() {

    String productName =  response.extract().path("data[4].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of 5th product : " + productName);
    System.out.println("------------------End of Test---------------------------");
}
//24. Extract the names of all the products
@Test
public void test24() {

    List<String> nameOfAllProduct = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The  name of all product : " + nameOfAllProduct);
    System.out.println("------------------End of Test---------------------------");
}

//25. Extract the productId of all the products
    @Test
    public void test25() {

        List<Integer> listOfIds = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productid of all product: " + listOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

//26. Print the size of the data list
@Test
public void test26() {

    List<Objects> sizeOfData = response.extract().path("data");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of data list : " + sizeOfData.size());
    System.out.println("------------------End of Test---------------------------");
}

//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test27() {

        List<HashMap<String,?>> values =  response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-Pack)' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
@Test
public void test28() {

    List<HashMap<?,Object>> modelName = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The prices of products whose name end with = Vehicles are: " + modelName);
    System.out.println("------------------End of Test---------------------------");
}

//29. Get all the categories of 8th products
    @Test
    public void test29() {

        List<String> categories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all categories of 8th products: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }
//30. Get categories of the store where product id = 150115
    @Test
    public void test30() {

        List<String> categories = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get categories of id 150115: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }
//31. Get all the descriptions of all the products
@Test
public void test31() {

    List<String> descriptionProduct = response.extract().path("data.description");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get descriptions of all the products : " + descriptionProduct);
    System.out.println("------------------End of Test---------------------------");
}
//32. Get id of all the all categories of all the products
    @Test
    public void test32(){

            List<Integer> storeServiceName = response.extract().path("data.categories.id");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The store id is: " + storeServiceName);
            System.out.println("------------------End of Test---------------------------");
    }
//33. Find the product names Where type = HardGood
@Test
public void test033() {

    List<String> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The the product names Where type = HardGood : " + productName);
    System.out.println("------------------End of Test---------------------------");
}
//34. Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)
    @Test
public void test34() {
    List<?> totalService = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get All Cat Total : " + totalService.size());
    System.out.println("------------------End of Test---------------------------");
}

//35. Find the createdAt for all products whose price < 5.49

    @Test
    public void test35() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
//            36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)”
@Test
public void test36() {
    List<HashMap<String, ?>> allCat = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)” : " + allCat);
    System.out.println("------------------End of Test---------------------------");
}
//37. Find the manufacturer of all the products
@Test
public void test37() {
    List<String> allManufacturer = response.extract().path("data.manufacturer");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get All Manufacturer Name : " + allManufacturer);
    System.out.println("------------------End of Test---------------------------");
}
//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void test38() {
    List<HashMap<String, ?>> img = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The image of products whose manufacturer is = Energizer: " + img);
    System.out.println("------------------End of Test---------------------------");
}
//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test39() {
    List<String> createdAt = response.extract().path("data.findAll{it.price > 5.49}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Get All Cat Total : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//            40. Find the uri of all the products
@Test
public void test40() {
    List<HashMap<String, ?>> url = response.extract().path("data.url");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Finding the uri of all the products : " + url);
    System.out.println("------------------End of Test---------------------------");
}
}
