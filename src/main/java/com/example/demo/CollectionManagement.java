package com.example.demo;

import java.util.List;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;

public interface CollectionManagement {

	public void addCard(Card card) throws TypeOfCardNotExist;
	public void updateMinion(Minion updatedMinion);
	public void updateSpell(Spell updatedSpell);
	public void updateWeapon(Weapon updatedWeapon);
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
