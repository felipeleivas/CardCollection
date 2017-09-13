insert into rarity(name,id) values('Common',1);
insert into rarity(name,id) values('Rare',2);
insert into rarity(name,id) values('Epic',3);
insert into rarity(name,id) values('Legendary',4);

insert into types(id, name) values (1,'Murloc');
insert into types(id, name) values (2,'Demon');
insert into types(id, name) values (3,'Mech');
insert into types(id, name) values (4,'Elemental');
insert into types(id, name) values (5,'Dragon');
insert into types(id, name) values (6,'Beast');
insert into types(id, name) values (7,'None');
insert into types(id, name) values (8,'Pirate');



insert into heros(power,id,name) values ('Deal 2 damage to the enemy Hero',1,'Rexxar');
insert into heros(power,id,name) values ('Deal 1 damage ',2,'Jaina');
insert into heros(power,id,name) values ('Gain 2 armor',3,'Garrosh');
insert into heros(power,id,name) values ('Equip a 1/2 Dagger',4,'Valira');
insert into heros(power,id,name) values ('Restore 2 health',5,'Anduin');
insert into heros(power,id,name) values ('Summon a 1/1 Silver Hand Recruit',6,'Uther');
insert into heros(power,id,name) values ('Draw a card and take 2 damage',7,'Guldan');
insert into heros(power,id,name) values ('Summon a random basic totem',8,'Thrall');
insert into heros(power,id,name) values ('Gain 1 armor and 1 Attack',9,'Malfurion');
insert into heros(power,id,name) values ('',10,'None');

insert into cards(name,description,rarity,hero,id,cost) values ('Gorehowl','',1,3,1,7);
insert into weapons(attack,duration,id) values (7,1,1);

insert into cards(name,description,rarity,hero,id,cost) values ('Vilespine Slayer','Combo: Destroy a minion',3,4,13,5);
insert into minions(maxatk,maxlife,typeofminion,id) values (3,4,7,13);

insert into cards(name,description,rarity,hero,id,cost) values ('Tirion','Divine shield, taunt and deathRattle: Gain a 5/3 Ash Bringer',4,6,2,8);
insert into minions(maxatk,maxlife,typeofminion,id) values (1,2,7,2);

insert into cards(name,description,rarity,hero,id,cost) values ('Flame Strike','Deal 4 damage to all enemy minions',2,2,3,1);
insert into spells(id) values (3);

insert into cards(name,description,rarity,hero,id,cost) values ('Sylvannas','DeathRattle',2,1,4,1);
insert into minions(maxatk,maxlife,typeofminion,id) values (1,2, 7,4);

insert into cards(name,description,rarity,hero,id,cost) values ('Fireball','Deal 6 damage',2,2,5,1);
insert into spells(id) values (5);

insert into cards(name,description,rarity,hero,id,cost) values ('Fiery Axe','',1,3,6,3);
insert into weapons(attack,duration,id) values (3,2,6);

insert into cards(name,description,rarity,hero,id,cost) values ('Counterfeit coin','Gain one mana Crystal this turn',2,4,7,0);
insert into spells(id) values (7);

insert into cards(name,description,rarity,hero,id,cost) values ('Binding Heal','Restore 5 health for a minion and your hero',2,5,8,1);
insert into spells(id) values (8);

insert into cards(name,description,rarity,hero,id,cost) values ('Consacration','Deal 2 damage to all enemies',2,6,9,4);
insert into spells(id) values (9);

insert into cards(name,description,rarity,hero,id,cost) values ('Dark Bomb','Deal 3 damage',2,7,10,2);
insert into spells(id) values (10);

insert into cards(name,description,rarity,hero,id,cost) values ('Lightning Bolt','Deal 3 damage, Overload:(1)',2,8,11,0);
insert into spells(id) values (11);

insert into cards(name,description,rarity,hero,id,cost) values ('Innervate','Gain 2 mana crystals this turn',2,9,12,0);
insert into spells(id) values (12);