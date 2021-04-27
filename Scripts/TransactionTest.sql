select * from vw_rentbookinfo vr ;
select * from vw_book_categoryname vbc ;
select * from rentinfo;
select * from bookinfo;
update bookinfo set count = count-1 where bookno = 40006 ;
insert into rentinfo  (membno , bookno, rentdate, returndate , overdate)  values ( 12004, 40008, now(),null,0);
-- 대출
update bookinfo set count = count-1  where bookno = 40001 and rentyn != 0;
-- 대출
update bookinfo set rentyn = 0  where count = 0;

-- 반납
update bookinfo set count = count+1 where bookno = 40001 and count<5;
update rentinfo set returndate = now() where rentno = ?; 
update bookinfo set rentyn = 1  where count !=0 ;

ers



 