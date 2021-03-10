package LibraryManagement.dao;

import java.util.List;

import LibraryManagement.dto.MembInfo;

public interface MembInfoDao {
	List<MembInfo> selectMembInfoByAll();
	List<MembInfo> selectMembInfoByMembNo(MembInfo membInfo);				//int 		회원번호로 select
	List<MembInfo> selectMembInfoByMembName(MembInfo membInfo);				//String	회원성명으로 select
	List<MembInfo> selectMembInfoByMembAccount(MembInfo membInfo);			//String	회원계정으로 select 
	
	
	
	int insertMembInfo(MembInfo membInfo);
	int updateMembInfo(MembInfo membInfo);
	int deleteMembInfo(MembInfo membInfo);
}
