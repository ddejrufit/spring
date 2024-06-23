create table kang_member(
	k_id varchar2(10 char) primary key,
	k_pw varchar2(10 char) not null,
	k_name varchar2(10 char) not null,
	k_addr varchar2(200 char) not null,
	k_photo varchar2(200 char) not null,
	k_role char(1 char) not null
);

select * from KANG_MEMBER

insert into KANG_MEMBER values('asdf', '1', 'hong', 'asdfasdf', 'wegds', '관');


create table kang_sns(
	k_no number(4) primary key, 			
	k_owner varchar2(10 char) not null, 	
	k_txt varchar2(300 char) not null,
	k_when date not null,
	k_color char(7) not null
);

create sequence kang_sns_seq;

create table kang_sns_reply(
	kr_no number(5) primary key,
	kr_k_no number(4) not null,
	kr_owner varchar2(10 char) not null,
	kr_txt varchar2(200 char) not null,
	kr_when date not null,
	constraint sns_reply2
		foreign key(kr_k_no) references kang_sns(k_no)
		on delete cascade
);

create sequence kang_sns_reply_seq;

drop table kang_sns_reply cascade constraint purge;


select count(*)	from kang_member, kang_sns where k_id = k_owner

select * from kang_sns_reply

insert into kang_sns_reply values(kang_sns_reply_seq.nextval , '1', 'hong', 'asdfasdf', 'wegds', '관');
