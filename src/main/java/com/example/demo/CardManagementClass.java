package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;

@Component
public class CardManagementClass implements CardManagement{
	private SpellRepository spell;
	private MinionRepository minions;
	private WeaponRepository weapons;
	
	@Autowired
	public CardManagementClass(SpellRepository spell,MinionRepository minions,  WeaponRepository weapons ) {
		this.spell = spell;
		this.minions = minions;
		this.weapons = weapons;
	}
	
	@Override
	public void addCard(Card card) throws TypeOfCardNotExist {
		if (card.getClass() == Weapon.class) {
			this.saveWeapon((Weapon) card);
		}
		else if (card.getClass() == Minion.class) {
			this.saveMinion((Minion) card);
		}
		else if (card.getClass() == Spell.class) {
			this.saveSpell((Spell) card);
		}
		else {
			throw new TypeOfCardNotExist("That is not a valid type of card");
		}
	}

	@Override
	public void updateMinion(Minion newMinion){
		this.minions.save(newMinion);
		
	}

	@Override
	public void updateWeapon(Weapon updatedWeapon) {
		this.weapons.save(updatedWeapon);
	}
		
	

	@Override
	public void updateSpell(Spell updatedSpell){
		this.spell.save(updatedSpell);
	}

	@Override
	public void deleteCard(Integer cardId) throws CardNotFoundException {
		
		Card card = this.getCardByCode(cardId);
		if(card != null) {
			if(card.getClass() == Spell.class) {
				this.spell.delete(cardId);
			}
			if(card.getClass() == Minion.class) {
				this.minions.delete(cardId);
			}
			if(card.getClass() == Weapon.class) {
				this.weapons.delete(cardId);
			}
		}
		else {
			throw new CardNotFoundException("There is not card with that ID");
		}
	}

	@Override
	public List<Card> showCardWithRarity(Rarity rarity) {
		Iterable<? extends Card> list = null;
		List<Card> cardList = new ArrayList<Card>();
		
		list = this.weapons.findByRarity(rarity);
		if(list != null) {
			List<? extends Card> cardListWeapons = this.toList(list);	
			cardList.addAll(cardListWeapons);	
		}
		
		list = this.minions.findByRarity(rarity);
		if(list != null) {
			List<? extends Card> cardListMinions = this.toList(list);	
			cardList.addAll(cardListMinions);
			
		}
		
		list = this.spell.findByRarity(rarity);
		if(list != null) {
			List<? extends Card> cardListspell = this.toList(list);	
			cardList.addAll(cardListspell);
			
		}
		
		cardList = this.sortCards(cardList);
		return cardList;
	}

	@Override
	public  List<Card> showAllCards() {
		Iterable<? extends Card> list = null;
		List<Card> cardList = new ArrayList<Card>();
		
		list = this.weapons.findAll();
		if(list != null) {
			List<? extends Card> cardListWeapons = this.toList(list);	
			cardList.addAll(cardListWeapons);	
		}
		
		list = this.minions.findAll();
		if(list != null) {
			List<? extends Card> cardListMinions = this.toList(list);	
			cardList.addAll(cardListMinions);
			
		}
		
		list = this.spell.findAll();
		if(list != null) {
			List<? extends Card> cardListspell = this.toList(list);	
			cardList.addAll(cardListspell);
			
		}
		cardList = this.sortCards(cardList);
		return cardList; 
	}

	@Override
	public Card showCard(String cardName) throws CardNotFoundException {
		Card card = this.minions.findByName(cardName);
		if(card != null) {
			return card;
		}
		card = this.spell.findByName(cardName);
		if(card != null) {
			return card;
		}
		card = this.weapons.findByName(cardName);
		if(card != null) {
			return card;
		}
			
		throw new CardNotFoundException("There is no card with that name");
	}


	@Override
	public List<Spell> showAllSpells() {
		return this.toList(this.spell.findAll());
	}

	@Override
	public List<Weapon> showAllWeapons() {
		return this.toList(this.weapons.findAll());
	}

	@Override
	public List<Minion> showAllMinions() {
		return this.toList(this.minions.findAll());
	}

	@Override
	public List<Card> showAllCardsWithCost(Integer cost) {
		Iterable<? extends Card> list = null;
		List<Card> cardList = new ArrayList<Card>();
		
		list = this.weapons.findByCost(cost);
		if(list != null) {
			List<? extends Card> cardListWeapons = this.toList(list);	
			cardList.addAll(cardListWeapons);	
		}
		
		list = this.minions.findByCost(cost);
		if(list != null) {
			List<? extends Card> cardListMinions = this.toList(list);	
			cardList.addAll(cardListMinions);
			
		}
		
		list = this.spell.findByCost(cost);
		if(list != null) {
			List<? extends Card> cardListspell = this.toList(list);	
			cardList.addAll(cardListspell);
			
		}
		cardList = this.sortCards(cardList);
		return cardList;
	}
	
	@Override
	public Card getCardByCode(Integer cardId) {
		Card cardFound = this.findSpell(cardId);
		if(cardFound != null) {
			return cardFound;
		}
		cardFound = this.findWeapon(cardId);
		if(cardFound != null) {
			return cardFound;
		}
		cardFound = this.findMinion(cardId);
		return cardFound;
	}
	private Spell findSpell(Integer cardId) {
		Spell spell = this.spell.findOne(cardId);
		return spell;			
	}
	private Weapon findWeapon(Integer cardId) {
		return this.weapons.findOne(cardId);
	}
	private Minion findMinion(Integer cardId) {
		return this.minions.findOne(cardId);
	}
	private void saveMinion(Minion minion) {
		this.minions.save(minion);
	}
	private void saveSpell(Spell spell) {
		this.spell.save(spell);
	}
	private void saveWeapon(Weapon weapon) {
		this.weapons.save(weapon);
	}
	private <T> List<T> toList(final Iterable<T> iterable) {
	    return StreamSupport.stream(iterable.spliterator(), false)
	                        .collect(Collectors.toList());
	}

	@Override
	public List<Card> showHeroAllCards(Hero hero) {
		Iterable<? extends Card> list = null;
		List<Card> cardList = new ArrayList<Card>();
		
		list = this.weapons.findByHero(hero);
		if(list != null) {
			List<? extends Card> cardListWeapons = this.toList(list);	
			cardList.addAll(cardListWeapons);	
		}
		
		list = this.minions.findByHero(hero);
		if(list != null) {
			List<? extends Card> cardListMinions = this.toList(list);	
			cardList.addAll(cardListMinions);
			
		}
		
		list = this.spell.findByHero(hero);
		if(list != null) {
			List<? extends Card> cardListspell = this.toList(list);	
			cardList.addAll(cardListspell);
			
		}
		cardList = this.sortCards(cardList);
		return cardList;

	}
	private List<Card> sortCards(List<Card> cardList){
		 Collections.sort(cardList, (Comparator<? super Card>) (Card c1, Card c2) -> c1.getId().compareTo(c2.getId()));
		 return cardList;
	}

}
