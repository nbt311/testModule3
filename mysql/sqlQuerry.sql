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

 SELECT s.id, 
 s.name,
s.dateOfBirth, s.email, s.address,
s.phone,s.classRoomId ,c.name from students s join 
classroom c on s.classRoomId = c.id
where s.id = 3;

SELECT s.id, s.name, s.dateOfBirth, s.email, s.address, s.phone, c.name FROM students s JOIN classroom c ON c.id = s.classRoomId WHERE s.name LIKE "%C%" ;

UPDATE students JOIN classroom ON students.classRoomId = classroom.id SET students.name = "Trung", students.dateOfBirth = "1994-11-03", students.email = "nbt@gmail.com", students.address = "Ha Noi", students.phone = "013457898", students.classRoomId = 3 WHERE students.id = 7;