CREATE TABLE `user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `create_user_id` int(32) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` int(32) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT NULL COMMENT '状态(N正常，L锁定，D删除)',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_index` (`user_id`,`user_name`,`real_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

