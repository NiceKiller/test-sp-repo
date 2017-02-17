# test-sp-repo

## Prerequisites

Test was run on Windows OS and IE 11
Java 1.8 and Maven 3 should be installed.

please set registry keys:
```
KLM_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main path should contain key TabProcGrowth with 0 value.
```
```
KEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE
```
For 64-bit Windows installations, the key is
```
HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE
```
Please note that the FEATURE_BFCACHE subkey may or may not be present, and should be created if it is not present.
Important: Inside this key, create a DWORD value named iexplore.exe with the value of 0.

Additionally, "Enhanced Protected Mode" must be disabled for IE 10 and higher. This option is found in the Advanced tab of the Internet Options dialog.

source https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration

Before test run go to test/java/features/ClaimsHandler.feature
and update this line with correct username and password
When user log in to https://supplier01.scalepoint.com/eccAdmin/gb/login.action with username set_user_here and password set_password_here

## Test run

To run test type in command line
```
mvn clean test
```

## Report

To generate report Allure Test Report plugin is used
after tests run type in command line
```
mvn site
```
report will be generated in
```
target/site/allure-maven-plugin/index.html
```
to run it in jetty type
```
mvn jetty:run
```
and open localhost:8080

screenshots are saved in target/screenshot/*
and are also attached in report for failed tests