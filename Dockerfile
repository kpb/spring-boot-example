FROM gradle:6.8.2-jdk11 as gradle-builder
WORKDIR /home/gradle
COPY . project
WORKDIR project
RUN gradle build
RUN java -Djarmode=layertools -jar build/libs/spring-boot-example-*.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
ARG BUILD_DIR=/home/gradle/project
COPY --from=gradle-builder $BUILD_DIR/dependencies/ ./
COPY --from=gradle-builder $BUILD_DIR/spring-boot-loader/ ./
COPY --from=gradle-builder $BUILD_DIR/snapshot-dependencies/ ./
COPY --from=gradle-builder $BUILD_DIR/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
EXPOSE 8090
