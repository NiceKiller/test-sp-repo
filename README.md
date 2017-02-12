# test-sp-repo

## Prerequisites

Test was run on Windows OS and Chrome version 55.0.2883.87
(support for Linux and MacOs is added but was no tested there)
Java 1.8 and Maven 3 should be installed.

## Test run

To run test type in command line
```
mvn clean test
```

## Report

To generate report we are using Allure Test Report plugin
after test run type in command line
```
mvn site
```
report will be generated in
```
target/site/allure-maven-plugin/index.html
```
screenshots are saved in target/screenshot/*
and are also attached in report for failed tests