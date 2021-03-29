package LibraryManagement.dao;

import java.util.List;

import LibraryManagement.dto.BookInfo;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public interface RentInfoDao {
	List<RentInfo> selectRentInfoByAll();
	List<RentInfo> selectRentInfoByRentNo(RentInfo rentInfo);
	List<RentInfo> selectRentInfoByMembNo(MembInfo membInfo);
	List<RentInfo> selectRentInfoByBookNo(BookInfo bookInfo);
	
	int insertRentInfo(RentInfo rentInfo);
	int updateRentInfo(RentInfo rentInfo);
	int deleteRentInfo(RentInfo rentInfo);
	int updateBookOverDate();
}
