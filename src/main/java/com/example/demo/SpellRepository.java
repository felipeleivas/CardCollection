package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends CrudRepository<Spell, Integer>{
	Spell findByName(String name);
	Iterable<Spell> findByCost(Integer cost);
	Iterable<Spell> findByRarity(Rarity rarity);
	Iterable<Spell> findByHero(Hero hero);
}
