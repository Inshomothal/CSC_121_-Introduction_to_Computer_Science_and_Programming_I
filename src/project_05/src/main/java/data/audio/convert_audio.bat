@echo off
setlocal enabledelayedexpansion

set "STATE=last_converted.txt"
set "EXT_IN=mp4"
set "EXT_OUT=wav"
set "RATE=44100"
set "CHAN=2"

rem Read last converted number (default 0 if missing)
set "LAST=0"
if exist "%STATE%" (
    set /p LAST=<"%STATE%"
)

echo Last converted: %LAST%

for %%F in (*.%EXT_IN%) do (
    set "NAME=%%~nF"
    rem skip if name is not numeric
    set "SAFE_NAME=!NAME:(=^(!"
    set "SAFE_NAME=!SAFE_NAME:)=^)!"
    echo(!SAFE_NAME!| findstr /r "^[0-9][0-9]*$" >nul
    if not errorlevel 1 (
        set /a NUM=!NAME!
        if !NUM! GTR !LAST! (
            echo Converting %%F ...
            ffmpeg -y -i "%%F" -ar %RATE% -ac %CHAN% -c:a pcm_s16le "%%~dpnF.%EXT_OUT%"
            if !ERRORLEVEL! EQU 0 (
                echo !NUM!>"%STATE%"
                set "LAST=!NUM!"
            ) else (
                echo Failed on %%F, stopping.
                goto :end
            )
        )
    )
)

:end
echo Done. Last converted recorded in %STATE%
pause
endlocal
