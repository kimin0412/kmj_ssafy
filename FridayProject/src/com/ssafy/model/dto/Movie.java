package com.ssafy.model.dto;

public class Movie {
	private String title;
	private String direction;
	private int grade;
	private String genre;
	private String summary;

	public Movie() {}

	public Movie(String title, String direction, int grade, String genre) {
		super();
		this.title = title;
		this.direction = direction;
		this.grade = grade;
		this.genre = genre;
	}

	public Movie(String title, String direction, int grade, String genre, String summary) {
		super();
		this.title = title;
		this.direction = direction;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [title=").append(title).append(", direction=").append(direction).append(", grade=")
				.append(grade).append(", genre=").append(genre).append(", summary=").append(summary).append("]");
		return builder.toString();
	}
	
}
