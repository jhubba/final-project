Drop Database if exists `BullnotesDB`;
create database `BullnotesDB`;
use `BullnotesDB`;

Drop Table if exists `Users`;
Create Table `Users`(
`uid` int (10) not null Auto_Increment,
`fname` varchar(30) not null,
`lname` varchar(30) not null,
`email` varchar(100) not null,
`username` varchar(100) not null,
 `passwordHash` blob not null,
 primary key (`uid`)
 );
 
 Drop Table if exists `Watchlist`;
 Create Table `Watchlist`(
 `WID` int (10) not null auto_increment,
 `stockSym` varchar(256) not null,
 `uid` int(10) not null,
 primary key (`WID`),
 foreign key (`uid`) references `Users` (`uid`) 
 );
