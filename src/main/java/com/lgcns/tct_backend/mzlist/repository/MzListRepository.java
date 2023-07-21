package com.lgcns.tct_backend.mzlist.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.restaurant.model.Restaurant;

@Mapper
public interface MzListRepository {
    MzList selectMzList(String mzListId);

    List<MzList> selectUserMzList(String userId);

    List<Restaurant> selectRestaurantInMzList(String mzListId);
}
