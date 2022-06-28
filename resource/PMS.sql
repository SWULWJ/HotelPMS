/*
 Navicat Premium Data Transfer

 Source Server         : CentOS-7-MySQL
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 192.168.87.131:3306
 Source Schema         : PMS

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 28/06/2022 15:14:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Store_records
-- ----------------------------
DROP TABLE IF EXISTS `Store_records`;
CREATE TABLE `Store_records`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品名称',
  `amount` int NOT NULL COMMENT '物品数量',
  `price` decimal(10, 2) NOT NULL COMMENT '物品单价',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bill_record
-- ----------------------------
DROP TABLE IF EXISTS `bill_record`;
CREATE TABLE `bill_record`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '账单记录ID',
  `bill_number` int NOT NULL COMMENT '账单编号',
  `staff_id` int NOT NULL COMMENT '员工ID，经手人',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账单类型（清洁、维修、住房、库存）',
  `time` datetime NOT NULL COMMENT '交易时间',
  `amount` int NOT NULL COMMENT '交易金额',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账单产生缘由',
  `auditing` tinyint(1) NOT NULL COMMENT '审计标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dispatch_records
-- ----------------------------
DROP TABLE IF EXISTS `dispatch_records`;
CREATE TABLE `dispatch_records`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '派遣表ID',
  `staff_id` int NOT NULL COMMENT '员工ID',
  `location` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '派遣目的地',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '派遣类型（清洁、维护、检查）',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作详情',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `staff_id`(`staff_id` ASC) USING BTREE,
  CONSTRAINT `dispatch_records_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for housing_records
-- ----------------------------
DROP TABLE IF EXISTS `housing_records`;
CREATE TABLE `housing_records`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '入住登记表ID',
  `room_id` int NOT NULL COMMENT '入住房间ID',
  `tenant_id` int NOT NULL COMMENT '开房人员ID',
  `check_in_time` datetime NOT NULL COMMENT '入住时间',
  `check_out_time` datetime NOT NULL COMMENT '退房时间',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `room_id`(`room_id` ASC) USING BTREE,
  INDEX `tenant_id`(`tenant_id` ASC) USING BTREE,
  CONSTRAINT `housing_records_ibfk_2` FOREIGN KEY (`tenant_id`) REFERENCES `tenant_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `housing_records_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房源ID',
  `room_number` int NOT NULL COMMENT '房间编号',
  `type` int NOT NULL COMMENT '房间类型',
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房间状态（空闲、清洁、维修、使用中）',
  `building` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在楼栋',
  `floor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在楼层',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type` ASC) USING BTREE,
  CONSTRAINT `room_info_ibfk_1` FOREIGN KEY (`type`) REFERENCES `room_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房间类型ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房间类型名称',
  `price` decimal(10, 2) NOT NULL COMMENT '房间类型价格',
  `bed_number` int NULL DEFAULT NULL COMMENT '房间床数',
  `max_people` int NULL DEFAULT NULL COMMENT '房间最大人数',
  `min_time` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间至少租用时长',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '员工表ID',
  `staff_number` int NOT NULL COMMENT '员工编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工性别',
  `age` int NULL DEFAULT NULL COMMENT '员工年龄',
  `position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工职位',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工电话',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `staff_number`(`staff_number` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房客ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房客姓名',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房客性别',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房客身份ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_card`(`id_card` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tenant_room
-- ----------------------------
DROP TABLE IF EXISTS `tenant_room`;
CREATE TABLE `tenant_room`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房客-客房表ID',
  `tenant_id` int NULL DEFAULT NULL COMMENT '房客ID',
  `room_id` int NULL DEFAULT NULL COMMENT '客房ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tenant_id`(`tenant_id` ASC) USING BTREE,
  INDEX `room_id`(`room_id` ASC) USING BTREE,
  CONSTRAINT `tenant_room_ibfk_1` FOREIGN KEY (`tenant_id`) REFERENCES `tenant_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tenant_room_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户账户表ID',
  `staff_id` int NULL DEFAULT NULL COMMENT '员工ID',
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工密码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `staff_id`(`staff_id` ASC) USING BTREE,
  UNIQUE INDEX `account`(`account` ASC) USING BTREE,
  CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
