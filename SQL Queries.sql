# SQL QUERIES FOR DATABASE CREATION
# 

CREATE TABLE `guest` (
  `username` varchar(8) NOT NULL,
  `availability` tinyint(4) NOT NULL DEFAULT '1',
  `room` varchar(4) NOT NULL,
  `emergName` varchar(20) DEFAULT NULL,
  `emergRelationship` varchar(20) DEFAULT NULL,
  `emergPhone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `FKguest` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `login` (
  `username` varchar(8) NOT NULL,
  `password` varchar(16) NOT NULL,
  `accountType` varchar(5) NOT NULL DEFAULT 'GUEST',
  `lastLogin` datetime DEFAULT NULL,
  `attempts` int(10) unsigned zerofill DEFAULT '0000000000',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `room` (
  `roomNumber` varchar(4) NOT NULL,
  `rental` float NOT NULL,
  `occupied` int(11) NOT NULL DEFAULT '0',
  `capasity` int(11) NOT NULL,
  PRIMARY KEY (`roomNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `staff` (
  `username` varchar(8) NOT NULL,
  `salary` int(11) NOT NULL,
  `bank` varchar(20) DEFAULT NULL,
  `accNumber` varchar(8) DEFAULT NULL,
  `department` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `FKstaff` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user` (
  `username` varchar(8) NOT NULL,
  `name` varchar(20) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL,
  `regDate` date DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `FKuser` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8