package com.ctd.gmbd.simple.repository;

import jakarta.persistence.*;
//import lombok.Data;

@Entity
@Table(name = "auth_user", 
		schema = "gmbd-common", 
		uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
//@Data // Generates getters, setters, and toString via Lombok
public class AuthUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false, unique = true)
    private String name;
	

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