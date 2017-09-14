package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exceptions.CardNotFoundException;
import exceptions.TypeOfCardNotExist;

@Controller
public class CollectionController {
	CollectionManagement cm;
	
	@Autowired
	public CollectionController(CollectionManagement cm) {
		this.cm = cm;
	}
	@GetMapping("/show/Cards")
	public String showAllCards(Model model) {
		model.addAttribute("cards", cm.showAllCards());
		return "showCards";
	}
	
	@GetMapping("/show/Spells")
	public String showAllSpells(Model model) {
		model.addAttribute("spells", cm.showAllSpells());
		return "showSpells";
	}

	@GetMapping("/show/Weapons")
	public String showAllWeapons(Model model) {
		model.addAttribute("weapons", cm.showAllWeapons());
		return "showWeapons";
	}
	
	@GetMapping("/show/Minions")
	public String showAllMinions(Model model) {
		model.addAttribute("minions", cm.showAllMinions());
		return "showMinions";
	}
	
	@GetMapping("/show/Card")
	public String showCard(Model model) {
		return "getShowCard";
	}
	@RequestMapping("/showCard")
	public String showCardPost(@RequestParam("cardName") String cardName,Model model) {
		Card card = null;
		try {
			card = this.cm.showCard(cardName);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "There is no card with that name registred");
			return "cardNotFound";
			}
		
		model.addAttribute("Card",card);
		if(card.getClass() == Minion.class) {		
			return "postShowCardMinion";
		}
		else if(card.getClass() == Weapon.class) {
			return "postShowCardWeapon";
		}
		else if(card.getClass() == Spell.class) {
			return "postShowCardSpell";
		}
		else {
			return "error";
		}
	}
	
	@GetMapping("/show/CardsHero")
	public String showAllCardsHero(Model model) {
		model.addAttribute("heros",this.cm.getHeros());
		return "getShowCardsHero";
	}
	
	@PostMapping("/showCardsHero")
	public String showAllCardsHero2(@RequestParam("hero") String heroName,Model model) {
		List<Card> cards = this.cm.showAllHeroCards(heroName);
		model.addAttribute("cards", cards);
		return "showCards";
	}
	
	@GetMapping("/show/CardsWithCost")
	public String showCardsWithCost(Model model) {
		return "getShowCardsWithCost";
	}
	
	@PostMapping("/showCardsWithCost")
	public String showCardsWithCost2(@RequestParam("cost") Integer cost,Model model) {
		model.addAttribute("cards",this.cm.showAllCardsWithCost(cost));
		return "showCards";
	}
	
	
	@GetMapping("/addCard")
	public String addCard(Model model) {
		return "getAddCard";
	}
	@GetMapping("/addCard/minion")
	public String addCardMinion(Model model) {
		model.addAttribute("types", this.cm.getTypesOfMinions());
		model.addAttribute("rarities", this.cm.getRarities());
		model.addAttribute("heroes", this.cm.getHeros());

		return "addMinion";
	}
	
	@PostMapping("/addCard/minion") 
	public String addMinion(@RequestParam("name") String name,@RequestParam("description") String description,
								  @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
								  @RequestParam("rarity") Integer rarity,@RequestParam("maxAtk") Integer maxAtk,
								  @RequestParam("maxLife") Integer maxLife,@RequestParam("type") Integer type,Model model) {
		Minion minion = new Minion(this.cm.getRarity(rarity), cost, description, this.cm.getHero(hero), name, maxLife, maxAtk, this.cm.getTypeOfMinion(type));
		try {
			this.cm.addCard(minion);
		} catch (TypeOfCardNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/show/Cards";
	}
	
	@GetMapping("/addCard/spell")
	public String addCardSpell(Model model) {
		model.addAttribute("rarities", this.cm.getRarities());
		model.addAttribute("heroes", this.cm.getHeros());

		return "addSpell";
	}
	@PostMapping("/addCard/spell") 
	public String addSpell(@RequestParam("name") String name,@RequestParam("description") String description,
								  @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
								  @RequestParam("rarity") Integer rarity,Model model) {
		;
		Spell spell = new Spell(cost, name , description, this.cm.getRarity(rarity), this.cm.getHero(hero));
		try {
			this.cm.addCard(spell);
		} catch (TypeOfCardNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/show/Cards";
	}
	
	@GetMapping("/addCard/weapon")
	public String addCardWeapons(Model model) {
		model.addAttribute("rarities", this.cm.getRarities());
		model.addAttribute("heroes", this.cm.getHeros());

		return "addWeapon";
	}
	@PostMapping("/addCard/weapon") 
	public String addWeapons(@RequestParam("name") String name,@RequestParam("description") String description,
								  @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
								  @RequestParam("rarity") Integer rarity, @RequestParam("duration") Integer duration,
								  @RequestParam("attack") Integer attack, Model model) {
		;
		Weapon weapons = new Weapon(cost, attack, duration, name , description, this.cm.getRarity(rarity), this.cm.getHero(hero));
		try {
			this.cm.addCard(weapons);
		} catch (TypeOfCardNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/show/Cards";
	}
	
	
//	###############################################################################################################################################

	@GetMapping("update")
	public String update(Model model,@RequestParam("id")Integer id) {
		Card card = null;
		try {
			card=this.cm.showCard(id);
		} catch (CardNotFoundException e) {
			model.addAttribute("message", "Card not found");
			return "cardNotFound";
		}
		List<Hero> heroes = new ArrayList<Hero>(this.cm.getHeros());
		List<Rarity> rarities = new ArrayList<Rarity>(this.cm.getRarities());

		if(!(heroes.remove(card.getHero())) || !(rarities.remove(card.getRarity()))) {
			return "error";
		}
		
		model.addAttribute("rarities",rarities);
		model.addAttribute("chosenRarity", card.getRarity());
		
		model.addAttribute("heroes",heroes);
		model.addAttribute("chosenHero",card.getHero());
		
		model.addAttribute("card",card);
		
		
		if(card.getClass() == Minion.class) {
		
			List<TypeOfMinion> types = new ArrayList<TypeOfMinion>( this.cm.getTypesOfMinions() );
			Minion minion = (Minion) card;
			if(!(types.remove(minion.getTypeOfMinion()))){
				return "error";
			}
			model.addAttribute("typesOfMinion", types);
			model.addAttribute("chosenType", minion.getTypeOfMinion());
			return "updateMinion";
		}
		if(card.getClass() == Spell.class) {
			return "updatespell";
		}
		if(card.getClass() == Weapon.class) {
			return "updateweapon";
		}
		return "error" ;
	}
	
	@PostMapping("update/minion")
	public String updateMinion(@RequestParam("name") String name,@RequestParam("description") String description,
							   @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
							   @RequestParam("rarity") Integer rarity,@RequestParam("id") Integer id,@RequestParam("maxAtk") Integer maxAtk,
							   @RequestParam("maxLife") Integer maxLife,@RequestParam("type") Integer type,Model model) {
		
		Card card = null;
		Minion minion = null;
		try {
			card = this.cm.showCard(id);
		} catch (CardNotFoundException e) {
			return "error";
		}
		if(card.getClass() == Minion.class) {
			minion = (Minion) card;
			
			minion.setCost(cost);
			minion.setDescriptionn(description);
			minion.setHero(this.cm.getHero(hero));
			minion.setMaxAtk(maxAtk);
			minion.setMaxLife(maxLife);
			minion.setName(name);
			minion.setRarity(this.cm.getRarity(rarity));
			minion.setTypeOfMinion(this.cm.getTypeOfMinion(type));
			this.cm.updateMinion(minion);
			
		}
		
		
		return "redirect:/showCard?cardName="+minion.getName();
	}
	
	@PostMapping("update/spell")
	public String updateSpell(@RequestParam("name") String name,@RequestParam("description") String description,
							   @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
							   @RequestParam("rarity") Integer rarity,@RequestParam("id") Integer id) {
		
		Card card = null;
		Spell spell = null;
		try {
			card = this.cm.showCard(id);
		} catch (CardNotFoundException e) {
			return "error";
		}
		if(card.getClass() == Spell.class) {
			spell = (Spell) card;
			
			spell.setCost(cost);
			spell.setDescriptionn(description);
			spell.setHero(this.cm.getHero(hero));
			spell.setName(name);
			spell.setRarity(this.cm.getRarity(rarity));
			this.cm.updateSpell(spell);
			
		}
		
		
		return "redirect:/showCard?cardName="+spell.getName();
	}
	
	@PostMapping("/update/weapon")
	public String updateWeapon(	  @RequestParam("name") String name,@RequestParam("description") String description,
								  @RequestParam("cost") Integer cost,@RequestParam("hero") String hero,
								  @RequestParam("rarity") Integer rarity, @RequestParam("duration") Integer duration,
								  @RequestParam("attack") Integer attack, @RequestParam("id") Integer id, Model model) {
		Card card = null;
		Weapon weapon = null;
		try {
			card = this.cm.showCard(id);
		} catch (CardNotFoundException e) {
			return "error";
		}
		if(card.getClass() == Weapon.class) {
			weapon = (Weapon) card;
			
			weapon.setCost(cost);
			weapon.setDescriptionn(description);
			weapon.setHero(this.cm.getHero(hero));
			weapon.setName(name);
			weapon.setRarity(this.cm.getRarity(rarity));
			weapon.setAttack(attack);
			weapon.setDuration(duration);
		
			this.cm.updateWeapon(weapon);
			
		}
		
		
		return "redirect:/showCard?cardName="+weapon.getName();
	}

	
	@GetMapping("delete/ 	Card")
	public String deleteCard(Model model) {
		return "deleteCard" ;
	}
	@GetMapping("deleteCard")
	public String deleteCard2(@RequestParam("id") Integer id,Model model) {
		try {
			this.cm.deleteCard(id);
		} catch (CardNotFoundException e) {
			model.addAttribute("message", e.getMessage());
			return "cardNotFound";
		}
		return "redirect:/show/Cards" ;
	}
	
	
	
	
	
}
