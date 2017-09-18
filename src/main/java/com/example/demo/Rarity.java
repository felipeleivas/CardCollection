package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rarity")
public class Rarity {
	@Id
	@SequenceGenerator(name="SEQ_RARITY", sequenceName="SEQ_RARITY", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_RARITY")
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
