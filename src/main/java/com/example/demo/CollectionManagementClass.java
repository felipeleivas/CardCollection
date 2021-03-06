package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;
@Component
public class CollectionManagementClass implements CollectionManagement{
	private HeroRepository hp;
	private CardManagement cm;
	private RarityRepository rr;
	private TypeOfMinionRepository tr;
	@Autowired
	public CollectionManagementClass(HeroRepository hp, CardManagement cm,TypeOfMinionRepository tr, RarityRepository rr) {
		this.hp = hp;
		this.cm = cm;
		this.rr = rr;
		this.tr = tr;
	}
	
	@Override
	public void addCard(Card card) throws TypeOfCardNotExist {
		cm.addCard(card);
		Hero hero =  card.getHero();
		hero.addCardToHero(card);
		hp.save(hero);
		
	}

	@Override
	public void updateMinion(Minion updatedMinion) {
		cm.updateMinion(updatedMinion);
		
	}

	@Override
	public void updateSpell(Spell updatedSpell){
		this.cm.updateSpell(updatedSpell);
	}

	@Override
	public void updateWeapon(Weapon updatedWeapon){
		this.cm.updateWeapon(updatedWeapon);
		
	}

	@Override
	public void deleteCard(Integer cardId) throws CardNotFoundException {
		Card card = cm.getCardByCode(cardId);
		if(card != null) {
			cm.deleteCard(cardId);
		}
	}

	@Override
	public Card showCard(String cardName) throws CardNotFoundException {
		return this.cm.showCard(cardName);
	}

	@Override
	public List<Card> showCardWithRarity(Rarity rarity) {
		return this.cm.showCardWithRarity(rarity);
	}

	@Override
	public List<Card> showAllCards() {
		return this.cm.showAllCards();
	}

	@Override
	public List<Spell> showAllSpells() {
		return this.cm.showAllSpells();
	}

	@Override
	public List<Weapon> showAllWeapons() {
		return this.cm.showAllWeapons();
	}

	@Override
	public List<Minion> showAllMinions() {
		return this.cm.showAllMinions();
	}

	@Override
	public List<Card> showAllCardsWithCost(Integer cost) {
		return this.cm.showAllCardsWithCost(cost);
	}

	@Override
	public void addHero(Hero hero) {
		this.hp.save(hero);
	}

	@Override
	public List<Card> showAllHeroCards(String  heroName) {
		return this.cm.showHeroAllCards(this.hp.findByName(heroName));
	}

	@Override
	public Hero getHero(String heroName) {
		return this.hp.findByName(heroName);
	}

	@Override
	public List<Rarity> getRarities() {
		
		return this.toList(this.rr.findAll());
	}

	@Override
	public List<TypeOfMinion> getTypesOfMinions() {
		// TODO Auto-generated method stub
		return this.toList(this.tr.findAll());
	}
	private <T> List<T> toList(final Iterable<T> iterable) {
	    return StreamSupport.stream(iterable.spliterator(), false)
	                        .collect(Collectors.toList());
	}

	@Override
	public List<Hero> getHeros() {
		
		return this.toList(this.hp.findAll());
	}

	@Override
	public Rarity getRarity(Integer id) {
		return this.rr.findOne(id);
	}

	@Override
	public TypeOfMinion getTypeOfMinion(Integer id) {
		return this.tr.findOne(id);
	}

	@Override
	public Card showCard(Integer id) throws CardNotFoundException {
		return this.cm.getCardByCode(id);
	}

}
