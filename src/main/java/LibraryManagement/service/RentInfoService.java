package LibraryManagement.service;

import java.util.List;

import LibraryManagement.dao.RentInfoDao;
import LibraryManagement.dao.impl.RentInfoDaoImpl;
import LibraryManagement.dto.MembInfo;
import LibraryManagement.dto.RentInfo;

public class RentInfoService {
	private RentInfoDao  dao = RentInfoDaoImpl.getInstance();
	
	public List<RentInfo> showRentInfoByMembNo(MembInfo membInfo){
		return dao.selectRentInfoByMembNo(membInfo);
	}
}
