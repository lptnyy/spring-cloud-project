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

 Date: 09/03/2020 16:13:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_enum
-- ----------------------------
DROP TABLE IF EXISTS `pro_enum`;
CREATE TABLE "pro_enum" (
  "enum_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '枚举id',
  "keyStr" varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'key',
  "valueStr" varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'value',
  "type" varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'type',
  "create_time" timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  PRIMARY KEY ("enum_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='枚举表 ';

-- ----------------------------
-- Table structure for pro_menu
-- ----------------------------
DROP TABLE IF EXISTS `pro_menu`;
CREATE TABLE "pro_menu" (
  "menu_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  "name" varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  "url" varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问地址',
  "icon" varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  "path" varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物理地址',
  "parent_id" int(11) DEFAULT NULL COMMENT '父级id',
  "type" varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  "create_time" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建事件',
  PRIMARY KEY ("menu_id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单表 ';

-- ----------------------------
-- Records of pro_menu
-- ----------------------------
BEGIN;
INSERT INTO `pro_menu` VALUES (1, '管理', '111', '111', '11', 0, '0', '2020-03-07 23:05:42');
INSERT INTO `pro_menu` VALUES (2, '管理1', '11', '11', '11', 1, '0', '2020-03-08 22:06:50');
COMMIT;

-- ----------------------------
-- Table structure for pro_role
-- ----------------------------
DROP TABLE IF EXISTS `pro_role`;
CREATE TABLE "pro_role" (
  "role_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  "name" varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("role_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统角色表 ';

-- ----------------------------
-- Table structure for pro_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `pro_role_menu`;
CREATE TABLE "pro_role_menu" (
  "rm_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  "role_id" int(11) DEFAULT NULL COMMENT '角色id',
  "menu_id" int(11) DEFAULT NULL COMMENT '菜单id',
  "create_time" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("rm_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单关系表';

-- ----------------------------
-- Table structure for pro_user
-- ----------------------------
DROP TABLE IF EXISTS `pro_user`;
CREATE TABLE "pro_user" (
  "user_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  "head_img" varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  "user_name" varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  "user_pass" varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  "login_num" int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  "last_login_time" datetime NOT NULL COMMENT '最后登录时间',
  "stats" int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("user_id")
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统管理员表 ';

-- ----------------------------
-- Records of pro_user
-- ----------------------------
BEGIN;
INSERT INTO `pro_user` VALUES (1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573236490563&di=f857b4884cf834d4ccba61dacfe7c95b&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D2190783073%2C1034081466%26fm%3D214%26gp%3D0.jpg', 'lptnyy', 'wangyang', 0, '2019-11-03 22:57:49', 0, '2019-11-03 22:57:52');
COMMIT;

-- ----------------------------
-- Table structure for pro_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pro_user_role`;
CREATE TABLE "pro_user_role" (
  "ur_id" int(11) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  "role_id" int(11) NOT NULL COMMENT '角色ID',
  "user_id" int(11) NOT NULL COMMENT '用户ID',
  "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("ur_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色关系表 ';

SET FOREIGN_KEY_CHECKS = 1;
