package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class TypeOfMinion {
	@SequenceGenerator(name="SEQ_TYPES_MINIONS", sequenceName="SEQ_TYPES_MINIONS", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_TYPES_MINIONS")
	@Id
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
