Feature: Get Current Air Quality Data

    Scenario: Get current air quality data of a particular post code
        Given I send a get air quality request to weatherbit for post code 28546
        Then the API should return status 200
        # Then Response should contain city name "Onslow"
        # And Response should contain State code "NC"
        And Response should contain Country code "US"