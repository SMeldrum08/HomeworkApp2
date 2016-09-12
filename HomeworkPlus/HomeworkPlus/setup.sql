create table teacheraccount (
	id number,
	firstName varchar2(30),
	lastName varchar2(30),
	userName varchar2(30),
	password varchar2(60),
	constraint teacheraccount_pk primary key (id),
	constraint app_teacheraccount_uk unique (userName)

)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;