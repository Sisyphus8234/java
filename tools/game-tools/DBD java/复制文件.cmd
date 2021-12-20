::设置编码utf-8
chcp 65001

:: /s 是代表删除所有子目录跟其中的档案 /q是不要它在删除档案或目录时，不再问我 Yes or No 的动作
rmdir /s/q out

mkdir out

:: /e复制目录和子目录，包括空的 /y强制复制
xcopy /e/y ..\..\M_K_listener\src\main\java out

xcopy /y Functions.java out

mkdir lib out
xcopy /e lib out\lib\

mkdir META-INF
xcopy /e META-INF\ out\META-INF\

xcopy 编译打包运行.bat out