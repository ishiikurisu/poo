cd src
javac Main.java || exit 1
mv ../bin *.class
cd ../bin
java Main || exit 2
rm *.class
cd ..
exit 0
