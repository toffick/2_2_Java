create database java_12_servlet

use java_12_servlet

create table users(
[login] varchar(30) primary key,
[password]  varchar(30),
[role]   varchar(30)
)

insert into users values ('admin', 'admin', 'admin');
insert into users values ('user1', 'user1', 'user');