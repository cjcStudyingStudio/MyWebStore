CREATE DATABASE webstore;

USE webstore;

CREATE TABLE `user` (
                        `uid` int primary key ,
                        username varchar (32),
                        nickname varchar (32),
                        password varchar (32),
                        email varchar (32),
                        birthday datetime,
                        updatetime datetime
)Engine= InnoDB Charset= utf8;

CREATE TABLE `admin` (
                         `aid` int primary key ,
                         username varchar (32),
                         `password` varchar (32)
)Engine= InnoDB Charset= utf8;

CREATE TABLE category(
                         cid int PRIMARY KEY,
                         cname VARCHAR(32)
)ENGINE = INNODB CHARSET=utf8;

CREATE TABLE `Order` (
                         `oid` VARCHAR(32) primary key ,
                         money  DOUBLE(10,2),
		recipients VARCHAR(32),
		tel VARCHAR(16),
		address VARCHAR(255),
		state int ,
		ordertime datetime,
		uid int,
	 FOREIGN KEY (uid) REFERENCES user(uid)
)Engine= InnoDB Charset= utf8;


CREATE TABLE product(
                        pid VARCHAR(100) PRIMARY KEY,
                        pname VARCHAR(200),
                        estoreprice DOUBLE(10,2),
		markprice DOUBLE(10,2),
		pnum int ,
		cid int ,
		imgurl varchar(255),
		`desc` VARCHAR(255),
		FOREIGN KEY (cid) REFERENCES category(cid)
)ENGINE = INNODB CHARSET=utf8;

CREATE TABLE orderItem(
                          itemid int PRIMARY KEY,
                          oid VARCHAR(32),
                          pid VARCHAR(100),
                          buynum int,
                          FOREIGN KEY (oid) REFERENCES `order`(oid),
                          FOREIGN KEY (pid) REFERENCES `product`(pid)
)ENGINE = INNODB CHARSET=utf8;

CREATE TABLE shoppingcar(
                            sid int PRIMARY KEY,
                            uid int,
                            FOREIGN KEY (uid) REFERENCES `user`(uid)
)ENGINE = INNODB charset = utf8;

CREATE TABLE shoppingitem(
                             itemid int PRIMARY KEY,
                             sid int,
                             pid VARCHAR(100),
                             FOREIGN KEY (sid) REFERENCES `shoppingcar`(sid),
                             FOREIGN KEY (pid) REFERENCES `product`(pid)
)ENGINE = INNODB charset = utf8;

