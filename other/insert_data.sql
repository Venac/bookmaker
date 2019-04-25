delete from matches_tickets;
alter table matches_tickets auto_increment=1;
delete from matches;
alter table matches auto_increment=1;
delete from teams;
alter table teams auto_increment=1;
delete from operators;
alter table operators auto_increment=1;
delete from tickets;
alter table tickets auto_increment=1;
delete from transactions;
alter table transactions auto_increment=1;
delete from users;
alter table users auto_increment=1;
delete from bookmakers;
alter table bookmakers auto_increment=1;

insert into bookmakers
(name, balance)
values
("Balkanbet", 150000000);

insert into teams
(name)
values
("Liverpool"),
("Manchester City"),
("Arsenal"),
("Tottenham"),
("Manchester United");

insert into operators
(first_name, last_name, email, password, bookmaker_id)
values
("Stanoje", "Stanojevic", "stanoje@gmail.com", "stanoje123", 1),
("Vidoje", "Vidojevic", "vidoje@gmail.com", "vidoje123", 1);

insert into users
(balance, first_name, last_name, email, password, bookmaker_id)
values
(9000, "Lepoje", "Lepojevic", "stefanfilipovic1987@gmail.com", "lepoje123", 1),
(8000, "Vukoje", "Vukojevic", "stefanfilipovic1987@gmail.com", "vukoje123", 1),
(12000, "Miloje", "Milojevic", "stefanfilipovic1987@gmail.com", "miloje123", 1),
(15000, "Spasoje", "Spasojevic", "stefanfilipovic1987@gmail.com", "spasoje123", 1);

insert into matches
(outcome, match_date, home_team_id, visiting_team_id, operator_id)
values
(0, now(), 1, 2, 1),
(0, now(), 1, 3, 1),
(0, now(), 2, 3, 1),
(0, now(), 3, 4, 2),
(0, now(), 3, 4, 2),
(0, now(), 4, 5, 2);

insert into tickets
(bet_amount, won, user_id)
values
(100, 0, 1),
(2000, 0, 2),
(300, 0, 3),
(450, 0, 1),
(3500, 0, 2),
(20, 0, 1);

insert into matches_tickets
(outcome_prediction, ticket_id, match_id)
values
(1, 1, 1),
(2, 1, 2),
(2, 2, 3),
(2, 2, 4),
(2, 3, 5),
(2, 3, 6),
(2, 4, 6),
(2, 4, 1),
(2, 5, 5),
(2, 5, 4),
(2, 6, 3),
(2, 6, 2);

insert into transactions
(transaction_date, amount, transaction_type, user_id, bookmaker_id)
values
(now(), 1000, 1, 1, 1),
(now(), 2000, 2, 1, 1),
(now(), 1500, 3, 2, 1),
(now(), 2500, 4, 2, 1),
(now(), 1750, 1, 3, 1),
(now(), 2750, 2, 3, 1),
(now(), 1875, 3, 4, 1),
(now(), 2875, 4, 4, 1);