# Bloodbank

<h3>Register Table</h3>
CREATE TABLE `reg` (
  `uname` varchar(100) NOT NULL default '',
  `pass` varchar(100) default NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

<h3>Blood Details</h3>

CREATE TABLE `orders` (
  `bId` int(50) NOT NULL auto_increment,
  `uname` varchar(100) default NULL,
  `lname` varchar(100) default NULL,
  `bgroup` varchar(50) default NULL,
  `mno` bigint(20) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`bId`),
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1
