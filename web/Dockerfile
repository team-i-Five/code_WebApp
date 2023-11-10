#클라우드 환경
FROM ubuntu:22.04

# jar 저장할 디렉토리
WORKDIR /ifive_boot


# 작업파일 복사하고 ifive_boot에 복사
COPY  .  .

# 실행환경 설정
RUN apt update

RUN apt install openjdk-17-jre-headless -y

RUN apt install maven -y

RUN mvn package -Dmaven.test.skip=true

# 사용포트 
EXPOSE 8080

# nohub 실행 명령
ENTRYPOINT [ "java", "-jar", "/ifive_boot/target/demo-0.0.1-SNAPSHOT.jar" ]