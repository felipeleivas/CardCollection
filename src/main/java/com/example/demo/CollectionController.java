package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/showCard")
	public String showCardPost(@RequestParam("cardName") String cardName,Model model) {
		Card card = null;
		try {
			card = this.cm.showCard(cardName);
		} catch (CardNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@GetMapping("update/cost")
	public String updateCost2(Model model) {
		return "updateCost" ;
	}
	
	@PostMapping("update/cost")
	public String updateCost(@RequestParam("id") Integer id, @RequestParam("newCost") Integer newCost,Model model) {
		try {
			this.cm.updateCost(id, newCost);
			model.addAttribute("Card",this.cm.showCard(id));
		} catch (CardNotFoundException e) {
			model.addAttribute("message","There is no card with that ID");
			return "cardNotFound";
		}
		return "postShowCard" ;
	}
	
	@GetMapping("update/atk")
	public String updateAtk2(Model model) {
		return "updateAtk" ;
	}
	
	@PostMapping("update/atk")
	public String updateAtk(@RequestParam("id") Integer id, @RequestParam("newAtk") Integer newAtk,Model model) {
		try {
			this.cm.updateAtk(id, newAtk);
			model.addAttribute("Card",this.cm.showCard(id));
		} catch (CardNotFoundException e) {
			model.addAttribute("message","There is no minions with that ID");
			return "cardNotFound";
		}
		return "postShowMinion" ;
	}


	@GetMapping("/update/def")
	public String updateDef2(Model model) {
		return "updateDef" ;
	}
	
	@PostMapping("/update/def")
	public String updateDef(@RequestParam("id") Integer id, @RequestParam("newDef") Integer newDef,Model model) {
		try {
			this.cm.updateDef(id, newDef);
			model.addAttribute("Card",this.cm.showCard(id));
		} catch (CardNotFoundException e) {
			model.addAttribute("message","There is no minions with that ID");
			return "cardNotFound";
		}
		return "postShowCard" ;
	}

	
	@GetMapping("deleteCard")
	public String deleteCard(Model model) {
		return "deleteCard" ;
	}
	
	@PostMapping("deleteCard")
	public String deleteCard2(@RequestParam("id") Integer id,Model model) {
		try {
			System.out.println(id);
			this.cm.deleteCard(id);
		} catch (CardNotFoundException e) {
			model.addAttribute("message", e.getMessage());
			return "cardNotFound";
		}
		return "redirect:/show/Cards" ;
	}
	
	
	
	
	
}
