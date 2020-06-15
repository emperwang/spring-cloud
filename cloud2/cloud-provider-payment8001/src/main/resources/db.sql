create database cloud2 if not exists ;
drop table if exists payment;
create table payment (
id BIGINT(8) auto_increment comment 'primary key',
serial varchar(255) comment 'payment id',
primary key(id)
) ENGINE=InnoDB  AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;