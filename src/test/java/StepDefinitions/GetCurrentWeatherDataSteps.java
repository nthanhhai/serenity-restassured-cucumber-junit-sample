package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import io.weatherbit.v2.common.CommonData;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GetCurrentWeatherDataSteps {

    public Response response;

    @Given("I send a get weather data request to weatherbit with lat {double} and lon {double}")
    public void sendRequestWithLatLon(Double lat, Double lon) throws IOException {
        response = SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .param("lat", lat)
                .param("lon", lon)
                .param("key", CommonData.APIKey)
                .when().get(CommonData.URL);
    }

    @Given("I send a get weather data request to weatherbit with a list of city as {string}")
    public void sendRequestWithCities(String cities) throws IOException {
        response = SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .param("cities", cities)
                .param("key", CommonData.APIKey)
                .when().get(CommonData.URL);
    }

    @Then("the API should return status {int}")
    public void verifyResponse(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }

    @Then("Response should contain city name {string}")
    public void verifyResponseContentCity(String cityName) {
        String outCityName = response.jsonPath().getString("data.city_name");
        System.out.println("City Name is " + outCityName);
        assertEquals(cityName, outCityName);
    }

    @Then("Response should contain lat {double}")
    public void verifyResponseContentLat(Double lat) {
        String outLat = response.jsonPath().getString("data.lat");
        assertEquals(lat, outLat);
    }

    @Then("Response should contain lon {double}")
    public void verifyResponseContentLon(Double lon) {
        String outLon = response.jsonPath().getString("data.lon");
        assertEquals(lon, outLon);
    }
}