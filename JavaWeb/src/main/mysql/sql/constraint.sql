-- 约束
-- 1.约束是作用于表中列上的规则, 用于限制加入表的数据
-- 2.保证了数据库中数据的正确性, 有效性和完整性
/* 约束的分类:
			非空约束	NOT NULL
			唯一约束	UNIQUE
			主键约束	PRIMARY KEY
			检查约束	CHECK
			默认约束	DEFAULT
			外键约束	FOREIGN KEY
*/
-- MySQL中不支持检查约束

-- drop table if exists emp;

-- 员工表
create table emp(
	id int primary key auto_increment, -- 员工id, (primary key)主键且(auto_increment)自增长
	ename varchar(50) not null unique, -- 员工姓名, 非空且唯一
	joindate date not null, -- 入职日期, 非空
	salary double(7,2) not null, -- 工资, 非空
	bonus double(7,2) default 0 -- 奖金, 如果没有奖金则默认为0
);

select * from emp;

-- 添加一条数据
insert into emp(id,ename,joindate,salary,bonus) values(1,'菜鲲鲲','1999-11-11',8800,5000);


-- 主键约束: 非空且唯一
insert into emp(id,ename,joindate,salary,bonus) values(null,'菜鲲鲲','1999-11-11',8800,5000);
-- 报错: Column 'id' cannot be null

insert into emp(id,ename,joindate,salary,bonus) values(1,'鲲鲲','1999-11-11',8800,5000);
-- 报错: Duplicate entry '1' for key 'PRIMARY'

insert into emp(id,ename,joindate,salary,bonus) values(2,'鲲鲲','1999-11-11',8800,5000);
-- 添加成功
 

-- 非空约束
insert into emp(id,ename,joindate,salary,bonus) values(3,null,'1999-11-11',8800,5000);
-- !: Column 'ename' cannot be null


-- 唯一约束
insert into emp(id,ename,joindate,salary,bonus) values(3,'鲲鲲','1999-11-11',8800,5000);
-- !: Duplicate entry '鲲鲲' for key 'ename'


-- 默认约束
insert into emp(id,ename,joindate,salary) values(3,'ikun','1999-11-11',8800);
insert into emp(id,ename,joindate,salary,bonus) values(4,'张三','1999-11-11',8800,null);
-- 默认约束只能是不给字段添加值的时候默认值才会生效, null也是值


-- 自动增长: auto_increment 当列是数字类型并且唯一约束
alter table emp modify id int auto_increment; -- 修改列约束类型

-- id值自增
insert into emp(ename,joindate,salary,bonus) values('歌姬','1999-11-11',8800,5000); -- id = 5
insert into emp(id,ename,joindate,salary,bonus) values(null,'老六','1999-11-11',8800,5000); -- id = 6

select * from emp;

