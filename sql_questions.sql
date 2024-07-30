1. Replace employee id with unique identifier
select eu.unique_id,e.name 
from employees as e left join employeeUNI as eu
on e.id=eu.id;

2. From the IMDb dataset, print the title and rating of those movies which have a genre starting from 'C' released in 2014 with a budget higher than 4 Crore.
select i.title, i.rating
from IMDB as i inner join genre as g
on i.Movie_id=g.Movie_id where g.genre like 'C%' and i.budget > 40000000 and i.title like '%(2014)%';
