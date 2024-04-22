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
## 자료구조 Method 정리

- ArrayList
    - remove(idx) 특정 인덱스 원소 삭제
    - add(idx, value) 특정 인덱스에 원소 추가
    - indexOf(value) 첫번째 value의 인덱스 반환 없으면 -1
    - size() 크기 반환
- 일반 배열
  - clone() 일반 배열 복사

## Graph 표현 방법
- 인접 행렬 
  - 노드가 많아지면 메모리 많이 사용
- 인접 리스트
  - 리스트로 노드 표현

## 공부하면 좋은 수학 지식
- 조합 및 순열
  - 파스칼의 삼각형

