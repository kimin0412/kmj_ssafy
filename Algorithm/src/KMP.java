
public class KMP {
	// 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘.
	// 접두사와 접미사 개념을 활용해서, '반복되는 연산을 최대한 줄이도록'
	// 지금까지 검사한 문자열의 접두사와 접미사가 일치하는 최대길이만큼 겹침을 이용

	// 접두사와 접미사 개념을 활용해서, '반복되는 연산을 얼마나 줄일 수 있는지'를 판별하여
	// 매칭할 문자열을 빠르게 점프하는 기법.
	// 접두사와 접미사가 일치하는 최대길이가 필요(점프 해야되서)

	// 파이 테이블 : 각 길이별로 접두사 == 접미사의 최대길이가 저장된 배열
	// Pi(실패 테이블) : 패턴이 일치하지 않을 경우 일치하는 부분만큼 점프할 수 있도록 이동 위치를 적은 테이블
	static int[] getPi(String pattern) {
		// 접두사와 접미사가 일치하는 최대길이를 담을 배열 선언 
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// 맞는 경우
			if (pattern.charAt(i) == pattern.charAt(j)) {
				// i길이 문자열의 공통길이는 j의 위치 + 1
				pi[i] = ++j;
			}
			// 안맞는 경우
			else {
				// 맞는날이 올때까지 하나 전칸에서의 공통부분 위치로 이동
				while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
					j = pi[j - 1];
			}
		}
		return pi;
	}

	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			// 일단 앞으로 이동하고 맞는경우를 처리해주셈.
			// 원문과 패턴이 맞지 않으면 
			while (j > 0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			// 맞는 경우 - 원문과 패턴이 일치한다면 
			if (origin.charAt(i) == pattern.charAt(j)) {
				// j의 값이 패턴의 길이-1 이라면 한번 다 찾은 거니까
				// 찾았다고 처리 
				if (j == pattern.length() - 1) {
					System.out.println("ㅇㅋ" + (i - pattern.length() + 1));
					// 패턴을 또 찾기 위해서 
					j = pi[j];
				}
				// 맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
				else
					// 다 찾은건 아니라면 계속 진행해야 하므로 j값 증가 
					j++;
			}
		}
	}

	public static void main(String[] args) {
//		String origin = "ababacabacaabacaabc";
//		String pattern = "abacaabc";
		String origin = "HELLOSSAFY";
		String pattern = "LOSS";
		KMP(origin, pattern);
	}

}
