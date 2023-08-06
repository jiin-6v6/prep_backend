package com.lgcns.tct_backend.mzlist.repository;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.model.MzListCond;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantCond;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantRelCond;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MzListRepository {
	MzList selectMzList(String mzListId);

	List<MzList> selectUserMzList(String userId);

	boolean selectUserMzListWithMzListName(MzListCond mzListCond);

	int insertUserMzList(MzListCond mzListCond);

	int deleteAllRestaurantMzList(String mzListId);

	int deleteRestaurantMzList(MzListRestaurantCond mzListRestaurantCond);

	int insertRestaurantMzList(MzListRestaurantRelCond mzListRestaurantRelCond);
}
