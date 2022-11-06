package com.vitalikasaty.intervale.test.library.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Magazine extends Product {

	private static final long serialVersionUID = 1364324377062967168L;

	public int issueNumber;
	public List<String> editors = new ArrayList<>();

	public Magazine() {
		super();
	}

	public Magazine(String title, String theme, String text, Date releaseDate, int issueNumber, List<String> editors) {
		super(title, theme, text, releaseDate);
		this.issueNumber = issueNumber;
		this.editors = editors;
	}
	
	public void addEditor(String editor) {
		this.editors.add(editor);
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public List<String> getEditors() {
		return editors;
	}

	public void setEditors(List<String> editors) {
		this.editors = editors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((editors == null) ? 0 : editors.hashCode());
		result = prime * result + issueNumber;
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
		Magazine other = (Magazine) obj;
		if (editors == null) {
			if (other.editors != null)
				return false;
		} else if (!editors.equals(other.editors))
			return false;
		if (issueNumber != other.issueNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Журнал. [Номер выпуска " + issueNumber + ", редакторы: " + editors + ", название: " + getTitle()
				+ ", жанр: " + getTheme() + ", дата выпуска: " + new SimpleDateFormat("dd.MM.yyyy").format(getReleaseDate())
				+ "]";
	}

	
}
