/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pro_user

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 11/05/2020 00:20:28
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='枚举表 ';

-- ----------------------------
-- Records of pro_enum
-- ----------------------------
BEGIN;
INSERT INTO `pro_enum` VALUES (1, 'image', '图片', 'oss', '2020-05-03 23:08:26');
INSERT INTO `pro_enum` VALUES (2, 'video', '视频', 'oss', '2020-05-03 23:08:59');
INSERT INTO `pro_enum` VALUES (3, 'audio', '音乐', 'oss', '2020-05-03 23:09:16');
INSERT INTO `pro_enum` VALUES (4, 'file', '文件', 'oss', '2020-05-03 23:09:26');
INSERT INTO `pro_enum` VALUES (5, 'default', '默认', 'oss', '2020-05-04 21:12:55');
INSERT INTO `pro_enum` VALUES (6, '根目录', '0', 'menu', '2020-05-10 13:29:14');
INSERT INTO `pro_enum` VALUES (7, '子页面', '1', 'menu', '2020-05-10 13:30:12');
INSERT INTO `pro_enum` VALUES (8, '功能', '2', 'menu', '2020-05-10 13:30:29');
INSERT INTO `pro_enum` VALUES (9, '链接', '3', 'menu', '2020-05-10 13:30:44');
COMMIT;

-- ----------------------------
-- Table structure for pro_generator
-- ----------------------------
DROP TABLE IF EXISTS `pro_generator`;
CREATE TABLE `pro_generator` (
  `gen_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `mysql` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库地址',
  `api_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'api参数包名',
  `controller_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Controller包名',
  `vo_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Vo包名',
  `service_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Service接口包名',
  `service_impl_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Service实现包名',
  `mapper_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Mapper包名',
  `dto_pgk` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Dto包名',
  `mysql_user` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库账号',
  `mysql_pass` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库密码',
  `table_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库表名称',
  `feign_client_service` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Feign服务名',
  `gate_way_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网关访问根目录',
  `log_source_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志来源名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `mysql_dev` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'mysql驱动',
  PRIMARY KEY (`gen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='代码生成表';

-- ----------------------------
-- Records of pro_generator
-- ----------------------------
BEGIN;
INSERT INTO `pro_generator` VALUES (6, 'jdbc:mysql://localhost:3306/pro_user', 'com.wzy.system.request', 'com.wzy.system.controller', 'com.wzy.system.vo', 'com.wzy.system', 'com.wzy.system.service', 'com.wzy.system.mapper', 'com.wzy.system.dto', 'root', 'wangyang', NULL, 'system-service', '/system', 'admin-app', '2020-05-10 23:50:44', 'com.mysql.jdbc.Driver');
COMMIT;

-- ----------------------------
-- Table structure for pro_log
-- ----------------------------
DROP TABLE IF EXISTS `pro_log`;
CREATE TABLE `pro_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志名称',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志内容',
  `class_name` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '函数类',
  `function_name` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '函数名',
  `run_time` float DEFAULT NULL COMMENT '执行时间ms',
  `source` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志来源',
  `body` text COLLATE utf8mb4_unicode_ci COMMENT '参数内容',
  `return_body` text COLLATE utf8mb4_unicode_ci COMMENT '反馈数据',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1620 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='操作日志';

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
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单表 ';

-- ----------------------------
-- Records of pro_menu
-- ----------------------------
BEGIN;
INSERT INTO `pro_menu` VALUES (55, 'system', NULL, 'ios-settings', 'Main', 0, '0', NULL, '2020-04-13 23:37:43', '系统管理');
INSERT INTO `pro_menu` VALUES (56, 'generator', NULL, 'ios-settings', '/pro/gen/index', 86, '1', NULL, '2020-04-13 23:39:12', '代码生成器');
INSERT INTO `pro_menu` VALUES (57, 'role', NULL, 'ios-settings', '/pro/system/role/index', 55, '1', NULL, '2020-04-16 00:18:24', '角色管理');
INSERT INTO `pro_menu` VALUES (58, 'user', NULL, 'ios-settings', '/pro/system/user/index', 55, '1', NULL, '2020-04-16 00:45:42', '管理员管理');
INSERT INTO `pro_menu` VALUES (59, 'menu', NULL, 'ios-settings', '/pro/system/menu/index', 55, '1', NULL, '2020-04-16 00:48:04', '菜单管理');
INSERT INTO `pro_menu` VALUES (60, NULL, NULL, NULL, NULL, 59, '2', 'addmenu', '2020-04-20 00:07:38', '添加菜单');
INSERT INTO `pro_menu` VALUES (61, NULL, NULL, NULL, NULL, 58, '2', 'addadmin', '2020-04-20 00:09:19', '添加管理员');
INSERT INTO `pro_menu` VALUES (62, NULL, NULL, NULL, NULL, 57, '2', 'addrole', '2020-04-20 00:09:38', '添加角色');
INSERT INTO `pro_menu` VALUES (63, NULL, NULL, NULL, NULL, 56, '2', 'gen:connecnt', '2020-04-20 00:10:06', '连接');
INSERT INTO `pro_menu` VALUES (64, 'enum', NULL, 'ios-settings', '/pro/system/enum/index', 55, '1', NULL, '2020-05-02 11:45:08', '枚举管理');
INSERT INTO `pro_menu` VALUES (65, 'file', NULL, 'ios-settings', '/pro/system/file/index', 55, '1', '', '2020-05-03 22:26:27', '文件管理');
INSERT INTO `pro_menu` VALUES (66, NULL, NULL, NULL, NULL, 65, '2', 'file_add', '2020-05-04 20:56:24', '上传文件');
INSERT INTO `pro_menu` VALUES (67, NULL, NULL, NULL, NULL, 65, '2', 'file_del', '2020-05-04 21:04:59', '文件删除');
INSERT INTO `pro_menu` VALUES (68, NULL, NULL, NULL, NULL, 64, '2', 'enum_select', '2020-05-05 13:44:14', '枚举查询');
INSERT INTO `pro_menu` VALUES (69, NULL, NULL, NULL, NULL, 64, '2', 'enum_add', '2020-05-05 13:44:40', '枚举添加');
INSERT INTO `pro_menu` VALUES (70, NULL, NULL, NULL, NULL, 64, '2', 'enum_edit', '2020-05-05 13:45:27', '枚举编辑');
INSERT INTO `pro_menu` VALUES (71, NULL, NULL, NULL, NULL, 64, '2', 'enum_del', '2020-05-05 13:45:44', '枚举删除');
INSERT INTO `pro_menu` VALUES (72, NULL, NULL, NULL, NULL, 65, '2', 'file_select', '2020-05-07 23:14:36', '文件查询');
INSERT INTO `pro_menu` VALUES (73, 'log', NULL, 'ios-settings', '/pro/system/log/index', 82, '1', NULL, '2020-05-08 00:42:06', '日志管理');
INSERT INTO `pro_menu` VALUES (74, NULL, NULL, NULL, NULL, 73, '2', 'log_select', '2020-05-08 00:42:30', '日志查询');
INSERT INTO `pro_menu` VALUES (75, NULL, NULL, NULL, NULL, 73, '0', 'log_del', '2020-05-08 00:42:42', '日志删除');
INSERT INTO `pro_menu` VALUES (76, NULL, NULL, NULL, NULL, 73, '2', 'log_info', '2020-05-08 01:25:00', '查看详情');
INSERT INTO `pro_menu` VALUES (77, NULL, NULL, NULL, NULL, 58, '2', 'admin_select', '2020-05-09 21:32:28', '管理员查询');
INSERT INTO `pro_menu` VALUES (78, NULL, NULL, NULL, NULL, 58, '2', 'admin_edit', '2020-05-09 21:32:52', '管理员修改');
INSERT INTO `pro_menu` VALUES (79, NULL, NULL, NULL, NULL, 58, '2', 'admin_del', '2020-05-09 21:33:49', '管理员删除');
INSERT INTO `pro_menu` VALUES (82, 'monitor', NULL, 'ios-settings', '/Main', 0, '0', NULL, '2020-05-10 00:04:38', '监控管理');
INSERT INTO `pro_menu` VALUES (83, 'eureka', NULL, 'ios-settings', 'http://localhost:8001', 82, '3', NULL, '2020-05-10 00:06:16', '注册服务');
INSERT INTO `pro_menu` VALUES (84, 'admin', NULL, 'ios-settings', 'http://192.168.0.151:8003', 82, '3', NULL, '2020-05-10 00:09:16', 'Admin');
INSERT INTO `pro_menu` VALUES (85, 'zipkin', NULL, 'ios-settings', 'http://192.168.0.151:8004', 82, '3', NULL, '2020-05-10 00:15:56', 'ZipKin');
INSERT INTO `pro_menu` VALUES (86, 'gen', NULL, 'ios-settings', 'Main', 0, '0', NULL, '2020-05-10 14:26:27', '生成器');
INSERT INTO `pro_menu` VALUES (88, 'generatoroption', NULL, 'ios-settings', '/pro/gen/option', 86, '1', NULL, '2020-04-13 23:39:12', '生成器设置');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统资源文件表 ';

-- ----------------------------
-- Records of pro_resource_file
-- ----------------------------
BEGIN;
INSERT INTO `pro_resource_file` VALUES (1, '王振宇的简历.pdf', NULL, '2020050420570427761.pdf', '900c442c3e313dbf8e5235eb15beffe6', 101183, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '文件', 'pdf', 'ali', '2020-05-04 20:57:10');
INSERT INTO `pro_resource_file` VALUES (2, '【研发部】2020年工作周报汇总.xlsx', NULL, '2020050421135225885.xlsx', 'f96dc1fcd554bcaa1ecc3246f016e32c', 38969, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'xlsx', 'ali', '2020-05-04 21:13:58');
INSERT INTO `pro_resource_file` VALUES (3, '下载.jpeg', NULL, '2020050513523582617.jpeg', 'd9e71ec5d7902591b6ded40c7ed72c1d', 8408, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '图片', 'jpeg', 'ali', '2020-05-05 13:52:38');
INSERT INTO `pro_resource_file` VALUES (4, '资助过程性管理系统开发需求规格说明书.docx', NULL, '2020050720010015446.docx', 'c4f62c3430a2153a3431552fcf383cbc', 427772, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'docx', 'ali', '2020-05-07 20:01:05');
INSERT INTO `pro_resource_file` VALUES (5, '2020-05-08 01_21_35.zip', NULL, '2020050920284982917.zip', 'c1d43fb8611e3fecd82b1d4a7f1205ae', 3372, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'zip', 'ali', '2020-05-09 20:28:53');
INSERT INTO `pro_resource_file` VALUES (6, 'db_jude.sql', NULL, '2020051013194433539.sql', '3aefd9a1b2846172583286d23819ed4', 290096, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '视频', 'sql', 'ali', '2020-05-10 13:19:48');
INSERT INTO `pro_resource_file` VALUES (7, 'db_jude.sql', NULL, '202005101449288127.sql', '3aefd9a1b2846172583286d23819ed4', 290096, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'sql', 'ali', '2020-05-10 14:49:33');
COMMIT;

-- ----------------------------
-- Table structure for pro_role
-- ----------------------------
DROP TABLE IF EXISTS `pro_role`;
CREATE TABLE `pro_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统角色表 ';

-- ----------------------------
-- Records of pro_role
-- ----------------------------
BEGIN;
INSERT INTO `pro_role` VALUES (17, '管理员', '2020-03-21 22:23:03');
INSERT INTO `pro_role` VALUES (18, '生成管理员', '2020-03-29 00:58:34');
INSERT INTO `pro_role` VALUES (19, '角色管理员', '2020-05-10 16:42:59');
INSERT INTO `pro_role` VALUES (20, '共和国管理', '2020-05-10 23:52:37');
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
) ENGINE=InnoDB AUTO_INCREMENT=5108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of pro_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `pro_role_menu` VALUES (4922, 18, 86, '2020-05-10 19:36:32');
INSERT INTO `pro_role_menu` VALUES (4923, 18, 56, '2020-05-10 19:36:32');
INSERT INTO `pro_role_menu` VALUES (4924, 18, 63, '2020-05-10 19:36:32');
INSERT INTO `pro_role_menu` VALUES (4925, 18, 88, '2020-05-10 19:36:32');
INSERT INTO `pro_role_menu` VALUES (4926, 18, 82, '2020-05-10 19:36:32');
INSERT INTO `pro_role_menu` VALUES (4927, 18, 85, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4928, 18, 84, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4929, 18, 83, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4930, 18, 73, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4931, 18, 76, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4932, 18, 75, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4933, 18, 74, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4934, 18, 55, '2020-05-10 19:36:33');
INSERT INTO `pro_role_menu` VALUES (4935, 18, 65, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4936, 18, 72, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4937, 18, 67, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4938, 18, 66, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4939, 18, 64, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4940, 18, 71, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4941, 18, 70, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4942, 18, 69, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4943, 18, 68, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4944, 18, 59, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4945, 18, 60, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4946, 18, 58, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4947, 18, 79, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4948, 18, 78, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4949, 18, 77, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4950, 18, 61, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4951, 18, 57, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4952, 18, 62, '2020-05-10 19:36:34');
INSERT INTO `pro_role_menu` VALUES (4953, 19, 86, '2020-05-10 19:36:40');
INSERT INTO `pro_role_menu` VALUES (4954, 19, 56, '2020-05-10 19:36:41');
INSERT INTO `pro_role_menu` VALUES (4955, 19, 63, '2020-05-10 19:36:41');
INSERT INTO `pro_role_menu` VALUES (4956, 19, 88, '2020-05-10 19:36:41');
INSERT INTO `pro_role_menu` VALUES (4957, 19, 82, '2020-05-10 19:36:41');
INSERT INTO `pro_role_menu` VALUES (4958, 19, 85, '2020-05-10 19:36:41');
INSERT INTO `pro_role_menu` VALUES (4959, 19, 84, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4960, 19, 83, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4961, 19, 73, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4962, 19, 76, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4963, 19, 75, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4964, 19, 74, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4965, 19, 55, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4966, 19, 65, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4967, 19, 72, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4968, 19, 67, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4969, 19, 66, '2020-05-10 19:36:42');
INSERT INTO `pro_role_menu` VALUES (4970, 19, 64, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4971, 19, 71, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4972, 19, 70, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4973, 19, 69, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4974, 19, 68, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4975, 19, 59, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4976, 19, 60, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4977, 19, 58, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4978, 19, 79, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4979, 19, 78, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4980, 19, 77, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4981, 19, 61, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4982, 19, 57, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (4983, 19, 62, '2020-05-10 19:36:43');
INSERT INTO `pro_role_menu` VALUES (5046, 17, 86, '2020-05-10 19:39:22');
INSERT INTO `pro_role_menu` VALUES (5047, 17, 56, '2020-05-10 19:39:22');
INSERT INTO `pro_role_menu` VALUES (5048, 17, 63, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5049, 17, 88, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5050, 17, 82, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5051, 17, 85, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5052, 17, 84, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5053, 17, 83, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5054, 17, 73, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5055, 17, 76, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5056, 17, 75, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5057, 17, 74, '2020-05-10 19:39:23');
INSERT INTO `pro_role_menu` VALUES (5058, 17, 55, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5059, 17, 65, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5060, 17, 72, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5061, 17, 67, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5062, 17, 66, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5063, 17, 64, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5064, 17, 71, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5065, 17, 70, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5066, 17, 69, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5067, 17, 68, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5068, 17, 59, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5069, 17, 60, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5070, 17, 58, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5071, 17, 79, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5072, 17, 78, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5073, 17, 77, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5074, 17, 61, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5075, 17, 57, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5076, 17, 62, '2020-05-10 19:39:24');
INSERT INTO `pro_role_menu` VALUES (5077, 20, 86, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5078, 20, 56, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5079, 20, 63, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5080, 20, 88, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5081, 20, 82, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5082, 20, 85, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5083, 20, 84, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5084, 20, 83, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5085, 20, 73, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5086, 20, 76, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5087, 20, 75, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5088, 20, 74, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5089, 20, 55, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5090, 20, 65, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5091, 20, 72, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5092, 20, 67, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5093, 20, 66, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5094, 20, 64, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5095, 20, 71, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5096, 20, 70, '2020-05-10 23:52:45');
INSERT INTO `pro_role_menu` VALUES (5097, 20, 69, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5098, 20, 68, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5099, 20, 59, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5100, 20, 60, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5101, 20, 58, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5102, 20, 79, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5103, 20, 78, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5104, 20, 77, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5105, 20, 61, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5106, 20, 57, '2020-05-10 23:52:46');
INSERT INTO `pro_role_menu` VALUES (5107, 20, 62, '2020-05-10 23:52:46');
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统管理员表 ';

-- ----------------------------
-- Records of pro_user
-- ----------------------------
BEGIN;
INSERT INTO `pro_user` VALUES (1, '2020050513523582617.jpeg', 'lptnyy', 'wangyang', 0, NULL, 0, '2020-05-10 03:15:20');
INSERT INTO `pro_user` VALUES (33, '2020050513523582617.jpeg', 'lptnii', 'wangyang', 0, NULL, 0, '2020-05-10 03:18:12');
INSERT INTO `pro_user` VALUES (34, '2020050513523582617.jpeg', 'lptnuu', 'wangyang', 0, NULL, 0, '2020-05-10 03:30:33');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色关系表 ';

-- ----------------------------
-- Records of pro_user_role
-- ----------------------------
BEGIN;
INSERT INTO `pro_user_role` VALUES (4, 18, 3, '2020-04-20 00:38:01');
INSERT INTO `pro_user_role` VALUES (5, 17, 3, '2020-04-20 00:38:01');
INSERT INTO `pro_user_role` VALUES (10, 18, 1, '2020-05-02 10:04:25');
INSERT INTO `pro_user_role` VALUES (11, 17, 1, '2020-05-02 10:04:25');
INSERT INTO `pro_user_role` VALUES (12, 18, 6, '2020-05-07 20:31:28');
INSERT INTO `pro_user_role` VALUES (13, 17, 6, '2020-05-07 20:31:28');
INSERT INTO `pro_user_role` VALUES (16, 18, 33, '2020-05-10 03:18:46');
INSERT INTO `pro_user_role` VALUES (17, 17, 33, '2020-05-10 03:18:46');
INSERT INTO `pro_user_role` VALUES (18, 17, 32, '2020-05-10 14:50:38');
INSERT INTO `pro_user_role` VALUES (19, 18, 32, '2020-05-10 14:50:38');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5707 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
