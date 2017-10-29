<?php
require_once('config.ini.php');


/**
 * 数据库部分
 */
//数据库地址(localhost)
define('DBSERVER',$dbserver);
//数据库端口(3306)
define('DBSERVER_PORT',$dbserver_port);
//数据库名
define('DBNAME',$dbname);
//数据库帐号
define('DBUSER',$dbuser);
//数据库密码
define('DBPASSWD',$dbpasswd);
//数据库连接类型(mysqli/mysql)
define('DBTYPE',$dbtype);
//数据库字符集(utf8/gbk)
define('DBCHARSET',$dbcharset);


//是否ucenter为独立数据库，独立则填1，不独立则填0
define('UCDBON', $isucenterdb);
//如果ucenter为独立数据库，请填写下面信息（若非，请保持下面数据信息为空）

//ucenter数据库地址(localhost)
define('UCSERVER',$ucserver);
//ucenter数据库端口(3306)
define('UCSERVER_PORT',$ucserver_port);
//ucenter数据库名
define('UCNAME',$ucname);
//ucenter数据库帐号
define('UCUSER',$ucuser);
//ucenter数据库密码
define('UCPASSWD',$ucpasswd);
//ucenter数据库连接类型(mysqli/mysql)
define('UCTYPE',$uctype);
//ucenter数据库字符集(utf8/gbk)
define('UCCHARSET',$uccharset);



//表前缀
define('DB_PRE',$db_pre);
//ucenter表前缀
define('UC_PRE', $uc_pre);

define('UC_ROOT', dirname(__FILE__).'/../../../../../BUCSSA.net/web/uc_server/');

define('UC_DATADIR', UC_ROOT.'data/');

define('MAIL', 'a:6:{s:8:"mailsend";s:1:"2";s:4:"smtp";a:1:{i:0;a:6:{s:6:"server";s:18:"smtp.exmail.qq.com";s:4:"port";s:2:"25";s:4:"auth";s:1:"1";s:4:"from";s:17:"bucssa@bucssa.net";s:13:"auth_username";s:17:"bucssa@bucssa.net";s:13:"auth_password";s:17:"rSNbs00vkk2EOqfPs";}}s:5:"esmtp";a:1:{i:0;a:6:{s:6:"server";s:18:"smtp.exmail.qq.com";s:4:"port";s:2:"25";s:4:"auth";s:1:"1";s:4:"from";s:17:"bucssa@bucssa.net";s:13:"auth_username";s:17:"bucssa@bucssa.net";s:13:"auth_password";s:17:"rSNbs00vkk2EOqfPs";}}s:13:"maildelimiter";s:1:"0";s:12:"mailusername";s:1:"1";s:15:"sendmail_silent";s:1:"1";}');

define('TIMESTAMP', time());

define('ADMINEMAIL', 'bucssa@bucssa.net');

define('ADMIN_EMAIL','bucssa@bucssa.net');

define('ADMIN_AUTH', 'rSNbs00vkk2EOqfPs');

define('ADMIN_HOST', 'smtp.exmail.qq.com');

define('SITENAME', 'BUCSSA波士顿大学中国学生学者联合会');

define('VERSION','X3.2');

define('TIMEOFFSET', 8);







