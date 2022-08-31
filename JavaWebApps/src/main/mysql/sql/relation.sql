-- 数据库设计

-- 表关系之多对多
/* 多对多:
			如: 订单和商品
			一个商品对应多个订单, 一个订单包含多个商品
*/
-- 实现方式: 建立第三张中间表, 中间表至少包含两个外键, 分别关联两方主键

-- 订单表 tb_order
create table tb_order(
		id int primary key auto_increment,
		payment double(10,2),
		payment_type VARCHAR(50),
		status VARCHAR(20)
);

-- 商品表 tb_goods
create table tb_goods(
		id int primary key auto_increment,
		title VARCHAR(50),
		price DOUBLE(10,2)
);

-- 订单中间表 tb_order_goods
create table tb_order_goods(
		id int primary key auto_increment,
		order_id int,
		goods_id int,
		count int
);

-- 键完表后, 添加外键
alter table tb_order_goods add CONSTRAINT fk_order_id FOREIGN key(order_id) REFERENCES tb_order(id);
alter table tb_order_goods add CONSTRAINT fk_goods_id FOREIGN key(goods_id) REFERENCES tb_goods(id);


-- 表关系之一对一
-- 实现方式: 在任意一方建立外键, 关联对方的主键, 并设置外键唯一


















