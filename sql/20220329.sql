
-------------
-- 20220329
-------------
--1) 
create table tbl_emp_join
as
select 
emp_id, emp_name, emp_no, email, phone, dept_code, 
job_code, sal_level, salary, bonus, manager_id, hire_date
from ex_employee 
where quit_yn = 'N';

select * from tbl_emp_join;

create table tbl_emp_quit
as
select 
emp_id, emp_name, emp_no, email, phone, dept_code, 
job_code, sal_level, salary, bonus, manager_id, hire_date, quit_date
from ex_employee 
where quit_yn = 'Y';

select * from tbl_emp_quit;

create or replace trigger trig_tbl_emp_del
    before
    delete on tbl_emp_join
    for each row
begin
    if deleting then
        insert into tbl_emp_quit
        values(
            :old.emp_id, :old.emp_name, :old.emp_no, :old.email, :old.phone, :old.dept_code
            ,:old.job_code, :old.sal_level, :old.salary, :old.bonus, :old.manager_id, :old.hire_date, sysdate
        );
    end if;
end;
/

--테스트
insert into tbl_emp_join(emp_id, emp_name, emp_no, job_code, sal_level)
values('224','김톄리','990909-2222222','J5','S4');

delete from tbl_emp_join where emp_id = '224';