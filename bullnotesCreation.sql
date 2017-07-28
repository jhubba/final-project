Drop Database if exists `BullnotesDB`;
create database `BullnotesDB`;
use `BullnotesDB`;

Drop Table if exists `Users`;
Create Table `Users`(
`uid` int (10) not null Auto_Increment,
`username` varchar(100) not null,
 `passwordHash` BIGINT not null,
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

insert into users (username, passwordHash) values ('testuser', 1216985755);
SELECT * FROM users
-- Use the user we all have already setup and now in the config properties file
-- CREATE USER 'testuser' IDENTIFIED BY 'p@ssw0rD';
-- Grant all on BullnotesDB.* to `testuser`;


