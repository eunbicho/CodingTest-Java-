select t1.flavor
from first_half t1, icecream_info t2 
where t1.flavor = t2.flavor 
and t1.total_order > 3000 
and t2.ingredient_type = "fruit_based"
order by t1.total_order desc;
