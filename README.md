# Sample API testing project using SerenityBDD, Rest-Assured, Cucumber

## Introduction
This framework is developed as an example of API Automated Testing solution. The framework is built based on 

- SerenityBDD
- Rest-Assured
- Cucumber
- Maven

The idea behind the framework is as following

![Automation Framework Mind map](/data/API_Testing_Automation_Framework.png)

## Cucumber integration

This framework allows to write the test in Gherkin syntax. An example of test developed in Gherkin syntax is as following

```
    Scenario: Get current air quality data of a particular post code
        Given I send a get air quality request to weatherbit for post code 28546
        Then the API should return status 200
        Then Response should contain city name "Onslow"
        And Response should contain State code "NC"
        And Response should contain Country code "US"
```

## CI Integration

This repository has integration with Circle CI. Link to sample Circle CI Test Execution Report

`https://app.circleci.com/pipelines/github/nthanhhai/serenity-restassured-cucumber-junit-sample/5/workflows/2c6595f5-05b8-4455-b8ba-79a0b58dd7f3/jobs/6`

## Test execution

Once clone the repository to local environment, use this following command to execute test

`mvn clean verify`

## Test Report
Sample test repot can be found at 
`data/sample_report/TestResults.zip`

In that archive, please look for 

`serenity-summary.html`

report for the Summary of Execution.

## Future development

- Use RequestSpecification and ResponseSpecification to validate request and response.
- Configuration for test to run on different environment, e.g. SIT, UAT, and Production
- Read Test Data from external resource.
