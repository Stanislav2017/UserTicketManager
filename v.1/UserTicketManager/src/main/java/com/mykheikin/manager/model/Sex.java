package com.mykheikin.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sex")
public class Sex {

	@Id
	@Column(name = "sex_id")
	private int id;
	@Column(name = "name")
	private String name;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public Sex() {
	}

	public Sex(int id, String name, User user) {
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
