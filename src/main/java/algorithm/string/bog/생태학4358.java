package algorithm.string.bog;

import java.util.*;
import java.io.*;

public class 생태학4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        int totalCount = 0;

        while (true) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            totalCount++;

            input = br.readLine();
            if (input == null) {
                break;
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            double value = ((double) map.get(key) / totalCount) * 100;
            bw.write(String.format("%s %.4f\n", key, value));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
