#!/bin/bash

n=50

for ((i=1; i<=n; i++)); do
    echo
    echo "[ESECUZIONE $i DI $n]"

    sleep 5

    echo "Starting Bludit container..."
    docker run --name bludit -p 8080:80 -d bludit/docker:3.13.1

    sleep 10

    echo "Running tests with Maven..."
    mvn -Dtest=TestSuite test

    echo "Saving results..."
    target_dir="../../../../flakycheck/bludit-3.13.1/java21-selenium435-chrome127native-2/$i"
    mkdir -p "$target_dir"
    cp -R target/surefire-reports/* "$target_dir/"

    echo "Stopping and removing Docker container..."
    docker stop bludit >/dev/null
    docker rm bludit >/dev/null

    sleep 5
done

echo
echo "======= COMPLETED ======="
