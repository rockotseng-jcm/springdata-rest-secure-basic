package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

import example.springdata.rest.Customer;

public class ListCustomerTest extends RestAssuredCustomerTest {

    @Test
    public void testListShouldReturnOkWithCorrectSize() {

        customerRepository.save(new Customer("Allen", "Yen"));
        customerRepository.save(new Customer("Rocko", "Tseng"));

        given(requestSpec).when().get().then().statusCode(200).body("_embedded.customers", hasSize(2));
    }

}
