drop database if exists department_service;
create database if not exists department_service;

use department_service;

drop table if exists departments;
drop table if exists employees;

create table if not exists departments
(
    id   int primary key auto_increment,
    name varchar(20) unique not null
);

create table if not exists employees
(
    id          int primary key auto_increment,
    dep_id      int         not null,
    salary      double      not null,
    birthday    DATE,
    name        varchar(30) not null,
    phone_number varchar(20) unique not null,
    e_mail      varchar(50) unique not null,
    foreign key (dep_id) references departments (id)
);

insert into departments(name)
values ('Marketing'),
       ('Finance'),
       ('Human Resource');

insert into employees(salary, dep_id, birthday, name, phone_number, e_mail)
values (2000.00, 1, '2012-12-23', 'Alex', '3_8123456789', 'Alex@mail.com'),
       (1500.00, 1, '2020-01-30', 'Anna', '4_5555775444', 'e_mailAnna@mail.com'),
       (1700.00, 2, '2020-01-30', 'Tony', '193746599', 'e_mailTony@mail.com'),
       (1700.00, 1, '2020-01-30', 'Ivan', '49487836455', 'e_mailIvan@mail.com'),
       (1700.00, 3, '2020-01-30', 'Sarah', '544477666444', 'e_mailSarah@mail.com'),
       (1700.00, 2, '2020-01-30', 'John', '48579238275495', 'e_mailJohn@mail.com'),
       (1700.00, 3, '2020-01-30', 'Tom', '934857219', 'e_mailTom@gmail.com'),
       (1700.00, 2, '2020-01-30', 'Max', 'Finance', 'e_mailMax@mail.com'),
       (1900.00, 3, '2020-01-30', 'Serhii', '6_4446668444', 'e_mailSerhii@mail.com'),
       (1900.00, 3, '1998-06-01', 'Daniil', '+30983431357', 'daniil_porvav@gmail.com');