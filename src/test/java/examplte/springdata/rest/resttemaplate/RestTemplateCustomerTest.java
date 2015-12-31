package examplte.springdata.rest.resttemaplate;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import example.springdata.rest.AbstractCustomerTest;

public abstract class RestTemplateCustomerTest extends AbstractCustomerTest {

    protected RestTemplate restTemplate;

    protected HttpHeaders headers;

    protected String baseUrl;

    @Before
    public void setup() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);

        List<HttpMessageConverter<?>> converters = Collections.<HttpMessageConverter<?>>singletonList(converter);

        this.restTemplate = new TestRestTemplate("user", "user");
        restTemplate.setMessageConverters(converters);

        this.headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE);

        this.baseUrl = "http://localhost:" + this.port + "/customers";
    }
}
