# Java ClearDB
This is a dummy example code to connect a Java client application to ClearDB in Bluemix

## Compile
```
javac -cp mysql-connector.jar com/duyhat/*.java
```
## Package:
```
jar -cfm clearTest.jar Manifest.text com/duyhat/*.class
```
## Run:
```
java -cp clearTest.jar com.duyhat.ClearRun

```
