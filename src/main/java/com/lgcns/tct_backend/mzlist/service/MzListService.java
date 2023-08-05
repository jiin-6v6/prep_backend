package com.lgcns.tct_backend.mzlist.service;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;

public interface MzListService {
	public List<MzList> getUserMzList(String userId);

	public List<Restaurant> getRestaurantListInMzList(String mzListId);

	public List<Restaurant> getRestaurantListNotInMzList(String mzListId);

	public boolean checkUserMzList(String userId, String mzListName);

	public int addUserMzList(String userId, String mzListName);
}
