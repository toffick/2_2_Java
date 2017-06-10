create database JAVA

create table BOOK 
(  BOOKNAME  char(50)   primary key,  
   AUTHORNAME   char(50) Foreign key         
                      references AUTHOR(AUTHORNAME),
   [YEAR] INT,
   PHOUSE  char(50)  
)

insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ('������', '�������', 1962, '��������');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ('��������', '�������',  1955, '��������');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ( '�������� ��������', '��������', 1962, '��������');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE )   
values  ( '����� ����','�������',  1911, '������');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE)   
values  ('���� ��������', '�������' , 1916, '��������');
insert into  BOOK   (BOOKNAME, AUTHORNAME,[YEAR],PHOUSE)   
values  ('����� � ���', '�������' , 1917, '��������');

create table AUTHOR 
(  AUTHORNAME  char(50)   primary key,  
   COUNTRY Char(50)
)

insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('�������', '������');
insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('��������', '��������������');
insert into  AUTHOR   (AUTHORNAME, COUNTRY)   
values  ('�������', '������');

select * from BOOK where AUTHORNAME = '�������'



select  count(*),AUTHOR.authorname,AUTHOR.COUNTRY from 
author inner join BOOK
on BOOK.AUTHORNAME = AUTHOR.AUTHORNAME
group by AUTHOR.authorname,AUTHOR.COUNTRY 
having count(*) >0

