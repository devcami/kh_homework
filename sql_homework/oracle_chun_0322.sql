
----------------
--20220322
----------------     
select * from tb_department;      --학과
select * from tb_student;         --학생      | 학과.학과번호 department_no
select * from tb_class;           --수업      | 학과.학과번호 department_no
select * from tb_class_professor; --수업-교수  | 수업.과목번호 class.no  | 교수.교수번호
select * from tb_professor;       --교수      | 학과.학과번호
select * from tb_grade;           --학점      | 수업.과목번호 | 학생.학생번호 

--1)
select
    student_no 학번
    ,student_name 이름
    ,to_char(entrance_date, 'yyyy-mm-dd') 입학년도
from
    tb_student
where
    department_no = '002'
order by
    3;

--2)
select
    professor_name
    ,professor_ssn
from
    tb_professor
where
    professor_name not like '___';

--3)
select 
    professor_name 교수이름
    ,trunc((sysdate - to_date((1900 + substr(professor_ssn, 1, 2)) || substr(professor_ssn, 3, 4))) / 365) 나이
from
    tb_professor
where
    substr(professor_ssn, 8, 1) in '1'
order by
    2;

--4)
select
    substr(professor_name, 2, 2)    
from
    tb_professor;

--5)
select
    student_no
    ,student_name
from
    tb_student
where
    (extract(year from entrance_date) - (1900 + substr(student_ssn, 1, 2))) > 19
order by
    1;


--6)
select
    to_char(to_date('2020/12/25'), 'day') "2020년 크리스마스"
from
    dual;

--7)
-- YY : 현재세기 기준 100년 (2000~2099)
-- RR : 2000년 기준 100년 (1950~2049)
--to_date('99/10/11', 'YY/MM/DD') : 2099년 10월 11일
--to_date('49/10/11', 'YY/MM/DD') : 2049년 10월 11일
--to_date('99/10/11', 'RR/MM/DD') : 1999년 10월 11일
--to_date('49/10/11', 'RR/MM/DD') : 2049년 10월 11일


--8)
select
    student_no
    ,student_name
from
    tb_student
where
    student_no not like 'A%';
 
--9)
select
    round(avg(point), 1) 평점
from
    tb_grade
where
    student_no in 'A517178';

--10)
select
    department_no 학과번호
    ,count(department_no) "학생수(명)"
from
    tb_student
group by
    department_no
order by
    1;

--11)
select
    count(*)
from
    tb_student
where
    coach_professor_no is null;

--12)
select
    substr(term_no,1,4) 년도
    ,round(avg(point),1) "년도 별 평점"
from
    tb_grade
where
    student_no in 'A112113'
group by
    substr(term_no,1,4)
order by
    1;

--13)
select
    distinct
    department_no "학과코드명"
    ,(select count(*) from tb_student s  where s.absence_yn in 'Y' and s.department_no = s2.department_no) "휴학생 수"
from
    tb_student s2 
order by
    1;

--14)
select
    distinct s1.student_name
    ,count(*)
from
    tb_student s1 , tb_student s2
where
    s1.student_name = s2.student_name
    and
    s1.student_no <> s2.student_no
group by
    s1.student_name
order by
    1;
  

--15)
select
    nvl(substr(term_no, 1, 4), '총학점') 년도
    ,nvl(substr(term_no, 5, 2), ' ') 학기
    ,round(avg(point) , 1) 평점
from
    tb_grade
where
    student_no in 'A112113'
group by
        rollup(substr(term_no, 1, 4),substr(term_no, 5, 2));


