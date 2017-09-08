package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rarity")
public class Rarity {
	@Id
	Integer id;
	
	@Column(name = "name")
	String name;
	
	
	public Rarity(){
	}
	
	public Rarity(String rarity, Integer id){
		this.name = rarity;
		this.id = id;
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


	public void setName(String rarity) {
		this.name = rarity;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
