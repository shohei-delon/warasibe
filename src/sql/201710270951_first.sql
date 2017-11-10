DROP database if exists warasibe;
CREATE database warasibe;

use warasibe;

DROP TABLE if exists commodity;
CREATE TABLE commodity(
id int not null primary key auto_increment,
name varchar(20),
detail varchar(255),
category_id int,
color enum("黒","白","赤","青","黄"),
age float,
height float,
width float,
depth float,
size_unit enum("mm","cm","m"),
status enum("販売中","交換申し込み中","交換済み") default "販売中",
close_trade boolean default false,
postdate date,
selldate date,
sell_user_id int,
buy_user_id int
);

DROP TABLE if exists account;
CREATE TABLE account(
id int not null primary key auto_increment,
login_id varchar(20),
login_password varchar(20),
nickname varchar(20),
introduce varchar(255),
mail varchar(255),
evaluation float DEFAULT 0.0,
trade_count int default 0
);

DROP TABLE if exists category;
CREATE TABLE category(
id int not null primary key auto_increment,
name varchar(255)
);

DROP TABLE if exists trade_status;
CREATE TABLE trade_status(
id int not null primary key auto_increment,
wish_info_id int,
trade_start_date date,
commodity1_delivered boolean default false,
commodity2_delivered boolean default false,
complete boolean default false
);

DROP TABLE if exists wish_info;
CREATE TABLE wish_info(
id int not null primary key auto_increment,
applied_user_id int,
have_commodity_id int,
have_user_id int,
applied_commodity_id int
);
