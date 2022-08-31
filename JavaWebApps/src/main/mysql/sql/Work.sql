-- 删除tb_brand表
drop table if exists tb_brand;

-- 创建tb_brand表
create table tb_brand (
    -- id 主键
   id int primary key auto_increment,
    -- 品牌名称
   brand_name varchar(20),
    -- 企业名称
   company_name varchar(20),
    -- 排序字段
   ordered int,
    -- 描述信息
   description varchar(100),
    -- 状态：0：禁用 1：启用
   status int
);

SELECT * FROM tb_brand;

-- 添加数据
INSERT INTO tb_brand ( brand_name, company_name, ordered, description, STATUS )
VALUES
	( '三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0 ),
	( '华为', '华为技术有限公司', 100, '华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界', 1 ),
	( '小米', '小米科技有限公司', 50, 'are you ok', 1 );

delete FROM tb_brand WHERE id = 5;



