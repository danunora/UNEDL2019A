#!/bin/bash
JRE=./jdk-9/bin/java.exe
JLIBDIR=./jlib
JUNIT_HOME=$JLIBDIR/junit-4.10.jar
CLASSPATH=$JUNIT_HOME:.
CLASS="GreetServer"
$JRE -cp $CLASSPATH $CLASS $@
