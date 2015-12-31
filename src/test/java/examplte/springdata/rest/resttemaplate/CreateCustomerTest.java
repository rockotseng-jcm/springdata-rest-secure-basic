package examplte.springdata.rest.resttemaplate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.springdata.rest.Customer;

public class CreateCustomerTest extends RestTemplateCustomerTest {

    @Test
    public void testCreateShouldReturnCreated() {

        String url = baseUrl;

        Customer customer =  new Customer("Sandra", "Wei");

        ResponseEntity<Void> entity =
                restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Customer>(customer, headers), Void.class);

        assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

}
