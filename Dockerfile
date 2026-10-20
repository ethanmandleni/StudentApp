# Step 1: Build the artifact using Maven 3.9.6 and Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
# Navigate into the subfolders before running the build command
RUN cd student-management/student-management && mvn clean package -DskipTests
# Step 2: Run the built JAR file using a slim Java 17 runtime
FROM eclipse-temurin:17-jre-alpine
# Copy the compiled jar from the nested target folder
COPY --from=build /student-management/student-management/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
