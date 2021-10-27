mkdir classfiles

javac -d .\classfiles *.java -encoding UTF-8 -cp ".;.\lib\*"

cd classfiles

jar cfm ..\run.jar ..\META-INF\MANIFEST.MF *.class

cd ..

java -jar run.jar