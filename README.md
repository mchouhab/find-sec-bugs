# Forked of the find-sec-bugs project
This fork attempts to add Java OpenJDK defects to the list of current bug patterns for memory errors detection

# List of Added JVM Defects

/plugin/src/test/java/testcode/EADataCorruption.java

/plugin/src/test/java/testcode/JDK6367889.java

/plugin/src/test/java/testcode/JDK6795161.java

/plugin/src/test/java/testcode/JDK6799693.java

/plugin/src/test/java/testcode/JDK6914126.java

/plugin/src/test/java/testcode/JDK7013538.java

/plugin/src/test/java/testcode/JDK8049107.java

/plugin/src/test/java/testcode/JDK8067258.java

/plugin/src/test/java/testcode/JDK8086046.java

/plugin/src/test/java/testcode/JDK8130847.java

# Eclipse Setup Instructions

https://github.com/find-sec-bugs/find-sec-bugs/wiki/Eclipse-Tutorial

# Compiling Instructions

https://github.com/find-sec-bugs/find-sec-bugs/wiki/Compiling

1- Clone project

2- Run maven: In Eclipse -> /plugin/pom.xml -> Run As -> Run Configuration -> [Goals: clean install -Dlicense.skip=true] -> Run

3- After build is successful, copy generated plugin jar from /plugin/target folder to any folder

4- Add generated jar to Eclipse SpotBugs plugin from the Eclipse -> Window -> Preferences -> SpotBugs -> 'Plugins and misc. Settings' tab

5- Verify new detectors are added to the 'Detector Configuration' tab

6- Scan Code using the improved Plugin with new detectors 


# Link to SpotBugs Manual

https://spotbugs.readthedocs.io/en/stable/

## Screenshots

### Eclipse

![Eclipse](http://find-sec-bugs.github.io/images/screens/eclipse.png)

### IntelliJ / Android Studio

![IntelliJ](http://find-sec-bugs.github.io/images/screens/intellij.png)

### SonarQube

![SonarQube](http://find-sec-bugs.github.io/images/screens/sonar.png)

## License

This software is release under [LGPL](http://www.gnu.org/licenses/lgpl.html).
