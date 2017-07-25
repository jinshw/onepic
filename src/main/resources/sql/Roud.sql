-- auto Generated on 2017-07-06 15:58:02 
-- DROP TABLE IF EXISTS `roud`; 
CREATE TABLE `roud`(
    `roud_id` VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'roudId',
    `roud_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'roudName',
    `roud_type` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roudType',
    `roud_level` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roudLevel',
    `roud_length` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'roudLength',
    `roud_status` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roudStatus',
    `start_lon` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'startLon',
    `start_lat` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'startLat',
    `end_lon` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'endLon',
    `end_lat` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'endLat',
    `parent_id` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'parentId',
    PRIMARY KEY (`roud_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`roud`';
