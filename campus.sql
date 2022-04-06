DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `user_id` int(11) NOT NULL COMMENT '发动态用户id',
  `dynamic_text` varchar(1000) DEFAULT NULL COMMENT '动态文本',
  `dynamic_time` datetime NOT NULL COMMENT '动态时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

DROP TABLE IF EXISTS `dynamic_image`;
CREATE TABLE `dynamic_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dynamic_id` int(11) DEFAULT NULL COMMENT '动态Id',
  `image_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `image_time` timestamp NULL DEFAULT NULL COMMENT '上传时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信用户序号',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(300) DEFAULT NULL COMMENT '头像地址',
  `open_id` varchar(50) NOT NULL COMMENT '用户唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4;
