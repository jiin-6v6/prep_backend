package com.lgcns.tct_backend.restaurant.service;

import com.lgcns.tct_backend.restaurant.model.Restaurant;
import com.lgcns.tct_backend.restaurant.repository.RestaurantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> getRestaurantListInMzList(String mzListId) {
		return restaurantRepository.selectRestaurantInMzList(mzListId);
	}

	@Override
	public List<Restaurant> getRestaurantListNotInMzList(String mzListId) {
		return restaurantRepository.selectRestaurantNotInMzList(mzListId);
	}
}
