# CityChallenge

A program using Spring Boot & Java (1.8 or above)
which determines if two cities are connected. Two cities are considered
connected if there’s a series of roads that can be traveled from one city
to another.

List of roads is available in a file. The file contains a list of city
pairs (one pair per line, comma separated), which indicates that there’s a
road between those cities.

The API respond with ‘yes’ if city1 is connected to city2,
’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response.

To run the project locally,  expected Maven is installed

Steps to run  
# mvn spring-boot:run

The API can be tested via API documentation available at 

http://localhost:8080/swagger-ui.html
