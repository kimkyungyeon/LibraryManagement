SELECT * FROM rentinfo;

update rentinfo set overdate = case

select  date_format(rentDate ,'%Y-%m-%d') as a , date_format (now(), '%Y-%m-%d') as b, datediff( now(), rentdate) from rentinfo;

select timestampdiff(quarter, rentdate, returndate) from rentinfo r ;

select datediff('returndate', 'rentdate') from rentinfo r2 ; 

select *
from rentinfo r 
where (to_days(now())-to_days(rentdate)) >3;

select *
from rentinfo r 
where (to_days(now())-to_days(rentdate)) >3;

-- 3일이 넘는 경우 연체일 업데이트
update rentinfo set overdate = (to_days(now())-to_days(rentdate))-3 
where (to_days(now())-to_days(rentdate)) >3;

select * from rentinfo;

-- 72시간이 넘는 경우 연체일 업데이트
update rentinfo set overdate = (TIMESTAMPDIFF(hour, rentdate,now())-72)/24 where TIMESTAMPDIFF(hour, rentdate,now()) >72;

select  TIMESTAMPDIFF(hour, '20210228',now()); from rentinfo;

select * from rentinfo;

select * from rentinfo;
select date_format(rentDate,'%') from rentinfo; 