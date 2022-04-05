
    
------------
--20220318
------------

-- 부서별 최대 급여를 받는 사원 조회(사원명, 부서명, 급여)
-- + 최소 급여를 받는 사원도 출력
-- + 인턴사원도 포함시키기
--1)
select
    emp_name 사원명,
    nvl(dept_code, '인턴')부서명,
    salary 급여
from
    employee e, department d
where
    e.dept_code = d.dept_id(+) 
    and
    ((nvl(e.dept_code,'인턴'), e.salary) in (select nvl(dept_code, '인턴'), max(salary) 
                                            from employee
                                            group by nvl(dept_code, '인턴'))
    or
    (nvl(e.dept_code,'인턴'), e.salary) in (select nvl(dept_code, '인턴'), min(salary) 
                                            from employee
                                            group by nvl(dept_code, '인턴')))
order by 2;

--2)
select
    emp_name 사원명,
    nvl(dept_code, '인턴')부서명,
    salary 급여
from
    employee
where
    (dept_code, salary) in (select nvl(dept_code, '인턴'), max(salary)
                                    from employee 
                                    group by nvl(dept_code, '인턴'))
union all
select
    emp_name 사원명,
    nvl(dept_code, '인턴')부서명,
    salary 급여
from
    employee
where
    (dept_code, salary) in (select nvl(dept_code, '인턴'), min(salary)
                                    from employee 
                                    group by nvl(dept_code, '인턴'))
order by
    2, 3;
    
    
---------
--220318 
---------
--220317 oracle ver

--2)
select
    e.emp_name 사원명,
    e.emp_no 주민번호,
    d.dept_title 부서명,
    j.job_name 직급명
from
    employee e, department d, job j
where
    e.dept_code = d.dept_id(+) and
    e.job_code = j.job_code(+) and
    (substr(e.emp_no, 1, 2) between 70 and 79) and
    substr(e.emp_no, 8, 1) in '2' and
    e.emp_name like '전%';

--3)
select
       emp_id 사번
     , emp_name 사원명
     , extract(year from sysdate)-(decode(substr(emp_no,8,1),'1',1900,'2',1900,2000))-substr(emp_no,1,2)+1 나이
     , dept_title 부서명
     , job_name 직급명
from 
    employee e, department d, job j
    ,(select min(extract(year from sysdate)-(decode(substr(emp_no,8,1),'1',1900,'2',1900,2000))-substr(emp_no,1,2) +1) min_age from employee) t
where
    e.dept_code = d.dept_id (+) and
    e.job_code = j.job_code and
    extract(year from sysdate)-(decode(substr(emp_no,8,1),'1',1900,'2',1900,2000))-substr(emp_no,1,2)+1 = min_age;


--서브쿼리 사용
select
    e.emp_id 사번,
    e.emp_name 사원명,
    (extract(year from sysdate) - (decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2))) + 1 "나이",
    d.dept_title 부서명,
    j.job_name 직급명
from
    employee e, department d, job j
where
    nvl(e.dept_code, 0) = nvl(d.dept_id, 0) and
    e.job_code = j.job_code and
    decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2) = 
    (select (max(decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2))) "출생년도" from employee);


--4)
select
    e.emp_id 사번,
    e.emp_name 사원명,
    d.dept_title 부서명
from
    employee e, department d
where
    e.dept_code = d.dept_id(+) and
    e.emp_name like '%형%';

--5)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    d.dept_id 부서코드,
    d.dept_title 부서명
from
    employee e , department d, job j
where
    e.dept_code = d.dept_id and
    e.job_code = j.job_code and
    d.dept_title like '해외영업%'
order by
    4;
    
--6)
select
    e.emp_name 사원명,
    e.bonus 보너스포인트,
    nvl(d.dept_title, '무소속') 부서명,
    nvl(n.national_name, '무소속') 근무지역명
from
    employee e , department d, location l, nation n
where
    e.dept_code = d.dept_id (+) and
    d.location_id = l.local_code (+) and
    l.national_code = n.national_code (+) and
    e.bonus is not null;

--7)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    d.dept_title 부서명,
    n.national_name 근무지역명
from
    employee e, job j, department d, location l, nation n
where
    e.job_code = j.job_code and
    e.dept_code = d.dept_id and
    d.location_id = l.local_code and
    l.national_code = n.national_code and
    e.dept_code in 'D2';

--8)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    to_char((e.salary + e.salary * nvl(bonus,0)),'l999,999,999') 급여,
    to_char(trunc((e.salary + e.salary * nvl(bonus,0)) * 12),'l999,999,999') 연봉
from
    employee e, job j, sal_grade s
where
    e.job_code = j.job_code and
    e.sal_level = s.sal_level and
    s.max_sal < e.salary;

--9)
select
    e.emp_name 사원명,
    d.dept_title 부서명,
    l.local_name 지역명,
    n.national_name 국가명
from
    employee e, department d, location l, nation n
where
    e.dept_code = d.dept_id and
    d.location_id = l.local_code and
    l.national_code = n.national_code and
    l.national_code in ('KO','JP');
    
--10)

select
    e1.emp_name 사원명,
    e2.emp_name 동료명,
    nvl(e1.dept_code, '인턴') 부서코드
from
    employee e1 ,employee e2
where
    nvl(e1.dept_code,0) = nvl(e2.dept_code,0) and
    nvl(e2.dept_code, 0) not in (select nvl(dept_code, 0) from employee where e1.emp_name = e2.emp_name)
order by
    1;




--11)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    to_char(e.salary, 'l999,999,999') 급여
from
    employee e , job j
where
    e.job_code = j.job_code and
    e.bonus is null and j.job_name in ('차장','사원');
    
   