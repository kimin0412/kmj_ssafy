package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
//		int res = 2;

		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<Character> list_skill = new ArrayList<Character>();
		List<Character[]> list_tree = new ArrayList<Character[]>();
		
		for (int i = 0; i < skill.length(); i++) {
			list_skill.add(skill.charAt(i));
		}
		for (int i = 0; i < skill_trees.length; i++) {
//			list_tree.add(skill_trees[i].toCharArray());

		}
		
		
		for (int i = 0; i < skill_trees.length; i++) {
			for (int j = 0; j < skill_trees[i].length(); j++) {
//				if(skill.contains(skill_trees[i].charAt(j))
			}
		}
		
		/*
		 * skill에 포함되어있지 않은 문자를 공백으로 치환해서 C->B->D라면 C, CB, CBD 중에 있는지 확
		 */
		
		return answer;
	}
}
