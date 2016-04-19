/*
Navicat MySQL Data Transfer

Source Server         : Royal
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : po

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2016-04-19 11:16:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for parking_space
-- ----------------------------
DROP TABLE IF EXISTS `parking_space`;
CREATE TABLE `parking_space` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL DEFAULT '可用',
  `pp_name` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parking_space
-- ----------------------------
INSERT INTO `parking_space` VALUES ('1', '正在使用', '1');
INSERT INTO `parking_space` VALUES ('2', '已预订', '2');
INSERT INTO `parking_space` VALUES ('3', '已预订', '3');
INSERT INTO `parking_space` VALUES ('4', '已预订', '4');
INSERT INTO `parking_space` VALUES ('5', '可用', '5');
INSERT INTO `parking_space` VALUES ('6', '可用', '6');
INSERT INTO `parking_space` VALUES ('7', '可用', '7');
INSERT INTO `parking_space` VALUES ('8', '可用', '8');
INSERT INTO `parking_space` VALUES ('9', '正在使用', '9');
INSERT INTO `parking_space` VALUES ('10', '已预定', '10');
INSERT INTO `parking_space` VALUES ('17', '已预订', '11');
INSERT INTO `parking_space` VALUES ('18', '可用', '12');

-- ----------------------------
-- Table structure for person_info
-- ----------------------------
DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `gander` char(2) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `token` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_info
-- ----------------------------
INSERT INTO `person_info` VALUES ('1', 'username_1', 'password', '18810409001', '女', '21221331', '14594071369770000');
INSERT INTO `person_info` VALUES ('2', 'username_2', 'password', '18810409002', '男', '21221331', '14594071370430000');
INSERT INTO `person_info` VALUES ('3', 'username_3', 'password', '18810409003', '女', '21221331', '14594071370650000');
INSERT INTO `person_info` VALUES ('4', 'username_4', 'password', '18810409004', '男', '21221331', '14594071370790000');
INSERT INTO `person_info` VALUES ('5', 'username_5', 'password', '18810409005', '女', '21221331', '14594071370920000');
INSERT INTO `person_info` VALUES ('6', 'username_6', 'password', '18810409006', '男', '21221331', '14594071371120000');
INSERT INTO `person_info` VALUES ('7', 'username_7', 'password', '18810409007', '女', '21221331', '14594071371330000');
INSERT INTO `person_info` VALUES ('8', 'username_8', 'password', '18810409008', '男', '21221331', '14594071371550000');
INSERT INTO `person_info` VALUES ('9', 'username_9', 'password', '18810409009', '女', '21221331', '14594071371730000');
INSERT INTO `person_info` VALUES ('10', 'username_10', 'password', '18810409001', '男', '21221331', '14594071371890000');
INSERT INTO `person_info` VALUES ('11', 'bbb', '25d55ad283aa400af464c76d713c07ad', '11111111111', '', 'http://pic.xoyo.com/bbs/2011/05/05/1105052118830c2d625c0efe2e.jpg', '');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` bigint(14) NOT NULL,
  `user_id` int(11) NOT NULL,
  `fee` double(5,2) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `space_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `reserve_ibfk_2` (`space_id`),
  CONSTRAINT `reserve_ibfk_2` FOREIGN KEY (`space_id`) REFERENCES `parking_space` (`id`),
  CONSTRAINT `reserve_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `person_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('37', '1460974545136', '11', '3.00', '1', '5');
INSERT INTO `reserve` VALUES ('38', '1460974615080', '11', '3.00', '1', '6');
INSERT INTO `reserve` VALUES ('39', '1460977229009', '11', '3.00', '1', '6');
INSERT INTO `reserve` VALUES ('40', '1460977783401', '11', '3.00', '0', '7');

-- ----------------------------
-- Table structure for servant
-- ----------------------------
DROP TABLE IF EXISTS `servant`;
CREATE TABLE `servant` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(1) NOT NULL,
  `authority` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servant
-- ----------------------------
INSERT INTO `servant` VALUES ('admin', '1966dd715c6d14f36578b6ab9fb0896d', '1', '1', '0');
INSERT INTO `servant` VALUES ('guest', '9a6dd60eb24928c2d83835eece96c479', '2', '1', '1');
