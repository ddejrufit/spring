-- 테이블명 : nov28_fruit
-- 컬럼명 : f_name(과일이름), f_price(과일가격)

create table nov28_fruit(
	f_name varchar2(10 char)primary key,
	f_price number(5) not null
);

select * from nov28_fruit

insert into nov28_fruit values('사과',3000);
insert into nov28_fruit values('바나나',4500);
insert into nov28_fruit values('딸기',6000);
