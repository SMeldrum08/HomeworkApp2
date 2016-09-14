create table teacheraccount (
	id int PRIMARY KEY,
	firstName varchar(30) NOT NULL,
	lastName varchar(30) NOT NULL,
	username varchar(30) UNIQUE NOT NULL,
	password varchar(60) NOT NULL,
	schoolid int NOT NULL

);

CREATE TABLE user_roles (
  user_role_id int(11) PRIMARY KEY,
  username varchar(30) NOT NULL,
  role varchar(45) NOT NULL,
  UNIQUE KEY uni_username_role (role,username),
  FOREIGN KEY (username) REFERENCES teacheraccount (username));