package com.lgcns.tct_backend.mzlist.repository;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.model.MzListCond;
import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MzListRepository {
	MzList selectMzList(String mzListId);

	List<MzList> selectUserMzList(String userId);

	List<Restaurant> selectRestaurantInMzList(String mzListId);

	boolean selectUserMzListWithMzListName(MzListCond mzListCond);

	int insertUserMzList(MzListCond mzListCond);
}
