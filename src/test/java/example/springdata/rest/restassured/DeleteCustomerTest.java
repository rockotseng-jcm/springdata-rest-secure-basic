package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import example.springdata.rest.Customer;

public class DeleteCustomerTest extends RestAssuredCustomerTest {

    @Test
    public void testDeleteShouldReturnNoContent() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given(requestSpec).when().delete("/{id}", customer.getId()).then().statusCode(204);
    }

    @Test
    public void testDeleteShouldReturnNotFound() {

        given(requestSpec).when().delete("/1").then().statusCode(404);
    }

}
