package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1247_D5_최적경로2 {
	static int client[][];
    static int home[];
    static int company[];
    static boolean visit[];
    static int n;
    static int max = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        for (int tc = 1; tc <= 10; tc++)
        {
            n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            company = new int[2];
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            client = new int[n][2];
            visit = new boolean[n];
            max = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
            {
                client[i][0] = Integer.parseInt(st.nextToken());
                client[i][1] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,home[0],home[1]);
            System.out.println("#"+tc+" "+max);
        }
    }
    private static void dfs(int dist,int count,int startx, int starty) {
        if (dist > max)
            return;
        if(count == n)
        {
            dist += Math.abs(startx-company[0]) +Math.abs(starty-company[1]);
            max = Math.min(max, dist);
        }
         
        for (int i = 0; i < n; i++)
        {
            if(!visit[i])
            {
                visit[i] = true;
                int cur = Math.abs(startx-client[i][0]) + Math.abs(starty-client[i][1]);
                dfs(dist+cur,count+1,client[i][0],client[i][1]);
                visit[i] = false;
            }
        }
    }
}