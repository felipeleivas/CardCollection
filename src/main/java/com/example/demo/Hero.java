package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import exceptions.CardNotFoundException;

@Entity
@Table(name = "heros")
public class Hero {
	@SequenceGenerator(name="SEQ", sequenceName="SEQ_HERO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	@Id
	private Integer id;
	
	@NotNull
	@Size(min= 2, max = 10)
	private String 	name;
	
	@NotNull
	@Column(name = "power")
	private String  heroPower;
	
	
	
	public Hero() {
	}
	
	@Autowired
	public Hero(String name, String heroPower) {
		this.name = name;
		this.heroPower = heroPower;
	}
	
	
	public void addCardToHero(Card newCard) {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeroPower() {
		return heroPower;
	}
	public void setHeroPower(String heroPower) {
		this.heroPower = heroPower;
	}
	
	public Integer getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return "Hero: " + this.name + " his hero power is: " + this.heroPower;
	}
	
	
}
