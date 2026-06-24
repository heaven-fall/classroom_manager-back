create table users(
  id int primary key auto_increment,
  username varchar(50) not null unique,
  password varchar(255) not null,
  real_name varchar(100),
  phone varchar(20),
  role tinyint default 0 comment '0学生,1老师,2,管理员',
  state tinyint default 0 comment '0正常1锁定2禁用'
);