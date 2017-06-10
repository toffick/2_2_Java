create database JAVA

create table BOOK 
(  BOOKNAME  char(50)   primary key,  
   AUTHORNAME   char(50) Foreign key         
                      references AUTHOR(AUTHORNAME),
   [YEAR] INT,
   PHOUSE  char(50)  
)

insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ('Лолита', 'Набоков', 1962, 'сссрхаус');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ('Отчаяние', 'Набоков',  1955, 'сссрхаус');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ( 'Заводной апельсин', 'Бёрджесс', 1962, 'англпабл');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ( 'Живой труп','Толстой',  1911, 'руспаб');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE)   
values  ('Анна Каренина', 'Толстой' , 1916, 'сссрхаус');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE)   
values  ('Война и мир', 'Толстой' , 1917, 'сссрхаус');

create table AUTHOR 
(  AUTHORNAME  char(50)   primary key,  
   COUNTRY Char(50)
)

insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('Набоков', 'Россия');
insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('Бёрджесс', 'Великобритания');
insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('Толстой', 'Россия');

select * from BOOK where AUTHORNAME = 'набоков'



select  count(*),AUTHOR.authorname,AUTHOR.COUNTRY from 
author inner join BOOK
on BOOK.AUTHORNAME = AUTHOR.AUTHORNAME
group by AUTHOR.authorname,AUTHOR.COUNTRY 
having count(*) >0

