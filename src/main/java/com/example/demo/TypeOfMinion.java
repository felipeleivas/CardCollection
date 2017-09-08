package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class TypeOfMinion {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	TypeOfMinion(){
	}
	
	TypeOfMinion(String typeOfMinion, Integer id){
		this.id = id;
		this.name = typeOfMinion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String type) {
		this.name = type;
	}
	
	
}
