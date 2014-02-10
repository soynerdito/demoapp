package com.soynerdito.app;

public enum EnumStat {
	NONE(""), TITLE("title"), LINK("link"), COPY(
			"copyright"), TTL("ttl"), DESC("description"), DATE("pubDate")
			, ITEM("item");

	public String caption;

	EnumStat(String value) {
		caption = value;
	}
	
	public static EnumStat[] all (){
		return new EnumStat[] { TITLE, LINK, COPY, TTL, DESC, DATE, ITEM};
	}
	public static EnumStat fromString(String value ){
		EnumStat result = NONE;
		for (int i = 0; i < EnumStat.all().length; i++) {
			if (value.equals(EnumStat.all()[i].caption)){
				result = EnumStat.all()[i];
				break;
			}			
		}
		return result;
	}
}
