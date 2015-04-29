To compile code you will need maven.
If maven is not installed please run
    $sudo apt-get install maven

It is recommended to clean everything to not have any conflicts
    $mvn clean

To run test
    $mvn test

To build everything
    $mvn install

Running commands will be as such
    $./vin.sh command [ command_options [ arguments ] ]
    
Might need to chmod the vin.sh
    $chmod +x vin.sh
	
To start tomcat on localhost:8080
	$./tomcat/bin/startup.sh
	use any browser or REST client to access the service
	