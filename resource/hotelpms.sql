/*
 Navicat Premium Data Transfer

 Source Server         : Bites The Dust
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : hotelpms

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 29/06/2022 09:06:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `staff_id`(`staff_id` ASC) USING BTREE,
  INDEX `time`(`time` ASC) USING BTREE,
  CONSTRAINT `bill_record_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bill_record
-- ----------------------------
INSERT INTO `bill_record` VALUES (1, 1, 2, '住房', '2022-06-23 15:24:47', 999, '1', 1);
INSERT INTO `bill_record` VALUES (2, 2, 2, '库存', '2022-06-28 15:36:01', 200, '买洗洁精', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dispatch_records
-- ----------------------------
INSERT INTO `dispatch_records` VALUES (1, 1, '619', '2022-06-28 15:28:41', '2022-06-29 15:29:16', '清洁', '在摸鱼');

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
  INDEX `check_in_time`(`check_in_time` ASC) USING BTREE,
  CONSTRAINT `housing_records_ibfk_2` FOREIGN KEY (`tenant_id`) REFERENCES `tenant_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `housing_records_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of housing_records
-- ----------------------------
INSERT INTO `housing_records` VALUES (1, 1, 1, '2022-06-23 15:24:47', '2022-07-15 15:24:56', 999.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (1, 619, 1, '空闲', 'B', '6');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, '监狱', 20.00, 8, 6, '30');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES (1, 1, '包翔天', '女', 18, '清洁', '120');
INSERT INTO `staff_info` VALUES (2, 2, '王海腾', '男', 66, '前台', '110');

-- ----------------------------
-- Table structure for store_records
-- ----------------------------
DROP TABLE IF EXISTS `store_records`;
CREATE TABLE `store_records`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品名称',
  `amount` int NOT NULL COMMENT '物品数量',
  `price` decimal(10, 2) NOT NULL COMMENT '物品单价',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of store_records
-- ----------------------------
INSERT INTO `store_records` VALUES (1, '洗衣液', 0, 10.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '刘书源', '男', '123');
INSERT INTO `tenant_info` VALUES (2, '李汪骏', '男', '321');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tenant_room
-- ----------------------------
INSERT INTO `tenant_room` VALUES (1, 1, 1);
INSERT INTO `tenant_room` VALUES (2, 2, 1);

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
  UNIQUE INDEX `account`(`account` ASC) USING BTREE,
  INDEX `staff_id`(`staff_id` ASC) USING BTREE,
  CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, 2, 'WDMND', 'WDNMD');

SET FOREIGN_KEY_CHECKS = 1;
