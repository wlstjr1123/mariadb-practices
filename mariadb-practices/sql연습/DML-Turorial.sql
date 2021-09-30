create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);

desc pet;

drop table pet;

-- 조회
select name, owner, species, gender, birth, death from pet;

-- 데이터 넣기(생성, create)
insert
	into pet
    value('성탄이', '조진석', 'dog', 'm', '2018-12-25', null);
    
-- 데이터 삭제(delete)
delete
 from pet
 where name = '성탄이';