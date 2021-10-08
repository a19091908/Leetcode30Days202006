package leetCodeJun2020;

public class LongestDuplicateSubstring19 {


	public static void main(String[] args) {
		String S = "banana";
		LongestDuplicateSubstring19 ld = new LongestDuplicateSubstring19();
		String ansStr = ld.longestDupSubstring(S);
		System.out.println(ansStr);

	}

	private String longestDupSubstring(String S) {
		int maxLengthStart = -1;
		int maxLengthend = -1;
		int max = 0;
		Node19 root = new Node19();
		Node19 tempNode = root;
		int length = S.length();
		
		for (int i = 0; i < length; i++) {
			tempNode = root;
			int intOfChar = Character.getNumericValue(S.charAt(i));
			int cnt = 0;
			while (true) {
				if (tempNode.engChar[intOfChar] == null) {
					tempNode.engChar[intOfChar] = new Node19();
					if (cnt > max) {
						maxLengthStart = i;
						maxLengthend = i + cnt -1;
						max = cnt;
					}
					break;
				}else {
					cnt++;
					tempNode = tempNode.engChar[intOfChar];
				}
				
			}
		}
		
		if (maxLengthStart == -1) 
			return "";
		else
			return S.substring(maxLengthStart,maxLengthend);
		
		
	}

	


}

class Node19 {
	Node19[] engChar;
	boolean isLeft;
	Node19(){
		engChar = new Node19[26];
	}
	
}

