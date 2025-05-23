@echo off
title Spring Boot 打包与运行
color 0A

set JAVA_HOME="C:\Program Files\Java\jdk-17"
set PATH=%JAVA_HOME%\bin;%PATH%
set "TARGET_URL=http://localhost:8080/cl22771684/client/index.html#/login"


cd /d D:\software\idea\work\JavaWarehouse\server_code

echo 正在启动 JAR...
for %%i in (target\*.jar) do (
    echo 运行: %%i
    java -jar "%%i"
)

timeout /t 5 /nobreak >nul

start "" "http://localhost:8080/cl22771684/client/index.html#/login"


:OPEN_BROWSER
echo 正在打开浏览器访问: %TARGET_URL%
start "" "%TARGET_URL%"

echo

pause