
insert into bookcategory values (1,'수학'),(2,'컴퓨터'),(3,'전자'),(4,'통계');
select * from bookinfo b2 ;
insert into bookinfo values (40001,'The elements of statistical learning',1,1,5,5),
							(40002,'Computer vision : a modern approach',1,2,5,5),
							(40003,'MATALAB for engineers',1,3,5,5),
							(40004,'CUDA by example',1,1,5,5),
							(40005,'An introduction to 3D computer vision',1,2,5,5),
							(40006,'Numerical methods',1,1,5,5),
							(40007,'Image-based modeling',1,2,5,5),
							(40008,'Machine learning',1,2,5,5),
							(40009,'Probabilistic robotics',1,4,5,5),
							(40010,'Pattern recognition and machine learning',1,2,5,5);

						alter table membinfo auto_increment = 12012;
						
insert into membinfo values
(12001,'gdhong','홍길동',19070405,'042-421-1739','010-9741-5821','대전'),
(12002,'yskim','김연수',19850301,'064-446-8695','010-4568-5581','제주'),
(12003,'jwkim','김지원',19860708,'053-548-7898','010-9111-5556','대구'),
(12004,'hwmoon','문희원',19800108,'052-221-1231','010-7777-7777','울산'),
(12005,'ihyou','유일한',19790205,'051-111-2222','010-4566-8886','부산'),
(12006,'dskim','김동수',19811123,'02-668-8887','010-1231-1211','서울'),
(12007,'jtbae','배진태',19820707,'044-500-7333','010-7877-7777','세종'),
(12008,'esryu','류은수',19830301,'062-233-1122','010-7444-1474','광주'),
(12009,'dckim','김동철',19870426,'061-887-4454','010-8525-1235','순천'),
(12010,'hschoi','최홍석',19900405,'054-555-7897','010-3214-6547','포항'),
(12011,'dskim','김동수',19830108,'043-529-8457','010-9566-4228','제천');

select * from bookinfo;
select * from bookcategory b ;
select * from membinfo;
update rentinfo set returndate = now() where rentno = 1 returndate is null;
select * from rentinfo;

create view vw_book_rentcategoryname
as select b.bookno, booktitle, rentYN, b.categoryno, count, totalcount , c.bookcategory
from bookinfo b join bookcategory c on b.categoryno  = c.categoryno
				join rentinfo r on b.bookno = r.bookno;
  
select * from vw_book_categoryname;
select * from bookinfo;
select * from vw_rentbookinfo vr ;

create view vw_rentall
as select r.rentno, b.bookno, b.booktitle, c.bookcategory, b.count, b.totalcount, r.overdate, r.rentdate, r.membno
from rentinfo r  join bookinfo b on r.bookno = b.bookno 
				 join bookcategory c on b.categoryno = c.categoryno ;
				
select * from vw_rentall;
				