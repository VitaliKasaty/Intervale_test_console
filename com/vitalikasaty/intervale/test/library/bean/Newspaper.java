package com.vitalikasaty.intervale.test.library.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Product {

	private static final long serialVersionUID = -6378088123949322541L;
	
	private String newsOfTheDay;
	private String distributionArea;	
	
	public Newspaper() {	
		super();
	}

	public Newspaper(String title, String theme, String text, Date releaseDate, String newsOfTheDay, String distributionArea) {
		super(title, theme, text, releaseDate);
		this.newsOfTheDay = newsOfTheDay;
		this.distributionArea = distributionArea;
	}

	public String getNewsOfTheDay() {
		return newsOfTheDay;
	}

	public void setNewsOfTheDay(String newsOfTheDay) {
		this.newsOfTheDay = newsOfTheDay;
	}

	public String getDistributionArea() {
		return distributionArea;
	}

	public void setDistributionArea(String distributionArea) {
		this.distributionArea = distributionArea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((distributionArea == null) ? 0 : distributionArea.hashCode());
		result = prime * result + ((newsOfTheDay == null) ? 0 : newsOfTheDay.hashCode());
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
		Newspaper other = (Newspaper) obj;
		if (distributionArea == null) {
			if (other.distributionArea != null)
				return false;
		} else if (!distributionArea.equals(other.distributionArea))
			return false;
		if (newsOfTheDay == null) {
			if (other.newsOfTheDay != null)
				return false;
		} else if (!newsOfTheDay.equals(other.newsOfTheDay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Газета. [Новость дня: " + newsOfTheDay + ", область распространения: " + distributionArea + ", название: "
				+ getTitle() + ", жанр: " + getTheme() + ", дата выпуска: "
				+ new SimpleDateFormat("dd.MM.yyyy").format(getReleaseDate()) + "]";
	}
	
	
}
