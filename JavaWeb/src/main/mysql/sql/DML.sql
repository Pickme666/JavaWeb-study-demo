-- DML操作数据

-- 设计一张学生表
CREATE TABLE stu (
	id INT,
	NAME VARCHAR ( 10 ),
	gender CHAR ( 1 ),
	birthday date,
	score DOUBLE ( 5, 2 ),
	email VARCHAR ( 64 ),
	tel VARCHAR ( 15 ),
	STATUS TINYINT 
	);

-- 查询所有数据
select * from stu;

-- 指定添加数据
insert into stu(id,name) values(1,'张三');

-- 给所有列添加数据,类名和列表可以省略(开发中不建议)
INSERT INTO stu(id,`name`,gender,birthday,score,email,tel,status)
VALUES(2,'ikun','男','2077-1-1',99.5,'123@qq.com','10086',6);

INSERT INTO stu
VALUES(3,'ikun','男','2077-1-1',99.5,'123@qq.com','10086',6),(3,'ikun','男','2077-1-1',99.5,'123@qq.com','10086',6);

-- 修改数据
UPDATE stu set gender = '女' where name = '张三';

-- 如果update语句没有加where条件,则会将表中所有数据全部修改!
update stu set birthday = '2008-12-12',score = 18 where name = '张三';

-- 删除数据
delete from stu where name = '张三';

-- 没有加where条件会删除所有数据!!!
delete from stu;


