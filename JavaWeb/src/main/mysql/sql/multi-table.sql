-- 多表查询: 从多张表查询数据
/* 分类
			1.连接查询
						内连接: 相当于查询AB交集数据
						外连接: 分为左外连接和右外连接
			2.子查询: 查询中嵌套查询
*/


DROP TABLE if EXISTS dept2;
DROP TABLE if EXISTS emp2;

-- 部门表
CREATE TABLE dept2(
		did int PRIMARY KEY auto_increment,
		dname VARCHAR(20)
);

-- 员工表
CREATE TABLE emp2(
		id int PRIMARY KEY auto_increment,
		name VARCHAR(10),
		gender char(1),
		salary DOUBLE,
		dep_id int,
		FOREIGN KEY (dep_id) REFERENCES dept2(did)
);

INSERT INTO dept2(dname) VALUES ('研发部'),('市场部'),('财务部'),('销售部');
INSERT INto emp2(name,gender,salary,dep_id) VALUES 
('刘备','男',8000,1),
('小乔','女',5000,2),
('达摩','男',2000,2),
('典韦','男',12000,3),
('虞姬','女',20000,1),
('关羽','男',6000,null);


-- 普通单表
SELECT * FROM dept2;
SELECT * FROM emp2;


-- 多表
SELECT * FROM emp2,dept2;
SELECT * FROM dept2,emp2;
-- 笛卡尔积显现: 有A,B两个集合, 取A,B所有的组合情况


-- 连接查询 ===================================================

-- 1.内连接
-- 隐式连接 WHERE ~
SELECT * FROM emp2,dept2 WHERE emp2.dep_id = dept2.did;
SELECT emp2.name, emp2.gender, dept2.dname FROM emp2,dept2 WHERE emp2.dep_id = dept2.did;

-- 显示内连接 表1 INNER(可省略) JOIN 表2 ON ~ 
SELECT * From emp2 inner join dept2 on emp2.dep_id = dept2.did;
SELECT * From emp2 join dept2 on emp2.dep_id = dept2.did;


-- 2.外连接
-- 左外连接: AB两表, 查询A表所有数据和交集部分数据 
SELECT * from emp2 left OUTER join dept2 on emp2.dep_id = dept2.did;  -- OUTER 可省略
SELECT * from dept2 left join emp2 on emp2.dep_id = dept2.did;

-- 右外连接: AB两表, 查询B表所有数据和交集部分数据 
SELECT * from emp2 right join dept2 on emp2.dep_id = dept2.did;


-- 子查询 ====================================================

-- 1.单行单列, 子查询作为条件值进行条件判断
-- 查询工资高于刘备的员工信息
-- 普通查询
SELECT salary FROM emp2 WHERE name = '刘备';
SELECT * FROM emp2 WHERE salary > 8000;

-- 子查询 (嵌套查询)
SELECT * FROM emp2 WHERE salary > (SELECT salary FROM emp2 WHERE name = '刘备');

-- 2.单行多列, 子查询作为条件值, 使用in等关键字进行条件判断
-- 查询财务部和市场部的所有员工
SELECT did FRom dept2 WHERE dname = '财务部' or dname = '市场部';
SELECT * from emp2 WHERE dep_id in (SELECT did FRom dept2 WHERE dname = '财务部' or dname = '市场部');

-- 3.多行多列, 子查询作为虚拟表
-- 查询工资大于5000的所有员工信息和部门信息
SELECT * FROM emp2 WHERE salary > 5000;
SELECT * FROM (SELECT * FROM emp2 WHERE salary > 5000)emp2, dept2 WHERE emp2.dep_id = dept2.did;
-- 不能查询部门值为null的员工

-- 外连接查询, 子查询
SELECT * FROM (SELECT * FROM emp2 WHERE salary > 5000)emp2 left JOIN dept2 on emp2.dep_id = dept2.did;
SELECT id,name,gender,salary,dname FROM (SELECT * FROM emp2 WHERE salary > 5000)t1 -- t1 别名, 原emp2
left JOIN dept2 on t1.dep_id = dept2.did;
-- 可以查询部门值为null的员工




