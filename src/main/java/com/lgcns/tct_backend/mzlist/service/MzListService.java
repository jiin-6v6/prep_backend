package com.lgcns.tct_backend.mzlist.service;

import java.util.List;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.restaurant.model.Restaurant;

public interface MzListService {
    public List<MzList> getUserMzList(String userId);

    public List<Restaurant> getRestaurantsInMzList(String mzListId);
}
