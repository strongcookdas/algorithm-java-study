package algorithm.string.programmers;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        String bStr = Integer.toBinaryString(n);
        char[] bNum = bStr.toCharArray();
        int idx = bStr.lastIndexOf("1");
        if (idx == -1) {
            return 0;
        }
        if (idx == 0) {
            return n * 2;
        }

        int swapIdx = -1;
        int count = 0;
        for (int i = idx; i >= 0; i--) {
            if (bNum[i] == '0') {
                bNum[i] = '1';
                swapIdx = i;
                break;
            } else {
                count++;
            }
        }

        String nextNum = String.valueOf(bNum);
        if (swapIdx == -1) {
            nextNum = bStr.substring(0, 1) + "0" + bStr.substring(1);
            swapIdx = 1;
        }

        bNum = nextNum.toCharArray();
        count--;
        for (int i = swapIdx + 1; i < bNum.length; i++) {
            if (bNum.length - i <= count) {
                bNum[i] = '1';
            } else {
                bNum[i] = '0';
            }
        }

        return Integer.parseInt(String.valueOf(bNum), 2);
    }
}
