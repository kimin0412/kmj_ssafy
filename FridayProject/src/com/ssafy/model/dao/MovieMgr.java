package com.ssafy.model.dao;

import java.util.ArrayList;
import java.util.Arrays;

import com.ssafy.model.dto.Movie;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index;
	private static MovieMgr instance;
	
	public MovieMgr() {
		movies = new Movie[10];
	}
	
	public static MovieMgr getInstance() {
		if(instance == null) {
			instance = new MovieMgr();
		}
		return instance;
	}
	
	private int searchIndex(String title) {
		if (title != null) {
			int idx = 0;
			for (int i = 0; i < index; i++) {
				Movie movie = movies[i];
				if (title.equals(movie.getTitle())) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}
	
//	private int searchInclude(String title) {
//		if (title != null) {
//			int idx = 0;
//			for (int i = 0; i < index; i++) {
//				Movie movie = movies[i];
//				if (movie.getTitle().contains(title)) {
//					return idx;
//				}
//				idx++;
//			}
//		}
//		return -1;
//	}
	
	/** 파라메터로 전달된 영화 정보를 전달받아 배열에 저장한다. */
	public void add(Movie m) {
		if(m != null) {
			int idx = searchIndex(m.getTitle());
			if (idx == -1) {
				int n = movies.length;
				if (index >= n) { // full인 상태
					Movie[] temp = Arrays.copyOf(movies, n + n >> 1);
				}
				movies[index++] = m;
			} else {
				System.out.printf("제목이 %s인 영화는 이미 등록된 영화입니다.\n", m.getTitle());
			}
		}
	}

	/** 배열에 저장된 모든 영화정보를 리턴한다. */
	public Movie[] search() {
		Movie[] temp = new Movie[index];
		for (int i = 0; i < index; i++) {
			temp[i] = movies[i];
		}
		return temp;
	}

	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 영화 정보를 검색하여 리턴 한다 */
	public Movie[] search(String title) {
		ArrayList<Movie> temp = new ArrayList<>(movies.length);
		for (int i = 0; i < index; i++) {
			Movie movie = movies[i];
			if (movie.getTitle().contains(title)) {
				temp.add(movie);
			}
		}
		Movie[] m = new Movie[temp.size()];
		return temp.toArray(m);
	}

	/** 파라메터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴한다 */
	public Movie[] searchDirector(String name) {
		ArrayList<Movie> temp = new ArrayList<>(movies.length);
		for (int i = 0; i < index; i++) {
			Movie movie = movies[i];
			if (movie.getDirection().equals(name)) {
				temp.add(movie);
			}
		}
		Movie[] m = new Movie[temp.size()];
		return temp.toArray(m);
	}

	/** 파라메터로 전달된 장르의 모든 영화 정보를 검색하여 리턴한다 */
	public Movie[] searchGenre(String genre) {
		ArrayList<Movie> temp = new ArrayList<>(movies.length);
		for (int i = 0; i < index; i++) {
			Movie movie = movies[i];
			if (movie.getGenre().equals(genre)) {
				temp.add(movie);
			}
		}
		Movie[] m = new Movie[temp.size()];
		return temp.toArray(m);
	}

	/** 파라메터로 전달된 제목의 영화를 삭제한다. */
	public void delete(String title) {
		int idx = searchIndex(title);
		if (idx > -1) {
			movies[idx] = movies[--index];
		} else {
			System.out.printf("제목이 %s인 영화는 등록되지 않았습니다.\n", title);
		}
	}

	/** 저장된 영화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return index;
	}
	
	public void print() {
		System.out.println("==============등록된 모든 영화 정보===========");
		for (int i = 0; i < index; i++) {
			System.out.println(movies[i]);
		}
	}
	
}
