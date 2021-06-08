# Test Automation - Web UI

## Introduction

This is a sample project developed by using Selenium - Kotlin to demonstrate how to use WebDriver Manager to automate the management of the binary drivers (chromedriver, geckodriver, etc.) required by Selenium.  
- All test cases - `./gradlew test`
- Screenshots of failed test cases - `./build/test-results`

## Adding custom test tasks

Custom test tasks can be added in `build.gradle.kts`. Current test task is as follows.
  
- General Regression Test Task (excluding wip tests) - regressionTest
