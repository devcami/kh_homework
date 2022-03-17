---------
--220317
---------

--1)
select
    to_char(to_date('20201225','yyyymmdd'), 'day') "20201225"
from
    dual;


select * from employee;
select * from department;
select * from job;
--2)
select
    e.emp_name 사원명,
    e.emp_no 주민번호,
    d.dept_title 부서명,
    j.job_name 직급명
from
    employee e 
        left join department d
            on nvl(e.dept_code, 0) = nvl(d.dept_id, 0)
        left join job j
            on e.job_code = j.job_code
where
    (substr(e.emp_no, 1, 2) between 70 and 79)
    and
    substr(e.emp_no, 8, 1) in ('2', '4')
    and
    e.emp_name like '전%';

--3)
select
    e.emp_id 사번,
    e.emp_name 사원명,
    (extract(year from sysdate) - (decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2))) + 1 "나이",
    d.dept_title 부서명,
    j.job_name 직급명
from
    employee e
        join department d
            on nvl(e.dept_code, 0) = nvl(d.dept_id, 0)
        join job j
            on e.job_code = j.job_code
where
   decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2) = 
   (select (max(decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2))) "출생년도" from employee);

------test
select (max(decode(substr(emp_no, 8, 1), '1', 1900, '2', 1900, 2000) + substr(emp_no, 1, 2))) "출생년도" from employee;

--4)
select
    e.emp_id 사번,
    e.emp_name 사원명,
    d.dept_title 부서명
from
    employee e
         left join department d
            on nvl(e.dept_code, 0) = nvl(d.dept_id, 0)
where
    e.emp_name like '%형%';

--5)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    d.dept_id 부서코드,
    d.dept_title 부서명
from
    employee e
        join department d
            on nvl(e.dept_code, 0) = nvl(d.dept_id, 0)
        join job j
            on e.job_code = j.job_code
where
    d.dept_title like '해외영업%'
order by
    4;
    
--6)
select * from department;
select * from location;
select * from nation;
select
    e.emp_name 사원명,
    e.bonus 보너스포인트,
    nvl(d.dept_title, '무소속') 부서명,
    nvl(n.national_name, '무소속') 근무지역명
from
    employee e
        left join department d
            on nvl(e.dept_code, 0) = nvl(d.dept_id, 0)
        left join location l
            on d.location_id = l.local_code
        left join nation n
            on l.national_code = n.national_code
where
     e.bonus is not null;

--7)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    d.dept_title 부서명,
    n.national_name 근무지역명
from
    employee e
        join job j
            on e.job_code = j.job_code
        join department d
            on e.dept_code = d.dept_id
        join location l
            on d.location_id = l.local_code
        join nation n
            on l.national_code = n.national_code
where
    e.dept_code in 'D2';

--8)
select * from sal_grade;
select
    e.emp_name 사원명,
    j.job_name 직급명,
    to_char((e.salary + e.salary * nvl(bonus,0)),'l999,999,999') 급여,
    to_char(trunc((e.salary + e.salary * nvl(bonus,0)) * 12),'l999,999,999') 연봉
from
    employee e
        join job j
            on e.job_code = j.job_code
        join sal_grade s
            on e.sal_level = s.sal_level
where
    s.max_sal < e.salary;

--9)
select
    e.emp_name 사원명,
    d.dept_title 부서명,
    l.local_name 지역명,
    n.national_name 국가명
from
    employee e
        join department d
            on e.dept_code = d.dept_id
        join location l
            on d.location_id = l.local_code
        join nation n
            on l.national_code = n.national_code
where
    l.national_code in ('KO','JP');
    
    
    
--10)
--중복제거는 모르겠다 ..
select
    e1.emp_name 사원명,
    e2.emp_name 동료명,
    nvl(e1.dept_code, '인턴') 부서코드
from
    employee e1 join employee e2
        on nvl(e1.dept_code,0) = nvl(e2.dept_code,0)
where
    nvl(e2.dept_code, 0) not in (select nvl(dept_code, 0) from employee where e1.emp_name = e2.emp_name)
order by
    3 , 1;

---테스트
-- 내이름 = 내이름 제외
select dept_code from employee where emp_name = emp_name;



--11)
select
    e.emp_name 사원명,
    j.job_name 직급명,
    to_char(e.salary, 'l999,999,999') 급여
from
    employee e join job j
        on e.job_code = j.job_code
where
    e.bonus is null and j.job_name in ('차장','사원');
    
    
--12)
select
    quit_yn 퇴사여부,
    count(*) 인원
from
    employee
group by
    quit_yn;