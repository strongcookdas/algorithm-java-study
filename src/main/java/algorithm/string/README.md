# 문자열

## 문자열 문제 풀 때 알면 좋은 함수

- String
    - length() 문자 길이 반환
    - toUpperCase(), toLowerCase() 대소문자 변환
    - toCharArray() String → char 배열
    - replace(char c, char c) 문자 대체
    - replaceAll(정규식, string s) 정규식으로 문자 대체
    - substring(int index, int index) 문자열 자르기
    - substring(int index) 시작점부터 끝까지 문자열 자르기
    - split() 문자열 자르기 return String[]
    - startsWith() 특정 문자열로 시작되는지 체크
- StringBuilder
    - reverse() 문자열 뒤집기
    - append(String s) 객체 생성하지 않고 문자열 이어붙이기
- Integer
    - parseInt(String s) 문자열을 숫자로
    - parseInt(String s, 2) 이진수를 십진수로
    - toBinaryString() 십진수를 이진수로
- Character
    - isLowerCase(char c), isUpperCase(char c) 대소문자 확인
    - toLowerCase(char c), toUpperCase(char c) 대소문자 변환
- 정규식
    - [^A-Z] 대문자 영어가 아닌 문자들
    - [^0-9] 숫자가 아닌 문자들

## 문제 목록

### 백준

- 팰린드롬 8892 S1
- 생태학 4358 S2
- 팰린드롬만들기 1254 S2
- 안정적인 문자열 4889 S1
- IOIOI 5525 S1 *
- 사다리타기 | G5 | 2469 *
- 로마숫자 | G5 | 2608 | 1H *
- 크로스워드퍼즐쳐다보기 | S2 | 3005 | 30M
- 소수부분문자열 | S2 | 5636 | 1H *

### 프로그래머스

- 다음 큰 숫자

## 다시 풀어볼 문제

### 프로그래머스

- 다음 큰 숫자 : 혼자 풀긴 했는데 오래 걸림 && 비트 연산에 대해 공부 필요

### 인프런

- 가장 짧은 문자거리 *
- 문자열 압축 *
- 암호 *

### swea

- 팰린드롬

### 백준

- IOIOI : 아이디어 참고
- 로마숫자 : 검색없이 풀긴 했는데 더 간단한 방법이 있음, 오래 걸림
- 사다리타기 : 아이디어 참고
- 소수부분문자열 : 내 풀이 방법은 너무 비효율적이다.