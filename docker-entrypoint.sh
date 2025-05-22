#!/bin/bash
set -e

echo "🚀 Starting Spring Boot + Auto-Compile Dev Mode"

# Stores a hash of all source files
hash_sources() {
  find src/main/java -type f -name "*.java" -exec sha1sum {} \; | sha1sum
}

# Initial hash
last_hash=""

# Start Spring Boot in the background
./mvnw spring-boot:run -Dspring-boot.run.fork=false &
APP_PID=$!

# Compile loop
while true; do
  current_hash=$(hash_sources)

  if [ "$current_hash" != "$last_hash" ]; then
    echo "🔁 Detected change — running mvn compile"
    ./mvnw compile
    last_hash="$current_hash"
  fi

  sleep 2
done
