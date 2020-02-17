package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int l = s.length();
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[l];
			int[][] arr2 = new int[l][2];
			for (int i = 0; i < l; i++) {
				arr[i] = s.charAt(i)- '0';
				arr2[i][0] = s.charAt(i)- '0';
				arr2[i][1] = i;
			}
			
			int jj = 0, jj2 = 0;
			Arrays.sort(arr2, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]>o2[0])
						return -1;
					else if(o1[0] == o2[0]) {
						if(o1[1]>o2[1])
							return -1;
						else
							return 1;
					}
					else
						return 1;
				}
			});
			
//			System.out.println(Arrays.toString(arr));
//			
//			for (int[] is : arr2) {
//				System.out.print(Arrays.toString(is));
//			}
//			System.out.println();
//			System.out.println();

			
			
			int k = 0;
			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < l; j++) {
//					if(arr2[k] == arr[j]) {
//						jj = j;
//						k++;
//						break;
//					}
//				}
//				if(k==jj2)
//					k = k-1;
				int tmp = arr[k];
				arr[k] = arr[arr2[k][1]];
				arr[arr2[k][1]] = tmp;
				k++;
			}
		
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
			
	}
}
