package algorithm.string.bog;

import java.util.*;

public class 로마숫자2608 {
    private HashMap<Character, Integer> map;
    private HashMap<Integer, Character> cMap;

    public 로마숫자2608() {
        this.map = new HashMap<>();
        this.cMap = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        cMap.put(1, 'I');
        cMap.put(5, 'V');
        cMap.put(10, 'X');
        cMap.put(50, 'L');
        cMap.put(100, 'C');
        cMap.put(500, 'D');
        cMap.put(1000, 'M');
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String A = kb.nextLine();
        String B = kb.nextLine();

        로마숫자2608 main = new 로마숫자2608();
        int a = main.toNum(A);
        int b = main.toNum(B);

        System.out.println(a + b);
        String answer = main.getRoma(a + b);
        System.out.println(answer);

    }

    private String getRoma(int i) {
        StringBuilder sb = new StringBuilder("");
        int div = 10;
        while (i > 0) {
            int num = i%div;
            i -= num;
            String roma = changeNum(num, div / 10);
            div *= 10;
            sb.insert(0, roma);
        }
        return sb.toString();
    }

    private String changeNum(int num, int div) {
        StringBuilder sb = new StringBuilder("");
        int tmp = num / div;
        if (tmp == 4) {
            sb.append(cMap.get(div));
            sb.append(cMap.get(5 * div));
        } else if (tmp == 9) {
            sb.append(cMap.get(div));
            sb.append(cMap.get(10 * div));
        } else {
            int r = tmp % 5;
            int d = tmp / 5;
            if (d == 1) {
                sb.append(cMap.get(5 * div));
            }
            while (r > 0) {
                sb.append(cMap.get(div));
                r--;
            }
        }
        return sb.toString();
    }

    private int toNum(String a) {
        int answer = 0;
        char[] arr = a.toCharArray();
        boolean[] ch = new boolean[arr.length];

        int count = 0;
        for (int i = 0; i < a.length() - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
                ch[i] = true;
            } else {
                if (count > 0) {
                    answer += map.get(arr[i]) * (count + 1);
                    count = 0;
                    ch[i] = true;
                }
            }
        }

        if (count > 0) {
            answer += map.get(arr[a.length() - 1]) * (count + 1);
            ch[a.length() - 1] = true;
        }

        for (int i = 0; i < a.length() - 1; i++) {
            if (ch[i] || ch[i + 1]) {
                continue;
            }
            int tmp1 = map.get(arr[i]);
            int tmp2 = map.get(arr[i + 1]);
            if (tmp2 > tmp1) {
                answer += (tmp2 - tmp1);
                ch[i] = true;
                ch[i + 1] = true;
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (ch[i]) {
                continue;
            }
            answer += map.get(arr[i]);
        }
        return answer;
    }
}
