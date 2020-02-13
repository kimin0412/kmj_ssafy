package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/1873_상호의배틀필트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H + 2][W + 2];
			int curR = 0, curC = 0;

			// 맵 입력받기
			for (int i = 1; i <= H; i++) {
				String line = br.readLine();
				for (int j = 1; j <= W; j++) {
					map[i][j] = line.charAt(j - 1);
					if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						curR = i;
						curC = j;
					}
				}
			}

			// 명령 입력받기
			int N = Integer.parseInt(br.readLine());
			char[] order = new char[N];
			String line = br.readLine();
			for (int i = 0; i < N; i++) {
				order[i] = line.charAt(i);

				switch (order[i]) {
				case 'U':
					if (map[curR - 1][curC] != ' ' && map[curR - 1][curC] == '.') {
						map[curR][curC] = '.';
						curR--;
					}
					map[curR][curC] = '^';
					break;

				case 'D':
					if (map[curR + 1][curC] != ' ' && map[curR + 1][curC] == '.') {
						map[curR][curC] = '.';
						curR++;
					}
					map[curR][curC] = 'v';
					break;
				case 'L':
					if (map[curR][curC - 1] != ' ' && map[curR][curC - 1] == '.') {
						map[curR][curC] = '.';
						curC--;
					}
					map[curR][curC] = '<';
					break;

				case 'R':
					if (map[curR][curC + 1] != ' ' && map[curR][curC + 1] == '.') {
						map[curR][curC] = '.';
						curC++;
					}
					map[curR][curC] = '>';
					break;

				case 'S':
					int p = 1;
					if (map[curR][curC] == '^') {
						while (true) {
							if (map[curR - p][curC] == '.' || map[curR - p][curC] == '-') {
								p++;
							} else if (map[curR - p][curC] == '*') {
								map[curR - p][curC] = '.';
								break;
							} else
								break;
						}
					}
					
					if (map[curR][curC] == 'v') {
						while (true) {
							if (map[curR + p][curC] == '.' || map[curR + p][curC] == '-') {
								p++;
							} else if (map[curR + p][curC] == '*') {
								map[curR + p][curC] = '.';
								break;
							} else
								break;
						}
					}
					
					if (map[curR][curC] == '<') {
						while (true) {
							if (map[curR][curC - p] == '.' || map[curR][curC - p] == '-') {
								p++;
							} else if (map[curR][curC - p] == '*') {
								map[curR][curC - p] = '.';
								break;
							} else
								break;
						}
					}
					
					if (map[curR][curC] == '>') {
						while (true) {
							if (map[curR][curC + p] == '.' || map[curR][curC + p] == '-') {
								p++;
							} else if (map[curR][curC + p] == '*') {
								map[curR][curC + p] = '.';
								break;
							} else
								break;
						}
					}

					break;
				}

			}
			
			System.out.print("#" + (tc+1) + " ");
			
			for (int j = 1; j < H+1; j++) {
				for (int j2 = 1; j2 < W+1; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}
			System.out.println();		
			
		}

	}

}
