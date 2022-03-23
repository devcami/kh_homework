
------------------
--20220323
------------------
select * from tb_department;      --학과
select * from tb_student;         --학생      | 학과.학과번호 department_no
select * from tb_class;           --수업      | 학과.학과번호 department_no
select * from tb_class_professor; --수업-교수  | 수업.과목번호 class.no  | 교수.교수번호
select * from tb_professor;       --교수      | 학과.학과번호
select * from tb_grade;           --학점      | 수업.과목번호 | 학생.학생번호 

--1)
select
    student_name "학생 이름"
    ,student_address 주소지
from
    tb_student
order by
    1;

--2)
select
    student_name
    ,student_ssn
from
    tb_student
where
    absence_yn = 'Y'
order by
    2 desc;

--3)
select
    student_name 학생이름
    ,student_no 학번
    ,student_address "거주지 주소"
from
    tb_student
where
    (student_address like '%경기도%'
    or
    student_address like '%강원도%')
    and 
    student_no not like 'A%'
order by
    1;
    
--4)
select
    professor_name
    ,professor_ssn
from
    tb_professor p join tb_department d
        using(department_no)
where
    d.department_name in '법학과'
order by
    2 ;
    
--5)
select
    student_no
    ,point
from
    tb_grade
where
    term_no = '200402'
    and
    class_no = 'C3118100'
order by
    2 desc, 1 asc;

--6)
select
    student_no
    ,student_name
    ,(select department_name from tb_department where department_no = s.department_no) department_name
from
    tb_student s
order by
    2;

--7)
select
    class_name
    ,(select department_name from tb_department where department_no = s.department_no) department_name
from
    tb_class s
order by
    1, 2;

--8)
select
    c.class_name "class_name"
    ,p.professor_name "professor_name"
from
    tb_class c
        join tb_class_professor cp
            using(class_no)
        join tb_professor p
            using(professor_no)
order by
    1,2;
            
--9)
select
    c.class_name "class_name"
    ,p.professor_name "professor_name"
from
    tb_class c
        join tb_class_professor cp
            using(class_no)
        join tb_professor p
            using(professor_no)
where
    (select category from tb_department where department_no = p.department_no) = '인문사회';    

--10)
select
    distinct
    s.student_no 학번
    ,s.student_name "학생 이름"
    ,round(avg(g.point) over(partition by g.student_no order by g.student_no), 1) "전체 평점"
from
    tb_department d 
        join tb_student s
            using(department_no)
        join tb_grade g
            on s.student_no = g.student_no
where
    department_name = '음악학과'
order by 
    1;
    
--11)
select
    (select department_name from tb_department where s.department_no = department_no) 학과이름
    ,student_name 학생이름
    ,(select professor_name from tb_professor where s.coach_professor_no = professor_no) 지도교수이름
from
    tb_student s
where
    student_no = 'A313047';

--12)
select
    (select student_name from tb_student where g.student_no = student_no) student_name
    ,g.term_no term_name
    
from
    tb_class c join tb_grade g
        using(class_no)
where
    c.class_name = '인간관계론'
    and
    g.term_no like '2007%';

--13) *
select
    c.class_name class_name
    ,department_name department_name
from
    tb_class c
        join tb_department
            using(department_no)
        left join tb_class_professor
            using(class_no)
where
    category = '예체능' and professor_no is null
order by 
    2;

--14)  
select
    s.student_name 학생이름
    ,nvl((select professor_name from tb_professor where s.coach_professor_no = professor_no), '지도교수 미지정') 지도교수
from
    tb_student s
where
    s.department_no = (select department_no from tb_department where department_name = '서반아어학과')
order by
    student_no;

--15) *
select
    s.student_no 학번
    ,s.student_name 이름
    ,(select department_name from tb_department where s.department_no = department_no) "학과 이름"
    ,avg(point) 평점
from   
    tb_student s join tb_grade g
        on s.student_no = g.student_no
where
    s.absence_yn = 'N'
group by
    s.student_no, s.student_name, s.department_no
having
    avg(point) >= 4.0
order by
    1;
    
--16)
select
    c.class_no
    ,c.class_name
    ,avg(g.point)
from
    tb_class c join tb_grade g
        on c.class_no = g.class_no
where
    c.department_no = (select department_no from tb_department where department_name = '환경조경학과')
    and
    c.class_type like '전공%'
group by
    c.class_no, c.class_name
order by
    1;
    
--17)
select
    student_name
    ,student_address
from
    tb_student 
where
    department_no = (select department_no from tb_student where student_name = '최경희')
order by
    1;
    
--18) *
select 
    *
from (
    select
        student_no
        ,student_name
    from 
        tb_student s
            join tb_department d using(department_no)
            join tb_grade g using(student_no)
    where
        department_name = '국어국문학과'
    group by
        student_no, student_name
    order by
        avg(point) desc
)
where
    rownum = 1;


--19)


select
    department_name "계열 학과명"
    ,round(avg(point),1) 전공평점
from
    tb_class 
        join tb_grade using(class_no)
        join tb_department using(department_no)
where
    category = (select category from tb_department where department_name = '환경조경학과')
    and
    class_type like '전공%'
group by
    department_name
order by 1;










    
    
    