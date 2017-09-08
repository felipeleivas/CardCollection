package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer>{
	public Hero findByName(String name);
	public Hero findById(Integer id);

}
