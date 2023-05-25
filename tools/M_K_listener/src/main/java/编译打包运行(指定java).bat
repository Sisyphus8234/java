:: /s 是代表删除所有子目录跟其中的档案 /q是不要它在删除档案或目录时，不再问我 Yes or No 的动作
rmdir /s/q classfiles
mkdir classfiles

javac -d .\classfiles *.java -encoding UTF-8 -cp ".;.\lib\*"

cd classfiles

del run.jar
jar cfm ..\run.jar ..\META-INF\MANIFEST.MF *.class

cd ..

set /p MyJavaPath=<MyJavaPath.txt
%MyJavaPath%\java -jar run.jar