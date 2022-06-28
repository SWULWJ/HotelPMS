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

 Date: 28/06/2022 11:48:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for housing_records
-- ----------------------------
DROP TABLE IF EXISTS `housing_records`;
CREATE TABLE `housing_records`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '住房记录ID',
  `room_number` int NOT NULL COMMENT '所住房间',
  `Check_in_time` datetime NOT NULL COMMENT '入住时间',
  `check_out_time` datetime NOT NULL COMMENT '退房时间',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '开房者身份证号',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `room_number`(`room_number` ASC) USING BTREE,
  INDEX `id_card`(`id_card` ASC) USING BTREE,
  CONSTRAINT `housing_records_ibfk_1` FOREIGN KEY (`room_number`) REFERENCES `room_info` (`room_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `housing_records_ibfk_2` FOREIGN KEY (`id_card`) REFERENCES `registrant_info` (`id_card`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of housing_records
-- ----------------------------

-- ----------------------------
-- Table structure for registrant_info
-- ----------------------------
DROP TABLE IF EXISTS `registrant_info`;
CREATE TABLE `registrant_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '开房者id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '开房者名字',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '开房者身份证号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE,
  INDEX `id_card`(`id_card` ASC) USING BTREE,
  CONSTRAINT `registrant_info_ibfk_1` FOREIGN KEY (`name`) REFERENCES `tenant_info` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `registrant_info_ibfk_2` FOREIGN KEY (`id_card`) REFERENCES `tenant_info` (`id_card`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of registrant_info
-- ----------------------------
INSERT INTO `registrant_info` VALUES (1, '刘书源', '1');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房源ID',
  `room_number` int NOT NULL COMMENT '房间号',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房间名称',
  `state` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房间状态（空闲、清洁、维修、使用中）',
  `building` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '楼栋号数',
  `floor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '楼层数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type` ASC) USING BTREE,
  INDEX `room_number`(`room_number` ASC) USING BTREE,
  CONSTRAINT `room_info_ibfk_1` FOREIGN KEY (`type`) REFERENCES `room_type` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (1, 304, '标准间', '空闲', 'A', '3');
INSERT INTO `room_info` VALUES (3, 619, '监狱', '使用中', 'B', '6');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房间ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房间名称',
  `price` decimal(10, 2) NOT NULL COMMENT '房间价格',
  `bed_number` int NULL DEFAULT NULL COMMENT '房间床位数',
  `max_people` int UNSIGNED NULL DEFAULT NULL COMMENT '房间最大人数',
  `min_time` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房间最少租用时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, '标准间', 65.00, 2, 2, '1');
INSERT INTO `room_type` VALUES (2, '监狱', 20.00, 6, 6, '30');

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房客ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房客姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房客性别',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房客身份',
  `information` int NOT NULL COMMENT '房客住的房间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `information`(`information` ASC) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE,
  INDEX `id_card`(`id_card` ASC) USING BTREE,
  CONSTRAINT `tenant_info_ibfk_1` FOREIGN KEY (`information`) REFERENCES `room_info` (`room_number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '刘书源', '男', '1', 619);

SET FOREIGN_KEY_CHECKS = 1;
