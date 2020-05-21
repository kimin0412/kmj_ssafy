import java.net.*;
import java.io.*;

public class Sample_Code {

	// User and Game Server Information
	static final String NICKNAME = "Java Player";
//	static final String HOST = "127.0.0.1";
	static final String HOST = "192.168.219.108";
	static final int PORT = 1447; // Do not modify

	// predefined variables(Do not modify these values)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = "9901/" + NICKNAME;
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play.");
			int cnt = 1;

			while (socket != null) {

				bytes = new byte[1024];

				int readByteCount = is.read(bytes);
				recv_data = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				String[] split_data = recv_data.split("/");
				if (split_data[0].equals("9909"))
					break;

				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = new byte[1024];
					balls = new int[NUMBER_OF_BALLS][2];
					bytes = "9902/9902".getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				if (Integer.parseInt(split_data[2 * cnt]) == -1 && Integer.parseInt(split_data[2 * cnt + 1]) == -1)
					cnt++;
				System.out.println("cnt : " + cnt);
				double angle = 0;
				double power = 0;

				double min = Integer.MAX_VALUE;
				int closeHole = 0;
				for (int i = 0; i < 6; i++) {
					if (min > Math.abs(HOLES[i][0] - balls[cnt][0]) + Math.abs(HOLES[i][1] - balls[cnt][1])) {
						min = Math.abs(HOLES[i][0] - balls[cnt][0]) + Math.abs(HOLES[i][1] - balls[cnt][1]);
						closeHole = i;
					}
				}

				int dx = Integer.parseInt(split_data[0]) - balls[cnt][0];
				int dy = Integer.parseInt(split_data[1]) - balls[cnt][1];
				int hx = balls[cnt][0] - HOLES[closeHole][0];
				int hy = balls[cnt][1] - HOLES[closeHole][1];

				double rad = Math.atan2(dx, dy);

				double degree = (rad * 180) / Math.PI;
				double z1 = Math.pow(dx, 2) + Math.pow(dy, 2);
				double z2 = Math.pow(hx, 2) + Math.pow(hy, 2);
				System.out.println(z1 + " " + z2);
				angle = degree + 180;
				power = (z1 * 0.6 + z2 * 0.75) / 100;

				String merged_data = angle + "/" + power;
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
