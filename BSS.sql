/*
 Navicat Premium Data Transfer

 Source Server         : Win10_Mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : bss

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 11/06/2020 23:54:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bId` bigint(20) NOT NULL AUTO_INCREMENT,
  `bName` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `picture` text CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `price` double NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`bId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
select * from book;
INSERT INTO `book` VALUES (1, '三体', '说明:买就完事了！！！！', '/imgs/1.png', '科幻', 55.5, 100);
INSERT INTO `book` VALUES (2, 'C语言程序设计', '说明:一入编程深似海', '/imgs/2.png', '技术', 40, 50);
INSERT INTO `book` VALUES (4, 'bilibili', '1111', 'bilibili', 'ganbei', 22333333, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oId` bigint(20) NOT NULL AUTO_INCREMENT,
  `uId` bigint(20) NOT NULL,
  `bId` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `addr` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` bigint(20) NOT NULL,
  `state` int(11) NULL DEFAULT NULL,
  /*`price` double NULL DEFAULT NULL,*/
  `dateTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`oId`) USING BTREE,
  INDEX `order_user`(`uId`) USING BTREE,
  INDEX `order_book`(`bId`) USING BTREE,
  CONSTRAINT `order_book` FOREIGN KEY (`bId`) REFERENCES `book` (`bId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_user` FOREIGN KEY (`uId`) REFERENCES `user` (`uId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

alter table orders drop column price;
-- -- ----------------------------
-- Records of orders
-- ----------------------------
select * from orders;
INSERT INTO `orders` VALUES (1, 1, 1, 1, '湖南永州', 13367465727, 1, NULL, '2020-06-07 20:40:31');
INSERT INTO `orders` VALUES (2, 1, 2, 1, '湖南永州', 13367465727, 1, NULL, '2020-06-07 20:40:31');
INSERT INTO `orders` VALUES (3, 1, 1, 1, 'aaaaaa', 123456, 0, NULL, '2020-06-11 12:20:14');
INSERT INTO `orders` VALUES (oId, 1, 6, 1, 'aaaaaa', 123456, 2, 30, now());
INSERT INTO `orders` VALUES (oId, 1, 6, 1, 'aaaaaa', 123456, 3, 30, now());
INSERT INTO `orders` VALUES (oId, 1, 6, 1, 'aaaaaa', 123456, 4, 30, now());
INSERT INTO `orders` VALUES (oId, 1, 6, 1, 'aaaaaa', 123456, 4, 30, now());

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `rId` bigint(20) NOT NULL AUTO_INCREMENT,
  `bId` bigint(20) NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`rId`) USING BTREE,
  CONSTRAINT `record_book` FOREIGN KEY (`bId`) REFERENCES `book` (`bId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

show tables;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 1, 100, '2020-06-07 20:40:31');
INSERT INTO `record` VALUES (2, 2, 50, '2020-06-07 20:40:31');
INSERT INTO `record` VALUES (3, 3, 111, '2020-06-11 10:52:06');
INSERT INTO `record` VALUES (4, 4, 1, '2020-06-11 23:51:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
Drop table user;
CREATE TABLE `user`  (
  `uId` bigint(20) NOT NULL AUTO_INCREMENT,
  `uEmail` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uPwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `uName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`uId`) USING BTREE,
  UNIQUE INDEX `user_uName_uindex`(`uName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

ALTER  TABLE user CHANGE uEmai uEmail varchar(40) ;

select * from user;

delete from user ;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '11111111@qq.com', 'gdyb21LQTcIANtvYMT7QVQ==', 'qq.com');
INSERT INTO `user` VALUES (2, NULL, '4QrcOUm6Wau+VuBX8g+IPg==', 'leo');
INSERT INTO `user` VALUES (3, '1111111@qq.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'test1');

SET FOREIGN_KEY_CHECKS = 1;
