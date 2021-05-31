Feature: Get Current Weather Data

  Scenario: Get current weather data by lat and lon
    Given I send a get weather data request to weatherbit with lat 38 and lon -78.25
    Then the API should return status 200
    # And Response should contain city name "Zion"
    #And Response should contain lat "38"
    And Response should contain lon "-78.25"

  Scenario: Get current weather data for multiple cities in the world
    Given I send a get weather data request to weatherbit with a list of city as "4487042, 4494942, 4504871"
    Then the API should return status 403
