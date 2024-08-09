FROM amazoncorretto:17
COPY out/artifacts/WalletTestTask_jar/ WalletTestTask.jar
CMD ["java", "-jar", "/walletTestTask.jar"]