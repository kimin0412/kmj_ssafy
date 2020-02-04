package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LinkedBinaryTree {
	public static final int PRE = 1;
	public static final int IN = 2;
	public static final int POST = 3;
	private TreeNode root;

	public TreeNode insertKey(TreeNode root, int x) {
		TreeNode p = root;
		TreeNode c = new TreeNode(x);
		if (p == null) {
			return c; // 부모가 없으면 현재 만든 노드가 부모가 됨.
		} else if (p.data > x) {
			p.left = insertKey(p.left, x);
		} else if (p.data < x) {
			p.right = insertKey(p.right, x);
		}
		return p;
	}

	public void insertBST(int x) {
		root = insertKey(root, x);
	}

	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void printBST(int method) {
		switch (method) {
		case IN:
			inorder(root);
			break;
		case PRE:
			preorder(root);
			break;
		case POST:
			postorder(root);
			break;
			
		default:
			break;
		}
		System.out.println();
	}
	
	//오버로딩
	public void printBST(int method, TreeNode p) {
		switch (method) {
		case IN:
			inorder(p);
			break;
		case PRE:
			preorder(p);
			break;
		case POST:
			postorder(p);
			break;
			
		default:
			break;
		}
		System.out.println();
	}


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/tree.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		LinkedBinaryTree bst = new LinkedBinaryTree();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N - 1; i++) { // 정점개수, 간선개수 헷갈리지 XXX
			bst.insertBST(Integer.parseInt(st.nextToken()));
		}
		System.out.println("==========inorder");
		bst.printBST(bst.IN);
		System.out.println("==========preorder");
		bst.printBST(bst.PRE);
		System.out.println("==========postorder");
		bst.printBST(bst.POST);

		TreeNode find = bst.searchBST(4);
		if (find == null) {
			System.out.println("탐색 실패");
		} else {
			System.out.println(find.data + " 탐색 성공");
			bst.printBST(bst.IN, find);
		}
	}

	public TreeNode searchBST(int i) {
		// TODO Auto-generated method stub
		TreeNode p = root;
		while(p != null) {
			if (p.data == i)
				return p;
			else if (p.data > i) {
				p = p.left;

			} else if (p.data < i) {
				p = p.right;
			}
		}
		return p;
	}

}
