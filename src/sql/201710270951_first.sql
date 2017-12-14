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

DROP TABLE if exists wish_info;
CREATE TABLE wish_info(
id int not null primary key auto_increment,
applied_user_id int,
have_commodity_id int,
have_user_id int,
applied_commodity_id int,
agreement boolean default false
);

DROP TABLE if exists trade_status;
CREATE TABLE trade_status(
id int not null primary key auto_increment,
wish_info_id int,
trade_start_date datetime,
progress enum("交換開始","片方が荷物の到着完了","両方が荷物の到着完了","片方が評価完了","両方が評価完了") default "交換開始",
FOREIGN KEY (wish_info_id) REFERENCES wish_info(id)
ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE if exists arrived;
CREATE TABLE arrived(
id int not null primary key auto_increment,
trade_status_id int,
arrived_user_id int,
FOREIGN KEY (trade_status_id) REFERENCES trade_status(id)
ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE if exists reviewed;
CREATE TABLE reviewed(
id int not null primary key auto_increment,
trade_status_id int,
reviewed_user_id int,
FOREIGN KEY (trade_status_id) REFERENCES trade_status(id)
ON UPDATE CASCADE ON DELETE CASCADE
);