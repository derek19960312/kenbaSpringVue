FROM openjdk:8-jdk-alpine
# # 加入bash功能
# RUN apk add --no-cache bash
# # 將檢測MySQL是否Ready的腳本加入
# COPY wait-for-it.sh /wait-for-it.sh
# # 調整權限
# RUN chmod +x /wait-for-it.sh
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080