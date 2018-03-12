@echo off
start java -jar selenium-server-standalone-3.5.3.jar -role hub
timeout /t 5
REM start java -jar selenium-server-standalone.jar -role node -Dwebdriver.ie.driver=..\..\drivers\IEDriverServer.exe  -Dwebdriver.chrome.driver=..\..\drivers\chromedriver.exe -nodeConfig DefaultNode_LOCAL_WIN.json
REM java -Dwebdriver.gecko.driver=..\..\drivers\geckodriver.exe -jar selenium-server-standalone-3.0.1.jar -role node -hub http://localhost:4444/grid/register
REM java -Dwebdriver.gecko.driver=..\..\drivers\geckodriver.exe -jar selenium-server-standalone-3.5.3.jar -role node -hub http://localhost:4444/grid/register
REM java -jar selenium-server-standalone-3.4.0.jar -role node -nodeConfig DefaultNode_LOCAL_WIN.json 
java -Dwebdriver.gecko.driver=D:\Selenium\Drivers\geckodriver\geckodriver.exe -jar selenium-server-standalone-3.5.3.jar -role node