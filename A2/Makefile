default: compile

compile: 
	javac ./src/*.java 
	javac -cp ./src:/usr/share/java/junit4.jar ./test/*.java

JUnitTest:
	java -cp ./src:./test:/usr/share/java/junit4.jar org.junit.runner.JUnitCore ImprovedStringTokenizerTest
	java -cp ./src:./test:/usr/share/java/junit4.jar org.junit.runner.JUnitCore ImprovedRandomTest

clean: 
	$(RM) ./src/*.class
	$(RM) ./test/*.class