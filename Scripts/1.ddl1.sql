-- 대출정보
DROP TABLE IF EXISTS LibraryManagement.rentinfo RESTRICT;

-- 도서정보
DROP TABLE IF EXISTS LibraryManagement.bookInfo RESTRICT;

-- 회원정보
DROP TABLE IF EXISTS LibraryManagement.membInfo RESTRICT;

-- 도서구분
DROP TABLE IF EXISTS LibraryManagement.bookcategory RESTRICT;

-- 관리자계정
DROP TABLE IF EXISTS LibraryManagement.adminTable RESTRICT;

-- 도서관리
DROP SCHEMA IF EXISTS LibraryManagement;

-- 도서관리
CREATE SCHEMA LibraryManagement;

-- 대출정보
CREATE TABLE LibraryManagement.rentinfo (
	rentno     INT(5) NOT NULL COMMENT '대여번호', -- 대여번호
	membno     INT(5) NOT NULL COMMENT '회원번호', -- 회원번호
	bookno     INT(5) NOT NULL COMMENT '도서번호', -- 도서번호
	rentdate   DATE   NOT NULL COMMENT '도서대여일', -- 도서대여일
	returndate DATE   NULL     COMMENT '도서반납일', -- 도서반납일
	overdate   INT(5) NULL     DEFAULT 0 COMMENT '도서연체일' -- 도서연체일
)
COMMENT '대출정보';

-- 대출정보
ALTER TABLE LibraryManagement.rentinfo
	ADD CONSTRAINT PK_rentinfo -- 대출정보 기본키
		PRIMARY KEY (
			rentno -- 대여번호
		);

ALTER TABLE LibraryManagement.rentinfo
	MODIFY COLUMN rentno INT(5) NOT NULL AUTO_INCREMENT COMMENT '대여번호';

-- 도서정보
CREATE TABLE LibraryManagement.bookInfo (
	bookno     INT(5)       NOT NULL COMMENT '도서번호', -- 도서번호
	booktitle  VARCHAR(120) NOT NULL COMMENT '도서제목', -- 도서제목
	rentYN     BOOL         NOT NULL COMMENT '대출여부', -- 대출여부
	categoryno INT(5)       NOT NULL COMMENT '구분번호', -- 구분번호
	count      INT(5)       NOT NULL COMMENT '권수', -- 권수
	totalcount INT(5)       NOT NULL COMMENT '총권수' -- 총권수
)
COMMENT '도서정보';

-- 도서정보
ALTER TABLE LibraryManagement.bookInfo
	ADD CONSTRAINT PK_bookInfo -- 도서정보 기본키
		PRIMARY KEY (
			bookno -- 도서번호
		);

ALTER TABLE LibraryManagement.bookInfo
	MODIFY COLUMN bookno INT(5) NOT NULL AUTO_INCREMENT COMMENT '도서번호';

-- 회원정보
CREATE TABLE LibraryManagement.membInfo (
	membno      INT(5)      NOT NULL COMMENT '회원번호', -- 회원번호
	membaccount VARCHAR(30) NULL     COMMENT '회원계정', -- 회원계정
	membName    VARCHAR(20) NOT NULL COMMENT '회원이름', -- 회원이름
	membbirth   DATE        NULL     COMMENT '회원생년월일', -- 회원생년월일
	membtel     VARCHAR(20) NULL     COMMENT '회원전화번호', -- 회원전화번호
	membphone   VARCHAR(20) NULL     COMMENT '회원휴대전화', -- 회원휴대전화
	membaddr    VARCHAR(10) NULL     COMMENT '회원주소' -- 회원주소
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE LibraryManagement.membInfo
	ADD CONSTRAINT PK_membInfo -- 회원정보 기본키
		PRIMARY KEY (
			membno -- 회원번호
		);

ALTER TABLE LibraryManagement.membInfo
	MODIFY COLUMN membno INT(5) NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 도서구분
CREATE TABLE LibraryManagement.bookcategory (
	categoryno   INT(5)      NOT NULL COMMENT '구분번호', -- 구분번호
	bookcategory VARCHAR(20) NOT NULL COMMENT '도서구분' -- 도서구분
)
COMMENT '도서구분';

-- 도서구분
ALTER TABLE LibraryManagement.bookcategory
	ADD CONSTRAINT PK_bookcategory -- 도서구분 기본키
		PRIMARY KEY (
			categoryno -- 구분번호
		);

ALTER TABLE LibraryManagement.bookcategory
	MODIFY COLUMN categoryno INT(5) NOT NULL AUTO_INCREMENT COMMENT '구분번호';

-- 관리자계정
CREATE TABLE LibraryManagement.adminTable (
	admin VARCHAR(30) NOT NULL COMMENT 'admin', -- admin
	passwd   VARCHAR(50) NOT NULL COMMENT 'passwd' -- password
)
COMMENT '관리자계정';

-- 관리자계정
ALTER TABLE LibraryManagement.adminTable
	ADD CONSTRAINT PK_adminTable -- 관리자계정 기본키
		PRIMARY KEY (
			admin -- admin
		);

-- 대출정보
ALTER TABLE LibraryManagement.rentinfo
	ADD CONSTRAINT FK_bookInfo_TO_rentinfo -- 도서정보 -> 대출정보
		FOREIGN KEY (
			bookno -- 도서번호
		)
		REFERENCES LibraryManagement.bookInfo ( -- 도서정보
			bookno -- 도서번호
		);

-- 대출정보
ALTER TABLE LibraryManagement.rentinfo
	ADD CONSTRAINT FK_membInfo_TO_rentinfo -- 회원정보 -> 대출정보
		FOREIGN KEY (
			membno -- 회원번호
		)
		REFERENCES LibraryManagement.membInfo ( -- 회원정보
			membno -- 회원번호
		);

-- 도서정보
ALTER TABLE LibraryManagement.bookInfo
	ADD CONSTRAINT FK_bookcategory_TO_bookInfo -- 도서구분 -> 도서정보
		FOREIGN KEY (
			categoryno -- 구분번호
		)
		REFERENCES LibraryManagement.bookcategory ( -- 도서구분
			categoryno -- 구분번호
		);