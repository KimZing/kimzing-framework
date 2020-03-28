CREATE TABLE `tb_shop_category` (
    `shop_category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店铺id',
    `shop_category_name` varchar(100) NOT NULL DEFAULT '' COMMENT '店铺类别名称',
    `shop_category_desc` varchar(1000) DEFAULT '' COMMENT '店铺类别描述',
    `shop_category_img` varchar(2000) DEFAULT NULL COMMENT '店铺类别图片地址',
    `priority` int(2) NOT NULL DEFAULT 0 COMMENT '展示的优先级',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_edit_time` datetime DEFAULT NULL COMMENT '修改时间',
    `parent_id` int(11) DEFAULT NULL COMMENT '店铺类别父类',
    PRIMARY KEY (`shop_category_id`),
    KEY `fk_shop_category_self` (`parent_id`),
    CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category`(`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8