package com.ssafy.graph;

import java.util.Arrays;

public class DisjointSet {
    static int[] parent;
    public static void makeSet(int v) {
        parent[v] = v;
    }
    public static int findSet(int v) {
        if(v == parent[v]) {
            return v;
        }
        //==>문제점   path가 길어지만 찾는 시간이 오래 걸림 ==> path compression필요
        return findSet(parent[v]);
    }
    public static void unionSet(int u, int v) {
        parent[ findSet(u)] = findSet(v);
    }
    public static void main(String[] args) {
        int N= 6;
        parent =new int[N+1];
        for (int i = 1; i <=N; i++) {
            makeSet(i);
        }
        unionSet(4, 3);
        unionSet(6, 5);
        unionSet(5, 4);
        System.out.println((char)(findSet(6)+'a'-1));
        System.out.println((char)(findSet(4)+'a'-1));
    }
}