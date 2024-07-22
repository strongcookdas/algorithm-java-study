package algorithm.bfs.boj;

import java.util.*;

public class 이모티콘14226 {
    static class Emoticon {
        int n;
        int clip;

        public Emoticon(int n, int clip) {
            this.n = n;
            this.clip = clip;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Emoticon emoticon = (Emoticon) o;
            return n == emoticon.n && clip == emoticon.clip;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, clip);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();

        이모티콘14226 main = new 이모티콘14226();
        System.out.println(main.bfs(N));
    }

    private int bfs(int n) {
        Queue<Emoticon> queue = new LinkedList<>();
        HashSet<Emoticon> visited = new HashSet<>();
        visited.add(new Emoticon(1, 0));
        queue.offer(new Emoticon(1, 0));
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Emoticon temp = queue.poll();
                if (temp.n == n) {
                    return time;
                }
                for (int j = 0; j < 3; j++) {
                    Emoticon emoticon;
                    if (j == 0) {
                        emoticon = new Emoticon(temp.n, temp.n);
                    } else if (j == 1) {
                        emoticon = new Emoticon(temp.n + temp.clip, temp.clip);
                    } else {
                        emoticon = new Emoticon(temp.n - 1, temp.clip);
                    }
                    if (!visited.contains(emoticon)) {
                        queue.offer(emoticon);
                        visited.add(emoticon);
                    }
                }
            }
            time++;
        }

        return time;
    }
}
