package com.lgcns.tct_backend.mzlist.repository;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.model.MzListCond;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MzListRepository {
	MzList selectMzList(String mzListId);

	List<MzList> selectUserMzList(String userId);

	boolean selectUserMzListWithMzListName(MzListCond mzListCond);

	int insertUserMzList(MzListCond mzListCond);
}
