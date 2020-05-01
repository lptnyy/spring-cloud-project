/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pro_user

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 01/05/2020 22:48:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_enum
-- ----------------------------
DROP TABLE IF EXISTS `pro_enum`;
CREATE TABLE `pro_enum` (
  `enum_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '枚举id',
  `keyStr` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'key',
  `valueStr` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'value',
  `type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'type',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  PRIMARY KEY (`enum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='枚举表 ';

-- ----------------------------
-- Table structure for pro_menu
-- ----------------------------
DROP TABLE IF EXISTS `pro_menu`;
CREATE TABLE `pro_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `url` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `path` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物理地址',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `type` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '类型',
  `jurisdiction` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建事件',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单表 ';

-- ----------------------------
-- Records of pro_menu
-- ----------------------------
BEGIN;
INSERT INTO `pro_menu` VALUES (55, 'system', NULL, 'ios-settings', 'Main', 0, '0', NULL, '2020-04-13 23:37:43', '系统管理');
INSERT INTO `pro_menu` VALUES (56, 'generator', NULL, 'ios-settings', '/pro/gen/index', 55, '1', NULL, '2020-04-13 23:39:12', '代码生成器');
INSERT INTO `pro_menu` VALUES (57, 'role', NULL, 'ios-settings', '/pro/system/role/index', 55, '1', NULL, '2020-04-16 00:18:24', '角色管理');
INSERT INTO `pro_menu` VALUES (58, 'user', NULL, 'ios-settings', '/pro/system/user/index', 55, '1', NULL, '2020-04-16 00:45:42', '管理员管理');
INSERT INTO `pro_menu` VALUES (59, 'menu', NULL, 'ios-settings', '/pro/system/menu/index', 55, '1', NULL, '2020-04-16 00:48:04', '菜单管理');
INSERT INTO `pro_menu` VALUES (60, NULL, NULL, NULL, NULL, 59, '2', 'addmenu', '2020-04-20 00:07:38', '添加菜单');
INSERT INTO `pro_menu` VALUES (61, NULL, NULL, NULL, NULL, 58, '2', 'addadmin', '2020-04-20 00:09:19', '添加管理员');
INSERT INTO `pro_menu` VALUES (62, NULL, NULL, NULL, NULL, 57, '2', 'addrole', '2020-04-20 00:09:38', '添加角色');
INSERT INTO `pro_menu` VALUES (63, NULL, NULL, NULL, NULL, 56, '2', 'gen:connecnt', '2020-04-20 00:10:06', '连接');
COMMIT;

-- ----------------------------
-- Table structure for pro_resource_file
-- ----------------------------
DROP TABLE IF EXISTS `pro_resource_file`;
CREATE TABLE `pro_resource_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `file_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `physics_path` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物理地址',
  `path` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '相对路径',
  `md5` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件指纹',
  `file_size` int(11) DEFAULT NULL COMMENT '文件大小',
  `file_dns` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问域名',
  `type` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类型',
  `suffix` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源后缀',
  `source_type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '储存源',
  `upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统资源文件表 ';

-- ----------------------------
-- Table structure for pro_role
-- ----------------------------
DROP TABLE IF EXISTS `pro_role`;
CREATE TABLE `pro_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统角色表 ';

-- ----------------------------
-- Records of pro_role
-- ----------------------------
BEGIN;
INSERT INTO `pro_role` VALUES (17, '管理员', '2020-03-21 22:23:03');
INSERT INTO `pro_role` VALUES (18, '生成管理员', '2020-03-29 00:58:34');
COMMIT;

-- ----------------------------
-- Table structure for pro_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `pro_role_menu`;
CREATE TABLE `pro_role_menu` (
  `rm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`rm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of pro_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `pro_role_menu` VALUES (212, 17, 55, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (213, 17, 59, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (214, 17, 60, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (215, 17, 58, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (216, 17, 61, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (217, 17, 57, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (218, 17, 62, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (219, 17, 56, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (220, 17, 63, '2020-04-20 01:38:57');
INSERT INTO `pro_role_menu` VALUES (232, 18, 55, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (233, 18, 59, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (234, 18, 60, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (235, 18, 58, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (236, 18, 61, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (237, 18, 57, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (238, 18, 62, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (239, 18, 56, '2020-05-01 22:24:05');
INSERT INTO `pro_role_menu` VALUES (240, 18, 63, '2020-05-01 22:24:05');
COMMIT;

-- ----------------------------
-- Table structure for pro_user
-- ----------------------------
DROP TABLE IF EXISTS `pro_user`;
CREATE TABLE `pro_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `head_img` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `user_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `user_pass` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `stats` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统管理员表 ';

-- ----------------------------
-- Records of pro_user
-- ----------------------------
BEGIN;
INSERT INTO `pro_user` VALUES (1, '2020042000311183427.jpeg', 'lptnyy', 'wangyang', 0, '2020-04-20 00:32:59', 0, '2020-04-20 00:32:26');
INSERT INTO `pro_user` VALUES (3, '2020042000373051031.jpeg', 'admin', 'wangyang', 0, '2020-04-20 00:37:49', 0, '2020-04-20 00:37:38');
COMMIT;

-- ----------------------------
-- Table structure for pro_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pro_user_role`;
CREATE TABLE `pro_user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色关系表 ';

-- ----------------------------
-- Records of pro_user_role
-- ----------------------------
BEGIN;
INSERT INTO `pro_user_role` VALUES (4, 18, 3, '2020-04-20 00:38:01');
INSERT INTO `pro_user_role` VALUES (5, 17, 3, '2020-04-20 00:38:01');
INSERT INTO `pro_user_role` VALUES (8, 18, 1, '2020-05-01 22:26:03');
INSERT INTO `pro_user_role` VALUES (9, 17, 1, '2020-05-01 22:26:03');
COMMIT;