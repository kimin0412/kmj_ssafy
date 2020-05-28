package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author itsmeyjc
 * @since 2020. 3. 18.
 * @see https://www.acmicpc.net/problem/1194
 * @mem 16692
 * @time 112
 * @caution 상황에 따라 방문 체크를 별도로 해야하는 문제 #bfs, 키의 상태를 변경하기 위해 #bitmasking 처리
 */
public class Main_1194_달이차오른다가자_수업 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static char[][] map;
    static int R, C, A;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokens.nextToken()); // (1 ≤ N, M ≤ 50)
        C = Integer.parseInt(tokens.nextToken());

        map = new char[R][];
        visited = new boolean[R][C][];

        Minsik start = null;
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if (start == null && map[r][c] == '0') {
                    start = new Minsik(r, c, 0, 0);
                }
                visited[r][c] = new boolean[0b111111 + 1];// 키는 6개이고 각 키의 조합을 bitmasking 할 예정이므로 크기는 이렇게
            }
        }
        for (char[] row : map) {
            System.out.println(Arrays.toString(row));
        }
        A = Integer.MAX_VALUE;
        bfs(start);
        System.out.println(A == Integer.MAX_VALUE ? -1 : A);
    }

    static void bfs(Minsik start) {
        Queue<Minsik> q = new LinkedList<>();
        q.offer(start);
        visited[start.row][start.col][start.keys] = true; // 현재 상태의 방문 여부 처리

        while (!q.isEmpty()) {
            Minsik front = q.poll();

            for (int d = 0; d < dirs.length; d++) {
                int nr = front.row + dirs[d][0];
                int nc = front.col + dirs[d][1];
                int nk = front.keys;
                if (isIn(nr, nc)) {
                    if (map[nr][nc] == '1') {
                        A = front.depth + 1;
                        return;
                    }

                    // 벽이면 못가요.
                    if (map[nr][nc] == '#') {
                        continue;
                    }
                    if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {// 문이 있는데 키가 없으면 못가요.
                        if ((front.keys & 1 << map[nr][nc] - 'A') == 0) {
                            continue;
                        }
                    }
                    // 키를 만나면 키 정보 업데이트
                    if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                        nk = front.keys | 1 << (map[nr][nc] - 'a');
                    }
                    // 이제 해당 지점을 방문한 적이 없다면 가보자.
                    if (visited[nr][nc][nk]) {
                        continue;
                    }
                    q.offer(new Minsik(nr, nc, front.depth + 1, nk));
                    visited[nr][nc][nk] = true;
                }
            }
        }
    }

    static boolean isIn(int row, int col) {
        return 0 <= row && 0 <= col && row < R && col < C;
    }

    static class Minsik {
        int row, col, keys;
        int depth;

        public Minsik(int row, int col, int depth, int keys) {
            this.row = row;
            this.col = col;
            this.depth = depth;
            this.keys = keys;
        }

    }

    private static String src = "1 7\r\n" +
                                "f0.F..1";
}
