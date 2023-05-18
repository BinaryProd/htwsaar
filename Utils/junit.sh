test_files=$(find . -name "*.java")

if [ "$USER" = "om3re" ]; then
    java -jar /home/om3re/.config/junit/junit-platform-console-standalone-1.9.2.jar --class-path . --scan-class-path
    exit 0
elif [ "$USER" = "idefux" ]; then
    java -jar /home/idefux/Dokumente/school/l2/semester2/programmierung2/exercice/Utils/junit/junit-platform-console-standalone-1.9.2.jar --class-path . --scan-class-path
    exit 0
fi
