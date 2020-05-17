
use bss

create table user(
    uId bigint PRIMARY key auto_increment,
    uEmai varchar(40) not null,
    uPwd varchar(20) not null,
    uName varchar(20) not null
);
insert into user values(uId, "baijiahui233@qq.com", "a", "bay");


create table book(
   bId bigint PRIMARY key auto_increment,
   bName varchar(40) not null,
   `explain` text,
   picture varchar(100),
   sort varchar(20),
   price double not null,
   num int
);
insert into book values(bId, "三体", "说明:买就完事了！！！！", "/imgs/1.png", "科幻", 55.5, 100);
select * from book;

create table orders(
    `oId` bigint PRIMARY key auto_increment,
    uId bigint not null,
    bId bigint not null,
    num int not null,
    adder varchar(100) not null,
    phone bigint not null,
    `dateTime` dateTime,
    state int
);

alter table orders add constraint order_user foreign key (uId) references user(uId);
alter table orders add constraint order_book foreign key (bId) references book(bId);
insert into orders values(oId, 1, 1, 1, "湖南永州", 13367465727, now(), 1);
select * from orders;


create table record(
    rId bigint PRIMARY key auto_increment,
    bId bigint not null,
    num int,
    `dateTime` dateTime
);
insert into record values(rId, 1, 100, now());

select * from record;

create table dictionary(
    tableName varchar(20),
    colName varchar(20),
    seq int,
    value varchar(20)
);
create index dic_query on dictionary(tableName, colName);