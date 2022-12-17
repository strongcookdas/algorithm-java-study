package algorithm.Like_lion.week9.algorithm_1128;

public class AlphabetCombination {
//    public void solution() {
//        for (int i = 0; i < 26; i++) {
//            for (int j = 0; j < 26; j++) {
//                System.out.println((char) ('a' + i) + " " + (char) ('a' + j));
//            }
//        }
//    }

//    public void solution(int c){
//        System.out.println((char)c);
//        if(c=='z') return;
//        solution(c+1);
//    }

    public void alphabetCombination(char c, char prefix) {
        if (c > 'z') return;
        System.out.println(prefix + " " + c);
        alphabetCombination((char) (c + 1), prefix);
    }

    public void solution(char c) {
        if (c > 'z') return;
        alphabetCombination('a', c);
        solution((char) (c + 1));
    }

    public static void main(String[] args) {
        new AlphabetCombination().solution('a');
    }
}
