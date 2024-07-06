/*
Navicat MySQL Data Transfer

Source Server         : 777
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : app

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2024-07-04 09:20:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `did` int DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('2', '张三', '2', '17790324622', 'f433d83851646431f1996f7e41d0d101', 'e90c35a5b1944ac79b164d82db97e7d5', '0');
INSERT INTO `user_info` VALUES ('3', '李四', '1', '13348945139', 'c8af1ac697af0389dad9675819d401ad', '8b6aff771a8343d2aa627116b2a59808', '0');
INSERT INTO `user_info` VALUES ('4', '王五', '2', '17340321415', '5275950be54f1f736791e1619966159d', 'f1e0c7f1e74342c380544b3bcd3621dd', '0');
INSERT INTO `user_info` VALUES ('5', 'Jack', '1', '17321345699', '1945db414b7c6a7ef93ad233cc1c0df5', 'c67f3eec96aa488ab11d7c7d41da2e3c', '0');
INSERT INTO `user_info` VALUES ('6', '小小', '1', '15897845632', '133b0be776dd2db616f7b0950d4fd83e', '496641', '0');
INSERT INTO `user_info` VALUES ('7', 'fss', '2', '18683454717', '5db71aa3eca6324bc0899ba71aabf48f', 'c9d04440c4f742f89825f310df32593a', '0');
INSERT INTO `user_info` VALUES ('10', 'aaa', '1', '17380521219', 'b23ab7a20a7dc8afc7b4915171a5c54e', '0cdde075aa06457d8645e544803e5524', '0');
INSERT INTO `user_info` VALUES ('11', 'aaaee', '1', '17345671345', '4696baf61c10091213ac5c3ef02f1b03', '1ac4d0a2756940c6955ef3c198258515', '0');
INSERT INTO `user_info` VALUES ('12', 'err43', '2', '13348765138', '915cb22a77164022bec6ce8cae10d152', 'cc0ca9099dd34c379d1bbbcaf2bdd035', '0');
INSERT INTO `user_info` VALUES ('13', 'zhangsan', '1', '17783522965', '66e585b7dc8ff431040aa135c834f7b7', '73b0d2bae31f48829efd38150db2094c', '0');
INSERT INTO `user_info` VALUES ('14', 'zhangsan', '1', '17742575712', '3e18204cbe1dfb25a70736cf837d755f', '3cf3f7f7593c4c1a8bc3d75336acf96c', '0');
INSERT INTO `user_info` VALUES ('15', 'zhangsan', '1', '17742575711', 'c15f12a6340f600f1a399a0d6cf7d0e2', '7d60506bab804089ae4993f985e2a4f2', '0');
INSERT INTO `user_info` VALUES ('16', 'zhangsan', '1', '17742575713', '93abd4daef8484a0c3a261dabd3f3866', 'f8dbda99f90d483fa98f634ea21e9bec', '0');
INSERT INTO `user_info` VALUES ('17', '测试用户', '2', '17783522955', 'bdd9a4ab08264a7bf7b15aa1c4a9d486', 'aabc077db84845d6803e68ea55bf2216', '0');
