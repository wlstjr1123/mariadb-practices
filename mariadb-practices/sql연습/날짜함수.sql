-- 함수: 날짜 함수alter

-- CURDATE(), CUFRENT_DATE
select CURDATE(), CURRENT_DATE;

-- CURTIME(), CURRENT_TIME
select CURTIME(), CURRENT_TIME;

-- now() -> 쿼리가 실행됬을떄 시간 vs sysdate() -> 함수가 호출 됬을때 시간
select now(), sysdate();
select now(), sleep(2), now();
select sysdate(), sleep(2), sysdate();

-- date_format(date, format)
select date_format(now(), '%Y/%m/%d %h:%i:%s');
select date_format(now(), '%Y/%c/%d %h:%i:%s');

-- period_diff
-- YYMM, YYYYMM
-- 예) 근무 개월 수를 출력
select first_name, 
		period_diff(date_format(curdate(), '%Y%m'), date_format(hire_date, '%Y%m')) as month
	from employees
order by month desc;

-- date_add(=adddate), data_sub(- subdate)
-- 날짜를 date에 type(day, month, year) 형식의 표현식(expr) 더하거나 뺸다.
-- 예제) 각 사원들의 근무 년수가 5년이 되는 날은 언제 인가요?
select first_name,
		hire_date,
        date_add(hire_date, interval 5 year)
	from employees;
    
-- cast
-- select '12345' + 10, cast('12345' as int) + 10;
select date_format(cast('2021-10-01' as date), '%Y-%m-%d');
select cast(1-2 as unsigned);
select cast(cast(1-2 as unsigned) as signed);

-- mysql type
-- varchar(), char(), text, CLOB(Character Large Obejct)
-- signed(unsigned), int(integer), medium int, big int, int(11)
-- float, double
-- time, date, datetime
-- LOB: CLOB, BLOB