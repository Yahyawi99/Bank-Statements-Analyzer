
# output directory for compiled classes
mkdir -p out

# Define the classpath
CP="lib/*:src/main/java"

echo "Compiling..."
javac -cp "$CP" src/main/java/*.java src/test/java/*.java -d out

if [ $? -eq 0 ]; then
    echo "Compilation successful. Running tests..."
    java -jar lib/junit-platform-console-standalone-1.10.0.jar --class-path out --scan-class-path
else
    echo "Compilation failed."
fi