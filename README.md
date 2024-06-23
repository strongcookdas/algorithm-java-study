# 알고리즘

## 알고리즘 유형

- DFS
    - 탐색 유형
        - 전위 순회 : root - left - right (ex. +12)
        - 중위 순회 : left - root - right (ex. 1+2)
        - 후위 순회 : left - right - root (ex. 12+)
    - 고려할 사항
        - 배열의 원소를 조합해보면서 최적의 값을 찾는 문제에서 원소의 정렬 상태에 따라 시간 최적화가 다르게 나온다.
            - ex. dfs - 동전 교환
- BFS
    - 최단 거리 구할 때 주로 사용
- Greedy
- 다익스트라 알고리즘 (Dijkstra)
    - 특정 노드에서 모든 노드에 대한 최단 경로를 구할 때 사용
    - 가중치가 음수일 경우에는 사용할 수 없다.
    - n이 노드의 개수, e가 간선의 개수라면 O(e*n)
        - PriorityQueue 사용하면 O(ElonN)으로 해결
    - 참고
        - https://great-park.tistory.com/133
- Union & Find
    - 노드가 특정 그래프의 노드인지 아닌지 구분할 때 사용
- DP
    - 큰 문제를 작은 문제로 쪼개 해결
    - 냅색 알고리즘
        - 조합 최적화 문제
- 누적합
    - 수열의 연속되는 부분의 합을 구할 때 사용
    - 식 응용해서 푸는 문제 가끔 발견

## 자료구조

- ArrayList
    - index로 value 조회
    - 조회시 효율
    - 원소 추가, 삭제시 비효율
- LinkedList
    - 주소값으로 연결
    - 조회시 처음부터 끝까지 조회하면서 찾아감
    - 조회 비효율
    - 원소 추가, 삭제시 연결된 원소의 주소값만 변경하면 되기에 효율

## 자료구조 Method 정리

- ArrayList
    - remove(idx) 특정 인덱스 원소 삭제
    - add(idx, value) 특정 인덱스에 원소 추가
    - indexOf(value) 첫번째 value의 인덱스 반환 없으면 -1
    - size() 크기 반환
- 일반 배열
    - clone() 일반 배열 복사
- PriorityQueue
    - `import java.util.*;`
    - `new PriorityQueue<>()` 기본형 : 우선순위가 낮은 숫자가 먼저 poll
    - `new PriorityQueue<>(Collections.reverseOrder())` 우선순위가 높은 숫자가 먼저 poll
    - 나머지 메소드들은 큐와 비슷하다.
- Comparable Interface
    - 클래스의 기본 정렬 기준을 설정하는 인터페이스
    - Comparable Interface의 `compareTo` 메소드를 구현하여 정렬의 기준이 되는 메소드를 정의하여 사용
    - `compareTo`의 리턴값
        - 음수 리턴 (자리 유지)
        - 0 리턴 (자리 유지)
        - 양수 리턴 (자리 바꿈)

## Graph 표현 방법

- 인접 행렬
    - 노드가 많아지면 메모리 많이 사용
    - 메모리 제한에 주의
- 인접 리스트
    - 리스트로 노드 표현

## 공부하면 좋은 수학 지식

- 조합 및 순열
    - 파스칼의 삼각형
- 유클리드 호제법
- 모듈러 연산

## 주의 사항

- 반복문, 조건문의 조건이 복잡하게 구현되면 반례 케이스에 걸릴 확률 높아짐
    - 단순 명쾌한 코드를 작성하도록 연습이 필요

