/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pro_merchant

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 11/05/2020 20:34:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_merchant
-- ----------------------------
DROP TABLE IF EXISTS `pro_merchant`;
CREATE TABLE "pro_merchant" (
  "merchant_id" bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标示列',
  "abbreviation" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '企业简称',
  "user_name" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  "pass_word" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  "logo_url" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'logo图片',
  "name" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '企业全名',
  "qualification" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商户资质材料',
  "margin" decimal(32,8) DEFAULT NULL COMMENT '保证金额',
  "collect_money" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收款账号',
  "tel" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '固定电话',
  "phone" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  "email" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  "province" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '省份',
  "city" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市',
  "area" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地区',
  "address" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '详细地址',
  "qq" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'qq号码',
  "home_url" varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '企业官网',
  "stat" int(11) DEFAULT NULL COMMENT '状态(枚举表 enterprise_stat)',
  "create_time" datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ("merchant_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商户表 ';

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE "undo_log" (
  "id" bigint(20) NOT NULL AUTO_INCREMENT,
  "branch_id" bigint(20) NOT NULL,
  "xid" varchar(100) NOT NULL,
  "context" varchar(128) NOT NULL,
  "rollback_info" longblob NOT NULL,
  "log_status" int(11) NOT NULL,
  "log_created" datetime NOT NULL,
  "log_modified" datetime NOT NULL,
  "ext" varchar(100) DEFAULT NULL,
  PRIMARY KEY ("id"),
  UNIQUE KEY "ux_undo_log" ("xid","branch_id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
