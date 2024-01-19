#### DB 환경

DB Server : MySql  
PORT : 3306  
계정ID : root  
계정PW : admin  

#### 개발 환경 

스프링부트 : 3.9.7 version  
Download link : https://dist.springsource.com/release/STS/3.9.7.RELEASE/dist/e4.10/spring-tool-suite-3.9.7.RELEASE-e4.10.0-win32-x86_64.zip  
JDK : 11 version  
Download Link : https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html  

#### 테스트 환경

MySql에서 기본적으로 제공해주는 'WORLD' 스키마에 'city' 테이블을 토대로 테스트를 진행했습니다.  
서버 실행 후, Swagger 페이지 http://localhost:8080/swagger-ui.html#/ 에서 기본적인 테스트가능합니다.  

#### AXON 서버

Docker없이 .jar을 다운받아서 바로 실행 할 수 있습니다.

https://download.axoniq.io/axonserver/AxonServer.zip

```
$ java -jar axonserver.jar
```


#### AXON 관련 테이블 생성 스크립트

기본적으로 아래와 같이 테이블을 생성해줘야 실행이 가능합니다.

drop table world.tokenentry ;  
drop table world.domainevententry ;  
drop table world.snapshot ;  

CREATE TABLE WORLD.TOKENENTRY (  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;processorName varchar(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;segment int NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;token blob,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tokenType varchar(255) DEFAULT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;timestamp varchar(255) DEFAULT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;owner varchar(255) DEFAULT null,  
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;primary key (processorName  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            ,segment)  
)  

CREATE TABLE world.DOMAINEVENTENTRY (  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;globalIndex int NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggregateIdentifier  VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sequenceNumber  BIGINT NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type  VARCHAR(255),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;eventIdentifier  VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;metaData VARCHAR(255) ,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payload VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payloadRevision  VARCHAR(255),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payloadType  VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;timestamp timestamp  ,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (globalIndex),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UNIQUE (aggregateIdentifier,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        sequenceNumber ),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UNIQUE (eventIdentifier)  
)

CREATE TABLE snapshot (  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggregateIdentifier VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sequenceNumber BIGINT NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;eventIdentifier VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;metaData  int,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payload  int NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payloadRevision VARCHAR(255),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;payloadType VARCHAR(255) NOT NULL,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (aggregateIdentifier,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;             sequenceNumber),  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UNIQUE (eventIdentifier)  
);
