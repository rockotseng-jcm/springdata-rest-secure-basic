package examplte.springdata.rest.resttemaplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.springdata.rest.Customer;

public class GetCustomerTest extends RestTemplateCustomerTest {

    @Test
    public void testGetShouldReturnOkWithCorrespondingResource() {

        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));
        
        String url = baseUrl + "/" + customer.getId();

        ResponseEntity<Customer> entity =
                restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Void>(headers), Customer.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertNotNull(entity.getBody().getFirstName());
    }
    
    @Test
    public void testGetShouldReturnNotFound() {

        String url = baseUrl + "/1";

        ResponseEntity<Customer> entity =
                restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Void>(headers), Customer.class);

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    }

}
