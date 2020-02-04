package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LinkedTree {
	public TreeNode root; // root에다가 자식들을 채움

	public void makeTree(int pnode, int cnode) {
		// root가 없으면 첫 pnode가 root가 된다.
		if (root == null) {
			root = new TreeNode(pnode);
		}
		// root가 있으면 root의 자손으로 pnode를 찾아서 pnode의 자식으로 cnode를 추가
		makeTree(root, pnode, cnode);
	}

	private void makeTree(TreeNode root, int pnode, int cnode) {
		if (root != null) {
			if (root.data == pnode) { // pnode는 root가 되므로 cnode를 자식에 추가
				TreeNode node = new TreeNode(cnode);
				if (root.left == null) {
					root.left = node;
				} else if (root.right == null) {
					root.right = node;
				}
				return;
			}
			makeTree(root.left, pnode, cnode);
			makeTree(root.right, pnode, cnode);
		}
	}
	public void preorder(TreeNode node) {
		if(node != null) {
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}
}

public class TreeListTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/tree3.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedTree blt = new LinkedTree();
		for (int i = 0; i < N-1; i++) { //정점개수, 간선개수 헷갈리지 XXX
			blt.makeTree(sc.nextInt(), sc.nextInt());
		}
		blt.preorder(blt.root);
	}

}
