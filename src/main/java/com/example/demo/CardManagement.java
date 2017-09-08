package com.example.demo;

import java.util.List;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;

public interface CardManagement {
	
	public void addCard(Card card) throws TypeOfCardNotExist;
	public void updateMinion(Minion updatedMinion);
	public void updateAtk(Integer cardId, Integer newAtk) throws CardNotFoundException;
	public void updateDef(Integer cardId, Integer newDef) throws CardNotFoundException;
	public void deleteCard(Integer cardId) throws CardNotFoundException;
	
	public Card showCard(String cardName) throws CardNotFoundException;
	public List<Card> showCardWithRarity(Rarity rarity);
	public List<Card> showAllCards();
	public List<Spell> showAllSpells();
	public List<Weapon> showAllWeapons();
	public List<Minion> showAllMinions();
	public List<Card> showAllCardsWithCost(Integer cost);
	public List<Card> showHeroAllCards(Hero hero);

	public Card getCardByCode(Integer cardId);
	
}
