package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {
	static int N, M;
	static int[] parent;

	public static int find(int x) {
		if (x == parent[x])
			return x;
		int y = find(parent[x]);
		parent[x] = y;
		return y;
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else {
			parent[y] = x;
			return true;
		}
	}

	static class Point {
		double x;
		double y;
		int n;

		public Point(double x, double y, int n) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", n=" + n + "]";
		}

	}

	static class Star implements Comparable<Star> {
		int s;
		int e;
		double w;

		public Star(int s, int e, double w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Star [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Star o) {
			if (w > o.w)
				return 1;
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 0; tc < 1; tc++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];

			for (int n = 0; n < N; n++) {
				parent[n] = n;
			}

			int cnt = 0;

			Point[] p = new Point[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());

				p[i] = new Point(x, y, i);

			}

			PriorityQueue<Star> stars = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double weight = Math.sqrt(Math.pow(p[i].x - p[j].x, 2) + Math.pow(p[i].y - p[j].y, 2));

					stars.add(new Star(p[i].n, p[j].n, weight));
				}
			}

			double answer = 0;

			while (!stars.isEmpty()) {
				Star i = stars.poll();

				if (find(i.s) != find(i.e)) {
					union(i.s, i.e);
					answer += i.w;
				}
			}

			System.out.print(String.format("%.2f", answer));
		}
	}

}
