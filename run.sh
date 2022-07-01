#!/bin/sh

clear
javac -d compiled *.java
cd compiled
java Run
