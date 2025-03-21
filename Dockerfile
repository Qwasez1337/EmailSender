# Используем Maven-образ с OpenJDK 21 для сборки и запуска приложения в режиме разработки
FROM maven:3.9.4-eclipse-temurin-21
WORKDIR /app

# Копируем pom.xml для загрузки зависимостей (это ускоряет повторные сборки)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем исходный код (он будет переопределён volume-монтажом)
COPY src ./src

# По умолчанию выполняем сборку и запуск приложения
CMD ["mvn", "clean", "package", "spring-boot:run"]

