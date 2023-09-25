# spring-practice

![image](https://github.com/KATEKEITH/spring-practice/assets/46472768/10b25ad9-1b7d-4899-8f35-e6d956a9e23b)

## Rolling

트래픽을 점진적으로 구버전에서 새로운 버전으로 옮기는 방식이다.

## Layered Architecture

### 단점

Persistence에서 POJO Repository와 실제 인프라에 의존하는 기술이 섞여있는 Repository가 하나의 계층에 혼재되어 있다.

## Read Cache Strategy / Write Cache Strategy

### Look Aside + Write Around

데이터를 찾을때 우선 캐시에 저장된 데이터가 있는지 우선적으로 확인하는 전략.
만일 캐시에 데이터가 없으면 DB에서 조회함.

