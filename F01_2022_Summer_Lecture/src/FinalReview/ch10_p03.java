package review;

import java.util.Scanner;

public class ch10_p03 {
	public int solution(int n, int[] arr) {
		int answer = 0;
		int[] dy = new int[n];
		dy[0] = 1;
		
		for(int i=1; i<n; i++) {
			int max = 0;

			for(int j=i-1; j>=0; j--) {
				if (arr[j] < arr[i] && dy[j] > max) {
					max = dy[j];
				}
			}
			
			dy[i] = max+1;
			answer = Math.max(answer, dy[i]);
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		ch10_p03 T = new ch10_p03();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, arr));
	}

}
