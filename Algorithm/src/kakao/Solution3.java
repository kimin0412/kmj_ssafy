package kakao;

class Solution3 {
	static int[] check;
	public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        check = new int[user_id.length];
        
        
        dfs(0);
        
        
        return answer;
    }

	private static void dfs(int i) {
		
		
		
	}

	public static void main(String[] args) {
//		int[][] list = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
//				{ 3, 5, 1, 3, 1 } };
//		int[] list2 = { 1, 5, 3, 5, 1, 2, 1, 4 };
		String[] ss = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] sb = {"fr*d*", "*rodo", "******", "******"};
		
		System.out.println(solution(ss, sb));
	}
}
