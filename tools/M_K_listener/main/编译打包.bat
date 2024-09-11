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

del java.txt
dir /s /b *.java > java.txt

::/S 是代表删除所有子目录跟其中的档案 
::/Q 是不要它在删除档案或目录时，不再问我 Yes or No 的动作
if exist classfiles (
    rmdir /s /q classfiles
)
mkdir classfiles

%MyJavaPath%\javac -d .\classfiles @java.txt -encoding UTF-8 -cp ".;.\lib\*"




if exist run.jar (
    del run.jar
)



cd classfiles

@echo off
chcp 65001 > nul

setlocal enabledelayedexpansion

rem 获取当前目录的绝对路径
for %%I in ("%cd%") do set "current_path=%%~fI"

rem 清空或创建一个新的文本文件
echo. > class.txt

rem 遍历当前目录下的所有 .class 文件
for /r %%F in (*.class) do (
    rem 获取文件的绝对路径
    set "absolute_path=%%~fF"
    rem 将绝对路径转换为相对路径
    set "relative_path=!absolute_path:%current_path%\=!"
    rem 将相对路径写入文本文件
    echo !relative_path! >> class.txt
)

echo 相对路径已保存到 class.txt 文件中。

endlocal

IF "%MyJavaPath%"=="" (
    jar cfm ..\run.jar ..\META-INF\MANIFEST.MF @class.txt
) ELSE (
    ..\%MyJavaPath%\jar cfm ..\run.jar ..\META-INF\MANIFEST.MF @class.txt
)

:: cd ..
:: %MyJavaPath%\java -jar run.jar

:: pause