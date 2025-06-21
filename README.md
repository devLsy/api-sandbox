# 🧪 실무형 샌드박스 프로젝트

이 저장소는 실무 프로젝트의 구조와 코드를 **분석, 학습, 개선**하기 위한 **샌드박스형 멀티모듈 프로젝트**입니다.  
**코드 재사용성 강화, 공통 모듈화, 리팩토링** 등을 중심으로 개발하며, **Gradle 멀티모듈 설계 경험 축적**을 주요 목적으로 합니다.

---

## 🧱 프로젝트 구조


---

## 📦 모듈 설명

### ✅ `api-common` (공통 유틸 모듈)

- 공통적으로 사용하는 **유틸, 응답 템플릿, 에러 핸들링 클래스 등**을 정의
- **컴파일 전용 의존성(`compileOnly`)** 으로 설정되어 있음
- **Spring Boot 실행 불가**: `bootJar.enabled = false`
- 별도 실행은 하지 않고, **JAR로만 빌드하여 다른 모듈에서 참조**
- **예: `CommonResponse`, `CommonErrorResponse`, 유효성 검사, Redis, Log 등**

> `api-common`은 실행 주체가 아니기 때문에  
> 내부에서 사용하는 라이브러리(Spring WebMVC, Tomcat, Redis 등)는  
> 전부 `compileOnly`로 설정되어 있고, 실제 런타임 제공은 서비스 모듈에서 처리함.

---

### ✅ `api-service` (메인 서비스 모듈)

- `api-common`의 공통 유틸리티를 `implementation project(':api-common')`으로 참조
- `@SpringBootApplication` 진입점 포함
- 모든 의존성과 실행 책임을 갖고 있는 **실행 주체**
- 웹 애플리케이션으로서 동작하며 컨트롤러, 서비스, 도메인 구성

---

## 📘 사용 기술

- Java 17
- Spring Boot 3.1.3
- Gradle (멀티모듈 구성)
- JPA / Redis / Validation / Jasypt
- Lombok / Jackson
- SLF4J
- JUnit5
- Swagger / Docker 빌드용 Jib (선택적 사용)

---

## 🛠 주요 Gradle 설정

- 루트 `build.gradle`에서는 공통 플러그인 버전만 선언하고, `apply false` 처리
- 하위 모듈에서는 실제로 적용
- 공통 설정은 `subprojects` 블록에서 일괄 적용
- `api-common`은 실행 가능 JAR을 만들지 않고, `jar`만 활성화
- `api-service`는 일반 Spring Boot 애플리케이션으로 실행 가능

---

## 💡 개발 및 커밋 전략

- 공통 모듈, 유틸, 응답 객체 등은 기능 단위로 정리
- 새로운 모듈 혹은 기능 개발 시 **의미 있는 단위로 커밋**
- 하나의 모듈을 모두 완성한 뒤, 관련 파일들을 묶어 **단일 커밋**으로 정리하는 방식 사용
- 테스트는 JUnit + SpringBootTest 기반

---

## ✍️ 참고 사항

- `@Builder.Default`는 Builder 패턴으로 생성 시에도 **기본 값을 유지**하도록 설정할 수 있음
- `@NoArgsConstructor`는 Jackson의 역직렬화를 위해 필수로 필요한 경우가 있음
- `<?>` 와일드카드는 **읽기 전용 목적**으로 사용되며, `List<?>` 타입은 타입 추론은 불가능하지만 다양한 타입 수용 가능

---

## 📌 향후 계획

- 공통 모듈 점진적 확장 (파일처리, 인증, 예외, 메시지처리 등)
- Swagger 설정 및 API 문서화 자동화
- 테스트 데이터 자동화 및 예외 처리 템플릿화
- 실무 프로젝트 구조에 가까운 샘플 API 완성

---

> 🔄 이 프로젝트는 학습과 개선을 반복하며 점차 완성도를 높여가는 실험용 저장소입니다.  
> 코드는 실무 구조를 반영하되, 자유롭게 테스트하고 리팩토링하는 것을 목적으로 합니다.

