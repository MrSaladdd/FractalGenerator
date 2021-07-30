echo off

REM Create a temp directory and move all test files into it
REM md temp
REM move *test.java temp

REM Clear the screen, then do the requested Xlint and Xdoclint runs
cls
"C:\Program Files\BlueJ\jdk\bin\javac.exe" -Xlint:unchecked,rawtypes *.java 
REM PAUSE
"C:\Program Files\BlueJ\jdk\bin\javac.exe" -Xdoclint:all *.java 

REM Move the files back and delete the now-empty directory
REM move temp\*.* .
REM rd temp
PAUSE