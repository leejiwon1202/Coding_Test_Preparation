package Chap01_String;

import java.util.*;

public class q12_RecordStudyTime {
	public int getTime(String time) {
		String[] tmp = time.split(":");
		int H = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		return H * 60 + M;
	}
	public String Solution(String[] times) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (String x : times)
			tmp.add(getTime(x));
		
		int sum = 0;
		for (int i=0; i<tmp.size() / 2; i++) {
			int dif = tmp.get(i * 2 + 1) - tmp.get(i * 2);
			// (1) 1시간 45분 이상 공부하면 +105
			// (2) 5분 이상 공부하면 +dif
			// (3) 5분 미만 공부했다면 +0
			if (dif >= 105)
				sum += 105;
			else if (dif >= 5)
				sum += dif;
		}
		
		// 분단위 정수형으로 저장된 결괏값을 다시 String으로 변환하여 반환
		int H = sum / 60;
		int M = sum % 60;
		return (H<10?"0"+H:H) + ":" + (M<10?"0"+M:M);
	}
	public static void main(String args[]) {
		q12_RecordStudyTime T = new q12_RecordStudyTime();
		System.out.println(T.Solution(new String[]{"08:30", "09:00", "14:00", "16:00", "16:07", "16:11"}));
		System.out.println(T.Solution(new String[]{"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"}));
	}
}
