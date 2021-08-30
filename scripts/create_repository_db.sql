DROP DATABASE IF EXISTS `model-repository`;
CREATE DATABASE IF NOT EXISTS `model-repository`;
USE `model-repository`;

-- Table definitions

DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`
(
    `id`                bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`              varchar(255) NOT NULL,
    `domain`            varchar(255) NOT NULL,
    `description`       text         NOT NULL,
    `modeling_language` varchar(255) NOT NULL,
    `file`              blob         NOT NULL,
    `file_name`         varchar(255) NOT NULL,
    `file_extension`    varchar(255) NOT NULL,
    `version_number`    float        NOT NULL,
    `tool`              varchar(255) NOT NULL,
    `created_at`        timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`        timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `version`;
CREATE TABLE `version`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `file`           blob         NOT NULL,
    `file_name`      varchar(255) NOT NULL,
    `file_extension` varchar(255) NOT NULL,
    `version_number` float        NOT NULL,
    `model_id`       bigint(20)   NOT NULL,
    `updated_at`     timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `pair` (`id`, `updated_at`),
    FOREIGN KEY (`model_id`) REFERENCES model (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;