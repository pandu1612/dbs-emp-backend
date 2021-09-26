DROP TABLE IF EXISTS User;
create table User (
id INT AUTO_INCREMENT  PRIMARY KEY,
  name varchar(25) not null,
  email_address varchar(25) not null,
  password varchar(100) not null,
  emp_role varchar(50) not null
);