package leetCodeJun2020;

public class IsSubsequence9 {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		boolean ans = isSubsequence(s,t);
		System.out.println(ans);
	}

	private static boolean isSubsequence(String s, String t) {
		int sLength = s.length(), tLength = t.length();
		int tIndex = 0;
		for (int i = 0; i < sLength; i++) {
			boolean isFind = false;
			for (int j = tIndex; j < tLength; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					tIndex = j+1;
					isFind = true;
					break;
				}
			}
			if (!isFind) return false;
		}
		
		return true;
	}

}
