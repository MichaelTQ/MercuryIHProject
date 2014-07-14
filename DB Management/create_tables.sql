-- Drop all the tables:
drop table transaction;
drop table ticket;
drop table station;
--drop table user_cards;
drop table card;
drop table all_user;
--drop table address;

-- Create table address
--create table address (
--	id number(10) primary key,
--	zip_code char(5),
--	street varchar2(20),
--	city varchar2(20),
--	state char(2)
--);

-- Create table all_user
-- type: 'c' means 'customers', 'a' means 'administrators'

create table all_user (
	id number(10) primary key,
	username varchar2(20) not null unique,
	email varchar2(40) not null unique,
	phone varchar2(10),
	first_name varchar2(20),
	last_name varchar2(20),
	password varchar2(50) not null,
	type char(1) not null,
	zip_code char(5),
	street varchar2(20),
	city varchar2(20),
	state char(2)
);

-- Create table card
create table card (
	card_number char(16) primary key,
	user_id number(10),
	ex_month char(2),
	ex_year char(4),
	card_type varchar2(20),
	constraint card_user_fk
		foreign key (user_id) references all_user (id)
);

-- Create table user_cards
--create table user_cards (
--	user_id number(10),
--	card_id number(10),
--	constraint user_cards_pk
--		primary key (user_id, card_id),
--	constraint user_cards_user_fk
--		foreign key (user_id) references all_user (id),
--	constraint user_cards_card_fk
--		foreign key (card_id) references card (id)
--);

-- Create table station
create table station (
	id number(10) primary key,
	name varchar2(20) not null,
	state char(2),
	city varchar2(20)
);

-- Create table ticket
create table ticket (
	id number(10) primary key,
	order_number varchar2(10),
	from_id number(10) not null,
	to_id number(10) not null,
	max_num number(4),
	price number(4, 2),
	start_time timestamp,
	arrive_time timestamp,
	constraint ticket_from_station_fk
		foreign key (from_id) references station (id),
	constraint ticket_to_station_fk
		foreign key (to_id) references station (id),
	constraint check_from_to check
		(from_id > to_id or from_id < to_id)
);

-- Create table transaction
create table transaction (
	id number(10) primary key,
	user_id number(10) not null,
	ticket_id number(10) not null,
	order_time timestamp,
	constraint transaction_user_fk
		foreign key (user_id) references all_user (id),
	constraint transaction_ticket_fk
		foreign key (ticket_id) references ticket (id)
);


-- Clear Data from all tables
alter table transaction
	disable constraint transaction_user_fk;
alter table transaction
	disable constraint transaction_ticket_fk;
alter table ticket
	disable constraint ticket_from_station_fk;
alter table ticket
	disable constraint ticket_to_station_fk;
alter table card
	disable constraint card_user_fk;
--alter table user_cards
--	disable constraint user_cards_card_fk;
--alter table user_cards
--	disable constraint user_cards_user_fk;
--alter table all_user
--	disable constraint all_user_address_fk;
--truncate table address;
truncate table all_user;
truncate table card;
--truncate table user_cards;
truncate table station;
truncate table ticket;
truncate table transaction;
--alter table all_user
--	enable constraint all_user_address_fk;
--alter table user_cards
--	enable constraint user_cards_user_fk;
--alter table user_cards
--	enable constraint user_cards_card_fk;
alter table card
	enable constraint card_user_fk;
alter table ticket
	enable constraint ticket_to_station_fk;
alter table ticket
	enable constraint ticket_from_station_fk;
alter table transaction
	enable constraint transaction_ticket_fk;
alter table transaction
	enable constraint transaction_user_fk;
