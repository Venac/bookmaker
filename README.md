# Spring Boot REST API for online betting

REST API emulates an online bookmaker. Registered users can pick from a list of available sport matches to bet on. 

Each match is comprised of competition between two teams - it has a play date and one of three possible outcomes on which the users can bet - home team wins the game, visiting team wins the game or there is a draw. Match outcome is generated randomly at midnight on the following day. Teams and matches are added through the API by the bookmaker staff – operators.

User compiles a ticket of matches that he wants to bet on with his outcome guess for each match. If the user has correctly predicted all the selected outcomes he wins a prize, calculated by multiplying cumulatively the amount of money that he placed by constant of 1.5 for each of the matches. 

Upon the resolution of ticket outcome, the user receives an email with relevant information and if the ticket has passed, the prize money gets transferred from bookmaker’s account to his own.  

Upon registering, each user receives starting amount of 5 EUR on his account, calculated in RSD at a daily exchange rate. The user places bets with the funds that he has transferred to his betting account. Apart from RSD, the user can add and withdraw funds in several different currencies offered by the bookmaker, at the specified exchange rate. Exchange rates are updated daily through an OpenAPI.

Each of the monetary transactions (adding funds; withdrawing funds; placing a bet; winning a bet) in the API are of transactional nature (the process is either completely finished and committed or rolled back in case of an exception).

User and operator registration and logging is secured by JWT through implementation of a filter – each user and operator is assigned a unique token and has set of pages/URIs that he can access.
