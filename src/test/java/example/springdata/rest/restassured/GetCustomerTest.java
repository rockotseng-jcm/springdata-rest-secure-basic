package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import example.springdata.rest.Customer;

public class GetCustomerTest extends RestAssuredCustomerTest {

    @Test
    public void testGetShouldReturnOkWithCorrespondingResource() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        given(requestSpec).when().get("/{id}", customer.getId()).then().statusCode(200).body("firstName",
                equalTo(customer.getFirstName()));
    }

    @Test
    public void testGetShouldReturnNotFound() {

        given(requestSpec).when().get("/1").then().statusCode(404);
    }

}
