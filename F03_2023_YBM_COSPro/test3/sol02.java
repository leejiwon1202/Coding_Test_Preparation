package test3;

import java.util.*;

public class sol02 {
    public boolean func_a(ArrayList<String> list, String s) {
		for (int i = 0; i < list.size(); i++)
			if (s.equals(list.get(i)))
				return true;
		return false;
	}

    public boolean func_b(String s) {
		int length = s.length();
		for (int i = 0; i < length / 2; i++)
			if (s.charAt(i) != s.charAt(length - i - 1))
				return false;
		return true;
	}
    
    public String func_c(ArrayList<String> palindromes, int k) {
        Collections.sort(palindromes, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        	// TODO Auto-generated method stub
        		if (o1.length() > o2.length())
        			return 1;
        		else if (o1.length() < o2.length())
        			return -1;
        		else {
        			return o1.compareTo(o2);
        			}
        		}
        });

        if (palindromes.size() < k)
        	return "NULL";
        else
        	return palindromes.get(k-1);
    }

    public String solution(String s, int k) {
        ArrayList<String> palindromes = new ArrayList<String>();
        int length = s.length();
        for (int startIdx = 0; startIdx < length; startIdx++) {
            for (int cnt = 1; cnt < length - startIdx + 1; cnt++) {
                String subStr = s.substring(startIdx, startIdx + cnt);
                if (func_b(subStr)) {
                	if (func_a(palindromes, subStr) == false)
                		palindromes.add(subStr);
                }
            }
        }

        String answer = func_c(palindromes, k);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
    	sol02 sol = new sol02();
        String s1 = new String("abcba");
        int k1 = 4;
        String ret1 = sol.solution(s1, k1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        String s2 = new String("ccddcc");
        int k2 = 7;
        String ret2 = sol.solution(s2, k2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}