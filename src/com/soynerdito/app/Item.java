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
		case I_DESC:
			description += data;
			break;
		case I_LINK:
			link += data;
			break;
		case I_TITLE:
			title += data;
			break;	
		case O_DATE:
			pubDate += data;
			break;
		}
	}
}
