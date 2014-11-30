clear
cd src
javac -d escola escola/Main.java
cd escola
cat inlet.in | java escola/Main > outlet.out
rm -rf escola
less outlet.out
rm *.in *.out
