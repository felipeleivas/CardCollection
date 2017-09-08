package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinionRepository extends CrudRepository<Minion, Integer> {
	Minion findByName(String name);
	Iterable<Minion> findByCost(Integer cost);
	Iterable<Minion> findByHero(Hero hero);
	Iterable<Minion> findByRarity(Rarity rarity);
}
