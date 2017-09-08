package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Integer> {
	Weapon findByName(String name);
	Iterable<Weapon> findByCost(Integer cost);
	Iterable<Weapon> findByHero(Hero hero);
	Iterable<Weapon> findByRarity(Rarity rarity);
}


