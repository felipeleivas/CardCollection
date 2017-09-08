package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "spells")
@PrimaryKeyJoinColumn(name="id")
public class Spell extends Card{
	
	public Spell() {
		super();
	}
	
	public Spell( Integer cost,String name, String description, Rarity cardRarity, Hero hero) {
		super(name, description, cardRarity, hero, cost);
	}
	
	
}
