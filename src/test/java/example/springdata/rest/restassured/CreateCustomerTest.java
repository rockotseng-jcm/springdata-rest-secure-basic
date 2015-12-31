package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import example.springdata.rest.Customer;

public class CreateCustomerTest extends RestAssuredCustomerTest {

    @Test
    public void testCreateShouldReturnCreated() {

        Customer customer = new Customer("Sandra", "Wei");

        given(requestSpec).body(customer).when().post().then().statusCode(201);
    }

}
