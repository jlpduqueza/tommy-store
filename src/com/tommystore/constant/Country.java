package com.tommystore.constant;


public enum Country {
	
	  PHILLIPINES("Philippines")
	, USA("United States of America")
	, AUSTRALIA("Australia")
	, KOREA("Korea")
	, JAPAN("Japan")
	, CHINA("China")
	, SINGAPORE("Singapore")
	, MALAYSIA("Malaysia")
	, SWITZERLAND("Switzerland")
	, SWEDEN("Sweden");
	
	public final String country;
	
    private Country(String country) {
        this.country = country;
    }
}
