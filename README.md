#Restapi
This is auto tests for rest api integration testing

##Run restapi tests
mvn clean test

##Run restapi tests under another environment
mvn clean test -Drestassured.baseUrl=<url>

#Settings
##### hostUrl
Please setup your base url: src/test/resources/application.properties file contains default settings

#Webapi

#This is Hellofresh challenge for UI testing

This is an application to test http://automationpractice.com
This application repeats user behavior via browser API

##Getting started
- Install Java 8.1
- Install maven 3.2.5
- Set account environment variables JAVA_HOME, M2_HOME
- Install Idea plugin "Cucumber plugin for java": Settings/Pluggins/Brouse repositories/Cucumber plugin for java
- Install Idea plugin "Lombok plugin": Settings/Pluggins/Brouse repositories/Lombok plugin for java
- Set Settings/Build/Compiller/Enable Annotation processing
 
##Setup driver properties
To be able to run tests please add paths to drivers on your local machine at src/test/resources/application.properties file
 - webdriver.chrome.driver
 - webdriver.gecko.driver
 - webdriver.ie.driver
 
##Setup default properties
To run tests by default you can set properties at src/test/resources/application.properties file
##### hostUrl
selenide.baseUrl
##### what browser to test (ex: chrome, firefox, ie)
selenide.browser

##Run tests mvn
mvn clean test

##Run test JUnitRunner in IDEA
If you lucky enough then IDEA will create runner for you just go to BigTestRunner.class and click run button
Go to Run/Debug configuration 
1. set Class: choose one of the runners from test/java/runners (like BigTestRunner)
2. set classPath webtest
3. set working directory $MODULE_DIR$

##Report
report path: /target/cucumber-report/smoketest/index.html
*screen shots will appear only on failed step inside the report 

