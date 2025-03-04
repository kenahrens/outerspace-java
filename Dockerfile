FROM maven:3-amazoncorretto-20 AS build
COPY ./ /usr/src/server
WORKDIR /usr/src/server
RUN mvn -q clean \
  && mvn -q -DskipTests package \
  && cp target/outerspace-*.jar /app.jar

FROM amazoncorretto:20

WORKDIR /usr/src/app
COPY --from=build /app.jar /usr/src/app/app.jar

ENV PORT=8080
EXPOSE $PORT

ENTRYPOINT [ "sh", "-c", "java -jar ./app.jar" ]