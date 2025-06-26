::设置编码utf-8
chcp 65001

:: 等待输入
set /p input=
set OutDir=%input%Out

::/S 是代表删除所有子目录跟其中的档案 
::/Q 是不要它在删除档案或目录时，不再问我 Yes or No 的动作
if exist "%OutDir%" (
    rmdir /s /q "%OutDir%"
)

::/Y 表示强制复制
::/E 表示复制子文件夹和文件。
::/C 允许继续复制，即使出现错误。
::/I 如果目标不存在并且是一个目录，则会创建它。
::/H 包括隐藏文件和系统文件。
::/K 保留源文件夹的只读属性。

xcopy /e/y/i main %OutDir%\ /EXCLUDE:exclude.txt

xcopy /y/e/i %input% %OutDir%