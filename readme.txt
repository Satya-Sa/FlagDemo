Import the continets.json.txt as is to the mongodb and name the collection as continents

Run the spring boot app with below command

	mvn spring-boot:run 
	
1) Swagger UI 
http://localhost:8080/swagger-ui.html

2) Actuator 
http://localhost:8080/actuator

3) Get Continents
http://localhost:8080/getContinents

4) Get Countries by continent Id as path variable
http://localhost:8080/getCountries/America

5) Get Countries and flags by comma separated countries
http://localhost:8080/getFlags?countries=Nigeria,Brazil



