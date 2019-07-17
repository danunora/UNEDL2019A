#!/bin/bash -x
JRE=./jdk-9/bin/javac.exe
JLIBDIR=./jlib
JUNIT_HOME=$JLIBDIR/junit-4.10.jar
CLASSPATH=$JUNIT_HOME:.
${JRE} -cp $CLASSPATH GreetServer.java
${JRE} -cp $CLASSPATH GreetClient.java
${JRE} -cp $CLASSPATH EchoServer.java
${JRE} -cp $CLASSPATH myTest.java
${JRE} -cp $CLASSPATH TestRunner.java
