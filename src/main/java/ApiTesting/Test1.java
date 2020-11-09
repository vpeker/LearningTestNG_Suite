package ApiTesting;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test1 {

    @Test

    public void requestUsZipCode() {
        given().
                when().when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                statusCode(200);

    }

    @Test
    public void requestUsZipCodeContentType() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                //contentType(ContentType.JSON);
                        contentType("application/json");


    }

    @Test
    public void requestResopnseDetails() {
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body();


    }

    @Test
    public void requestResopnseDetailsSpecific() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));


    }

    @Test
    public void requestResopnseDetailsExpectCalifornia() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places[0].'state'", equalTo("California"));

    }

    @Test
    public void requestResopnseDetailsExpectContainBeverlyHill() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places.'place name'", hasItem("Beverly Hills"));

    }

    @Test
    public void requestResopnseDetailsExpectNOTContainBeverlyHill() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places.'place name'", not(hasItem("Beverly Hills")));

    }

    @Test
    public void requestResopnseDetailsExpectOne() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().body("places.'place name'", hasSize(1));


    }
}