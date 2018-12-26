create table admin
(
  id       bigint unsigned auto_increment
    primary key,
  account  varchar(20) not null comment '账号',
  password varchar(20) not null comment '密码'
);


create table attendance
(
  id               bigint unsigned auto_increment
    primary key,
  klass_seminar_id bigint unsigned     not null comment '讨论课（某班级）id',
  team_id          bigint unsigned     not null comment '队伍id',
  team_order       tinyint(4) unsigned not null comment '该队伍顺序',
  is_present       tinyint(4) unsigned not null comment '是否正在进行',
  report_name      varchar(30)         null comment '提交的报告文件名',
  report_url       varchar(50)         null comment '提交的报告文件位置',
  ppt_name         varchar(30)         null comment '提交的PPT文件名',
  ppt_url          varchar(50)         null comment '提交的PPT文件位置'
);

create index idx_klass_seminar_id
  on attendance (klass_seminar_id);

create index idx_team_id
  on attendance (team_id);

INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (1, 9, 18, 1, 1, '', null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (2, 9, 21, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (3, 9, 20, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (4, 9, 7, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (5, 9, 6, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (6, 9, 14, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (7, 10, 3, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (8, 10, 9, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (9, 10, 5, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (10, 10, 15, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (11, 10, 17, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (12, 10, 16, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (13, 11, 22, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (14, 11, 23, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (15, 11, 24, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (16, 11, 25, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (17, 11, 26, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (18, 11, 27, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (19, 12, 19, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (20, 12, 12, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (21, 12, 8, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (22, 12, 17, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (23, 12, 6, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (24, 12, 10, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (25, 13, 3, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (26, 13, 11, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (27, 14, 26, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (28, 14, 27, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (29, 14, 23, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (30, 14, 25, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (31, 14, 22, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (32, 26, 6, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (33, 26, 18, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (34, 26, 14, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (35, 26, 12, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (36, 26, 17, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (37, 26, 6, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (38, 26, 8, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (39, 27, 11, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (40, 27, 3, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (41, 27, 16, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (42, 27, 9, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (43, 27, 2, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (44, 27, 13, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (45, 28, 22, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (46, 28, 23, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (47, 28, 24, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (48, 28, 25, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (49, 28, 26, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (50, 28, 26, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (51, 29, 27, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (52, 29, 9, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (53, 29, 13, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (54, 29, 8, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (55, 29, 16, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (56, 29, 21, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (57, 30, 22, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (58, 30, 17, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (59, 30, 20, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (60, 30, 7, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (61, 30, 19, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (62, 30, 10, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (63, 21, 17, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (64, 21, 8, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (65, 21, 18, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (66, 21, 19, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (67, 21, 6, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (68, 21, 7, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (69, 22, 16, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (70, 22, 3, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (71, 22, 11, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (72, 22, 15, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (73, 23, 22, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (74, 23, 23, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (75, 23, 24, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (76, 23, 25, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (77, 23, 26, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (78, 23, 27, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (79, 24, 27, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (80, 24, 9, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (81, 24, 11, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (82, 24, 21, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (83, 24, 13, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (84, 24, 26, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (85, 25, 16, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (86, 25, 20, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (87, 25, 22, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (88, 25, 8, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (89, 25, 19, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (90, 25, 6, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (91, 31, 20, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (92, 31, 19, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (93, 31, 21, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (94, 31, 10, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (95, 32, 4, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (96, 32, 15, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (97, 32, 5, 6, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (98, 33, 22, 1, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (99, 33, 23, 2, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (100, 33, 24, 3, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (101, 33, 25, 4, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (102, 33, 26, 5, 1, null, null, null, null);
INSERT INTO standard_seminar_system.attendance (id, klass_seminar_id, team_id, team_order, is_present, report_name, report_url, ppt_name, ppt_url) VALUES (103, 33, 27, 6, 1, null, null, null, null);
create table conflict_course_strategy
(
  id          bigint unsigned auto_increment
    primary key,
  course_1_id bigint unsigned not null comment '冲突课程1',
  course_2_id bigint unsigned not null comment '冲突课程2'
);


create table course
(
  id                      bigint unsigned auto_increment
    primary key,
  teacher_id              bigint unsigned     not null comment '教师id',
  course_name             varchar(30)         not null comment '课程名称',
  introduction            varchar(500)        null comment '课程介绍',
  presentation_percentage tinyint(4) unsigned not null comment '展示分数占比',
  question_percentage     tinyint(4) unsigned not null comment '提问分数占比',
  report_percentage       tinyint(4) unsigned not null comment '报告分数占比',
  team_start_time         datetime            not null comment '开始组队时间',
  team_end_time           datetime            not null comment '截止组队时间',
  team_main_course_id     bigint unsigned     null comment '共享分组，主课程id',
  seminar_main_course_id  bigint unsigned     null comment '共享讨论课，主课程id'
);

create index idx_teacher_id
  on course (teacher_id);

INSERT INTO standard_seminar_system.course (id, teacher_id, course_name, introduction, presentation_percentage, question_percentage, report_percentage, team_start_time, team_end_time, team_main_course_id, seminar_main_course_id) VALUES (16, 3, 'OOAD', '面向对象分析与设计', 40, 30, 30, '2018-09-15 00:00:21', '2018-09-26 00:00:06', null, null);
INSERT INTO standard_seminar_system.course (id, teacher_id, course_name, introduction, presentation_percentage, question_percentage, report_percentage, team_start_time, team_end_time, team_main_course_id, seminar_main_course_id) VALUES (17, 3, 'J2EE', 'javaEE', 40, 30, 30, '2018-09-15 20:47:47', '2018-09-26 20:48:00', 16, null);
INSERT INTO standard_seminar_system.course (id, teacher_id, course_name, introduction, presentation_percentage, question_percentage, report_percentage, team_start_time, team_end_time, team_main_course_id, seminar_main_course_id) VALUES (18, 4, 'SE', '软件工程', 40, 30, 30, '2018-12-19 20:52:03', '2018-12-19 20:52:06', null, null);
INSERT INTO standard_seminar_system.course (id, teacher_id, course_name, introduction, presentation_percentage, question_percentage, report_percentage, team_start_time, team_end_time, team_main_course_id, seminar_main_course_id) VALUES (19, 5, 'SE', '软件工程', 40, 30, 30, '2018-12-19 20:54:19', '2018-12-19 20:54:21', null, null);
INSERT INTO standard_seminar_system.course (id, teacher_id, course_name, introduction, presentation_percentage, question_percentage, report_percentage, team_start_time, team_end_time, team_main_course_id, seminar_main_course_id) VALUES (20, 6, '.NET', '刀奈特', 40, 30, 30, '2018-12-19 20:55:53', '2018-12-19 20:55:56', null, null);
create table course_member_limit_strategy
(
  id         bigint unsigned auto_increment
    primary key,
  course_id  bigint unsigned     not null comment '课程id',
  min_member tinyint(4) unsigned null comment '队伍中选该课程最少人数',
  max_member tinyint(4) unsigned null comment '队伍中选该课程最多人数'
);


create table klass
(
  id             bigint unsigned auto_increment
    primary key,
  course_id      bigint unsigned     not null comment '课程id',
  grade          int unsigned        not null comment '年级',
  klass_serial   tinyint(4) unsigned not null comment '班级序号',
  klass_time     varchar(20)         not null comment '上课时间',
  klass_location varchar(20)         not null comment '上课地点'
);

create index idx_course_id
  on klass (course_id);

INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (21, 16, 2016, 1, '上午1,2节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (22, 16, 2016, 2, '上午3,4节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (23, 16, 2016, 3, '下午5,6节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (24, 17, 2016, 1, '晚上9,10节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (25, 18, 2016, 1, '上午1,2节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (26, 18, 2016, 2, '上午3,4节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (27, 19, 2016, 1, '上午3,4节', '海韵');
INSERT INTO standard_seminar_system.klass (id, course_id, grade, klass_serial, klass_time, klass_location) VALUES (28, 20, 2016, 1, '这个真的不知道', '海韵');
create table klass_round
(
  klass_id      bigint unsigned  not null comment '课程id',
  round_id      bigint unsigned  not null comment '轮次id',
  enroll_number tinyint unsigned null comment '某班级，某轮次队伍报名次数限制',
  primary key (klass_id, round_id)
);

INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 3, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 4, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 5, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 6, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 7, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (21, 8, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 3, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 4, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 5, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 6, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 7, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (22, 8, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 3, 2);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 4, 2);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 5, 2);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 6, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 7, 1);
INSERT INTO standard_seminar_system.klass_round (klass_id, round_id, enroll_number) VALUES (23, 8, 1);
create table klass_seminar
(
  id         bigint unsigned auto_increment
    primary key,
  klass_id   bigint unsigned not null comment '班级id',
  seminar_id bigint unsigned not null comment '讨论课id
',
  report_ddl datetime        null comment '报告截止时间',
  status     tinyint         not null comment '讨论课所处状态，未开始0，正在进行1，已结束2，暂停3'
);

create index idx_klass_id
  on klass_seminar (klass_id);

create index idx_seminar_id
  on klass_seminar (seminar_id);

INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (9, 21, 5, '2018-11-16 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (10, 22, 5, '2018-11-16 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (11, 23, 5, '2018-11-16 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (12, 21, 6, '2018-11-30 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (13, 22, 6, '2018-11-30 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (14, 23, 6, '2018-11-30 12:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (15, 21, 7, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (16, 22, 7, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (17, 23, 7, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (18, 21, 8, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (19, 22, 8, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (20, 23, 8, '2018-12-21 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (21, 21, 10, '2018-09-28 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (22, 22, 10, '2018-09-28 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (23, 23, 10, '2018-09-28 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (24, 24, 11, '2018-10-01 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (25, 24, 12, '2018-10-14 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (26, 21, 9, '2018-10-26 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (27, 22, 9, '2018-10-26 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (28, 23, 9, '2018-10-26 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (29, 24, 13, '2018-11-07 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (30, 24, 14, '2018-11-07 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (31, 21, 15, '2018-11-04 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (32, 22, 15, '2018-11-04 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (33, 23, 15, '2018-11-04 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (34, 21, 16, '2018-10-13 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (35, 24, 17, '2018-10-23 00:00:00', 1);
INSERT INTO standard_seminar_system.klass_seminar (id, klass_id, seminar_id, report_ddl, status) VALUES (36, 24, 18, '2018-10-30 00:00:00', 1);
create table klass_student
(
  klass_id   bigint unsigned not null comment '班级id',
  student_id bigint unsigned not null comment '学生id',
  course_id  bigint unsigned not null comment '课程id',
  team_id    bigint unsigned null comment '学生所在小组id',
  primary key (klass_id, student_id)
);

create index idx_team_id
  on klass_student (team_id);

INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 103, 16, 19);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 104, 16, 10);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 105, 16, 19);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 106, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 107, 16, 12);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 108, 16, 8);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 109, 16, 21);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 110, 16, 8);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 111, 16, 19);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 112, 16, 8);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 113, 16, 19);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 114, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 115, 16, 6);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 116, 16, 10);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 117, 16, 4);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 118, 16, 10);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 119, 16, 14);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 120, 16, 17);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 121, 16, 14);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 122, 16, 6);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 123, 16, 7);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 124, 16, 14);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 125, 16, 10);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 126, 16, 14);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 127, 16, 6);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 128, 16, 20);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 129, 16, 20);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 130, 16, 17);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 131, 16, 17);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 132, 16, 7);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 133, 16, 21);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 134, 16, 6);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 135, 16, 17);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 136, 16, 20);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 137, 16, 17);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 138, 16, 21);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 139, 16, 20);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 140, 16, 7);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 141, 16, 21);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 142, 16, 18);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 143, 16, 18);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 144, 16, 7);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 145, 16, 6);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 146, 16, 18);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 147, 16, 12);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 148, 16, 12);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 149, 16, 18);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 150, 16, 12);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 151, 16, 8);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 152, 16, 8);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 153, 16, 14);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 154, 16, 21);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 155, 16, 20);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 156, 16, 7);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (21, 157, 16, 19);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 158, 16, 3);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 159, 16, 16);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 160, 16, 3);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 161, 16, 3);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 162, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 163, 16, 13);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 164, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 165, 16, 16);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 166, 16, 5);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 167, 16, 16);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 168, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 169, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 170, 16, 4);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 171, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 172, 16, 2);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 173, 16, 13);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 174, 16, 9);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 175, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 176, 16, 16);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 177, 16, 16);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 178, 16, 13);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 179, 16, 5);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 180, 16, 9);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 181, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 182, 16, 15);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 183, 16, 5);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 184, 16, 5);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 185, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 186, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 187, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 188, 16, 11);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 189, 16, 13);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 190, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 191, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 192, 16, 4);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 193, 16, 4);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 194, 16, 2);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 195, 16, 9);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 196, 16, 2);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 197, 16, 2);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 198, 16, 2);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 199, 16, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 200, 16, 4);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 201, 16, 5);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (22, 202, 16, 3);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 203, 16, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 204, 16, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 205, 16, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 206, 16, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 207, 16, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 208, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 209, 16, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 210, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 211, 16, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 212, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 213, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 214, 16, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 215, 16, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 216, 16, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 217, 16, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 218, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 219, 16, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 220, 16, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 221, 16, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 222, 16, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 223, 16, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 224, 16, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 225, 16, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 226, 16, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 227, 16, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 228, 16, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 229, 16, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 230, 16, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (23, 231, 16, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 103, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 104, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 105, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 107, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 108, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 109, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 110, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 111, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 113, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 115, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 116, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 117, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 118, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 119, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 120, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 121, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 123, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 124, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 125, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 128, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 129, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 130, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 132, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 133, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 134, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 135, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 136, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 139, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 140, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 141, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 142, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 143, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 144, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 145, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 146, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 147, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 148, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 149, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 150, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 151, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 152, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 154, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 155, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 156, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 157, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 158, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 160, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 161, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 163, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 164, 17, 15);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 165, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 167, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 168, 17, 11);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 169, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 173, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 174, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 175, 17, 13);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 177, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 178, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 180, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 181, 17, 11);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 182, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 184, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 186, 17, 15);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 187, 17, 9);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 188, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 189, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 190, 17, 11);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 191, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 192, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 193, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 195, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 196, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 197, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 198, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 200, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 202, 17, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 203, 17, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 204, 17, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 205, 17, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 206, 17, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 207, 17, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 208, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 209, 17, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 210, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 211, 17, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 212, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 213, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 215, 17, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 217, 17, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 218, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 219, 17, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 220, 17, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 222, 17, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 223, 17, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 224, 17, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 225, 17, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 226, 17, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 227, 17, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 228, 17, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 229, 17, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 230, 17, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (24, 231, 17, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 103, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 105, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 107, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 108, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 109, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 110, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 111, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 112, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 113, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 119, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 121, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 128, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 129, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 132, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 133, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 134, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 136, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 138, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 139, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 140, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 141, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 144, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 147, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 148, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 150, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 151, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 152, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 154, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 155, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 156, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 157, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 158, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 159, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 160, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 161, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 164, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 165, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 166, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 167, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 170, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 171, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 174, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 176, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 177, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 180, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 181, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 182, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 183, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 185, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 186, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 187, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 188, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 190, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 191, 18, 15);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 192, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 193, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 195, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 199, 18, 9);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 201, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (25, 202, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 104, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 114, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 115, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 116, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 117, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 118, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 120, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 122, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 123, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 124, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 125, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 126, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 127, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 130, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 131, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 135, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 137, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 142, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 143, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 145, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 146, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 149, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 153, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 163, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 168, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 169, 18, 11);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 172, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 173, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 175, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 178, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 179, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 184, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 189, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 194, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 196, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 197, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 198, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (26, 200, 18, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 203, 19, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 204, 19, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 205, 19, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 206, 19, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 207, 19, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 208, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 209, 19, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 210, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 211, 19, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 212, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 213, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 214, 19, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 215, 19, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 216, 19, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 217, 19, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 218, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 219, 19, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 220, 19, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 221, 19, 24);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 222, 19, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 223, 19, 22);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 224, 19, 25);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 225, 19, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 226, 19, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 227, 19, 23);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 228, 19, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 229, 19, 27);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 230, 19, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (27, 231, 19, 26);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 166, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 171, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 179, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 183, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 185, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 201, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 214, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 216, 20, 0);
INSERT INTO standard_seminar_system.klass_student (klass_id, student_id, course_id, team_id) VALUES (28, 221, 20, 0);
create table member_limit_strategy
(
  id         bigint unsigned auto_increment
    primary key,
  min_member tinyint(4) unsigned null comment '最少人数',
  max_member tinyint(4) unsigned null comment '最多人数'
);


create table question
(
  id               bigint unsigned auto_increment
    primary key,
  klass_seminar_id bigint unsigned     not null,
  attendance_id    bigint unsigned     not null comment '问题所针对的发言id',
  team_id          bigint unsigned     not null comment '提问小组的id',
  student_id       bigint unsigned     not null comment '提问学生的id',
  is_selected      tinyint(4) unsigned not null comment '是否被选中',
  score            decimal(4, 1)       null comment '提问分数'
);

create index idx_attendance_id
  on question (attendance_id);

create index idx_klass_seminar_id
  on question (klass_seminar_id);

create index idx_student_id
  on question (student_id);

create index idx_team_id
  on question (team_id);

INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (1, 26, 33, 6, 122, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (2, 26, 33, 7, 156, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (3, 26, 34, 7, 156, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (4, 26, 33, 8, 108, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (5, 26, 34, 8, 108, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (6, 26, 33, 17, 135, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (7, 26, 33, 18, 142, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (8, 26, 33, 19, 113, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (9, 26, 33, 21, 141, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (10, 26, 33, 10, 116, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (11, 26, 33, 12, 150, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (12, 26, 33, 14, 126, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (13, 26, 34, 14, 126, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (14, 27, 39, 16, 176, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (15, 27, 40, 16, 176, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (16, 27, 41, 16, 176, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (17, 27, 39, 9, 187, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (18, 27, 40, 9, 187, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (19, 27, 39, 11, 190, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (20, 27, 40, 11, 190, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (21, 27, 41, 11, 190, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (22, 27, 39, 2, 197, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (23, 27, 39, 3, 160, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (24, 27, 40, 3, 160, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (25, 27, 39, 5, 183, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (26, 27, 40, 5, 183, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (27, 27, 41, 5, 183, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (28, 28, 45, 22, 211, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (29, 28, 45, 23, 207, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (30, 28, 46, 23, 207, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (31, 28, 45, 24, 221, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (32, 28, 46, 24, 221, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (33, 28, 47, 25, 208, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (34, 28, 48, 25, 208, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (35, 28, 49, 26, 206, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (36, 28, 46, 27, 205, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (37, 21, 63, 6, 122, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (38, 21, 64, 6, 145, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (39, 21, 64, 7, 156, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (40, 21, 63, 8, 112, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (41, 21, 65, 8, 108, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (42, 21, 66, 8, 110, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (43, 21, 65, 20, 129, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (44, 21, 67, 20, 129, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (45, 21, 67, 17, 135, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (46, 21, 68, 18, 142, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (47, 21, 68, 19, 113, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (48, 21, 64, 21, 141, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (49, 21, 66, 21, 141, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (50, 21, 68, 21, 141, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (51, 21, 63, 14, 126, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (52, 21, 64, 14, 126, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (53, 21, 66, 14, 126, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (54, 22, 69, 16, 176, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (55, 22, 70, 9, 108, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (56, 22, 71, 11, 190, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (57, 22, 70, 2, 197, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (58, 22, 70, 3, 160, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (59, 22, 72, 3, 160, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (60, 23, 73, 22, 211, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (61, 23, 73, 23, 207, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (62, 23, 75, 23, 207, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (63, 23, 77, 23, 207, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (64, 23, 78, 24, 221, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (65, 23, 74, 25, 208, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (66, 23, 75, 25, 208, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (67, 23, 77, 25, 208, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (68, 23, 78, 26, 206, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (69, 23, 76, 27, 205, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (70, 31, 91, 8, 108, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (71, 31, 91, 20, 128, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (72, 31, 91, 17, 120, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (73, 31, 91, 19, 113, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (74, 31, 91, 21, 133, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (75, 31, 91, 10, 118, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (76, 31, 92, 17, 120, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (77, 32, 95, 16, 159, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (78, 32, 95, 11, 188, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (79, 32, 95, 13, 178, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (80, 32, 95, 3, 202, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (81, 32, 96, 4, 192, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (82, 33, 98, 22, 209, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (83, 33, 99, 23, 207, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (84, 33, 98, 24, 214, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (85, 33, 98, 25, 212, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (86, 33, 98, 26, 206, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (87, 33, 98, 27, 203, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (88, 9, 1, 6, 122, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (89, 9, 1, 17, 135, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (90, 9, 2, 17, 135, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (91, 9, 1, 18, 142, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (92, 9, 2, 18, 142, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (93, 9, 1, 19, 113, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (94, 9, 1, 21, 141, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (95, 9, 1, 10, 116, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (96, 9, 1, 14, 126, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (97, 10, 7, 16, 176, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (98, 10, 7, 9, 187, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (99, 10, 7, 2, 197, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (100, 10, 7, 3, 160, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (101, 11, 13, 22, 211, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (102, 11, 14, 22, 211, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (103, 11, 13, 23, 207, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (104, 11, 13, 24, 221, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (105, 11, 13, 25, 208, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (106, 11, 13, 26, 206, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (107, 11, 13, 27, 205, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (108, 12, 19, 6, 122, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (109, 12, 19, 8, 108, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (110, 12, 19, 17, 135, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (111, 12, 20, 17, 135, 1, 5.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (112, 12, 21, 17, 135, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (113, 12, 19, 21, 141, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (114, 12, 19, 12, 150, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (115, 12, 20, 12, 150, 1, 3.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (116, 14, 27, 22, 211, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (117, 14, 27, 23, 207, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (118, 14, 27, 25, 208, 1, 4.0);
INSERT INTO standard_seminar_system.question (id, klass_seminar_id, attendance_id, team_id, student_id, is_selected, score) VALUES (119, 14, 27, 26, 206, 1, 4.0);
create table round
(
  id                        bigint unsigned auto_increment
    primary key,
  course_id                 bigint unsigned     not null comment '课程id',
  round_serial              tinyint(4) unsigned not null comment '轮次序号',
  presentation_score_method tinyint(4) unsigned not null comment '本轮展示分数计算方法',
  report_score_method       tinyint(4) unsigned not null comment '本轮报告分数计算方法',
  question_score_method     tinyint(4) unsigned not null comment '本轮提问分数计算方法'
);

create index idx_course_id
  on round (course_id);

INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (3, 16, 1, 0, 0, 0);
INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (4, 16, 2, 0, 0, 0);
INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (5, 16, 3, 0, 0, 0);
INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (6, 16, 4, 0, 0, 0);
INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (7, 17, 1, 0, 0, 0);
INSERT INTO standard_seminar_system.round (id, course_id, round_serial, presentation_score_method, report_score_method, question_score_method) VALUES (8, 17, 2, 0, 0, 0);
create table round_score
(
  round_id           bigint unsigned not null comment '轮次id',
  team_id            bigint unsigned not null comment '小组id',
  total_score        decimal(4, 1)   null comment '总成绩',
  presentation_score decimal(4, 1)   null comment '展示成绩',
  question_score     decimal(4, 1)   null comment '提问成绩',
  report_score       decimal(4, 1)   null comment '报告成绩',
  primary key (round_id, team_id)
);

INSERT INTO standard_seminar_system.round_score (round_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (3, 6, 4.7, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.round_score (round_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (3, 7, 4.1, 5.0, 4.0, 3.0);
INSERT INTO standard_seminar_system.round_score (round_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (3, 8, 3.6, 3.0, 5.0, 3.0);
create table seminar
(
  id                bigint unsigned auto_increment
    primary key,
  course_id         bigint unsigned     not null comment '课程id',
  round_id          bigint unsigned     not null comment '轮次id',
  seminar_name      varchar(30)         not null comment '讨论课名称',
  introduction      varchar(500)        null comment '讨论课介绍',
  max_team          tinyint(4) unsigned not null comment '报名讨论课最多组数',
  is_visible        tinyint(4) unsigned not null comment '是否可见',
  seminar_serial    tinyint(4) unsigned not null comment '讨论课序号',
  enroll_start_time datetime            null comment '讨论课报名开始时间',
  enroll_end_time   datetime            null comment '讨论课报名截止时间'
);

create index idx_course_id
  on seminar (course_id);

create index idx_round_id
  on seminar (round_id);

INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (5, 16, 5, '对象模型设计', '对象模型设计

所有小组请课前提前准备，课堂讨论每个小组15分钟

课后提交书面报告，书面报告应该是一份完整对象模型和关系模型的设计说明书。课后以作业方式提交设计报告，文件以组号命名， PDF格式', 7, 1, 5, '2018-09-01 21:40:14', '2018-11-16 12:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (6, 16, 5, 'Controller层API设计', 'Controller的api的详细设计

所有小组请课前提前准备，课堂讨论每个小组15分钟

课后提交书面报告，书面报告应该是一份完整API设计说明书。课后以作业方式提交设计报告，文件以组号命名， PDF格式，可以提交在线链接

本次讨论课供报名竞选Controller层标准组的小组报名，每个小组只能竞选一个标准组名额。

不想竞选的小组请报名第五次讨论课', 6, 1, 6, '2018-09-01 21:41:36', '2018-11-30 12:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (7, 16, 6, '讨论课七', '系统Controller层、Service层、DAO层和Entity的详细设计，包括Package的设计，类图，Sequence Diagram（能体现设计的部分），Deployment Diagram', 6, 1, 7, '2018-09-01 08:58:35', '2018-12-21 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (8, 16, 6, '详细设计', '系统Controller层、Service层、DAO层和Entity的详细设计，包括Package的设计，类图，Sequence Diagram（能体现设计的部分），Deployment Diagram', 6, 1, 8, '2018-09-01 08:58:35', '2018-12-21 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (9, 16, 4, '界面设计', '界面导航图和所有界面原型设计

所有小组请课前提前准备，课堂讨论每个小组15分钟

课后提交书面报告，书面报告应该是一份完整界面设计说明书。课后以作业方式提交设计报告，文件以组号命名， PDF格式', 6, 1, 3, '2018-09-15 11:35:00', '2018-10-11 11:35:16');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (10, 16, 3, '用例分析', '题目为课堂管理系统的用例分析，包括分辨Actors、Use Cases划分和撰写用例。课后发言小组提交书面报告，书面报告应该是一份完整的用例设计。课后以作业方式提交设计报告，文件以组号命名，PDF格式', 6, 1, 1, '2018-09-01 11:49:42', '2018-09-27 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (11, 17, 7, 'JavaEE与其他脚本平台比较', '本次讨论课一共可容纳5个小组，每个小组15分钟，其中10分钟陈述，5分钟讨论 报名参加讨论课一的小组请按照以下格式撰写标题： 序号：小组编号， 如1-1组想在第4个发言，则发帖标题为4:1-1 PPT请以回复方式发在自己的帖子后面', 5, 1, 1, '2018-09-01 11:56:52', '2018-09-30 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (12, 17, 7, 'POJO和依赖注入对于系统设计和测试的意义', '请按照以下格式撰写标题： 序号：小组编号， 如1-1组想在第4个发言，则发帖标题为4:1-1 PPT请以回复方式发在自己的帖子后面', 6, 1, 2, '2018-09-01 11:58:57', '2018-10-13 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (13, 17, 8, '比较FreeMarker与其他的视图层技术', '比较FreeMarker与其他的视图层技术。

本次讨论课一共可容纳6个小组，

每个小组15分钟，其中10分钟陈述，5分钟讨论

请按照以下格式撰写标题： 序号：小组编号， 如1-1组想在第4个发言，则发帖标题为4:1-1 PPT请以回复方式发在自己的帖子后面

成绩50%课堂发言，30%书面报告，20%课堂提问', 6, 1, 5, '2018-11-01 12:22:37', '2018-11-16 12:22:42');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (14, 17, 8, 'Mybatis', '共6组报名。每个小组15分钟，其中10分钟陈述，5分钟讨论

请按照以下格式撰写标题： 序号：小组编号， 如1-1组想在第4个发言，则发帖标题为4:1-1 PPT请以回复方式发在自己的帖子后面

成绩50%课堂发言，30%书面报告，20%课堂提问', 6, 1, 6, '2018-11-10 12:26:11', '2018-11-16 12:26:27');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (15, 16, 4, '领域模型', '讨论课内容为领域模型分析，包括领域模型的Package Diagrams。所有小组请课前提前准备，课堂讨论每个小组15分钟。课后提交书面报告，书面报告应该是一份完整领域模型设计。课后以作业方式提交设计报告，文件以组号命名， PDF格式。', 6, 1, 4, '2018-09-01 00:00:00', '2018-11-02 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (16, 16, 3, '业务流程分析', '每个小组需要以讨论课1中的一个小组的用例设计为基础来设计业务流程。', 6, 1, 2, '2018-09-01 00:35:29', '2018-10-13 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (17, 17, 7, 'SpringBoot综述
和Maven综述', 'SpringBoot综述
和Maven综述', 6, 1, 1, '2018-09-01 01:16:20', '2018-10-18 00:00:00');
INSERT INTO standard_seminar_system.seminar (id, course_id, round_id, seminar_name, introduction, max_team, is_visible, seminar_serial, enroll_start_time, enroll_end_time) VALUES (18, 17, 7, '在JavaEE中的MVC体系结构', '重点讨论MVC架构，各层的作用以及在JavaEE中的技术实现', 6, 1, 1, '2018-09-01 01:16:31', '2018-11-01 00:00:00');
create table seminar_score
(
  klass_seminar_id   bigint unsigned not null comment '班级讨论课id',
  team_id            bigint unsigned not null comment '小组id',
  total_score        decimal(4, 1)   null comment '总成绩',
  presentation_score decimal(4, 1)   null comment '展示成绩',
  question_score     decimal(4, 1)   null comment '提问成绩',
  report_score       decimal(4, 1)   null comment '报告成绩',
  primary key (klass_seminar_id, team_id)
);

INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 6, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 7, null, 4.0, 0.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 8, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 10, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 12, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 14, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 17, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 18, null, 4.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 19, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 20, null, 4.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (9, 21, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 2, null, 5.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 3, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 4, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 5, null, 4.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 9, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 11, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 13, null, 4.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 15, null, 4.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (10, 16, null, 4.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 22, null, 5.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 23, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 24, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 25, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 26, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (11, 27, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 6, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 7, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 8, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 10, null, 4.0, 0.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 12, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 14, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 17, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 18, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 19, null, 4.0, 0.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 20, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (12, 21, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 2, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 3, null, 5.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 4, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 5, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 9, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 11, null, 4.5, 0.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 13, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 15, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (13, 16, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 22, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 23, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 24, null, 3.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 25, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 26, null, 5.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (14, 27, null, 4.5, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 22, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 23, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 24, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 25, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 26, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (17, 27, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 22, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 23, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 24, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 25, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 26, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (20, 27, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 6, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 7, null, 5.0, 4.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 8, null, 3.0, 5.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 10, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 12, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 14, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 17, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 18, null, 3.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 19, null, 2.0, 5.0, 0.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 20, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (21, 21, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 2, null, null, 3.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 3, null, 5.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 4, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 5, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 9, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 11, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 13, null, null, 0.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 15, null, 0.0, 0.0, 0.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (22, 16, null, 4.0, 3.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 22, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 23, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 24, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 25, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 26, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (23, 27, null, 5.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 6, null, 5.0, 4.0, 3.5);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 7, null, 5.0, 5.0, 3.5);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 8, null, 4.0, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 10, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 12, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 14, null, 5.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 17, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 18, null, 5.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 19, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 20, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (26, 21, null, null, 4.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 2, null, 3.0, 4.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 3, null, 3.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 4, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 5, null, null, 5.0, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 9, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 11, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 13, null, 4.0, null, 3.5);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 15, null, null, null, null);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (27, 16, null, 5.0, 4.0, 3.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 22, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 23, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 24, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 25, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 26, null, 5.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (28, 27, null, 4.0, 4.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (31, 10, null, 5.0, 3.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (31, 19, null, 4.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (31, 20, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (31, 21, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (32, 4, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (32, 5, null, 4.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (32, 15, null, 5.0, 0.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 22, null, 4.0, 5.0, 5.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 23, null, 5.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 24, null, 4.0, 4.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 25, null, 4.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 26, null, 4.0, 5.0, 4.0);
INSERT INTO standard_seminar_system.seminar_score (klass_seminar_id, team_id, total_score, presentation_score, question_score, report_score) VALUES (33, 27, null, 5.0, 4.0, 5.0);
create table share_seminar_application
(
  id                    bigint unsigned auto_increment
    primary key,
  main_course_id        bigint unsigned     not null comment '主课程id',
  sub_course_id         bigint unsigned     not null comment '从课程id',
  sub_course_teacher_id bigint unsigned     not null comment '从课程的教师id',
  status                tinyint(4) unsigned null comment '请求状态，同意1、不同意0、未处理null'
);

create index idx_main_course_id
  on share_seminar_application (main_course_id);

create index idx_sub_course_id
  on share_seminar_application (sub_course_id);

create index idx_sub_course_teacher_id
  on share_seminar_application (sub_course_teacher_id);


create table share_team_application
(
  id                    bigint unsigned auto_increment
    primary key,
  main_course_id        bigint unsigned     not null comment '主课程id',
  sub_course_id         bigint unsigned     not null comment '从课程id',
  sub_course_teacher_id bigint unsigned     not null comment '从课程老师id',
  status                tinyint(4) unsigned null comment '请求状态，同意1、不同意0、未处理null'
);

create index idx_main_course_id
  on share_team_application (main_course_id);

create index idx_sub_course_id
  on share_team_application (sub_course_id);

create index idx_sub_course_teacher_id
  on share_team_application (sub_course_teacher_id);


create table student
(
  id           bigint unsigned auto_increment
    primary key,
  account      varchar(20)         not null comment '学生账户',
  password     varchar(20)         not null comment '账户密码',
  is_active    tinyint(4) unsigned not null comment '账号是否激活',
  student_name varchar(10)         not null comment '学生姓名',
  email        varchar(30)         null comment '邮箱地址',
  constraint uk_account
    unique (account),
  constraint uk_email
    unique (email)
);

create index idx_password
  on student (password);

INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (103, '10120162202618', '123456', 0, '陈姗', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (104, '20420162201582', '123456', 0, '叶西蒙', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (105, '20420162201666', '123456', 0, '林庚', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (106, '21620142202651', '123456', 0, '吕剑坡', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (107, '21620152203084', '123456', 0, '郑承波', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (108, '24320162202805', '123456', 0, '蔡岳东', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (109, '24320162202821', '123456', 0, '邓绪麟', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (110, '24320162202830', '123456', 0, '高继威', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (111, '24320162202834', '123456', 0, '韩蕾', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (112, '24320162202836', '123456', 0, '侯世康', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (113, '24320162202839', '123456', 0, '黄译嶙', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (114, '24320162202842', '123456', 0, '黄云峰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (115, '24320162202847', '123456', 0, '蒋耀', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (116, '24320162202852', '123456', 0, '柯信玉', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (117, '24320162202854', '123456', 0, '赖建群', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (118, '24320162202860', '123456', 0, '李岩松', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (119, '24320162202862', '123456', 0, '李元慧', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (120, '24320162202863', '123456', 0, '梁佳音', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (121, '24320162202869', '123456', 0, '林俊强', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (122, '24320162202873', '123456', 0, '林晓明', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (123, '24320162202874', '123456', 0, '林泽煌', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (124, '24320162202875', '123456', 0, '刘晶', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (125, '24320162202883', '123456', 0, '罗雅馨', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (126, '24320162202885', '123456', 0, '马子晋', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (127, '24320162202888', '123456', 0, '牛晓彤', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (128, '24320162202889', '123456', 0, '彭淑媛', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (129, '24320162202893', '123456', 0, '邱学良', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (130, '24320162202894', '123456', 0, '任剑鹏', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (131, '24320162202895', '123456', 0, '任天翔', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (132, '24320162202897', '123456', 0, '邵子薇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (133, '24320162202902', '123456', 0, '孙承昱', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (134, '24320162202904', '123456', 0, '谈雪', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (135, '24320162202906', '123456', 0, '谭源杰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (136, '24320162202912', '123456', 0, '王泓泓', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (137, '24320162202917', '123456', 0, '王圣哲', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (138, '24320162202919', '123456', 0, '王玮权', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (139, '24320162202921', '123456', 0, '王旭佳', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (140, '24320162202924', '123456', 0, '魏畅', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (141, '24320162202925', '123456', 0, '吴悠', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (142, '24320162202928', '123456', 0, '谢停停', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (143, '24320162202929', '123456', 0, '谢芸芸', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (144, '24320162202930', '123456', 0, '谢作源', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (145, '24320162202934', '123456', 0, '徐刚', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (146, '24320162202935', '123456', 0, '徐灵', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (147, '24320162202943', '123456', 0, '杨雨涵', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (148, '24320162202949', '123456', 0, '于梦恺', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (149, '24320162202952', '123456', 0, '袁梓倍', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (150, '24320162202953', '123456', 0, '张砾夫', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (151, '24320162202961', '123456', 0, '赵明初', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (152, '24320162202965', '123456', 0, '郑鑫鑫', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (153, '24320162202966', '123456', 0, '郑英林', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (154, '24320162202967', '123456', 0, '钟子帆', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (155, '24320162202969', '123456', 0, '周雨欣', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (156, '24320162202970', '123456', 0, '朱演演', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (157, '30320162200068', '123456', 0, '吴苏悦', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (158, '19720162203635', '123456', 0, '吴为', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (159, '20420162201736', '123456', 0, '游鹏超', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (160, '21620162203180', '123456', 0, '周必群', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (161, '22320162201119', '123456', 0, '余炬波', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (162, '24320152202847', '123456', 0, '俞剑桥', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (163, '24320162202804', '123456', 0, '蔡咏锜', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (164, '24320162202807', '123456', 0, '陈浩', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (165, '24320162202808', '123456', 0, '陈焕璋', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (166, '24320162202809', '123456', 0, '陈辉宇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (167, '24320162202815', '123456', 0, '陈昱甫', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (168, '24320162202817', '123456', 0, '陈梓豪', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (169, '24320162202820', '123456', 0, '邓文晋', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (170, '24320162202823', '123456', 0, '杜旭焘', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (171, '24320162202829', '123456', 0, '傅嘉锐', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (172, '24320162202832', '123456', 0, '龚凌', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (173, '24320162202833', '123456', 0, '郭方杰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (174, '24320162202835', '123456', 0, '洪启武', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (175, '24320162202837', '123456', 0, '黄鸿宇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (176, '24320162202838', '123456', 0, '黄巍', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (177, '24320162202841', '123456', 0, '黄裕文', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (178, '24320162202844', '123456', 0, '黄振闽', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (179, '24320162202853', '123456', 0, '匡镓玮', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (180, '24320162202855', '123456', 0, '赖少鹏', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (181, '24320162202858', '123456', 0, '李伟泽', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (182, '24320162202859', '123456', 0, '李欣然', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (183, '24320162202871', '123456', 0, '林南瑞', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (184, '24320162202880', '123456', 0, '陆婧昭', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (185, '24320162202891', '123456', 0, '邱恒哲', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (186, '24320162202896', '123456', 0, '尚莹超', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (187, '24320162202900', '123456', 0, '宋灵冰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (188, '24320162202901', '123456', 0, '苏天宇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (189, '24320162202909', '123456', 0, '陶玉娇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (190, '24320162202918', '123456', 0, '王世奇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (191, '24320162202927', '123456', 0, '谢河富', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (192, '24320162202932', '123456', 0, '熊安书', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (193, '24320162202936', '123456', 0, '徐政强', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (194, '24320162202939', '123456', 0, '闫远峰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (195, '24320162202940', '123456', 0, '严学焕', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (196, '24320162202947', '123456', 0, '叶育杰', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (197, '24320162202950', '123456', 0, '喻枭', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (198, '24320162202951', '123456', 0, '袁江华', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (199, '24320162202956', '123456', 0, '张天一', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (200, '24320162202958', '123456', 0, '张炜伦', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (201, '24320162202959', '123456', 0, '张志文', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (202, '25120152201958', '123456', 0, '张敬峥', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (203, '20420162201516', '123456', 0, '陈华董', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (204, '21620152202972', '123456', 0, '刘悦然', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (205, '21620152203004', '123456', 0, '苏灵奇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (206, '22320162201037', '123456', 0, '胡泽勇', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (207, '24320162202814', '123456', 0, '陈序辉', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (208, '24320162202818', '123456', 0, '程日', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (209, '24320162202825', '123456', 0, '方波', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (210, '24320162202826', '123456', 0, '方俊', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (211, '24320162202831', '123456', 0, '高庭闲', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (212, '24320162202845', '123456', 0, '蒋辉', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (213, '24320162202848', '123456', 0, '矫丽瑶', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (214, '24320162202864', '123456', 0, '梁思博', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (215, '24320162202877', '123456', 0, '刘予佳', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (216, '24320162202908', '123456', 0, '陶晨晨', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (217, '24320162202911', '123456', 0, '王安特', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (218, '24320162202916', '123456', 0, '王凯', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (219, '24320162202920', '123456', 0, '王文强', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (220, '24320162202931', '123456', 0, '辛春蕾', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (221, '24320162202937', '123456', 0, '许霏', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (222, '24320162202945', '123456', 0, '叶存英', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (223, '24320162202962', '123456', 0, '赵涛', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (224, '24320162202963', '123456', 0, '赵雨宣', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (225, '24320162202971', '123456', 0, '朱聿莹', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (226, '25120152201910', '123456', 0, '梁依帆', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (227, '25120152201938', '123456', 0, '王振伟', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (228, '30220162200810', '123456', 0, '宋文静', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (229, '32420162202603', '123456', 0, '周健', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (230, '33920152203997', '123456', 0, '刘畅', null);
INSERT INTO standard_seminar_system.student (id, account, password, is_active, student_name, email) VALUES (231, '34520162201351', '123456', 0, '石新羽', null);
create table teacher
(
  id           bigint unsigned auto_increment
    primary key,
  account      varchar(20)         not null comment '教师账户',
  password     varchar(20)         not null comment '账户密码',
  teacher_name varchar(10)         not null comment '教师姓名',
  is_active    tinyint(4) unsigned not null comment '账号是否激活',
  email        varchar(30)         not null comment '邮箱地址',
  constraint uk_account
    unique (account),
  constraint uk_email
    unique (email)
);

create index idx_password
  on teacher (password);

INSERT INTO standard_seminar_system.teacher (id, account, password, teacher_name, is_active, email) VALUES (3, 'qm', '123', '邱明', 1, 'qiu@xmu.edu.cn');
INSERT INTO standard_seminar_system.teacher (id, account, password, teacher_name, is_active, email) VALUES (4, 'wmh', '123', '王美红', 1, 'wang@xmu.edu.cn');
INSERT INTO standard_seminar_system.teacher (id, account, password, teacher_name, is_active, email) VALUES (5, 'lkh', '123', '林坤辉', 1, 'lin@xmu.edu.cn');
INSERT INTO standard_seminar_system.teacher (id, account, password, teacher_name, is_active, email) VALUES (6, 'ylq', '123', '杨律青', 1, 'yang@xmu.edu.cn');
create table team
(
  id          bigint unsigned auto_increment
    primary key,
  klass_id    bigint unsigned     not null comment '班级序号',
  course_id   bigint unsigned     not null comment '课程序号',
  leader_id   bigint unsigned     not null comment '队长的学生id',
  team_name   varchar(30)         not null comment '队伍名称',
  team_serial tinyint(4) unsigned not null comment '队伍序号',
  status      tinyint(4) unsigned not null comment '队伍状态，不合法0、合法1、审核中2'
);

create index idx_course_id
  on team (course_id);

create index idx_klass_id
  on team (klass_id);

create index idx_leader_id
  on team (leader_id);

INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (2, 22, 16, 197, '*', 6, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (3, 22, 16, 160, 'WEAK', 7, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (4, 22, 16, 192, 'j2ee', 8, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (5, 22, 16, 183, 'dotnet TIF小组', 9, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (6, 21, 16, 122, 'Intellij', 2, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (7, 21, 16, 156, 'FLAG', 3, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (8, 21, 16, 108, 'Knight', 4, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (9, 22, 16, 187, '锦鲤', 2, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (10, 21, 16, 116, 'OJ', 10, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (11, 22, 16, 190, 'RBs', 3, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (12, 21, 16, 150, 'Beefcake', 11, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (13, 22, 16, 163, 'GHCT', 4, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (14, 21, 16, 126, 'Flyway', 12, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (15, 22, 16, 182, '*', 5, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (16, 22, 16, 176, '2018秋季智能教室JS爱好者小组', 1, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (17, 21, 16, 135, '咕咕鸟', 6, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (18, 21, 16, 142, ' ', 7, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (19, 21, 16, 113, '正经人', 8, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (20, 21, 16, 129, '超励志小组', 5, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (21, 21, 16, 141, '晚晚鸟', 9, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (22, 23, 16, 211, '*', 1, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (23, 23, 16, 207, '*', 2, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (24, 23, 16, 221, '*', 3, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (25, 23, 16, 208, '*', 4, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (26, 23, 16, 206, '*', 5, 1);
INSERT INTO standard_seminar_system.team (id, klass_id, course_id, leader_id, team_name, team_serial, status) VALUES (27, 23, 16, 205, '*', 6, 1);
create table team_and_strategy
(
  id              bigint unsigned auto_increment
    primary key,
  strategy_1_name varchar(50)     not null comment '“与”组队策略1实现类名称',
  strategy_1_id   bigint unsigned not null comment '“与”组队策略1_id',
  strategy_2_name varchar(50)     not null comment '“与”组队策略2实现类名称',
  strategy_2_id   bigint unsigned not null comment '“与”组队策略2_id'
);


create table team_or_strategy
(
  id              bigint unsigned auto_increment
    primary key,
  strategy_1_name varchar(50)     not null comment '“或”组队策略1实现类名称',
  strategy_1_id   bigint unsigned not null comment '“或”组队策略1_id',
  strategy_2_name varchar(50)     not null comment '“或”组队策略2实现类名称',
  strategy_2_id   bigint unsigned not null comment '“或”组队策略2_id'
);


create table team_strategy
(
  course_id     bigint unsigned auto_increment comment '课程id',
  strategy_id   bigint unsigned not null comment '策略id',
  strategy_name varchar(50)     not null comment '组队策略实现类名称',
  primary key (course_id, strategy_id, strategy_name)
);


create table team_valid_application
(
  id         bigint unsigned auto_increment
    primary key,
  team_id    bigint unsigned     not null comment '小组id',
  teacher_id bigint unsigned     not null comment '教师id',
  reason     varchar(500)        null comment '申请理由',
  status     tinyint(4) unsigned null comment '请求状态，同意1、不同意0、未处理null'
);

create index idx_teacher_id
  on team_valid_application (teacher_id);

create index idx_team_id
  on team_valid_application (team_id);

