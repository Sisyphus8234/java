::设置编码utf-8
chcp 65001

:: 等待输入
set /p input=
set OutDir=%input%Out

:: /s 是代表删除所有子目录跟其中的档案 /q是不要它在删除档案或目录时，不再问我 Yes or No 的动作
:: rmdir /s/q %OutDir%
:: mkdir %OutDir%

:: /e复制目录和子目录，包括空的 /y强制复制 /i表示如果目标目录不存在，将会被创建。
xcopy /e/y/i src\main\java %OutDir%\

xcopy /y Config.properties %OutDir%\
xcopy /y 1.png %OutDir%\

xcopy /y/i %input% %OutDir%