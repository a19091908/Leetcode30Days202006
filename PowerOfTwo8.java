package leetCodeJun2020;

public class PowerOfTwo8 {

	public static void main(String[] args) {
		int n = 8;
		boolean ans = isPowerOfTwo(n);
		System.out.println(ans);

	}
	
	public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while ( n > 2){
            if (n % 2 == 1) return false;
            n = n / 2;
        }
        return true;
    }
}
