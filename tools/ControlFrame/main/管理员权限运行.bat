@echo off
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"



set /p java_path=<java_path.txt


start %java_path%javaw -jar run-1.0-jar-with-dependencies.jar
