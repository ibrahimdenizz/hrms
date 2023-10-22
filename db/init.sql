CREATE DATABASE IF NOT EXISTS `hrms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hrms`;

DROP TABLE IF EXISTS `LEAVE`;
DROP TABLE IF EXISTS `EMPLOYEE`;
DROP TABLE IF EXISTS `LEAVE_TYPE`;

CREATE TABLE `EMPLOYEE`
(
    ID              VARCHAR(36)                        NOT NULL UNIQUE KEY,
    USERNAME        VARCHAR(50)                        NOT NULL,
    PASSWORD        VARCHAR(255)                       NOT NULL,
    FIRST_NAME      VARCHAR(50)                        NOT NULL,
    LAST_NAME       VARCHAR(50)                        NOT NULL,
    EMAIL           VARCHAR(255)                       NOT NULL,
    GENDER          ENUM ('MALE', 'FEMALE')            NOT NULL,
    DEPARTMENT      VARCHAR(50),
    BIRTHDAY        DATE,
    STARTED_WORK_AT DATE                               NOT NULL,
    LEAVE_WORK_AT   DATE,
    ROLE            ENUM ('HUMAN_RESOURCES', 'WORKER') NOT NULL,
    CREATED_AT      DATETIME                           NOT NULL,
    UPDATED_AT      DATETIME,
    PRIMARY KEY (ID)
);

INSERT INTO `EMPLOYEE`
VALUES (UUID(),
        'ibrahim.deniz',
        'ibrahim.deniz',
        'İbrahim',
        'Deniz',
        'dnzibrahim1@gmail.com',
        'MALE',
        'IT',
        '2000-04-02',
        '2019-04-02',
        NULL,
        'HUMAN_RESOURCES',
        NOW(),
        NULL);

-- Test worker
INSERT INTO `EMPLOYEE`
VALUES (UUID(),
        'test.worker',
        'test.worker',
        'Test',
        'Worker',
        'test.worker@hrms.com',
        'MALE',
        'IT',
        '2000-04-02',
        '2019-04-02',
        NULL,
        'WORKER',
        NOW(),
        NULL);

CREATE TABLE LEAVE_TYPE
(
    ID       VARCHAR(36)  NOT NULL UNIQUE KEY,
    NAME     VARCHAR(100) NOT NULL,
    MAX_DAYS INT,
    GENDER   ENUM ('MALE', 'FEMALE'),
    PRIMARY KEY (ID)
);

INSERT INTO `LEAVE_TYPE`
VALUES (UUID(),
        'Annual Leave',
        14,
        NULL);

INSERT INTO `LEAVE_TYPE`
VALUES (UUID(),
        'Maternity Leave',
        20,
        'FEMALE');

CREATE TABLE `LEAVE`
(
    ID            VARCHAR(36)                              NOT NULL UNIQUE KEY,
    EMPLOYEE_ID   VARCHAR(36)                              NOT NULL UNIQUE KEY,
    LEAVE_TYPE_ID VARCHAR(36)                                      NOT NULL UNIQUE KEY,
    START_DATE    DATE                                     NOT NULL,
    END_DATE      DATE                                     NOT NULL,
    REASON        VARCHAR(2048),
    STATUS        ENUM ('PENDING', 'APPROVED', 'REJECTED') NOT NULL,
    CREATED_AT    DATETIME                                 NOT NULL,
    UPDATED_AT    DATETIME,
    PRIMARY KEY (ID),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID),
    FOREIGN KEY (LEAVE_TYPE_ID) REFERENCES LEAVE_TYPE (ID)
);

INSERT INTO `LEAVE`
VALUES (UUID(),
        (SELECT ID FROM EMPLOYEE WHERE USERNAME = 'test.worker'),
        (SELECT ID FROM LEAVE_TYPE WHERE NAME = 'Annual Leave'),
        '2023-04-02',
        '2023-04-16',
        'Test leave',
        'PENDING',
        NOW(),
        NULL);
