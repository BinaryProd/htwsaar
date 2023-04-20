#!/bin/bash


# Function to check if a string contains a certain sentence
contains_sentence() {
    if [[ "$1" == *"$2"* ]]; then
        return 0
    else
        return 1
    fi
}

# Function to add a sentence to the first line of a file
add_sentence() {
    echo "$1" | cat - "$2" > temp && mv temp "$2"
}

# Check if a file or directory path is given as an argument
if [ -z "$1" ]; then
    echo "Usage: $0 <file or directory>"
    exit 1
fi

# Loop through all files in the directory or check the single file
if [ -d "$1" ]; then
    # Directory path given
    for file in "$1"/*; do
        if [ -f "$file" ]; then
            file_name=$(basename "$file")
            file_name_without_ext=$(echo "$file_name" | cut -f 1 -d '.')
            first_line=$(head -n 10 "$file")
            if ! contains_sentence "$first_line" "<h1> $file_name_without_ext </h1>"; then
                echo "Adding text to $file"
                add_sentence " */" "$file"
                add_sentence " * @since 2023-04-11" "$file"
                add_sentence " * @version 1.0." "$file"
                add_sentence " * @author Victor Plage and David Glaser" "$file"
                add_sentence " * " "$file"
                add_sentence " * <h1> $file_name_without_ext </h1>" "$file"
                add_sentence "/**" "$file"
            fi
        fi
    done
    echo "Finished processing all files in directory: $1"
else
    # Single file path given
    if [ -f "$1" ]; then
        file_name=$(basename "$1")
        file_name_without_ext=$(echo "$file_name" | cut -f 1 -d '.')
        first_line=$(head -n 10 "$1")
        if ! contains_sentence "$first_line" "<h1> $file_name_without_ext </h1>"; then
            echo "Adding text to $1"
            add_sentence " */" "$1"
            add_sentence " * @since 2023-04-11" "$1"
            add_sentence " * @version 1.0.0" "$1"
            add_sentence " * @author Victor Plage and David Glaser" "$1"
            add_sentence " * " "$1"
            add_sentence " * <h1> $file_name_without_ext </h1>" "$1"
            add_sentence "/**" "$1"
        fi
        echo "Finished processing file: $1"
    else
        echo "Error: File or directory not found: $1"
        exit 1
    fi
fi

