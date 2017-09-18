insert into rarity(name,id) values('Common',SEQ_RARITY.NEXTVAL);
insert into rarity(name,id) values('Rare',SEQ_RARITY.NEXTVAL);
insert into rarity(name,id) values('Epic',SEQ_RARITY.NEXTVAL);
insert into rarity(name,id) values('Legendary',SEQ_RARITY.NEXTVAL);

insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Murloc');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Demon');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Mech');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Elemental');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Dragon');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Beast');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'None');
insert into types(id, name) values (SEQ_TYPES_MINIONS.NEXTVAL,'Pirate');



insert into heros(power,id,name) values ('Deal 2 damage to the enemy Hero',SEQ_HERO.NEXTVAL,'Rexxar');
insert into heros(power,id,name) values ('Deal 1 damage ',SEQ_HERO.NEXTVAL,'Jaina');
insert into heros(power,id,name) values ('Gain 2 armor',SEQ_HERO.NEXTVAL,'Garrosh');
insert into heros(power,id,name) values ('Equip a 1/2 Dagger',SEQ_HERO.NEXTVAL,'Valira');
insert into heros(power,id,name) values ('Restore 2 health',SEQ_HERO.NEXTVAL,'Anduin');
insert into heros(power,id,name) values ('Summon a 1/1 Silver Hand Recruit',SEQ_HERO.NEXTVAL,'Uther');
insert into heros(power,id,name) values ('Draw a card and take 2 damage',SEQ_HERO.NEXTVAL,'Guldan');
insert into heros(power,id,name) values ('Summon a random basic totem',SEQ_HERO.NEXTVAL,'Thrall');
insert into heros(power,id,name) values ('Gain 1 armor and 1 Attack',SEQ_HERO.NEXTVAL,'Malfurion');
insert into heros(power,id,name) values (' ',SEQ_HERO.NEXTVAL,'None');

commit;