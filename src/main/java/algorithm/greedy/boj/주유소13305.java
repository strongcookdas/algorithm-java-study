package algorithm.greedy.boj;

import java.util.*;
import java.io.*;
import java.math.*;

public class 주유소13305 {

    City[] arr;

    static class City {
        BigInteger capacity;
        BigInteger distance;

        public City(String c, String d) {
            this.capacity = new BigInteger(c);
            this.distance = new BigInteger(d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] dis = new String[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dis[i] = st.nextToken();
        }

        주유소13305 main = new 주유소13305();
        main.arr = new City[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                main.arr[i] = new City(st.nextToken(), dis[i]);
            } else {
                main.arr[i] = new City(st.nextToken(), "0");
            }
        }

        System.out.println(main.solution());
    }

    private String solution() {
        BigInteger cost = arr[0].capacity.multiply(arr[0].distance);
        BigInteger min = arr[0].capacity;
        for(int i = 1; i<arr.length; i++){
            if(arr[i].capacity.compareTo(min)<0){
                min = arr[i].capacity;
            }
            BigInteger total = min.multiply(arr[i].distance);
            cost = cost.add(total);
        }
        return cost.toString();
    }
}
