SELECT count(*),m.membname , r.membno 
FROM bookinfo b JOIN rentinfo r ON b.bookno = r.bookno 
join bookcategory c  on b.categoryno = c.categoryno
join membinfo m  on r.membno =m.membno group by m.membName order by count(*) desc limit 5;
where r.membno = 1200342 and returndate is null;

select * from rentinfo r  where membno = 12001;


SELECT count(*), b.booktitle , b.bookno 

FROM bookinfo b JOIN rentinfo r ON b.bookno = r.bookno 
join bookcategory c  on b.categoryn  o = c.categoryno
join membinfo m  on r.membno =m.membno group by b.bookNo order by count(*) desc limit 5;