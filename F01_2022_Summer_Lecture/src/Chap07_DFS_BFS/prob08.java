package chap07;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class prob08 {
	int[] dis = {1, -1, 5};
	int[] ch;
	Queue<Integer> Q = new LinkedList<>();
	
	public int BFS(int s, int e) {
		ch = new int[10001];
		ch[s] = 1;
		Q.offer(s);
		
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			
			for(int i=0; i<len; i++) {
				int x = Q.poll();
				
				for(int j=0; j<dis.length; j++) {
					int nx = x + dis[j];
					if(nx == e) {
						return L+1;
					}
					if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		
		return L;
	}

	public static void main(String[] args) {
		prob08 T = new prob08();
		Scanner kb = new Scanner(System.in);
		
		int s = kb.nextInt();
		int e = kb.nextInt();
		System.out.println(T.BFS(s, e));
	}

}
