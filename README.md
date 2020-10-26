Prerequisites:
Webstorm, NodeJs, NPM, IntelliJ, Maven, Mysql-Workbench

In Mysql-Workbench setup a new connection with credentials from src/main/resources/application.properties
host: 127.0.0.1
port: 3306
username: admin
password: Capone123@

and Import LearningProject_atm.sql from project in Server -> Data import

In IntelliJ, open entire project, open Project Structure -> Modules and then set
src/main/java as Sources
src/test/java as Tests
src/main/resources as Resources
and then run mvn clean install

In Webstorm, open ang-src folder and run npm install in terminal






