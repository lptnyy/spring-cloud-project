/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : seata

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/05/2020 03:24:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for branch_table
-- ----------------------------
DROP TABLE IF EXISTS `branch_table`;
CREATE TABLE `branch_table` (
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `resource_group_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `resource_id` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `lock_key` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `branch_type` varchar(8) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `client_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`branch_id`),
  KEY `idx_xid` (`xid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `xid` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `application_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `transaction_service_group` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `transaction_name` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `begin_time` bigint(20) DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`xid`),
  KEY `idx_gmt_modified_status` (`gmt_modified`,`status`),
  KEY `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for lock_table
-- ----------------------------
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table` (
  `row_key` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `xid` varchar(96) COLLATE utf8mb4_bin DEFAULT NULL,
  `transaction_id` mediumtext COLLATE utf8mb4_bin,
  `branch_id` mediumtext COLLATE utf8mb4_bin,
  `resource_id` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
  `table_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `pk` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`row_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
