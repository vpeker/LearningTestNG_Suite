package ApiTesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@RunWith(DataProviderRunner.class)

public class Test2 {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us","90210","California"},
                {"us","12345","New York"},
                {"ca","B2R","Nova Scotia"},
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestResopnseWithDataProvider(String countryCode,String zipCode, String expectedPlaceName) {
        given().
                pathParam("countryCode",countryCode).pathParam("zipCode",zipCode).
                when().
                //get("http://zippopotam.us/us/12345").
                        get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().body("places[0].'state'", equalTo(expectedPlaceName));

    }
}