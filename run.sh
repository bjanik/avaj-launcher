#!/bin/bash

find * -name "*.java" > sources.txt
javac -sourcepath . @sources.txt

java fr.bjanik.avaj_launcher.Simulation.Simulation $1