### 문자열 문제 풀 때 알면 좋은 함수

- String
    - length() 문자 길이 반환
    - toUpperCase(), toLowerCase() 대소문자 변환
    - toCharArray() String → char 배열
    - replace(char c, char c) 문자 대체
    - replaceAll(정규식, string s) 정규식으로 문자 대체
    - substring(int index, int index) 문자열 자르기
    - substring(int index) 시작점부터 끝까지 문자열 자르기
    - split() 문자열 자르기 return String[] 
- StringBuilder
    - reverse() 문자열 뒤집기
    - append(String s) 객체 생성하지 않고 문자열 이어붙이기
- Integer
    - parseInt(String s) 문자열을 숫자로
    - parseInt(String s, 2) 이진수를 십진수로
- Character
    - isLowerCase(char c), isUpperCase(char c) 대소문자 확인
    - toLowerCase(char c), toUpperCase(char c) 대소문자 변환
- 정규식
  - [^A-Z] 대문자 영어가 아닌 문자들

### 다시 풀어볼 문제
- 인프런
  - 중복문자제거
  - 팰린드롬