# swed_b
The task. This is java 7 project that uses gradle as build tool.

Resources folder includes:
a) Decathlon_input.txt - test file for input
b) Decathlon_out.xml - sample of files produced by application
c) transform.xsl - sample style file for output xml

# Steps to run
1. Download or clone the porject code.
2. Navigate to the project root.
3. Run 'gradlew build' -- this will build project together with application jar file under \build\libs folder.
4. Run application by navigating to \build\libs and enter java -jar Decathlon-1.0-SNAPSHOT.jar
5. Follow the instructions.

# Steps to run using gradle wrapper
1. Download or clone the porject code.
2. Navigate to the project root.
3. Run 'gradlew build execute -q'

# Run unit test using gradle
1. Navigate to the project root.
2. Run 'gradlew test'
3. \build\reports or \build\test-results should be populated.

