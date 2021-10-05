-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
	from  salaries
where to_date = '9999-01-01'
	and salary > (select avg(salary) 
					from salaries
					where to_date = '9999-01-01');

-- 문제2.
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단
-- 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.
select e.emp_no, e.first_name, de.dept_no, s.salary
	from salaries s join employees e on s.emp_no = e.emp_no
		join dept_emp de on e.emp_no = de.emp_no
where s.to_date = '9999-01-01'
	and de.to_date = '9999-01-01'
    and (s.salary, de.dept_no) in (select max(s2.salary), de2.dept_no 
									from salaries s2 join dept_emp de2 on s2.emp_no = de2.emp_no
									where s2.to_date = '9999-01-01'
										and de2.to_date = '9999-01-01'
									group by de2.dept_no)
order by s.salary desc;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요
select *
	from employees e join salaries s on e.emp_no = s.emp_no
		join dept_emp de on e.emp_no = de.emp_no
        join (select de2.dept_no as de2, avg(s2.salary) as sal
									from salaries s2 join dept_emp de2 on s2.emp_no = de2.emp_no
									where s2.to_date = '9999-01-01'
										and de2.to_date = '9999-01-01'
									group by de2.dept_no) a on de.dept_no = de2 
where s.to_date = '9999-01-01'
	and de.to_date = '9999-01-01'
    and s.salary > sal;
    
-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no, e.first_name, manager_name, d.dept_name
	from employees e join dept_emp de on e.emp_no = de.emp_no
		join departments d on d.dept_no = de.dept_no
        join dept_manager dm on dm.dept_no = d.dept_no
        join (select dm2.dept_no as d2de, e2.first_name as manager_name
				from employees e2 join dept_manager dm2 on e2.emp_no = dm2.emp_no
                where dm2.to_date = '9999-01-01') a on d.dept_no = d2de
where de.to_date = '9999-01-01'
	and dm.to_date = '9999-01-01';
    
select *
	from dept_manager;
    
select *
	from employees
    where emp_no = '111939';

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select e.emp_no, e.first_name, t.title, s.salary
	from employees e join salaries s on e.emp_no = s.emp_no
		join titles t on e.emp_no = t.emp_no
        join dept_emp de on e.emp_no = de.emp_no
where s.to_date = '9999-01-01'
	and t.to_date = '9999-01-01'
	and de.dept_no = (select de2.dept_no
						from employees e2 join dept_emp de2 on e2.emp_no = de2.emp_no
							join salaries s2 on e2.emp_no = s2.emp_no
						where s2.to_date = '9999-01-01'
							and de2.to_date = '9999-01-01'
						group by de2.dept_no
						having avg(s2.salary) = (select max(avg_salary)
													from (select de2.dept_no, avg(s2.salary) as avg_salary
															from employees e2 join dept_emp de2 on e2.emp_no = de2.emp_no
																join salaries s2 on e2.emp_no = s2.emp_no
													where s2.to_date = '9999-01-01'
													and de2.to_date = '9999-01-01'
													group by de2.dept_no) a));

-- 문제6.
-- 평균 연봉이 가장 높은 부서는?
select de.dept_no, ROUND(AVG(s.salary)) AS avg_salary
	from employees e join salaries s on e.emp_no = s.emp_no
		join dept_emp de on e.emp_no = de.emp_no
	where s.to_date = '9999-01-01'
		and de.to_date = '9999-01-01'
	group by de.dept_no
    having de.dept_no = (select de2.dept_no
						from employees e2 join dept_emp de2 on e2.emp_no = de2.emp_no
							join salaries s2 on e2.emp_no = s2.emp_no
						where s2.to_date = '9999-01-01'
							and de2.to_date = '9999-01-01'
						group by de2.dept_no
						having avg(s2.salary) = (select max(avg_salary)
													from (select de2.dept_no, avg(s2.salary) as avg_salary
															from employees e2 join dept_emp de2 on e2.emp_no = de2.emp_no
																join salaries s2 on e2.emp_no = s2.emp_no
													where s2.to_date = '9999-01-01'
													and de2.to_date = '9999-01-01'
													group by de2.dept_no) a));

-- 문제7.
-- 평균 연봉이 가장 높은 직책?

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은? 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
-- 