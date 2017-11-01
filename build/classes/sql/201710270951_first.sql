DROP database if exists warasibe;
CREATE database warasibe;

use warasibe;

DROP TABLE if exists commodity;
CREATE TABLE commodity(
id int not null primary key auto_increment,
name varchar(20),
detail varchar(255),
category_id int,
price int,
color enum("黒","白","赤","青","黄"),
age float,
height float,
width float,
depth float,
size_unit enum("mm","cm","m"),
close_trade boolean,
postdate date,
sell_user_id int,
buy_user_id int
);

DROP TABLE if exists account;
CREATE TABLE account(
id int not null primary key auto_increment,
login_id varchar(20),
login_password varchar(20),
nickname varchar(20),
mail varchar(255),
evaluation float DEFAULT 0.0
);

DROP TABLE if exists category;
CREATE TABLE category(
id int not null primary key auto_increment,
name varchar(255)
);

DROP TABLE if exists wish_list_info;
CREATE TABLE wish_list_info(
id int not null primary key auto_increment,
user_id int,
commodity_id int
);