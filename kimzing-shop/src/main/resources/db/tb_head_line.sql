CREATE TABLE `tb_head_line` (
    `line_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '头条id',
    `line_name` varchar(100) DEFAULT NULL COMMENT '头条名称',
    `line_link` varchar(200) NOT NULL COMMENT '头条链接',
    `line_img` varchar(2000) NOT NULL COMMENT '头条图片地址',
    `priority` int(2) DEFAULT NULL COMMENT '展示的优先级',
    `enable_status` int(2) NOT NULL DEFAULT 0 COMMENT '头条名称',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_edit_time` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`line_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8