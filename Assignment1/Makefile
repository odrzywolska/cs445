default: compile

compile: 
	javac ./src/*.java 
	javac -cp ./src:/usr/share/java/junit4.jar ./test/*.java

run: 
	java -cp src TestCreature

JUnitTest:
	java -cp ./src:./test:/usr/share/java/junit4.jar org.junit.runner.JUnitCore AntTest BatTest FlyTest ThingTest TigerTest

clean: 
	$(RM) ./src/*.class
	$(RM) ./test/*.class
