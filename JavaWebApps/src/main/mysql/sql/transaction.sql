-- 事务
-- 事务是一个不可分割的工作逻辑单元, 把所有的命令作为一个整体向系统提交或撤销操作请求,
-- 即这一组数据库命令要么同时成功, 要么同时失败
/* 执行流程 
				开启事务 START TRANSACTION 或 BEGIN
				提交事务 COMMIT
				回滚事务 ROLLBACK
*/

-- 账户表
DROP TABLE IF EXISTS account;

CREATE TABLE account(
		id int PRIMARY KEY auto_increment,
		name VARCHAR(10),
		money DOUBLE
);

INSERT INTO account(name, money) VALUES('张三', 1000), ('李四', 1000);

UPDATE account SET money = 1000;

SELECT * FROM account;


-- 模拟转账事务

begin; -- 开启事务

UPDATE account SET money = money - 500 WHERE name = '李四';

-- 模拟转账错误

UPDATE account SET money = money + 500 WHERE name = '张三';

commit; -- 提交事务 (手动)

rollback; -- 回滚事务 (撤销操作)


/* 事务的四大特征

原子性 (Atomicity)：一个事务（transaction）中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节。
事务在执行过程中发生错误，会被回滚（Rollback）到事务开始前的状态，就像这个事务从来没有执行过一样。

一致性 (Consistency)：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。
这表示写入的资料必须完全符合所有的预设规则，这包含资料的精确度、串联性以及后续数据库可以自发性地完成预定的工作。

隔离性 (Isolation)：当多个并发事务同对其数据进行操作时，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。
事务隔离分为不同级别:
		读取未提交（Read uncommitted）、读取提交（read committed）、可重复读取（repeatable read）和串行化（Serializable）。

持久性 (Durability)：事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失
*/


-- MySQL的事务是自动提交的, 一条DML(增删改)语句会自动提交一次事务
-- 手动提交, 需要先开启事务, 再提交 (Oracle数据库默认使手动提交)

-- 查看提交方式
select @@autocommit;
-- 1 自动提交, 0 手动提交

-- 修改提交方式
-- set @@autocommit = 0 或 1;


