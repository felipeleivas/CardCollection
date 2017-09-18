package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "minions")
@PrimaryKeyJoinColumn(name="id")
public class Minion extends Card {
	@NotNull
	@Min(0)
	@Column(name = "maxlife")
	private Integer maxLife;
	@NotNull
	@Min(0)
	@Column(name = "maxatk")
	private Integer maxAtk;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "typeofminion")
	private TypeOfMinion typeOfMinion;
	@NotNull
	
	
	public Minion(Rarity rarity,Integer cost, String description,Hero hero, String name ,Integer maxLife, Integer maxAtk, TypeOfMinion typeOfMinion) {
		super(name , description, rarity, hero,cost);
		this.maxLife = maxLife;
		this.maxAtk = maxAtk;
		this.typeOfMinion = typeOfMinion;
	
	}
	
	public Minion() {
		
	}
	
	public Integer getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(Integer maxLife) {
		this.maxLife = maxLife;
	}

	public Integer getMaxAtk() {
		return maxAtk;
	}

	public void setMaxAtk(Integer maxAtk) {
		this.maxAtk = maxAtk;
	}

	public TypeOfMinion getTypeOfMinion() {
		return typeOfMinion;
	}

	public void setTypeOfMinion(TypeOfMinion typeOfMinion) {
		this.typeOfMinion = typeOfMinion;
	}
	
}
