package examplte.springdata.rest.resttemaplate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.springdata.rest.Customer;

public class DeleteCustomerTest extends RestTemplateCustomerTest {

    @Test
    public void testDeleteShouldReturnNoContent() {
        
        Customer customer = customerRepository.save(new Customer("Allen", "Yen"));
        
        String url = baseUrl + "/" + customer.getId();
        
        ResponseEntity<Void> entity =
                restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<Void>(headers), Void.class);

        assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
    }
    
    @Test
    public void testDeleteShouldReturnNotFound() {
        
        String url = baseUrl + "/1";
        
        ResponseEntity<Void> entity =
                restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<Void>(headers), Void.class);

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    }
    
}
