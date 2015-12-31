package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import example.springdata.rest.Customer;

public class UpdateCustomerTest extends RestAssuredCustomerTest {

    @Test
    public void testUpdateShouldReturnOk() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        Customer body = new Customer("Rocko", "Tseng");

        given(requestSpec).body(body).when().put("/{id}", customer.getId()).then().statusCode(200);
    }

    @Test
    public void testUpdateShouldReturnCreatedIfCustomerNotFound() {

        Customer body = new Customer("Rocko", "Tseng");

        given(requestSpec).body(body).when().put("/1").then().statusCode(201);
    }

}
