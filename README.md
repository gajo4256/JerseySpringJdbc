# JerseySpringJdbc
Jersey 2.x with Spring xml configuration

Sample project with Jersey framework and Spring JDBC together xml.

MySQL is database used in project, but can be easily changed with different DB dependency in `pom.xml`.
If DB dependency is changed, you have to change `applicationContext.xml` accordingly.

Run with `mvn package` and it will generate .war file that can be deployed to server container.

