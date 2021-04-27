select * from membinfo;
-- membinfo insert 테스트
insert into membinfo (membaccount, membname, membbirth, membtel, membphone, membaddr) values ('kykim', '김경연', '19940801','053-323-1241','010-6510-7277','대구');
delete from membinfo where membname ='김경연';

select categoryno, bookcategory from bookcategory;
select bookno,booktitle,rentYN,categoryno,count,totalcount  from bookinfo;
select * from rentinfo r;
insert into rentinfo  (membno , bookno, rentdate, returndate , overdate)  values ( 12004, 40008, now(),null,0);
select * from bookcategory b ;
select * from rentinfo r2 ;
select rentno , bookno, overdate, rentdate from rentInfo where membno =12001 and returndate is null;

select rentno , bookno,  overdate, rentdate from rentInfo where membno = 12001 and returndate is null;

-- 1.main화면 형식 좌측 회원목록 
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membbirth as 생년월일 ,membtel as 회원번호, membphone as 휴대전화
from membinfo m ;

-- 1.main화면 형식 좌측 회원목록 검색(회원번호)
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membtel as 회원번호, membphone as 휴대전화
from membinfo m  where membno like '%04%';

-- 1.main화면 형식 좌측 회원목록 검색(이름)
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membtel as 회원번호, membphone as 휴대전화
from membinfo m where membname like '%김동%';

-- 1.main화면 형식 좌측 회원목록 검색(전화번호)
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membtel as 회원번호, membphone as 휴대전화
from membinfo m where membtel like '%12%';

-- 1.main화면 형식 좌측 회원목록 검색 (휴대전화)
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membtel as 회원번호, membphone as 휴대전화
from membinfo m where membphone like '%47%';

-- 1.main화면 형식 좌측 회원목록 검색 (회원계정)
select membno as 회원번호, membaccount as 회원계정,membname as 회원이름, membtel as 회원번호, membphone as 휴대전화
from membinfo m where membaccount like '%kim%';

-- 2.main화면 형식 우측 도서목록 
select bookno as 도서번호, booktitle as 도서제목, 
	case  when rentyn= 1 then '대출가능' 
	  	  when rentyn=  0 then '대출불가' end  as '대출여부',
	 count as 권수 
from bookinfo;

-- 2.main화면 형식 우측 도서목록 검색(도서번호)
select bookno as 도서번호, booktitle as 도서제목,
	case  when rentyn= 1 then '대출가능'
		  when rentyn=  0 then '대출불가' end  as '대출여부',
	 count as 권수 
from bookinfo where bookno like '%10%';

-- 2.main화면 형식 우측 도서목록 검색(도서제목)
select bookno as 도서번호, booktitle as 도서제목,
	case  when rentyn= 1 then '대출가능'
		  when rentyn=  0 then '대출불가' end  as '대출여부',
	 count as 권수 
from bookinfo where booktitle like '%ele%';

-- 3.main화면 형식 하단 대여중인 도서목록 
select rentno , booktitle, rentdate, overdate
from rentinfo r join bookinfo b on r.bookno = b.bookno 
where r.membno = '?';

select * from membinfo;

-- 4.회원목록(초기값)
select membno, membName, membaccount ,membtel ,membphone 
from membinfo m ;

-- 4.회원검색(
select membno, membName, membaccount ,membtel ,membphone 
from membinfo m 
where  ;

select * from vw_book_categoryname vbc ;

select * from vw_rentbookinfo vr;

select * from bookInfo;

select * from bookcategory b ;

update membinfo set membaccount = 'kskim'  where membno = 12013;
