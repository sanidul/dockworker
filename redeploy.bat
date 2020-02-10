docker rm -f dockworker
docker rmi com.dock/worker
call gradlew clean build
call docker build --build-arg JAR_FILE=build/libs/*.jar -t com.dock/worker .
call docker run -d -p 8080:8080 --network composenetwork --name dockworker com.dock/worker
pause