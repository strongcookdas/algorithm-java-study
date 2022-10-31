package week5.brute_force;

//1. 3명의 student 학생의 답안 형식을 배열로 선언
//2. 2중 for문 사용 3번 반복하고 답안의 길이만금 비교
//3. 맞으면 count++해준다.
//4. count한 것을 answer 배열에 저장
//6. answer 배열은 객체배열 (student 번호, count 필드가 있는 객체)
//7. count를 기준으로 배열 정렬
//8. 정렬된 학생 번호는 1차원 배열에 다시 저장

public class PrepareTest {
    public int solution(int[] problem){
        int[] student1 = {1,2,3,4,5};
        int count = 0;
        for (int i = 0; i < problem.length; i++) {
            if(problem[i]==student1[i%student1.length]){
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        PrepareTest test = new PrepareTest();
        int[] problem = {1,2,3,4,5,1,2,5,1};
        System.out.println(test.solution(problem));
    }
}
