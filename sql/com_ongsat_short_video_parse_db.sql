/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : com_ongsat_short_video_parse_db

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-06 14:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_video_parse
-- ----------------------------
DROP TABLE IF EXISTS `t_video_parse`;
CREATE TABLE `t_video_parse` (
  `id` varchar(255) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  `play_url` varchar(500) DEFAULT NULL,
  `original_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `original_url_index` (`original_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
