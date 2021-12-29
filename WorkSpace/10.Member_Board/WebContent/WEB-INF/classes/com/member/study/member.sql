create table ListView(
imgresId number,
title varchar2(200),
content varchar2(1000),

constraint list_pk primary key (title, imgresId)
);

insert into ListView
values (1, 'title1', 'content1');
insert into ListView
values (2, 'title1', 'content1');
insert into ListView
values (3, 'title1', 'content1');
insert into ListView
values (4, 'title1', 'content1');
insert into ListView
values (5, 'title1', 'content1');
insert into ListView
values (6, 'title1', 'content1');
insert into ListView
values (7, 'title1', 'content1');
insert into ListView
values (8, 'title1', 'content1');
insert into ListView
values (9, 'title1', 'content1');
insert into ListView
values (10, 'title1', 'content1');
select * from ListView;

commit;

drop table ListView;



