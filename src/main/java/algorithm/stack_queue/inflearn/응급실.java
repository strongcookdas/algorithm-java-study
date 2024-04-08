package algorithm.stack_queue.inflearn;

import java.util.*;

/*
- 해당문제는 큐 말고도 정렬로 풀 수 있을 것 같았지만 같은 위험도를 가졌을 때 코드가 복잡해진다.
- 아.. 큐 1개로는 같은 위험도 구분하기 어려움...
- 큐 2개로 구현
- 이건 java다... 큐 두개 만들 필요없이 클래스로 구현하면 된다.. (다시 보면 클래스로 해결하도록)
 */
public class 응급실 {
    public static int solution(int n, int m, int[] arr) { // 다시
        int answer = 0;
        Queue<Integer> idxQueue = new LinkedList<>();
        Queue<Integer> riskQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            idxQueue.offer(i);
        }
        for (int i : arr) {
            riskQueue.offer(i);
        }
        int idx = -1;
        while (idx != m) {
            boolean check = false;
            for (Integer i : riskQueue) {
                if (riskQueue.peek() < i) {
                    idxQueue.offer(idxQueue.poll());
                    riskQueue.offer(riskQueue.poll());
                    check = true;
                    break;
                }
            }
            if (!check) {
                answer++;
                idx = idxQueue.poll();
                riskQueue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
