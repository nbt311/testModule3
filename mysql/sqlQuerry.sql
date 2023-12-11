create database testmodule3;
use testmodule3;
create table classroom (id int primary key auto_increment, 
name varchar(255) not null);
insert into classroom (name) 
values 
("C0822I1"),
("C0922H1"),
("C1022I1");
create table students(
id int primary key auto_increment,
name varchar(255) not null,
dateOfBirth date not null,
email varchar(255) unique not null ,
address varchar(255) not null,
phone varchar(255) unique not null,
classRoomID int not null,
foreign key (classRoomId) 
references classroom(id));
insert into students(
name,
dateOfBirth,
email,
address,
phone,
classRoomId
) 
values
("Nguyen Van A","1995-01-15","nguyenvana@gmail.com","Ha Noi","0987654321",1),
("Nguyen Ba B","1995-01-15","nguyenb@gmail.com","Yen Bai","0887654321",1),
("Dao Van C","1995-01-15","daovanc@gmail.com","Bac Ninh","0987755321",2),
("Tran Van D","1995-01-15","trand@gmail.com","Lang Son","0997654320",2),
("Nguyen Tuan E","1995-01-15","nguyentuane@gmail.com","Ha Noi","0987613321",3);

 SELECT students.id,
students.name,
students.dateOfBirth, students.email, students.address,
students.phone, classroom.name from students join 
classroom on students.classRoomId = classroom.id;
select * from students;

 SELECT students.id,
students.name,
students.dateOfBirth, students.email, students.address,
students.phone,students.classRoomId ,classroom.name from students join 
classroom on students.classRoomId = classroom.id
where students.id = 3;