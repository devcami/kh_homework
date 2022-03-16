--------
--220315
--------
-- 1.
create table tbl_escape_watch(
    watchname varchar2(40),
    description varchar2(200)
);

--drop table tbl_escape_watch;

insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values('은시계', '고객 만족도 99.99점을 획득한 고급시계');

commit;

--1)
select
    description
from
    tbl_escape_watch
where
    description like '%99.99\%%' escape '\'; 
--2)    
select description
from tbl_escape_watch
where instr(description, '99.99%') != 0;

    
-- 2.
create table tbl_files(
    fileno number(3),
    filepath varchar2(500)
);

insert into tbl_files values(1, 'c:\abc\deft\salesinfo.xls');
insert into tbl_files values(2, 'c:\music.mp3');
insert into tbl_files values(3, 'c:\documents\resume.hwp');

commit;

select 
    fileno 파일번호,
    substr(filepath, instr(filepath, '\', -1) + 1) 파일명
from
    tbl_files;





