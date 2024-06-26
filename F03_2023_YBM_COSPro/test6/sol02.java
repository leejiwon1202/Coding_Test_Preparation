package test6;

//다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class sol02 {
 public int solution(int K, String[] words) {
     // 여기에 코드를 작성해주세요.
     int answer = 1;
     int limit = 10;
     
     ArrayList<Integer> arr = new ArrayList<>();
     
     for(String s : words) {
    	 if(s.length() <= limit)
    		 limit -= (s.length() + 1);
    	 else {
    		 answer++;
    		 limit = K - (s.length() - 1);
    	 }
     }
    
     
     return answer;
 }

 // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
 public static void main(String[] args) {
	 sol02 sol = new sol02();
     int K = 10;
     String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
     int ret = sol.solution(K, words);

     // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
     System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
 }
}