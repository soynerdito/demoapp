package com.soynerdito.app;

public class Item {
	public String title;
	public String description;
	public String pubDate;
	public String link;
		
	public Item(){
		this("","","","");	
	}
	
	public Item(String title,String description ,
			String pubDate,String link){
			
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link= link; 
	}
	
	public void addData(EnumStat stat, String data){
		switch(stat){
		case DESC:
			description += data;
			break;
		case LINK:
			link += data;
			break;
		case TITLE:
			title += data;
			break;	
		case DATE:
			pubDate += data;
			break;
		}
	}
}
