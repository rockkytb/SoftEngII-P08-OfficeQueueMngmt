# SoftEngII-P08-OfficeQueueMngmt
Office Queue Management solution by P08

Structure of our Application

"src/main/ui" Is the front-end, modify this using visual studio code
<br>
"src/main/java" Is the back-end, modify this using Eclipse or IntelliJ
<br>
"src/test" Is the folder for testing
<br>
"src/resources" Will contains data


## How to start back-end and connect to DB
<br>
1) after cloning project in intelliJ/Eclipse build the project using maven<br>
2) Run the file OfficeQueueMngmntFullStackApplication.java<br>
3) Be sure you get the last line like this: "Started OfficeQueueMngmntFullStackApplication in 4.737 seconds (JVM running for 5.555)"<br>
4) Connect to http://localhost:8080/h2-console <br>
5) In JDBC URL write: jdbc:h2:file:./database <br>
6) Press connect <br>
7) You will see the database <br>
