:: /s 是代表删除所有子目录跟其中的档案 /q是不要它在删除档案或目录时，不再问我 Yes or No 的动作
rmdir /s/q out

mkdir classfiles

javac -d .\classfiles *.java -encoding UTF-8 -cp ".;.\lib\*"

cd classfiles

jar cfm ..\run.jar ..\META-INF\MANIFEST.MF *.class

cd ..

java -jar run.jar