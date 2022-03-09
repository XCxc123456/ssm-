/*
Navicat MySQL Data Transfer

Source Server         : 100benji
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : zuoyedb

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2020-04-27 16:57:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', '1', 'iUOoOdMAl7FsB1Kig37hmg==');

-- ----------------------------
-- Table structure for `kaoshixx`
-- ----------------------------
DROP TABLE IF EXISTS `kaoshixx`;
CREATE TABLE `kaoshixx` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `riqi` varchar(255) default NULL,
  `con` varchar(2550) default NULL,
  `url` varchar(255) default NULL,
  `tearcher` varchar(255) default NULL,
  `banji` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kaoshixx
-- ----------------------------
INSERT INTO `kaoshixx` VALUES ('7', '计算机信息管理考试', '2020-02-20', '考试题目', 'picture/1.doc', null, null);
INSERT INTO `kaoshixx` VALUES ('8', '数据库技术测试', '2020-02-20', '考试题目', 'picture/1.doc', null, null);
INSERT INTO `kaoshixx` VALUES ('9', '英语考试', '2020-02-25', '考试题目', 'picture/1.doc', null, null);
INSERT INTO `kaoshixx` VALUES ('15', 'JAVA编程题', '2020-02-25', '考试题目', 'picture/1.doc', null, null);

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `riqi` varchar(255) default NULL,
  `con` varchar(2550) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('7', '疫情防控指南', '2020-02-20', '疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南疫情防控指南');
INSERT INTO `news` VALUES ('8', '放假通知', '2020-02-20', '放假通知放假通知放假通知');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL COMMENT '用户名',
  `password` varchar(255) default NULL COMMENT '密码',
  `name` varchar(255) default NULL COMMENT '收货人',
  `phone` varchar(255) default NULL COMMENT '收货电话',
  `address` varchar(255) default NULL COMMENT '收货地址',
  `lianxiren` varchar(255) default NULL,
  `youxiang` varchar(255) default NULL,
  `con` varchar(2550) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2', '1', '1', '李培培', '18222924832', '南京', '教授', '1641@qq.com', '无');
INSERT INTO `teacher` VALUES ('3', '2', '2', '刘士军', '13698758485', '北京', '教授', '1641@qq.com', '无');

-- ----------------------------
-- Table structure for `tops`
-- ----------------------------
DROP TABLE IF EXISTS `tops`;
CREATE TABLE `tops` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(50) default NULL,
  `zuoyexx_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tops
-- ----------------------------

-- ----------------------------
-- Table structure for `types`
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '数据库信息管理');
INSERT INTO `types` VALUES ('2', '高等数学');
INSERT INTO `types` VALUES ('3', '大学英语');
INSERT INTO `types` VALUES ('4', '计算机网络技术');
INSERT INTO `types` VALUES ('5', 'JAVA高级编程');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL COMMENT '用户名',
  `password` varchar(255) default NULL COMMENT '密码',
  `name` varchar(255) default NULL COMMENT '收货人',
  `phone` varchar(255) default NULL COMMENT '收货电话',
  `address` varchar(255) default NULL COMMENT '收货地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', '1', 'iUOoOdMAl7FsB1Kig37hmg==', '李平', '18222924832', '南京');
INSERT INTO `users` VALUES ('4', '2', 'ag3OB0a0vnwiWexZ+52IfQ==', '刘华', '13578987874', '西安');

-- ----------------------------
-- Table structure for `zuoyetijiao`
-- ----------------------------
DROP TABLE IF EXISTS `zuoyetijiao`;
CREATE TABLE `zuoyetijiao` (
  `id` int(11) NOT NULL auto_increment,
  `zuoyexxname` varchar(50) default NULL,
  `typesname` varchar(50) default NULL,
  `teachername` varchar(50) default NULL,
  `shuliang` int(11) default NULL,
  `zyurl` varchar(50) default NULL,
  `zt` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zuoyetijiao
-- ----------------------------
INSERT INTO `zuoyetijiao` VALUES ('2', 'JAVA理论作业5', null, '李平', '90', 'picture/20021056615.pdf', '完成');
INSERT INTO `zuoyetijiao` VALUES ('3', 'JAVA编程作业1', null, '李平', '0', 'picture/20021008695.TXT', '待批阅');

-- ----------------------------
-- Table structure for `zuoyexx`
-- ----------------------------
DROP TABLE IF EXISTS `zuoyexx`;
CREATE TABLE `zuoyexx` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '名称',
  `cover` varchar(255) default NULL COMMENT '封面',
  `image1` varchar(255) default NULL COMMENT '细节图片1',
  `image2` varchar(255) default NULL COMMENT '细节图片2',
  `banji` int(11) default NULL COMMENT '价格',
  `intro` varchar(2550) default NULL COMMENT '介绍',
  `renshu` int(11) default '0' COMMENT '库存',
  `type_id` int(11) default NULL COMMENT '分类',
  `teachername` varchar(255) default NULL,
  `shuliang` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zuoyexx
-- ----------------------------
INSERT INTO `zuoyexx` VALUES ('1', 'JAVA编程作业1', 'picture/1.doc', '/picture/zy.jpg', '/picture/1-3.jpg', '229', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('2', 'JAVA编程作业2', 'picture/1.doc', '/picture/zy.jpg', '/picture/2-3.jpg', '229', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('3', 'JAVA编程作业3', 'picture/1.doc', '/picture/zy.jpg', '/picture/3-3.jpg', '229', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('4', 'JAVA理论作业1', 'picture/1.doc', '/picture/zy.jpg', '/picture/4-3.jpg', '299', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('5', 'JAVA理论作业2', 'picture/1.doc', '/picture/zy.jpg', '/picture/5-3.jpg', '269', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('6', 'JAVA理论作业3', 'picture/1.doc', '/picture/zy.jpg', '/picture/6-3.jpg', '299', '请同学们认真完成作业。', '10', '5', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('7', '计算机网络技术作业', 'picture/1.doc', '/picture/zy.jpg', '/picture/7-3.jpg', '299', '请同学们认真完成作业。', '10', '4', '刘士军', '0');
INSERT INTO `zuoyexx` VALUES ('8', '大学英语作业', 'picture/1.doc', '/picture/zy.jpg', '/picture/8-3.jpg', '299', '请同学们认真完成作业。', '10', '3', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('9', '数据库作业', 'picture/1.doc', '/picture/zy.jpg', '/picture/9-3.jpg', '299', '请同学们认真完成作业。', '10', '1', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('10', '高等数学作业1', 'picture/1.doc', '/picture/zy.jpg', '/picture/10-3.jpg', '28', '请同学们认真完成作业。', '10', '2', '李培培', '40');
INSERT INTO `zuoyexx` VALUES ('11', '高等数学作业2', 'picture/1.doc', '/picture/zy.jpg', '/picture/11-1.jpg', '38', '请同学们认真完成作业。', '10', '2', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('12', '高等数学作业3', 'picture/1.doc', '/picture/zy.jpg', '/picture/12-1.jpg', '36', '请同学们认真完成作业。', '10', '2', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('13', '高等数学作业4', 'picture/1.doc', '/picture/zy.jpg', '/picture/13-1.jpg', '36', '请同学们认真完成作业。', '10', '2', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('14', '高等数学作业5', 'picture/1.doc', '/picture/zy.jpg', '/picture/14-1.jpg', '39', '请同学们认真完成作业。', '10', '2', '李培培', '1');
INSERT INTO `zuoyexx` VALUES ('15', 'JAVA理论作业4', 'picture/1.doc', '/picture/zy.jpg', null, '1', '请同学们认真完成作业。', '12', '5', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('16', 'JAVA理论作业5', 'picture/1.doc', '/picture/zy.jpg', null, '1', '请同学们认真完成作业。', '23', '5', '李培培', '0');
INSERT INTO `zuoyexx` VALUES ('17', '12', 'picture/20042712375.jpg', '/picture/zy.jpg', null, '1', '21', '12', '5', '李培培', '0');
