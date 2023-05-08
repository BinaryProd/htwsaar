#!/bin/bash

# Find the latest directory
latest_dir=$(ls -td -- */ | head -n 1)

# Compile Java files in the latest directory
javac -cp .:Utils/junit-platform-console-standalone-1.9.2.jar "${latest_dir}"*.java
