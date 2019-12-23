-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `phone_number` varchar(40) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'phone number',
  `password` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'user password',
  `nickname` varchar(40) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'user nick name',
  `gender` tinyint(2) NOT NULL DEFAULT '0' COMMENT 'user gender',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_phone_number` (`phone_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;