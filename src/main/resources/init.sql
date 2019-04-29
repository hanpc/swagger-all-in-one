CREATE TABLE `swagger_url`  (
  `id`  int(16) PRIMARY KEY	NOT NULL auto_increment COMMENT '主键' ,
  `name` varchar(100) NOT NULL COMMENT '系统名称',
  `url` varchar(300) NULL COMMENT '该系统docurl',
  `tag` varchar(100) NULL COMMENT '标签  相同标签会在一起',
  `create_time` timestamp(0) NULL COMMENT '添加时间',
  `update_time` timestamp(0) NULL COMMENT '修改时间',
  `valid` tinyint(1) NOT NULL COMMENT '是否合法'

);
insert into swagger_url (`name`,`url`,`tag`,`create_time`,`update_time`,`valid`) values
( '主页','/v2/api-docs','swagger',now(),now(),1);