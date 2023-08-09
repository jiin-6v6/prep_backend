package com.lgcns.tct_backend.mzlist.model;

import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MzListRestaurantRes {
	private String mzListId;
	private List<Restaurant> restaurantListInMzList;
	private List<Restaurant> restaurantListNotInMzList;
}
