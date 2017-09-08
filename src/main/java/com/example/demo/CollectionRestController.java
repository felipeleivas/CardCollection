package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.TypeOfCardNotExist;

@RestController
public class CollectionRestController {
	private CollectionManagement cm;
	
	@Autowired
	public CollectionRestController(CollectionManagement cm) {
		this.cm = cm;
	}
	
	public CollectionRestController() {
		
	}
	
	@RequestMapping("/show")
	public String showAllCards(){
		List<Card> x = cm.showAllCards();
		if (x == null) {
			return "ERROR";
		}
		return x.toString();
	}
	
	@RequestMapping("/autoUpdateTheDataBaseBecauseIDontKnowHowToImport")
	public void showCardWithRarity(){
		List<Card> x = cm.showAllCards();
		if (x != null) {
			for(Card card:x) {
				try {
					cm.addCard(card);
				} catch (TypeOfCardNotExist e) {

				}
			}
		}
	}
}
