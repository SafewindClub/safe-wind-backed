CREATE TABLE `sys_apply_form` (
                                  `id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
                                  `student_id` VARCHAR(50) UNIQUE COMMENT '学生学号',
                                  `grade` CHAR(5) NOT NULL COMMENT '年级，形如 ‘2025’ 的字符串',
                                  `speciality` VARCHAR(128) NOT NULL COMMENT '专业',
                                  `faculty` VARCHAR(64) NOT NULL COMMENT '学院',
                                  `name` VARCHAR(64) NOT NULL COMMENT '姓名',
                                  `sex` TINYINT NOT NULL COMMENT '性别，“1，男“，”0，女“',
                                  `class` VARCHAR(128) NOT NULL COMMENT '班级 ',
                                  `dept_id` BIGINT NOT NULL COMMENT '部门',
                                  `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                  `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                  `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                  PRIMARY KEY(`id`)
) COMMENT='申请表';


CREATE TABLE `sys_user` (
                            `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE COMMENT '主键',
                            `student_id` VARCHAR(255) NOT NULL UNIQUE COMMENT '登录用户名，学号',
                            `password` VARCHAR(255) COMMENT '密码',
                            `email` VARCHAR(100) UNIQUE COMMENT '邮箱',
                            `openid` VARCHAR(255) UNIQUE,
                            `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY(`id`)
) COMMENT='用户名';


CREATE TABLE `sys_user_info` (
                                 `id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
                                 `sys_user_id` BIGINT NOT NULL UNIQUE COMMENT '系统用户id',
                                 `nickname` VARCHAR(50) NOT NULL COMMENT '用户昵称',
                                 `avatar` VARCHAR(255) COMMENT '头像 ，程序层默认一张图',
                                 `grade` CHAR(5) NOT NULL COMMENT '年级，形如 ‘2025’ 的字符串',
                                 `speciality` VARCHAR(128) NOT NULL COMMENT '专业',
                                 `faculty` VARCHAR(64) NOT NULL COMMENT '学院',
                                 `name` VARCHAR(64) NOT NULL COMMENT '姓名',
                                 `sex` TINYINT NOT NULL COMMENT '性别，“1，男“，”0，女“',
                                 `class` VARCHAR(128) NOT NULL COMMENT '班级 ',
                                 `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                 `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY(`id`)
) COMMENT='成员信息表';


CREATE TABLE `sys_role` (
                            `role_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                            `role_name` VARCHAR(30) NOT NULL COMMENT '角色名称',
                            `role_key` VARCHAR(100) NOT NULL COMMENT '角色权限字符串',
                            `role_sort` INTEGER NOT NULL COMMENT '显示顺序',
                            `data_scope` CHAR(1) NOT NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
                            `menu_check_strictly` TINYINT NOT NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
                            `dept_check_strictly` TINYINT NOT NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
                            `status` CHAR(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
                            `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY(`role_id`)
) COMMENT='角色信息表';


CREATE TABLE `sys_user_role` (
                                 `user_id` BIGINT NOT NULL COMMENT '用户ID',
                                 `role_id` BIGINT NOT NULL COMMENT '角色ID',
                                 `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                 `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY(`user_id`, `role_id`)
) COMMENT='用户和角色关联表';


CREATE TABLE `sys_role_menu` (
                                 `role_id` BIGINT NOT NULL COMMENT '角色ID',
                                 `menu_id` BIGINT NOT NULL COMMENT '菜单ID',
                                 `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                 `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY(`role_id`, `menu_id`)
) COMMENT='角色和菜单关联表';


CREATE TABLE `sys_menu` (
                            `menu_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                            `menu_name` VARCHAR(50) NOT NULL COMMENT '菜单名称',
                            `parent_id` BIGINT NOT NULL DEFAULT 0 COMMENT '父菜单ID',
                            `order_num` INTEGER NOT NULL DEFAULT 0 COMMENT '显示顺序',
                            `path` VARCHAR(200) NOT NULL COMMENT '路由地址',
                            `component` VARCHAR(255) DEFAULT NULL COMMENT '组件路径',
                            `query` VARCHAR(255) DEFAULT NULL COMMENT '路由参数',
                            `route_name` VARCHAR(50) NOT NULL COMMENT '路由名称',
                            `is_frame` INTEGER NOT NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
                            `is_cache` INTEGER NOT NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
                            `menu_type` CHAR(1) NOT NULL COMMENT '菜单类型（M目录 C菜单 F按钮）',
                            `visible` CHAR(1) NOT NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
                            `status` CHAR(1) NOT NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
                            `perms` VARCHAR(100) DEFAULT NULL COMMENT '权限标识',
                            `icon` VARCHAR(100) NOT NULL DEFAULT '#' COMMENT '菜单图标',
                            `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            `remark` VARCHAR(500) NOT NULL COMMENT '备注',
                            PRIMARY KEY(`menu_id`)
) COMMENT='菜单权限表';


CREATE TABLE `sys_club` (
                            `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                            `name` VARCHAR(128),
                            `logo` VARCHAR(255) COMMENT 'logo',
                            `introduction` TEXT(65535) NOT NULL COMMENT '部门介绍',
                            `html_text` TEXT(65535) NOT NULL COMMENT '富文本存储',
                            `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY(`id`)
) COMMENT='社团表';


CREATE TABLE `sys_dept` (
                            `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE COMMENT '主键',
                            `name` VARCHAR(255) COMMENT '部门名字',
                            `content` TEXT(65535) COMMENT '部门介绍富文本',
                            `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                            `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                            `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                            `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY(`id`)
) COMMENT='部门表';


CREATE TABLE `sys_user_dept` (
                                 `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                                 `user_id` BIGINT COMMENT '用户id',
                                 `dept_id` BIGINT,
                                 `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                 `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY(`id`)
) COMMENT='用户部门映射表';


CREATE UNIQUE INDEX `sys_user_dept_index`
    ON `sys_user_dept` (`user_id`, `dept_id`);
CREATE TABLE `sys_club_dept` (
                                 `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                                 `club_id` BIGINT,
                                 `dept_id` BIGINT,
                                 `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                                 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                 `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                                 `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                                 PRIMARY KEY(`id`)
) COMMENT='社团部门映射表';


CREATE UNIQUE INDEX `sys_club_dept_index_0`
    ON `sys_club_dept` (`club_id`, `dept_id`);
CREATE TABLE `sys_review` (
                              `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                              `apply_id` BIGINT,
                              `state` INTEGER DEFAULT 0 COMMENT '0 未审核 1审核通过 2拒绝',
                              `remark` VARCHAR(255) NOT NULL COMMENT '备注',
                              `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                              `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                              `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                              `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                              `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                              PRIMARY KEY(`id`)
);


CREATE TABLE `ws_news` (
                           `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                           `title` BIGINT COMMENT '新闻标题',
                           `publish_time` DATETIME COMMENT '发布时间',
                           `content` TEXT(65535) COMMENT '新闻内容',
                           `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                           `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                           `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                           `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                           `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY(`id`)
) COMMENT='新闻';


CREATE TABLE `ws_activity` (
                               `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE,
                               `titile` VARCHAR(255) COMMENT '标题',
                               `breif` VARCHAR(255) NOT NULL COMMENT '简介',
                               `introduction` TEXT(65535) COMMENT '详情',
                               `start_time` DATETIME COMMENT '活动时间',
                               `picture` VARCHAR(255) COMMENT '视觉图',
                               `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                               `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                               `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                               `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                               `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                               PRIMARY KEY(`id`)
) COMMENT='申请表';


CREATE TABLE `ws_wall` (
                           `id` BIGINT UNSIGNED AUTO_INCREMENT UNIQUE COMMENT '主键',
                           `name` BIGINT COMMENT '名字',
                           `content` TEXT(65535) COMMENT '内容',
                           `del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                           `create_by` VARCHAR(64) NOT NULL COMMENT '创建者',
                           `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                           `update_by` VARCHAR(64) NOT NULL COMMENT '更新者',
                           `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY(`id`)
) COMMENT='海风墙';


CREATE TABLE `sys_posts` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `post_name` varchar(255) NOT NULL COMMENT '职位名称',
                             `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                             `create_by` varchar(64) NOT NULL COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) NOT NULL COMMENT '更新者',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;