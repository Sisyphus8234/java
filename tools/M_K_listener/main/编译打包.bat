@echo off
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"

set /p MyJavaPath=<MyJavaPath.txt



::/Y 表示强制复制
::/E 表示复制子文件夹和文件。
::/C 允许继续复制，即使出现错误。
::/I 如果目标不存在并且是一个目录，则会创建它。
::/H 包括隐藏文件和系统文件。
::/K 保留源文件夹的只读属性。
xcopy /y/i base\lib\* lib\
xcopy /y/i addition\lib\* lib\
xcopy /y/i custom\lib\* lib\





::/S 是代表删除所有子目录跟其中的档案 
::/Q 是不要它在删除档案或目录时，不再问我 Yes or No 的动作
if exist META-INF (
    rmdir /s /q META-INF
)
mkdir META-INF

setlocal enabledelayedexpansion
set "ClassPath="

for %%i in (lib\*.jar) do (
    set "ClassPath=!ClassPath!lib\%%~nxi "
)

(
  echo Main-Class: base.MainClass
  echo Class-Path: !ClassPath!
) > META-INF\MANIFEST.MF

endlocal





::/S 是代表删除所有子目录跟其中的档案 
::/Q 是不要它在删除档案或目录时，不再问我 Yes or No 的动作
if exist classfiles (
    rmdir /s /q classfiles
)
mkdir classfiles

%MyJavaPath%javac -d .\classfiles base\*.java addition\*.java custom\*.java -encoding UTF-8 -cp ".;.\lib\*"

if exist run.jar (
    del run.jar
)

cd classfiles
IF "%MyJavaPath%"=="" (
    jar cfm ..\run.jar ..\META-INF\MANIFEST.MF base\*.class addition\*.class custom\*.class
) ELSE (
    ..\%MyJavaPath%jar cfm ..\run.jar ..\META-INF\MANIFEST.MF base\*.class addition\*.class custom\*.class
)

:: cd ..
:: %MyJavaPath%java -jar run.jar