SELECT r.bookno, b.booktitle, r.overdate , r.rentdate 
  FROM bookinfo b JOIN rentinfo r
  	ON b.bookno = r.bookno where r.membno = ? and returndate is null;