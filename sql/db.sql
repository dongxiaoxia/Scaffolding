-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '主键id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `createBy` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新者',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `delFlag` char(255) CHARACTER SET utf8 NOT NULL COMMENT '删除标记(0有效，1删除掉)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for tbl_example
-- ----------------------------
DROP TABLE IF EXISTS `tbl_example`;
CREATE TABLE `tbl_example` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '主键id',
  `value` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '值',
  `createBy` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新者',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `delFlag` char(255) CHARACTER SET utf8 NOT NULL COMMENT '删除标记(0有效，1删除掉)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
