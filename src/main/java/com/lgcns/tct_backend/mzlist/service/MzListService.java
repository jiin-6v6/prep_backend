package com.lgcns.tct_backend.mzlist.service;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;

public interface MzListService {
	public List<MzList> getUserMzList(String userId);

	public List<Restaurant> getRestaurantsInMzList(String mzListId);
}
