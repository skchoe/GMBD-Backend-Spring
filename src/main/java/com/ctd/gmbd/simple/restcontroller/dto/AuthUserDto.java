package com.ctd.gmbd.simple.restcontroller.dto;

import com.google.gson.annotations.Expose;

public class AuthUserDto {

	@Expose(serialize = true, deserialize = true)
	private Long id;
	@Expose(serialize = true, deserialize = true)
	private String name;

	public AuthUserDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
