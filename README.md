# springsecurity

# setup docker for mysql

```shell
docker run --rm \
--name=mysql-pzn-db \
-e MYSQL_DATABASE=mysqlpzn-db \
-e MYSQL_USER=yukbelajar \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 6603:3306 \
-v "$PWD/mydata/mysql/log":/var/log/mysql \
-v "$PWD/mydata/mysql/data":/var/lib/mysql \
-v "$PWD/mydata/mysql/conf":/etc/mysql/conf.d \
mysql:8
```

# create table

```mysql
--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled`  tinyint(1)  NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES ('john', '{noop}test123', 1),
       ('mary', '{noop}test123', 1),
       ('susan', '{noop}test123', 1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`
(
    `username`  varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES ('john', 'ROLE_EMPLOYEE'),
       ('mary', 'ROLE_EMPLOYEE'),
       ('mary', 'ROLE_MANAGER'),
       ('susan', 'ROLE_EMPLOYEE'),
       ('susan', 'ROLE_ADMIN');
```