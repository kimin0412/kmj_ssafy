package swea.sw;
///////보류////////
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5658_모의SW_보물상자비밀번호 {
	static int N, K;
	static LinkedList<Character> hexa;
	static int n;
//	static LinkedList<Integer> hexa;
	
	public static class Words{
		String word;
		int order;
		public Words(String word, int order) {
			super();
			this.word = word;
			this.order = order;
		}
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5658_모의SW_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			hexa = new LinkedList<>();
			int nn = N / 4;

			String line = br.readLine();
			for (int i = 0; i < N; i++) {

				char a = line.charAt(i);
//				int a = line.charAt(i) - '0';
//				if (a >= 17) {
//					a -= 7;
//				}
				hexa.offer(a);
			}

			System.out.println(hexa.toString());

//			Words[] arrr = new Words[12];
			String[] arr = new String[12];
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				String tmp = "";
				for (int j = 0; j < N; j++) {
					tmp += hexa.get(j);
					System.out.println(j + " " + tmp);
					if (j % nn == nn - 1) {
						boolean flag = true;
						for (int k = 0; k < idx; k++) {
//							if (arrr[k].getWord().equals(tmp)) {
							if (arr[k].equals(tmp)) {
								flag = false;
								tmp = "";
								break;
							}
						}

						if (flag == true) {
//							arrr[idx].setWord(tmp);
//							arrr[idx].setOrder(j % nn);
							arr[idx] = tmp;
							idx++;
							tmp = "";
						}
					}
				}
				char c = hexa.pollLast();
				hexa.offerFirst(c);


			}
			
//			Arrays.sort(arrr, new Comparator<Words>() {
//
//				@Override
//				public int compare(Words o1, Words o2) {
//					for
//					if (o1[n] < o2[n])
//						return -1;
//					else if (o1[n] == o2[n])
//						return 0;
//					else
//						return 1;
//				}
//
//			});

			Arrays.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					for (int i = 0; i < nn; i++) {
						if (o1.charAt(i) < o2.charAt(i))
							return -1;
						else if (o1.charAt(i) == o2.charAt(i))
							return 0;
						else
							return 1;
					}
					return 0;

				}

			});
			
			
			for (String s : arr) {
				System.out.println(s);
			}
			
//			System.out.println(Arrays.toString(arr));
//			for (int i = 0; i < idx; i++) {
//				for (int j = 0; j < nn; j++) {
//					System.out.println(arr[i][j]);
//					
//				}
//			}
			System.out.println("#" + tc + " "  + arr[K]);

		}
	}
}
