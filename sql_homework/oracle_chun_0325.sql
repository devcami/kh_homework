
-----------------
-- 20220325
-- DDL
-----------------
--1)
create table tb_category(
    name varchar2(10)
    ,use_yn char(1) default 'Y'
);

select * from tb_category;

--2)
create table tb_class_type(
    no varchar2(5)
    ,name varchar2(10)
    ,constraint pk_tb_class_type_no primary key(no)
);

--3)
alter table tb_category
add constraint pk_tb_category_name primary key(name);

--4)
alter table tb_class_type
modify name varchar2(10) not null;

--5)
alter table tb_category
modify name varchar2(20);

alter table tb_class_type
modify name varchar2(20)
modify no varchar2(10); 

desc tb_class_type;
desc tb_category;

--6)
alter table tb_category
rename column name to category_name;

alter table tb_class_type
rename column name to class_type_name;

alter table tb_class_type
rename column no to class_type_no;

--7)
alter table tb_category
rename constraint pk_tb_category_name to pk_category_name;

alter table tb_class_type
rename constraint pk_tb_class_type_no to pk_class_type_no;

--8)
insert into tb_category values('공학','Y');
insert into tb_category values('자연과학','Y');
insert into tb_category values('의학','Y');
insert into tb_category values('예체능','Y');
insert into tb_category values('인문사회','Y');
commit;

--9)
alter table tb_department
add constraint fk_department_category foreign key(category) references tb_category(category_name);

--10)
grant create view to chun;

create view vw_student_info
as
select
    student_no
    ,student_name
    ,student_address
from   
    tb_student;

--11)
create view vw_advice
as
select
    s.student_name student_name
    ,(select department_name from tb_department where s.department_no = department_no) department_name
    ,nvl((select professor_name from tb_professor where s.coach_professor_no = professor_no), '지도교수 없음') professor_name
from
    tb_student s;

--12)
create view vw_student_count
as
select
    d.department_name department_name
    ,count(*) student_count
from   
    tb_student s join tb_department d
        on s.department_no = d.department_no
group by
    d.department_no, d.department_name;

--13)
update 
    vw_student_info
set
    student_name = '이은민'
where
    student_no = 'A213046';
    

--14)
create or replace view vw_student_info
as
select student_no, student_name, student_address from tb_student
with read only;

--15)
--최근 3년 수강인원이 가장 많은 3과목

select * from tb_department;      --학과
select * from tb_student;         --학생      | 학과.학과번호 department_no
select * from tb_class;           --수업      | 학과.학과번호 department_no
select * from tb_class_professor; --수업-교수  | 수업.과목번호 class.no  | 교수.교수번호
select * from tb_professor;       --교수      | 학과.학과번호
select * from tb_grade;           --학점      | 수업.과목번호 | 학생.학생번호 

with fam_class_view
as(   
select
    class_no
    ,count(*) count_student
from
    tb_grade
where
    substr(term_no, 1, 4) > (select max(substr(term_no, 1, 4)) - 3 from tb_grade)
group by
    class_no
order by
    2 desc
)
select
    class_no
    ,c.class_name
    ,f.count_student
from
   fam_class_view f join tb_class c
        using(class_no)
where
    rownum <= 3;

--제약조건 조회
select
    constraint_name
    ,uc.table_name
    ,ucc.column_name
    ,uc.constraint_type
    ,uc.search_condition
from
    user_constraints uc join user_cons_columns ucc
        using(constraint_name)
where
    uc.table_name = 'TB_CATEGORY';


select
    constraint_name
    ,uc.table_name
    ,ucc.column_name
    ,uc.constraint_type
    ,uc.search_condition
from
    user_constraints uc join user_cons_columns ucc
        using(constraint_name)
where
    uc.table_name = 'TB_CLASS_TYPE';    
    
-----------------
-- DCL
-----------------

--1)
insert into tb_class_type values('01','전공필수');
insert into tb_class_type values('02','전공선택');
insert into tb_class_type values('03','교양필수');
insert into tb_class_type values('04','교양선택');
insert into tb_class_type values('05','논문지도');

--2)
create table tb_student_info
as
(select student_no, student_name, student_address from tb_student);

--3)
create table tb_국어국문학과
as
(select
    student_no 학번
    ,student_name 학생이름
    ,decode(substr(student_ssn, 8, 1), '1', 1900, '2', 1900, 2000) + substr(student_ssn, 1, 2) 출생년도
    ,nvl((select professor_name from tb_professor where s.coach_professor_no = professor_no),'지정교수 없음') 교수이름
from
    tb_student s
where
    s.department_no = (select department_no from tb_department where department_name = '국어국문학과')
);
--drop table tb_국어국문학과;
select * from tb_국어국문학과;

--4)
update
    tb_department
set
    capacity = round(capacity * 1.1);
select * from tb_department;

--5)
select * from tb_student where student_no = 'A413042';
update
    tb_student
set
    student_address = '서울시 종로구 숭인동 181-21'
where
    student_no = 'A413042';

--6)
select * from tb_student;
update
    tb_student
set
    student_ssn = substr(student_ssn, 1, 6);

--7)
update
    tb_grade
set
    point = 3.5
where
    student_no = 
            (select s.student_no 
             from tb_student s join tb_department d
                     on s.department_no = d.department_no
             where student_name = '김명훈' and d.department_name = '의학과')
    and
    class_no = 
            (select class_no from tb_class where class_name = '피부생리학');

--8)
select * from tb_grade;

delete from tb_grade
where student_no in (select student_no from tb_student where absence_yn = 'Y');









