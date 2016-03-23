/*
Navicat MySQL Data Transfer

Source Server         : Royal
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : po

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2016-03-23 09:16:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `parking_space`
-- ----------------------------
DROP TABLE IF EXISTS `parking_space`;
CREATE TABLE `parking_space` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `space_number` int(5) NOT NULL,
  `car_number` varchar(20) NOT NULL,
  `status` varchar(2) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `cost` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parking_space
-- ----------------------------
INSERT INTO `parking_space` VALUES ('1', '-1', '冀H1', '空', '2016-03-17 11:48:36', '2016-03-17 11:48:40', '70.00');
INSERT INTO `parking_space` VALUES ('553', '0', '京A0', '满', '2016-03-16 10:45:59', '2016-03-16 10:45:59', '70.00');
INSERT INTO `parking_space` VALUES ('554', '1', '京A1', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('555', '2', '京A2', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('556', '3', '京A3', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('557', '4', '京A4', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('558', '5', '京A5', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('559', '6', '京A6', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('560', '7', '京A7', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('561', '8', '京A8', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('562', '9', '京A9', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('563', '10', '京A10', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('564', '11', '京A11', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('565', '12', '京A12', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('566', '13', '京A13', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('567', '14', '京A14', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('568', '15', '京A15', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('569', '16', '京A16', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('570', '17', '京A17', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('571', '18', '京A18', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('572', '19', '京A19', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('573', '20', '京A20', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('574', '21', '京A21', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('575', '22', '京A22', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('576', '23', '京A23', '满', '2016-03-16 10:46:02', '2016-03-16 10:46:02', '50.00');
INSERT INTO `parking_space` VALUES ('577', '24', '京A24', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('578', '25', '京A25', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('579', '26', '京A26', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('580', '27', '京A27', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('581', '28', '京A28', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('582', '29', '京A29', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('583', '30', '京A30', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('584', '31', '京A31', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('585', '32', '京A32', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('586', '33', '京A33', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('587', '34', '京A34', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('588', '35', '京A35', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('589', '36', '京A36', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('590', '37', '京A37', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('591', '38', '京A38', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('592', '39', '京A39', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('593', '40', '京A40', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('594', '41', '京A41', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('595', '42', '京A42', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('596', '43', '京A43', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('597', '44', '京A44', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('598', '45', '京A45', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('599', '46', '京A46', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('600', '47', '京A47', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('601', '48', '京A48', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');
INSERT INTO `parking_space` VALUES ('602', '49', '京A49', '满', '2016-03-16 10:46:03', '2016-03-16 10:46:03', '50.00');

-- ----------------------------
-- Table structure for `servant`
-- ----------------------------
DROP TABLE IF EXISTS `servant`;
CREATE TABLE `servant` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servant
-- ----------------------------
INSERT INTO `servant` VALUES ('admin', '1966dd715c6d14f36578b6ab9fb0896d', '1', '1');
INSERT INTO `servant` VALUES ('guest', '9a6dd60eb24928c2d83835eece96c479', '2', '1');
