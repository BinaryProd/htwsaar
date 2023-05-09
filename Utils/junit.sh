test_files=$(find . -name "*.java")

java -jar /home/om3re/.config/junit/junit-platform-console-standalone-1.9.2.jar --class-path . --scan-class-path

