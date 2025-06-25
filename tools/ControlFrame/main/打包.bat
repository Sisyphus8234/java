@echo off
call mvn clean compile assembly:single -DskipTests -s s.xml

if %errorlevel% neq 0 (
    echo ❌ Maven 构建失败，按任意键查看错误信息...
    pause
    exit /b
)

copy /y "target\run-1.0-jar-with-dependencies.jar" "run-1.0-jar-with-dependencies.jar"

::pause
