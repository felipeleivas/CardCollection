package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "weapons")
@PrimaryKeyJoinColumn(name="id")
@OnDelete(action=OnDeleteAction.CASCADE)
public class Weapon extends Card {
	@Min(0)
	Integer attack;
	@Min(0)
	Integer duration;
	
	public Weapon() {
		super();
	}
	
	public Weapon(Integer cost, Integer attack, Integer duration, String name, String description, Rarity cardRarity, Hero hero) {
		super(name, description, cardRarity, hero, cost);
		this.attack = attack;
		this.duration = duration;
	}
	
	public Integer getAttack() {
		return attack;
	}
	
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
