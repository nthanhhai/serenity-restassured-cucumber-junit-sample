package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import io.weatherbit.v2.common.CommonData;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetCurrentWeatherDataSteps {

    public Response response;

    @Given("I send a get weather data request to weatherbit with lat {double} and lon {double}")
    public void sendRequestWeatherDataWithLatLon(Double lat, Double lon) throws IOException {
        response = SerenityRest.given()
                .baseUri(CommonData.URL)
                .basePath("/current")
                .param("lat", lat)
                .param("lon", lon)
                .param("key", CommonData.APIKey)
                .when().get();

        System.out.println(response.toString());
    }

    @Given("I send a get weather data request to weatherbit with a list of city as {string}")
    public void sendRequestWeatherDataWithCities(String cities) throws IOException {
        response = SerenityRest.given()
                .baseUri(CommonData.URL)
                .basePath("/current")
                .param("cities", cities)
                .param("key", CommonData.APIKey)
                .when().get();
        System.out.println(response.toString());
    }

    @Then("the API should return status {int}")
    public void verifyResponse(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }

    @Then("Response should contain city name {string}")
    public void verifyResponseContentCity(String cityName) {
        String outCityName = response.jsonPath().getString("data[0].city_name");
        assertEquals(cityName, outCityName);
    }

    @Then("Response should contain lat {string}")
    public void verifyResponseContentLat(String lat) {
        String outLat = response.jsonPath().getString("data[0].lat");
        assertEquals(lat, outLat);
    }

    @Then("Response should contain lon {string}")
    public void verifyResponseContentLon(String lon) {
        String outLon = response.jsonPath().getString("data[0].lon");
        assertEquals(lon, outLon);
    }
}