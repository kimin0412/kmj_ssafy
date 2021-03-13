package programers;

public class Solution_전화번호목록 {
	public static void main(String[] args) {
		String[][] board = { { "119", "97674223", "1195524421" }, { "123", "456", "789" },
				{ "12", "123", "1235", "567", "88" } };

	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (i == j)
					continue;
				if (phone_book[j].indexOf(phone_book[i]) == 0) {
					return false;
				}
			}
		}
		return answer;
	}
}
