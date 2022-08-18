-- 外键约束
-- 外键用来让两个表的数据之间建立链接, 保证数据的一致和完整性

-- 部门表
create table dept(
	id int primary key auto_increment,
	dep_name varchar(20),
	addr varchar(20)
);

select * from dept;

-- 员工表
CREATE table emp1(
	id int primary key auto_increment,
	name varchar(20),
	age int,
	dep_id int,
	
	-- 添加外键约束 deo_id 关联 dept 表的 id 主键, fk_emp1_dept 外键名 (一般以fk开头)
	CONSTRAINT fk_emp1_dept FOREIGN KEY (dep_id) REFERENCES dept (id)
	-- k_emp1_dept 外键名； (dep_id) 列名； dept (id) 关联表名(关联表列名)
);
-- 这两张表属于一对多关系, 所有只需在 "多" 的一方添加外键关联 "一" 的主键

select * from emp1;

-- 添加信息
insert into dept(dep_name,addr) values('研发部','广州'),('销售部','深圳');

INSERT into emp1(name,age,dep_id) values
('ikun1',20,1),
('ikun2',20,1),
('ikun3',20,1),
('歌姬1',20,2),
('歌姬2',22,2),
('歌姬3',18,2);

-- 删除外键
alter table emp1 drop foreign key fk_emp1_dept;

-- 键完表后, 添加外键
alter table emp1 add constraint fk_emp1_dept foreign key (dep_id) references dept(id);







