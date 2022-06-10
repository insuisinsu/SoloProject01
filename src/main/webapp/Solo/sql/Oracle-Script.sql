-- users
Create table useraccount(
    idx number not null,
    userid varchar2(50) primary key,
    userpw varchar2(50) not null,
    username varchar2(50) not null,
    useremail varchar2(100) not null,
    userregidate date default sysdate not null
);

insert into useraccount(idx, userid, userpw, username, useremail, userregidate)
values(seq_user_num.nextval, 'test', '1234', 'name2', 'email3', sysdate);
create sequence seq_user_num
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

create table freeboard(
    num number primary key,
    userid varchar2(50) not null,
    title varchar2(200) not null,
    content varchar2(2000) not null,
    postdate date default sysdate not null,
    visitcount number default 0 not null,
    ofile varchar2(200),
    sfile varchar2(30),
    downcount number(5) default 0 not null
);
insert into freeboard(num, title, content, userid)
values(seq_freeboard_num.nextval, '力格11', '郴侩11', 'test');
insert into freeboard(num, title, content, userid)
values(seq_freeboard_num.nextval, '力格22', '郴侩22', 'test');
insert into freeboard(num, title, content, userid)
values(seq_freeboard_num.nextval, '力格33', '郴侩33', 'test');
insert into freeboard(num, title, content, userid)
values(seq_freeboard_num.nextval, '力格44', '郴侩44', 'test');
insert into freeboard(num, title, content, userid)
values(seq_freeboard_num.nextval, '力格55', '郴侩55', 'test');

alter table freeboard
    add constraint freeboard_user_fk foreign key (userid)
    references useraccount (userid)

create sequence seq_freeboard_num
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

drop table useraccount;
drop sequence seq_user_num;
drop table freeboard
drop sequence seq_freeboard_num;

    
select * from useraccount;
select * from freeboard;
commit;
