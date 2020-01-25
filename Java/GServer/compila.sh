#!/bin/bash -x
JRE=/usr/bin/javac
JLIBDIR=./jlib
JUNIT_HOME=$JLIBDIR/junit-4.13.jar
CLASSPATH=$JUNIT_HOME:.
${JRE} -cp $CLASSPATH GreetServer.java
${JRE} -cp $CLASSPATH GreetClient.java
${JRE} -cp $CLASSPATH EchoServer.java
${JRE} -cp $CLASSPATH myTest.java
${JRE} -cp $CLASSPATH TestRunner.java
