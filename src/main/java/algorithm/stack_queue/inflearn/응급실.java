package algorithm.stack_queue.inflearn;

import java.util.*;

public class 응급실 {
    static class Person implements Comparable<Person> {
        int order;
        int priority;

        public Person(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }

        @Override
        public int compareTo(Person o) {
            return o.priority - this.priority;
        }
    }

    public static int solution(int n, int m, Person[] people) {
        Queue<Person> q = new LinkedList<>();
        for (Person p : people) q.offer(p);
        Arrays.sort(people);
        int order = 1;
        int idx = 0;
        while (people[idx].priority > q.peek().priority || q.peek().order != m) {
            if (q.peek().priority >= people[idx].priority) {
                q.poll();
                idx++;
                order++;
            } else q.offer(q.poll());
        }
        return order;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Person(i, scanner.nextInt());
        }
        System.out.println(solution(n, m, arr));
    }
}
