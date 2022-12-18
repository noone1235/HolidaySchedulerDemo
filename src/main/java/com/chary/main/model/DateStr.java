package com.chary.main.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Holidays")
public class DateStr {
	
	@Id
	private String Date;

	public String getDate() {
		return Date;
	}

	public void setDate(String dates) {
		this.Date = dates;
	}
	
}
