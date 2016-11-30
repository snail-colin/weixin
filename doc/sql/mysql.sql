/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/6/21 14:31:06                           */
/*==============================================================*/


drop index ACCOUNT_TOKEN_INDEX on ACCOUNT;

drop index ACCOUNT_USERNO_INDEX on ACCOUNT;

drop table if exists ACCOUNT;

drop index MENU_ACCOUNT_NO_INDEX on MENU;

drop table if exists MENU;

drop index USER_USERNAME_INDEX on USER;

drop table if exists USER;

/*==============================================================*/
/* Table: ACCOUNT                                               */
/*==============================================================*/
create table ACCOUNT
(
   USER_NO              varchar(50) not null comment '用户编号',
   ACCOUNT_NO           varchar(18) not null comment '编号',
   ACCOUNT              varchar(100) not null comment '微信号',
   NAME                 varchar(50) comment '名称',
   API_URL              varchar(100) comment '接口地址',
   TYPE                 tinyint not null default 0 comment '类型(0、订阅号,1、服务号)',
   TOKEN                varchar(32) comment 'token',
   APP_ID               varchar(32) comment '微信APPID',
   APP_SECRET           varchar(32) comment '微信APPSECRET',
   CREATE_DATE          varchar(14) comment '创建时间',
   UPDATE_DATE          varchar(14) comment '更新时间',
   primary key (ACCOUNT_NO)
);

alter table ACCOUNT comment '公众号';

/*==============================================================*/
/* Index: ACCOUNT_USERNO_INDEX                                  */
/*==============================================================*/
create index ACCOUNT_USERNO_INDEX on ACCOUNT
(
   USER_NO
);

/*==============================================================*/
/* Index: ACCOUNT_TOKEN_INDEX                                   */
/*==============================================================*/
create index ACCOUNT_TOKEN_INDEX on ACCOUNT
(
   TOKEN
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU
(
   ACCOUNT_NO           varchar(18) not null comment '微信编号',
   MENU_NO              varchar(18) not null comment '菜单编号',
   PARENT               varchar(18) comment '父类编号',
   NAME                 varchar(40) not null comment '菜单标题',
   TYPE                 varchar(50) not null comment '菜单的响应动作类型',
   MENU_KEY             varchar(128) comment '菜单KEY值',
   URL                  varchar(1024) comment '网页链接',
   MEDIA_ID             varchar(250) comment '素材ID',
   CREATE_DATE          varchar(14) not null comment '创建时间',
   UPDATE_DATE          varchar(14) not null comment '更新时间',
   primary key (MENU_NO)
);

alter table MENU comment '菜单';

/*==============================================================*/
/* Index: MENU_ACCOUNT_NO_INDEX                                 */
/*==============================================================*/
create index MENU_ACCOUNT_NO_INDEX on MENU
(
   ACCOUNT_NO
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USER_NO              varchar(50) not null comment '编号',
   USER_NAME            varchar(50) not null comment '账号名称',
   PASSWORD             varchar(50) not null comment '密码',
   STATUS               tinyint not null default 0 comment '状态',
   CREATE_DATE          varchar(14) not null comment '创建时间',
   UPDATE_DATE          varchar(14) not null comment '更新时间',
   primary key (USER_NO)
);

alter table USER comment '用户';

/*==============================================================*/
/* Index: USER_USERNAME_INDEX                                   */
/*==============================================================*/
create index USER_USERNAME_INDEX on USER
(
   USER_NAME
);

