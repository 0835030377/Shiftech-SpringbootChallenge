# Shiftech-SpringbootChallenge

## What is this 

This is a  Springboot backend application, its main functionality is to capture credit cards , validate them and store them in a temporally storage in Springboot backed using Angular 10 User interface

Requirements
You need java  on your machine, Eclipes or IntelliJ code to import the Springboot project and access the code.



## Development server and Testing

Right click on main  class ShifTechAssessmentChallengeApplication.java , run as a java application , embedded tomcat server will be up at localhost:8080. To test run Angular frontend OR test the Rest APIs separatey by navigating to http POST request http://localhost:8080/creditcards to add Credit Cards AND http GET request  http://localhost:8080/creditcards/getAllcreditcards to get all captured credit cards. Note that you will have to capture cards first in order to to them since the backend is using temporaly storage .
