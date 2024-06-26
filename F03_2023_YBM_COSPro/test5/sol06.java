package test5;

//다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class sol06 {	
 public String solution(String s1, String s2, int p, int q) {
     // 여기에 코드를 작성해주세요.
     String answer = "";
     
     int sum = 0;
     for(int i=0; i<s1.length(); i++) {
    	 int a = s1.charAt(i) - 48;
    	 sum += Math.pow(p, s1.length() - 1 - i) * a ;
     }
     for(int i=0; i<s2.length(); i++) {
    	 int a = s2.charAt(i) - 48;
    	 sum += Math.pow(p, s2.length() - 1 - i) * a ;
     }
     
     while(sum > 0) {
    	 answer = Integer.toString(sum % q) + answer;
    	 sum /= q;
     }
     
     return answer;
 }
 
 // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.	
 public static void main(String[] args) {
	 sol06 sol = new sol06();
 	String s1 = new String("112001");
     String s2 = new String("12010");
     int p = 3;
     int q = 8;
 	String ret = sol.solution(s1, s2, p, q);
 	
     // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
     System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
}
}