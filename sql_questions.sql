1. https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/?envType=study-plan-v2&envId=top-sql-50
select eu.unique_id,e.name 
from employees as e left join employeeUNI as eu
on e.id=eu.id;

2.https://www.naukri.com/code360/problems/testingg-sql_1755903?topList=top-100-sql-problems&problemListRedirection=true
select i.title, i.rating
from IMDB as i inner join genre as g
on i.Movie_id=g.Movie_id where g.genre like 'C%' and i.budget > 40000000 and i.title like '%(2014)%';

3. https://www.naukri.com/code360/problems/rising-temperature_2110761?topList=top-100-sql-problems&problemListRedirection=true&leftPanelTabValue=PROBLEM
select w1.id as "Id"
from weather w1 inner join weather w2 
on w1.recordDate=w2.recordDate+1 where w1.temperature>w2.temperature;

4. https://www.naukri.com/code360/problems/department-highest-salary_2119329?topList=top-100-sql-problems&problemListRedirection=true&leftPanelTabValue=PROBLEM&count=25&page=1&search=&sort_entity=order&sort_order=ASC&attempt_status=COMPLETED&customSource=studio_nav
select d.Name "Department",e.Name  "Employee",e.Salary  "salary"
from Employee as e  inner join Department as d
on e.DepartmentId=d.Id where (e.DepartmentId,e.Salary) in 
(select DepartmentId,max(Salary) from Employee group by DepartmentId);
