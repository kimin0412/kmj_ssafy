package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.ssafy.model.dao.MovieMgr;
import com.ssafy.model.dto.Movie;

public class MovieTest {

	public static void main(String[] args) throws IOException {
		MovieMgr mgr = MovieMgr.getInstance();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			System.out.println("<<<  영화 관리 프로그램 >>> ");
			System.out.println("1. 영화 정보 입력 ");
			System.out.println("2. 영화 정보 전체 검색 ");
			System.out.println("3. 영화명 검색  ");
			System.out.println("4. 영화 장르별 검색 ");
			System.out.println("5. 영화 정보 삭제 ");
			System.out.println("0.   종료");
			System.out.print("원하는 번호를 선택하세요. : ");
			int N = Integer.parseInt(in.readLine());
			if(N == 0)
				break;
			switch (N) {
			case 1:
				System.out.println("제목, 감독, 평점, 장르, 요약 순으로 입력해주세요.");
				String title = in.readLine();
				String direction = in.readLine();
				int grade = Integer.parseInt(in.readLine());
				String genre = in.readLine();
				String summary = in.readLine();
				mgr.add(new Movie(title, direction, grade, genre, summary));
				break;
			case 2:
				mgr.print();
				System.out.println();
				break;
			case 3:
				System.out.println("검색할 영화 제목을 입력하세요.");
				title = in.readLine();
				Movie[] movies = mgr.search(title);
				for (Movie movie : movies) {
					System.out.println(movie);
				}
				System.out.println();
				break;
			case 4:
				System.out.println("검색할 영화 장르를 입력하세요.");
				genre = in.readLine();
				movies = mgr.search(genre);
				for (Movie movie : movies) {
					System.out.println(movie);
				}
				System.out.println();
				break;
			case 5:
				System.out.println("삭제할 영화 제목을 입력하세요.");
				title = in.readLine();
				mgr.delete(title);
				mgr.print();
				System.out.println();
				break;
			}

		}

	}

}
