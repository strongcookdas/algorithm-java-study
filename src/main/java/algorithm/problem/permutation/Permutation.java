package algorithm.problem.permutation;

import java.util.Arrays;

/*
    순열
        1. 3P2를 구현
 */
public class Permutation {
    int[] arr = {0, 1, 2};
    boolean[] checkList = new boolean[arr.length];
    int r = 2;
    int[] result = new int[r];

    public void permutation(int depth) {
        // depth가 r일때 순열은 완성되며 출력한다.
        if (depth == r) System.out.println(Arrays.toString(this.result));
        else {
            for (int i = 0; i < arr.length; i++) {
                // checkList[i]가 true이면 이미 사욯한 숫자이기 때문에 continue를 한다.
                if (checkList[i] == true) continue;
                // result[depth]에 arr[i]에 해당하는 숫자를 넣는다.
                result[depth] = arr[i];
                // 사용한 숫자는 다시 사용할 수 없도록 해당 checkList에 true를 대입한다.
                checkList[i] = true;
                // result[depth]의 다음 인덱스로 옮기기 위해 depth+1을 permutation 매개변수로 넘긴다.
                permutation(depth + 1);
                // permutation 함수가 종료되었다는 것은 1가지 경우의 순열을 출력했다는 의미
                // checkList[i]의 값을 false로 대입하여 다음 경우의 순열을 만드는 준비를 한다.
                checkList[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation(0);
    }
}
