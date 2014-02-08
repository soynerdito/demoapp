package com.soynerdito.app;

public enum EnumStat {
	 NONE(""), M_TITLE("title"), 
	 M_LINK("link"), M_DESC("description"), 
	 M_COPY("copyright"), M_TTL("ttl"),
		I_TITLE("title"),I_DESC("description"),O_DATE("pubDate"),I_LINK("link") ;
	
	 public String caption;
	 
	 EnumStat(String value){
		 caption = value;
	 }
}
