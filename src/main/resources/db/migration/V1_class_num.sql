CREATE TABLE `CLASS_NUM` (
`	id` SERIAL NOT NULL COMMENT 'ID',
	`SCHOOL_CD` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`CLASS_NUM` VARCHAR(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	PRIMARY KEY (`SCHOOL_CD`,`CLASS_NUM`)
) ENGINE=InnoDB;