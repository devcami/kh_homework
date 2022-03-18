--===================
--실습문제 chun 계정
--===================

select * from tb_department;      --학과
select * from tb_student;         --학생      | 학과.학과번호 department_no
select * from tb_class;           --수업      | 학과.학과번호 department_no
select * from tb_class_professor; --수업-교수  | 수업.과목번호 class.no  | 교수.교수번호
select * from tb_professor;       --교수      | 학과.학과번호
select * from tb_grade;           --학점      | 수업.과목번호 | 학생.학생번호 


--1.
select
    department_name "학과 명",
    category "계열"
from 
    tb_department;
    
--2.
select
    department_name || '의 정원은 ' || capacity || '명 입니다.' "학과별 정원"
from
    tb_department;
    
--3.
select
    s.student_name "학생이름"
from
    tb_student s join tb_department d
        on s.department_no = d.department_no
where
    d.department_name in '국어국문학과' 
    and s.absence_yn = 'Y' 
    and substr(s.student_ssn, 8, 1) in ('2','4');
  
--4.
select
    student_name
from
    tb_student
where
    student_no in ('A513079','A513090','A513091','A513110','A513119')
order by
    1 desc;

--5.
select
    department_name,
    category
from
    tb_department
where
    capacity between 20 and 30;

--6.
select
    professor_name
from
    tb_professor
where
    department_no is null;

--7.
select
    *
from
    tb_student
where
    department_no is null;

--8.
select
    class_no
from
    tb_class
where
    preattending_class_no is not null;

--9.
select
    category
from
    tb_department
group by
    category;

--10.
select
    student_no,
    student_name,
    student_ssn
from
    tb_student
where
--  extract(year from entrance_date) = 2002
    substr(student_no, 1, 2) in 'A2'
    and absence_yn in 'N'
    and student_address like '%전주%';

----------------
--20220318
---------------- oracle문법으로 변환

select * from tb_department;      --학과
select * from tb_student;         --학생      | 학과.학과번호 department_no
select * from tb_class;           --수업      | 학과.학과번호 department_no
select * from tb_class_professor; --수업-교수  | 수업.과목번호 class.no  | 교수.교수번호
select * from tb_professor;       --교수      | 학과.학과번호
select * from tb_grade;           --학점      | 수업.과목번호 | 학생.학생번호 

--1.
select
    student_no 학번
    ,student_name 학생명
    ,nvl(p.professor_name, '없음') 교수명
from
    tb_student s, tb_professor p
where
    s.coach_professor_no = p.professor_no(+);
    
--2.
select
    decode(grouping(d.department_name), 0, d.department_name, 1, '총교수인원') 학과명
    ,decode(grouping(p.professor_name), 0, p.professor_name, 1, '학과교수인원') 교수명
    ,count(p.professor_name) 인원수
    
from 
    tb_department d, tb_professor p
where
    d.department_no = p.department_no
group by
    rollup(d.department_name, p.professor_name);

--3.
select
    s.student_name 이름
    ,g.student_no 학번
    ,round(avg(g.point), 2) 학점
from
    tb_student s, tb_grade g
where
    s.student_no = g.student_no
    and
    s.student_name like '%람'
group by
    s.student_name, g.student_no;

--4.
select
    s.student_name 학생명
    ,g.term_no 학기
    ,c.class_name 과목명
    ,g.point 학점
from
    tb_student s, tb_grade g, tb_class c
where
    s.student_no = g.student_no and
    g.class_no = c.class_no
order by
    1;
    
