package leetCodeJun2020;

public class ReverseString4 {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
	}

	private static void reverseString(char[] s) {
		if (s.length == 0) return;
		int left = 0, right = s.length-1;
		
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
		
	}

}
