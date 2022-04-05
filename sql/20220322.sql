
-------------
-- 20220322
-------------

--1)
select
    *
from (
    select
        emp_name 이름
        ,nvl(dept_code, '인턴') 부서코드
        ,salary 급여
    from
        employee e, department d
    where
        e.dept_code = d.dept_id
        and
        d.dept_title in '기술지원부'
); 

--2)
select
    *
from (
    select
        emp_name 이름
        ,nvl(dept_code, '인턴') 부서코드
        ,to_char((salary + (salary * nvl(bonus, 0))), 'fml999,999,999') 급여
        ,to_char((salary + (salary * nvl(bonus, 0))) * 12, 'fml999,999,999') 연봉
    from
        employee e, department d
    where
        e.dept_code = d.dept_id
        and
        d.dept_title in '기술지원부'
    order by
        4 desc
)
where
    rownum = 1;

--3-1)
select
    e1.emp_id 사번
    ,e1.emp_name 이름
    ,e2.emp_name 매니저이름
    ,e1.salary 월급
from
    employee e1 join employee e2
        on e1.manager_id = e2.emp_id
where
    e1.manager_id is not null
    and
    e1.salary > (select avg(salary) from employee);


--3-2)
select
    e1.emp_id 사번
    ,e1.emp_name 이름
    ,(select e2.emp_name from employee e2 where e1.manager_id = e2.emp_id) 매니저이름
    ,e1.salary 월급
from
    employee e1
where
    e1.manager_id is not null 
    and
    e1.salary > (select avg(salary) from employee);

--4)
select
    e1.emp_name
    ,e1.job_code
    ,e1.salary
    ,e1.sal_level
from
    employee e1
where
    e1.salary >= (select avg(e2.salary) from employee e2 where e1.job_code = e2.job_code);


--5)
select
    (select nvl(dept_title,'인턴') from department d where nvl(e1.dept_code, 0) = nvl(d.dept_id, 0)) 부서명
    , trunc(avg(salary)) 부서평균급여
from
    employee e1
where
    (select avg(e2.salary) from employee e2 where nvl(e1.dept_code, 0) = nvl(e2.dept_code, 0)) >= 3000000
group by
    dept_code;
    
--6)
select
    emp_name 사원명
    ,(select job_name from job j where j.job_code = e1.job_code)직급명
    ,(select dept_title from department where dept_code = dept_id)부서명
    ,(salary + (salary * nvl(bonus, 0))) 연봉
from
    employee e1
where
    (salary + (salary * nvl(bonus, 0))) < (select avg(salary + (salary * nvl(bonus, 0))) 직급평균연봉 from employee e2 where e1.job_code = e2.job_code)
    and
    substr(emp_no , 8, 1) in ('2','4')
order by
    1;

--6) with inline-view
with year_sal_by_job_w
as
(select
        e.*
        ,decode(substr(emp_no , 8, 1), '2','여','4','여') 성별
        ,(salary + (salary * nvl(bonus, 0))) 연봉
        ,(select avg((salary + (salary * nvl(bonus, 0)))) from employee where job_code = e.job_code) 직급평균연봉
    from
        employee e)
select
    emp_name 사원명
    ,(select job_name from job j where j.job_code = e.job_code)직급명
    ,(select dept_title from department where dept_code = dept_id)부서명
    ,연봉
from
    (year_sal_by_job_w) e
where
    성별 = '여'
    and
    연봉 < 직급평균연봉
order by
    1;

--7)
create table tbl_books (
book_title  varchar2(50)
,author     varchar2(50)
,loyalty     number(5)
);

insert into tbl_books values ('반지나라 해리포터', '박나라', 200);
insert into tbl_books values ('대화가 필요해', '선동일', 500);
insert into tbl_books values ('나무', '임시환', 300);
insert into tbl_books values ('별의 하루', '송종기', 200);
insert into tbl_books values ('별의 하루', '윤은해', 400);
insert into tbl_books values ('개미', '장쯔위', 100);
insert into tbl_books values ('아지랑이 피우기', '이오리', 200);
insert into tbl_books values ('아지랑이 피우기', '전지연', 100);
insert into tbl_books values ('삼국지', '노옹철', 200);
insert into tbl_books values ('별의 하루', '대북혼', 300);

select
    *
from
    (select distinct b1.* 
     from tbl_books b1 join tbl_books b2 on b1.book_title = b2.book_title
     where b1.author <> b2.author)
order by
    1;
    
    






