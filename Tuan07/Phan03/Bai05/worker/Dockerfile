FROM openjdk:17
WORKDIR /app

# Tải thư viện cần thiết
ADD https://jdbc.postgresql.org/download/postgresql-42.7.3.jar postgresql.jar
ADD https://repo1.maven.org/maven2/redis/clients/jedis/5.1.0/jedis-5.1.0.jar jedis.jar

# Copy mã nguồn
COPY Worker.java .

# Biên dịch Java với classpath chứa jedis + postgres
RUN javac -cp ".:jedis.jar:postgresql.jar" Worker.java

# Chạy app
CMD ["java", "-cp", ".:jedis.jar:postgresql.jar", "Worker"]
