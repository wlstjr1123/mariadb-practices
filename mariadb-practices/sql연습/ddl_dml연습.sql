drop table member;

create table member(
	no int(11) not null auto_increment,
	email varchar(200) not null,
	password varchar(20) not null,
	name varchar(100) not null,
	department varchar(100),
	primary key(no)
);

alter table member add juminbunho char(13) not null after email;
alter table member drop juminbunho;
alter table member add join_date datetime not null;
alter table member change department department varchar(100) not null;
alter table member add self_intro text;

desc member;

-- insert
insert into member
values(null, 'kickscar@gmail.com', password('1234'), '조진석', '개발팀', now(), null);

insert into member(no, email, password, name, department, join_date)
values(null, 'kickscar2@gmail.com', password('1234'), '조진석2', '개발팀2', now());

-- update
update member
	set email = 'kicks@gmail.com', password=password('5678')
    where no = 3;

-- delete
delete
	from member
where no = 3;

-- transaction
select @@AUTOCOMMIT;
set autocommit = 0;

insert into member(no, email, password, name, department, join_date)
values(null, 'kickscar3@gmail.com', password('1234'), '조진석3', '개발팀3', now());


select * from member;