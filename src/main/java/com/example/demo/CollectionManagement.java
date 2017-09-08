package com.example.demo;

import java.util.List;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;

public interface CollectionManagement {

	public void addCard(Card card) throws TypeOfCardNotExist;
	public void updateCost(Integer cardId, Integer newCost) throws CardNotFoundException;
	public void updateAtk(Integer cardId, Integer newAtk) throws CardNotFoundException;
	public void updateDef(Integer cardId, Integer newDef) throws CardNotFoundException;
	public void deleteCard(Integer cardId) throws CardNotFoundException;
	
	public Card showCard(Integer id) throws CardNotFoundException;
	public Card showCard(String cardName) throws CardNotFoundException;
	public List<Card> showCardWithRarity(Rarity rarity);
	public List<Card> showAllCards();
	public List<Spell> showAllSpells();
	public List<Weapon> showAllWeapons();
	public List<Minion> showAllMinions();
	public List<Card> showAllCardsWithCost(Integer cost);
	
	public void addHero(Hero hero);
	public List<Card> showAllHeroCards(String heroName);
	
	public Hero getHero(String heroName);
	public Rarity getRarity(Integer id);
	public TypeOfMinion getTypeOfMinion(Integer id);

	public List<Rarity> getRarities();
	public List<TypeOfMinion> getTypesOfMinions();
	public List<Hero> getHeros();
}
