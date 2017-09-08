package com.example.demo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cards", uniqueConstraints = 	@UniqueConstraint(columnNames="name"))
public abstract class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull
	@Size(min=1, max = 20)
	@Column(name = "name")
	private String name;
	
	@Size(max = 100)
	private String description;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rarity")
	private Rarity rarity;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "hero")
	private Hero hero;
	
	@Min(0)
	@NotNull
	private Integer cost;
	
	public Card() {
		
	}
	
	public Card(String name, String description, Rarity rarity, Hero hero,Integer cost) {
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.hero = hero;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescriptionn(String descreation) {
		this.description = descreation;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", descreption=" + description + ", rarity=" + rarity + ", hero="
				+ hero + ", cost=" + cost + "]";
	}
	
	
	
	
}
