create table department(
	department_id int primary key,
	department_name varchar(100)
);

create table employee(
	emp_id int primary key,
	emp_name varchar(100),
	department_id int,
	foreign key (department_id) references department(department_id)
);

insert into department(department_id,department_name)values(101,'Hr'),(102,'It'),(103,'Operations');
insert into employee(emp_id,emp_name,department_id)values(1,'Shruthi Mohan',101),(2,'Shilpa Patel',101),(3,'Anchal Mehta',103));
insert into employee(emp_id,emp_name,department_id)values(4,'ABC',null)

select e.emp_id, e.emp_name,d.department_name from employee e inner join department d on e.department_id=d.department_id;

select e.emp_id, e.emp_name,d.department_name from employee e left join department d on e.department_id=d.department_id;

select e.emp_id, e.emp_name,d.department_name from employee e right join department d on e.department_id=d.department_id;

create temporary table employee_department as 
select e.emp_id, e.emp_name,d.department_name from employee e inner join department d on e.department_id=d.department_id;

select * from employee_department;

create table salaries(
	salary decimal(10,2),
	emp_id int,
	foreign key (emp_id) references employee(emp_id)
);
insert into salaries(salary,emp_id) values(50000.23,1),(340000.2,2)
	
select ed.emp_id,ed.emp_name,ed.department_name, s.salary from employee_department ed inner join salaries s on ed.emp_id=s.emp_id;

drop table if exists employee_department;
