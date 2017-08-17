Drop Database if exists `BullnotesDB`;
create database `BullnotesDB`;
use `BullnotesDB`;

Drop Table if exists `Users`;
Create Table `Users`(
`uid` int (10) not null Auto_Increment,
`username` varchar(100) not null,
`passwordHash` BIGINT not null,
`first_name` varchar(256) not null,
`last_name` varchar(256) not null,
`email` varchar(256) not null,
primary key (`uid`),
UNIQUE (username)
);
 
 Drop Table if exists `Watchlist`;
 Create Table `Watchlist`(
 `WID` int (10) not null auto_increment,
 `wl_name` varchar(256) not null,
 `stockSym` varchar(256) not null,
 `uid` int(10) not null,
 `default_wl` tinyint(1) default 0,
 primary key (`WID`),
 foreign key (`uid`) references `Users` (`uid`) 
 );
 
 -- add permissions to the database and a confg.properties with a db username and password setup for the database