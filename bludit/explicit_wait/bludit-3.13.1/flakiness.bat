@echo off
setlocal enabledelayedexpansion

REM ======= NUMBER OF EXECUTIONS ==========
set n=50

for /L %%i in (1,1,%n%) do (
    echo.
    echo [ESECUZIONE %%i DI %n%]

    timeout /t 5 /nobreak >nul

    echo Starting Bludit container...
    docker run --name bludit -p 8080:80 -d bludit/docker:3.13.1

    timeout /t 10 /nobreak >nul

    echo Running tests with Maven...
    mvn -Dtest=TestSuite test

    echo Saving results...
    mkdir "..\..\..\..\flakycheck\bludit-3.13.1\java21-selenium435-chrome127native-2\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\bludit-3.13.1\java21-selenium435-chrome127native-2\%%i\"
    move "*.html" "..\..\..\..\flakycheck\bludit-3.13.1\java21-selenium435-chrome127native-2\%%i\"

    echo Stopping and removing Docker containers...
    docker stop bludit >nul
    docker rm bludit >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETED =======
pause
