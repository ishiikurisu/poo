clear
cd src
javac Main.java || exit 1
mv *.class ../bin
cd ..
sh main.sh || exit 2
# clear
