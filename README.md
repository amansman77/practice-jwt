# JWT활용 예제

## 목표
JWT를 활용한 인증 방식을 활용할 때의 Rest API의 구조를 잡아본다.

## JWT란
[IETF RFC7519](https://tools.ietf.org/html/rfc7519)에 기반한 표준으로 상호 데이터 전송시 간편하고 안전하게 할 수 있도록 하는 기술입니다.

JWT의 경우 제 3자에게 탈최당한 경우에 대한 보안에 취약하기 때문에 Access Token & Refresh Token 방식을 활용합니다.[쉽게 알아보는 서버 인증 2편(Access Token + Refresh Token) - 자유로운 오랑우탄](https://tansfil.tistory.com/59)

여기서는 Access Token만 사용하는 방식을 활용해봅니다.

## 개발 프레임워크
- IDE : STS-4.2.2.RELEASE
- Java : openjdk 12.0.1
- Spring Boot : 2.1.7
- Gradle : 5.6
 
## 스타일
- Http header의 Authorization 필드에 Bearer 타입으로 토큰 전송
- 토큰에 대한 발급과 갱신만 제공하고 제거 기능은 제공하지 않음
    - 서버에서는 token정보를 저장하지 않기 때문에 클라이언트에서 token을 제거하면 동일한 기능으로 동작하기 때문

## 참고 문헌
- [JWT site](https://jwt.io/)
- [JWT(JSON Web Token)로 로그인 REST API 만들기  - A MEAN blog](https://www.a-mean-blog.com/ko/blog/Node-JS-API/_/JWT-JSON-Web-Token-%EB%A1%9C-%EB%A1%9C%EA%B7%B8%EC%9D%B8-REST-API-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- [JWT를 구현하면서 마주치게 되는 고민들 - Swalloow blog](https://swalloow.github.io/implement-jwt)