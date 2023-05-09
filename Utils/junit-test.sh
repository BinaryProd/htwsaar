#!/bin/bash

# Find the latest directory
latest_dir=$(ls -td -- */ | head -n 1)

# Run JUnit tests in the latest directory
java -cp .:Utils/junit-platform-console-standalone-1.9.2.jar \
    --scan-class-path \
    --details=tree \
    --disable-ansi-colors \
    --fail-if-no-tests \
    --fail-on-severe \
    --fail-on-warnings \
    --exclude-engine=junit-vintage \
    org.junit.platform.console.ConsoleLauncher \
    --class-path "${latest_dir}" \
    --scan-class-path
