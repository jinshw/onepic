-- auto Generated on 2017-07-05 11:56:45 
-- DROP TABLE IF EXISTS `stake`; 
CREATE TABLE `stake`(
    `stake_id` VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'stakeId',
    `stake_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'stakeName',
    `stake_type` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'stakeType',
    `stake_num` INT (11) NOT NULL COMMENT 'stakeNum',
    `stake_length` DOUBLE (16,4) NOT NULL COMMENT 'stakeLength',
    `lon` DOUBLE (16,4) NOT NULL COMMENT 'lon',
    `lat` DOUBLE (16,4) NOT NULL COMMENT 'lat',
    PRIMARY KEY (`stake_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`stake`';
