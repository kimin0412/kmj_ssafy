package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408_자기방돌아오기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		// 마주보는 방을 같은 번호로 맞추고 옮길때마다 누적하여 가장 큰수를 출력한다.
		
		
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine().trim());
			int rooms[] = new int[201];
			// rooms={0,0,0,0,........,0}
			int max = 0;
			int temp;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int playRoom = Integer.parseInt(st.nextToken());
				int myRoom = Integer.parseInt(st.nextToken());

				// 만약 되돌아가야 할 방의 번호가 작다면 SWAP
				if (playRoom > myRoom) {
					temp = playRoom;
					playRoom = myRoom;
					myRoom = temp;
				}

				// 마주 보는 홀수 짝수를 같은 번호로 맞추어 주기!!
				if (playRoom % 2 != 0)
					playRoom++; // 3번 ---> 4번 101번 ---> 102번
				if (myRoom % 2 != 0)
					myRoom++;

				// 방의 갯수를 절반으로 줄이기 1~400room ==> 1~200room
				playRoom = playRoom / 2; // ` 2 짝수4번방: 2 , 홀수101번방 짝수102번방 ---> 51
				myRoom = myRoom / 2;

				// rooms={0,0,0,0,0,0........,0}
				// 만약 2번방에서 출발, 3번방 도착!!
				// rooms={0,1,1,0,0,0........,0}
				// 만약 3번방에서 출발, 5번방 도착!!
				// rooms={0,1,2,1,1,0,0........,0}

				// 지나간 발자취에 +1 해주기
				for (int move = playRoom; move <= myRoom; move++)
					rooms[move]++;

				// 전체배열중 최대값 구하기
				for (int k = 0; k < rooms.length; k++)
					max = Math.max(max, rooms[k]);
			}
			System.out.println("#" + tc + " " + max);
		} // tc
	}// main
}