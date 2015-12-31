package example.springdata.rest.restassured;

import static com.jayway.restassured.RestAssured.basic;

import org.junit.Before;
import org.springframework.hateoas.MediaTypes;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import example.springdata.rest.AbstractCustomerTest;

public abstract class RestAssuredCustomerTest extends AbstractCustomerTest {

    protected RequestSpecification requestSpec;

    @Before
    public void setup() {

        RestAssured.port = this.port;
        RestAssured.basePath = "/customers";
        RestAssured.authentication = basic("user", "user");

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(MediaTypes.HAL_JSON_VALUE);
        this.requestSpec = builder.build();
    }

}
