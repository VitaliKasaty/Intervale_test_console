package com.vitalikasaty.intervale.test.library.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends Product{

	private static final long serialVersionUID = -1112995440209084026L;
	
	private String author;

	public Book() {
		super();		
	}

	public Book(String title, String theme, String text, Date releaseDate, String author) {
		super(title, theme, text, releaseDate);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Книга. [Автор: " + author + ", название: " + getTitle() + ", жанр: " + getTheme() + ", год выпуска : " + new SimpleDateFormat("dd.MM.yyyy").format(getReleaseDate()) + "]";
	}


}
