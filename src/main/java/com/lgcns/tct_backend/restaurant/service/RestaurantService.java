package com.lgcns.tct_backend.restaurant.service;

import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;

public interface RestaurantService {
	List<Restaurant> getRestaurantListInMzList(String mzListId);

	List<Restaurant> getRestaurantListNotInMzList(String mzListId);
}
