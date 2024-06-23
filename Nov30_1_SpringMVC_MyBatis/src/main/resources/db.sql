
create table nov29_student(
	s_no number(5)primary key,
	s_name varchar2(5 char) not null,
	s_nickname varchar2(20 char)not null
);

create sequence nov29_student_seq;

insert into nov29_student values(nov29_student_seq.nextval, '홍길동', '의적');

select*from NOV29_STUDENT order by s_no

------------------------------------------------------------------

create table nov30_test(
	t_title varchar2(6 char)primary key,
	t_when date not null
);

insert into nov30_test values('과학', to_date('2023-12-30', 'yyyy-MM-dd'))

select*from nov30_test;