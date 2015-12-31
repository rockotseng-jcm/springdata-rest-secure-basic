package examplte.springdata.rest.resttemaplate;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import example.springdata.rest.Customer;

public class ListCustomerTest extends RestTemplateCustomerTest {

    @Test
    public void testListShouldReturnOkWithCorrectSize() {

        customerRepository.save(new Customer("Allen", "Yen"));
        customerRepository.save(new Customer("Rocko", "Tseng"));
        
        String url = baseUrl;

        ResponseEntity<PagedResources<Customer>> entity = restTemplate.exchange(url, HttpMethod.GET,
                new HttpEntity<String>(headers), new ParameterizedTypeReference<PagedResources<Customer>>() {});

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertThat(entity.getBody().getContent(), hasSize(2));
    }

}
