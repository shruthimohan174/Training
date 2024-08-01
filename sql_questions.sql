1. Replace employee id with unique identifier
select eu.unique_id,e.name 
from employees as e left join employeeUNI as eu
on e.id=eu.id;

2. From the IMDb dataset, print the title and rating of those movies which have a genre starting from 'C' released in 2014 with a budget higher than 4 Crore.
select i.title, i.rating
from IMDB as i inner join genre as g
on i.Movie_id=g.Movie_id where g.genre like 'C%' and i.budget > 40000000 and i.title like '%(2014)%';

3. Rising Temperature
select w1.id as "Id"
from weather w1 inner join weather w2 
on w1.recordDate=w2.recordDate+1 where w1.temperature>w2.temperature;

4.  Department Highest Salary
select d.Name "Department",e.Name  "Employee",e.Salary  "salary"
from Employee as e  inner join Department as d
on e.DepartmentId=d.Id where (e.DepartmentId,e.Salary) in 
(select DepartmentId,max(Salary) from Employee group by DepartmentId);
