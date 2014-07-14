-- address Sample data
--insert into address
--	values(0, '08540', '5 Independence Way','Princeton' ,'NJ');
--insert into address
--	values(1, '07030', '245 5th Street', 'Hoboken', 'NJ');

-- all_user Sample data
insert into all_user
	values(0, 'test_user0', 'test@gmail.com', '2014449999',
			'John', 'Doe', 'mercury', 'c',
			'08540', '5 Independence Way','Princeton' ,'NJ');
insert into all_user
	values(1, 'administrator', 'admin@gmail.com', '1043332222',
			'Admin', 'Smith', 'mercury', 'a',
			'07030', '245 5th Street', 'Hoboken', 'NJ');
insert into all_user
	values(2, 'admin', 'admin@aol.com', '2220004444',
			'Admin', 'Howard', 'mercury', 'a',
			'08540', '5 Independence Way','Princeton' ,'NJ');

-- card Sample data
insert into card
	values('3714496353984312', 0, '5', '2015', 'VISA');
insert into card
	values('4111111111111111', 0, '6', '2020', 'MASTER');
insert into card
	values('5105105105105100', 0, '12', '2017', 'MASTER');
insert into card
	values('378282246310005', 0, '8', '2040', 'AMERICAN EXPRESS');

-- user_cards sample data
--insert into user_cards
--	values(0, 0);
--insert into user_cards
--	values(0, 1);
--insert into user_cards
--	values(0, 2);
--insert into user_cards
--	values(0, 3);

-- station sample data
insert into station
	values(0, 'Princeton Junction', 'NJ', 'Princeton');
insert into station
	values(1, 'Hoboken Terminal', 'NJ', 'Hoboken');
insert into station
	values(2, 'Penn Station', 'NY', 'New York');
insert into station
	values(3, 'New Brunswick', 'NJ', 'New Brunswick');
insert into station
	values(4, 'Hudson', 'NY', 'Hudson');
insert into station
	values(5, 'Buffalo–Depew', 'NY', 'Buffalo');

-- ticket sample data
insert into ticket
	values(0, 'ADAO42', 0, 5, 50, 70, 
		(select current_timestamp from dual), null);
insert into ticket
	values(1, 'IHsB3D', 0, 1, 100, 10, null , null);
insert into ticket
	values(2, '84NBY3', 0, 2, 50, 25, null , null);
insert into ticket
	values(3, '0JB84S', 0, 3, 20, 7.5, null , null);
insert into ticket
	values(4, 'MX9SS3', 2, 4, 20, 20, null , null);
insert into ticket
	values(5, '9HVOQD', 2, 5, 40, 55, null , null);
insert into ticket
	values(6, 'YB7NBE', 3, 4, 20, 40, null , null);

-- transaction sample data
insert into transaction 
	values (0, 0, 4,
		(select current_timestamp from dual));
insert into transaction 
	values (1, 0, 2, null);
insert into transaction 
	values (2, 0, 0, null);
insert into transaction 
	values (3, 0, 3, null);
insert into transaction 
	values (4, 0, 6, null);
insert into transaction 
	values (5, 0, 2, null);

commit;

-- Display all results properly.
set numwidth 5;

column username format a10;
column email format a10;
column first_name heading FNAME;
column last_name heading LNAME;
column first_name format a8;
column last_name format a8;
column address_id heading ADDRESS;
column password format a10;
select * from all_user;

set numwidth 5;
select * from card;

select * from station;

column start_time format a15;
column arrive_time format a15;
select * from ticket;

column order_time format a30;
select * from transaction;

-- Clear certain column format
column column_name clear;

-- Clear all columns
clear columns