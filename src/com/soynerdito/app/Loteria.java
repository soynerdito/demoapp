package com.soynerdito.app;

import java.util.ArrayList;

public class Loteria {
	public String title;
	public String link;
	public String description;
	public String copyright;
	public ArrayList<Item> items;

	public Loteria() {
		this("","","","");
	}

	public Loteria(String title, String link, String description,
			String copyright) {
		
		this.title = title;
		this.link = link;
		this.description = description;
		this.link = link;
		this.copyright = copyright;
		items = new ArrayList<Item>();
	}
	
	public void addData(EnumStat stat, String data){
		switch(stat){
		case COPY:
			copyright += data;
			break;
		case LINK:
			link += data;
			break;
		case DESC:
			description += data;
			break;
		case TITLE:
			title += data;
			break;
		case TTL:
			break;
		}
	}
}
