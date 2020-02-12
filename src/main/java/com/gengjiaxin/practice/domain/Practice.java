package com.gengjiaxin.practice.domain;

public class Practice {

	private Integer id;
	
	private String name;
	
	private String picture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Practice(Integer id, String name, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
	}

	public Practice() {
		super();
	}
	
	
}
