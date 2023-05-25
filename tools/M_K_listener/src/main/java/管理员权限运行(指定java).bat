@echo off
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"

set /p MyJavaPath=<MyJavaPath.txt
start  %MyJavaPath%\javaw -jar run.jar