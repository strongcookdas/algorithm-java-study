package algorithm.Like_lion.week9.algorithm_1128;

public class AlphabetCombination2 {

    int length = 0;

    public void solution(String prefix) {
        if (prefix.length() > this.length - 1) {
            System.out.println(prefix);
            return;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            solution(prefix + c);
        }
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String[] args) {
        AlphabetCombination2 ac = new AlphabetCombination2();
        ac.setLength(3);
        ac.solution("");
    }


}
