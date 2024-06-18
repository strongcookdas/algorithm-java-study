package algorithm.math.boj;

import java.util.Scanner;

public class 나머지10430 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] inputs = kb.nextLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int C = Integer.parseInt(inputs[2]);

        System.out.println((A+B)%C);
        System.out.println(((A%C)+(B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);
    }
}
