#!/bin/bash

javac database/*.java
javac models/*.java
javac utils/*.java
javac JavaApp.java
#java -classpath mysql-connector.jar:. JavaApp