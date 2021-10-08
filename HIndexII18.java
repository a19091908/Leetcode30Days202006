package leetCodeJun2020;

public class HIndexII18 {

	public static void main(String[] args) {
		
		int[] citations = {100};
		
		int hIndex = hIndex(citations);
		
		System.out.println(hIndex);
	}

	private static int hIndex(int[] citations) {

		int left = 0, right = citations.length-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;

			if (citations[mid] == (citations.length - mid)) {
				return citations[mid];
			} else if (citations[mid] > (citations.length - mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return citations.length - left;
	}

}
