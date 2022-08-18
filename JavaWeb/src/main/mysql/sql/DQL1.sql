-- DQL聚合函数===============================================
-- 将一列数据作为一个整体, 进行纵向计算, null值不参与所有聚合函数运算
/* 聚合函数分类: 
			count	统计数量
			max		最大值
			min		最小值
			sum		求和
			avg		平均值
*/

select * from stud;

-- 统计数量 COUNT(列名), 一般选用不为null的列
/* 取值:
			1.主键 (非空且唯一)
			2.*
*/
select count(name) from stud;
select count(english) from stud;
select count(*) from stud;

-- 最大, 最小值 MAX, MIN
select max(math) from stud;
select min(english) from stud;

-- 求和 SUM
select sum(math) from stud;

-- 求平均值 AVG
select avg(math) from stud;


-- DQL 分组查询===========================================
-- SELECT 字段列表, [聚合函数] FROM 表名 [WHERE 分组前条件限定] GROUP BY 分组字段名 [HAVING 分组后条件过滤]...;
-- 分组之后, 查询的字段为聚合函数和分组字段, 查询其他字段无任何意义

-- 查询男女同学的数学平均分
select avg(math) from stud group by sex;
select sex, avg(math) from stud group by sex;
select name, sex, avg(math) from stud group by sex; -- name列无意义

-- 查询男女同学的数学平均分和人数
select sex, avg(math),count(*) from stud group by sex;

-- 条件分组查询
-- 执行顺序: WHERE > 聚会函数 > HAVING
/* WHERE 和 HAVING 的区别: 
			1.执行时机不一样: where时分组之前进行限定, 不满足where条件则不参与分组, 而having是分组之后对结果进行过滤
			2.可判断的条件不一样: 因执行顺序where不能对聚合函数进行判断, 而having可以
*/

-- 条件分组, 分数低于60不参与分组
select sex, avg(math),count(*) from stud where math > 70 group by sex;

-- 条件分组, 数低于60不参与分组, 且分组之后人数要大于3个
select sex, avg(math),count(*) from stud where math > 70 group by sex having count(*) > 2;


-- 分页查询 LIMIT==========================================
-- ~ LIMIT 起始索引 (从0开始), 查询条目数;

-- 查询前3条数据
select * from stud limit 0 , 3;

-- 从起始索引3开始, 查询4条数据
select * from stud limit 3 , 4;

-- 分页查询计算公式: 起始索引 = (当前页码 - 1) * 每页显示的条数
select * from stud limit 0 , 3; -- 第1页
select * from stud limit 3 , 3; -- 第2页
select * from stud limit 6 , 3; -- 第3页


