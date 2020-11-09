package ApiTesting;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Test3 {
    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us").build();

    }

    @Test
    public void requestUsZipCode90210() {
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().
                assertThat().
                statusCode(200);
    }

    public static ResponseSpecification responseSpec;

    @BeforeClass
    public void createResponseSpecification() {

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType((ContentType.JSON)).
                build();


    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResoponseBody_expectBeverlyHills() {
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                // get("http://api.zippopotam.us/us/90210").
                        then().
                spec(responseSpec).
                and().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResoponseBody_assertBeverlyHills() {
        String placeName =
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                // get("http://api.zippopotam.us/us/90210").
                        then().
                extract().
                path("places[0].'place name'");

        Assert.assertEquals(placeName, "Beverly Hills");

    }
}
