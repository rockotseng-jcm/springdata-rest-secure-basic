package examplte.springdata.rest.resttemaplate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.springdata.rest.Customer;

public class UpdateCustomerTest extends RestTemplateCustomerTest {

    @Test
    public void testUpdateShouldReturnOk() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));

        String url = baseUrl + "/" + customer.getId();

        Customer toUpdate = new Customer("Rocko", "Tseng");

        ResponseEntity<Void> entity =
                restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(toUpdate, headers), Void.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());

    }

    @Test
    public void testUpdateShouldReturnCreatedIfCustomerNotFound() {

        String url = baseUrl + "/1";

        Customer customer = new Customer("Allen", "Yen");

        ResponseEntity<Void> entity =
                restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer, headers), Void.class);

        assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

}
