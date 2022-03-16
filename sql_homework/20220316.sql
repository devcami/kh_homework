

--------
--220316
--------

--1)
select
    emp_name 이름,
    email 이메일,
    length(email) 이메일길이
from
    employee;

--2)
select
    emp_name 이름,
    substr(email, 1, instr(email, '@') - 1) 아이디
from
    employee;

--3)
select
    emp_name 이름,
    decode(substr(emp_no, 8, 1),'1','1900','2','1900','2000') + substr(emp_no, 1, 2) 년생,
    nvl(bonus, 0)보너스
from
    employee
where
    substr(emp_no, 1, 2) >= 60 and substr(emp_no, 1, 2) < 70;
    
--4)
select
    count(*) || '명' "010을 쓰지않는 사람"
from
    employee
where
    substr(phone, 1, 3) not in ('010');
    
--5)
select
    emp_name 사원명,
    to_char(hire_date, 'rrrr"년" mm"월"') 입사년월
from
    employee;

--6)
select
    emp_name 사원명,
    rpad(substr(emp_no, 1, 8), 14, '*') 주민번호
from
    employee;
    
--7)
select
    emp_name 사원명,
    job_code 직급명,
    to_char((salary + (salary * nvl(bonus, 0))) * 12, 'FML999,999,999') "연봉(원)"
from
    employee;
    
--8)
select
    emp_id 사번,
    emp_name 사원명,
    dept_code 부서코드,
    hire_date 입사일
from
    employee
where
    dept_code in ('D5', 'D9') and substr(hire_date, 1, 2) in '04';
 
--9)
select
    emp_name 사원명,
    hire_date 입사일,
    floor(sysdate - hire_date) || '일' "오늘까지의 근무일수"
from
    employee;
    
--10)
select
    emp_name 사원명,
    dept_code 부서코드,
    to_char(
    to_date(
    decode(substr(emp_no, 8, 1), '1', '19', '2', '19', '20') || substr(emp_no, 1, 6)
    ,'yyyymmdd')    
    , 'yyyy"년" mm"월" dd"일"') 생년월일
from
    employee;
    
--11)
select
    sum(decode(substr(hire_date, 1, 2), '98', 1, 0)) "1998년",
    sum(decode(substr(hire_date, 1, 2), '99', 1, 0)) "1999년",
    sum(decode(substr(hire_date, 1, 2), '00', 1, 0)) "2000년",
    sum(decode(substr(hire_date, 1, 2), '01', 1, 0)) "2001년",
    sum(decode(substr(hire_date, 1, 2), '02', 1, 0)) "2002년",
    sum(decode(substr(hire_date, 1, 2), '03', 1, 0)) "2003년",
    sum(decode(substr(hire_date, 1, 2), '04', 1, 0)) "2004년",
    
    count(*) "전체사원 수"
from
    employee;

--12)
select
    emp_name 사원명,
    dept_code 부서코드,
    case dept_code
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        when 'D9' then '영업부'
    end 부서명
from
    employee
where
    dept_code in ('D5','D6','D9')
order by
    2;
    
    
--13)
select
    manager_id "관리자",
    count(manager_id) "관리하는 사원 수"
from
    employee
group by
    manager_id
having
    count(manager_id) >= 2;