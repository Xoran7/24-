/*
Navicat MySQL Data Transfer

Source Server         : 777
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : app

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2024-07-04 09:20:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `did` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `department_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '销售部', '销售');
INSERT INTO `department_info` VALUES ('2', '开发部', '开发');
