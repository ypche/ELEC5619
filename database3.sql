CREATE TABLE `t_board` (
  `board_id` int(11) NOT NULL auto_increment COMMENT 'BoardID',
  `board_name` varchar(150) NOT NULL default '' COMMENT 'BoardTitle',
  `board_desc` varchar(255) default NULL COMMENT 'BoardDesc',
  `topic_num` int(11) NOT NULL default '0' COMMENT 'BoardNum',
  PRIMARY KEY  (`board_id`),
  KEY `AK_Board_NAME` (`board_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
CREATE TABLE `t_board_manager` (
  `board_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`board_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BoardManager';
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `ip` varchar(30) NOT NULL default '',
  `login_datetime` varchar(14) NOT NULL,
  PRIMARY KEY  (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_post` (
  `post_id` int(11) NOT NULL auto_increment COMMENT 'PostID',
  `board_id` int(11) NOT NULL default '0' COMMENT 'BoardID',
  `topic_id` int(11) NOT NULL default '0' COMMENT 'TopicID',
  `user_id` int(11) NOT NULL default '0' COMMENT 'PublisherID',
  `post_type` tinyint(4) NOT NULL default '2' COMMENT 'PostType 1:MainPost 2:ReplyPost',
  `post_title` varchar(50) NOT NULL COMMENT 'PostTitle',
  `post_text` text NOT NULL COMMENT 'PostContent',
  `create_time` date NOT NULL COMMENT 'CreateTime',
  PRIMARY KEY  (`post_id`),
  KEY `IDX_POST_TOPIC_ID` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='Post';
CREATE TABLE `t_topic` (
  `topic_id` int(11) NOT NULL auto_increment COMMENT 'PostID',
  `board_id` int(11) NOT NULL COMMENT 'BoardID',
  `topic_title` varchar(100) NOT NULL default '' COMMENT 'PostTitle',
  `user_id` int(11) NOT NULL default '0' COMMENT 'PublisherID',
  `create_time` date NOT NULL COMMENT 'CreateTime',
  `last_post` date NOT NULL COMMENT 'LastPost',
  `topic_views` int(11) NOT NULL default '1' COMMENT 'ViewNum',
  `topic_replies` int(11) NOT NULL default '0' COMMENT 'ReplyNum',
  `digest` int(11) NOT NULL COMMENT '0:Not digest 1:digest',
  PRIMARY KEY  (`topic_id`),
  KEY `IDX_TOPIC_USER_ID` (`user_id`),
  KEY `IDX_TOPIC_TITLE` (`topic_title`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='Topic';
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL auto_increment COMMENT 'UserId',
  `user_name` varchar(30) NOT NULL COMMENT 'User',
  `password` varchar(30) NOT NULL default '' COMMENT 'password',
  `user_type` tinyint(4) NOT NULL default '1' COMMENT '1:User 2:Admin',
  PRIMARY KEY  (`user_id`),
  KEY `AK_AK_USER_USER_NAME` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;