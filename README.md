# 🧪 실무형 샌드박스 프로젝트

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.1.3-success?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-Multi--module-02303A?logo=gradle)

이 저장소는 실무 프로젝트의 구조와 코드를 **분석, 학습, 개선**하기 위한  
**샌드박스형 멀티모듈 프로젝트**입니다.  
**코드 재사용성 강화, 공통 모듈화, 리팩토링** 등을 중심으로 개발하며,  
**Gradle 멀티모듈 설계 경험 축적**을 주요 목적으로 합니다.

기존 실무 프로젝트는 API가 각각 개별 프로젝트로 존재해 관리 비용이 컸기 때문에,  
이를 **하나의 프로젝트로 통합하고 모듈화된 구조로 재설계**하는 데 목적이 있습니다.

📅 **프로젝트 시작일**: 2025년 6월 21일  
⏱ **목표 기간**: 약 1개월 (2025년 7월 21일까지)

---

## 🧱 프로젝트 구조

```
root-project/
    ├── gradle/
    ├── build.gradle
    ├── settings.gradle
    ├── api-common/ # 공통 유틸 모듈 (JAR만 생성됨)
        ├── src/
            ├── main/
                ├── java/
    ├── menu-api/ # 예: 메뉴 API 모듈(스프링부트 애플리케이션)
        ├── src/
            ├── main/
                ├── java/
                ├── resources/ 
    ├── file-api/ # 예: 파일 API 모듈(스프링부트 애플리케이션)
        ...
```
![image](https://github.com/user-attachments/assets/2023e60a-1027-46de-b307-96840c594744)

---

## 📦 모듈 설명

### ✅ `api-common` (공통 유틸 모듈)

- 공통적으로 사용하는 **유틸 클래스, 응답 템플릿, 예외 처리, Redis 연동 등** 포함
- **`bootJar` 비활성화**, **`jar`만 생성**하여 다른 모듈에서 의존성으로 참조
- 자체 실행은 불가, **컴파일 전용 의존성(`compileOnly`)**으로 설계
- **예: `CommonResponse`, `CommonErrorResponse`, 유효성 검사, Redis, Log 등**
- - 실제 런타임 시 필요한 라이브러리는 **서비스 모듈에서 명시**

> 📌 공통 모듈은 **중복을 줄이고 재사용을 극대화**하는 데 초점  
> 👉 비즈니스 로직은 서비스 모듈에서만 담당하도록 역할을 분리

---

### ✅ `api-service` (예: `menu-api`, `file-api` 등)

- 각 도메인에 따른 **Spring Boot 애플리케이션 모듈**
- `@SpringBootApplication`을 포함해 **독립 실행 가능**
- 필요한 의존성과 **`api-common` 모듈을 `implementation`으로 참조**
- 실제 API 요청을 처리하며 컨트롤러, 서비스, 도메인, 레포지토리 등 포함

---

## 📘 사용 기술

- Java 17
- Spring Boot 3.1.3
- Gradle (멀티모듈 구성)
- JPA
- Redis
- Validation
- Jasypt 등

---

## 🛠 주요 Gradle 설정

- 루트 `build.gradle`에서는 공통 플러그인 버전만 선언하고, `apply false` 처리
- 하위 모듈에서는 실제로 적용
- 공통 설정은 `subprojects` 블록에서 일괄 적용
- `api-common`은 실행 가능 JAR을 만들지 않고, `jar`만 활성화
- `api-service`는 일반 Spring Boot 애플리케이션으로 실행 가능
- gradle 설정은 루트에서 일괄적으로 관리(하위 모듈의 build.gradle에서는 최소한의 개별 설정만(querydsl 등))

---

## ✅ 프로젝트 구조 설계

- **모듈 별 책임과 역할이 명확**
- **공통 기능은 `api-common`에서만 관리**하고 JAR로 배포
- 서비스 모듈은 **비즈니스 로직 구현에 집중**
- **의존성 및 플러그인 설정을 루트에서 일괄 관리**
- 반복/중복 코드 제거, 빌드 속도 및 유지보수 효율성 향상
- 신규 API 추가 시에도 **모듈 추가만으로 손쉬운 확장 가능**

## 💡 개발 및 커밋 전략

- 공통 모듈, 유틸, 응답 객체 등은 기능 단위로 정리
- 새로운 모듈 혹은 기능 개발 시 **의미 있는 단위로 커밋**
- 하나의 모듈을 모두 완성한 뒤, 관련 파일들을 묶어 **단일 커밋**으로 정리하는 방식 사용

---

## 📌 향후 계획

- 공통 모듈 점진적 확장 (파일처리, 인증, 예외, 메시지처리 등)
- Swagger 설정 및 API 문서화 자동화
- 테스트 데이터 자동화 및 예외 처리 템플릿화
- 실무 프로젝트 구조에 가까운 샘플 API 완성

---

> 🔄 이 프로젝트는 학습과 개선을 반복하며 점차 완성도를 높여가는 실험용 저장소입니다.  
> 코드는 실무 구조를 반영하되, 자유롭게 테스트하고 리팩토링하는 것을 목적으로 합니다.
> ⚠️ 현재 구조는 단일 프로젝트 내부의 모듈화에 초점을 맞추고 있으며,
> MSA 환경에서의 API 서버 부하 분산 및 게이트웨이 처리 등은 고려하지 않았습니다.
> 관련 내용은 추후 필요 시 README에 별도 항목으로 추가 정리할 예정입니다.
