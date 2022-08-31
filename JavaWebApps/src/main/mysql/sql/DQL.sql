-- DQL查询语句

-- 创建stud表
CREATE TABLE stud (
	id INT,-- 编号
	NAME VARCHAR ( 20 ),-- 姓名
	age INT,-- 年龄
	sex VARCHAR ( 5 ),-- 性 别
	address VARCHAR ( 100 ),-- 地址
	math DOUBLE ( 5, 2 ),-- 数学成绩
	english DOUBLE ( 5, 2 ),-- 英语成绩
	hire_date DATE -- 入学时间
	
);
INSERT INTO stud ( id, NAME, age, sex, address, math, english, hire_date )
VALUES
	( 1, '马运', 55, '男', '杭州', 66, 78, '1995-09-01' ),
	( 2, '马花疼', 45, '女', '深圳', 98, 87, '1998-09-01' ),
	( 3, '马斯克', 55, '男', '香港', 56, 77, '1999-09-02' ),
	( 4, '柳白', 20, '女', '湖南', 76, 65, '1997-09-05' ),
	( 5, '柳青', 20, '男', '湖南', 86, NULL, '1998-09-01' ),
	( 6, '刘德花', 57, '男', '香港', 99, 99, '1998-09-01' ),
	( 7, '张学右', 22, '女', '香港', 99, 99, '1998-09-01' ),
	( 8, '德玛西亚', 18, '男', '南京', 56, 65, '1994-09-02' );

-- 基础查询====================================================

-- 查询所有数据(*号可以代替全部,但在企业中不要使用)
select * from stud;

-- 查询 name age两列
select name,age from stud;

-- 查询 DISTINCT 去除重复记录
select distinct address from stud;

-- 查询姓名,数学和英语成绩,用 AS 可以指定展示列名(AS可以省略)
select name,math as 数学成绩,english 英语成绩 from stud;


-- 条件查询 WHERE===============================================

-- 查询年龄大于20
select * from stud where age > 20;
select * from stud where age >= 20;

-- 查询区间,使用 && 或 AND 或 BETWEEN ~ AND
select * from stud where age >= 20 and age <= 30;
select * from stud where age between 20 and 30;
select * from stud where hire_date between '1990-09-01' and '1999-09-01';

-- 查询等值
select * from stud where age = 18;
select * from stud where age <> 18; -- 不等于号 <> 或 !=

-- 多条件查询 OR 或 ||
select * from stud where age = 18 or age = 20 or age = 22;
select * from stud where age in(18,20,22);

-- 查询null值,使用 IS 等于, IS NOT 不等于
select * from stud where english is null;
select * from stud where english is not null;


-- 模糊查询 LIKE===============================================
-- 通配符: _ 代表单个字符, % 代表多个字符

-- 查询姓马的学员
select * from stud where name like '马%';

-- 表达式
select * from stud where name like '_化%';
select * from stud where name like '%德%';


-- 排序查询ORDER BY==============================================
-- 排序方式: ASC 升序(默认,可省略), DESC 降序, 可以按多个字段排序

-- 按年龄升序
select * from stud order by age;
select * from stud order by age asc;

-- 按数学成绩降序
select * from stud order by math desc;

-- 按数学成绩降序, 如果数学成绩一样, 再按英语成绩升序排列
-- 如果有多个排序条件, 当前边的条件值一样时, 才会根据第二个条件进行排序
select * from stud order by math desc,english asc;


