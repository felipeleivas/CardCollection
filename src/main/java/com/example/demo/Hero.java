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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import exceptions.CardNotFoundException;

@Entity
@Table(name = "heros")
public class Hero {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull
	@Size(min= 2, max = 10)
	private String 	name;
	
	@NotNull
	@Column(name = "power")
	private String  heroPower;
	
	@JoinColumn(name = "cardList")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Card> cardList;
	
	public Hero() {
		this.cardList = new ArrayList<Card>();
	}
	
	@Autowired
	public Hero(String name, String heroPower) {
		this.name = name;
		this.heroPower = heroPower;
		this.cardList = new ArrayList<Card>();
	}
	
	
	public void addCardToHero(Card newCard) {
		this.cardList.add(newCard);
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
	public List<Card> getCardList() {
		return cardList;
	}
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	public Integer getId() {
		return id;
	}
	
	public void deleteCardFromCardList(Card card) throws CardNotFoundException {
		if( this.cardList.contains(card) == true) {
			this.cardList.remove(card);
		}
		else {
			throw new CardNotFoundException("These card doesn't belong to this hero");			
		}
	}
	@Override
	public String toString() {
		return "Hero: " + this.name + " his hero power is: " + this.heroPower + "and he has " + this.cardList.size() + " cards";
	}
	
	
}
