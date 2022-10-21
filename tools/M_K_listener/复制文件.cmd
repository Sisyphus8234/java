::设置编码utf-8
chcp 65001

:: 等待输入
set /p input=

:: /s 是代表删除所有子目录跟其中的档案 /q是不要它在删除档案或目录时，不再问我 Yes or No 的动作
rmdir /s/q out

mkdir out

:: /e复制目录和子目录，包括空的 /y强制复制
xcopy /e/y src\main\java out\

xcopy /y resources\* out\

xcopy /y %input%\Functions.java out\

xcopy /y %input%\Config.properties out\