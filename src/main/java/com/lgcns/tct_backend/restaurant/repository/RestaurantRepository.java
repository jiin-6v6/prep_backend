package com.lgcns.tct_backend.restaurant.repository;

import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestaurantRepository {
	List<Restaurant> selectRestaurantInMzList(String mzListId);

	List<Restaurant> selectRestaurantNotInMzList(String mzListId);
}
