1) check the project 
2) import the project to the workspace in Eclipse 
3) in the file "application.property" 
	- jdbc.url = jdbc:mysql://localhost:3306/realestate?useSSL=false
	- jdbc.username = root
	- jdbc.password = root
	- hibernate.dialect = org.hibernate.dia
	
	* base on this configuration you need to create the database name "realestate".
	* the username is root (you can change if you want)
	* password is root. (you can change if you want)
4) add JUnit to Library 
5) update the project using maven
6) run the project on the server using "apache Tomcat 9" 
7) by default we initial 4 user in "initial_data.sql"
	"saler@mum.edu" password : "123" , role: "saler"
	"buyer@mum.edu" password : "123" , role: "buyer"
	"agent@mum.edu" password : "123" , role: "agent"
	"admin@mum.edu" password : "123" , role: "admin"

8) all the doc files are in src/doc folder