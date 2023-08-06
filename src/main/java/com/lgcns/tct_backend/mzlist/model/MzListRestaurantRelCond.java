package com.lgcns.tct_backend.mzlist.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MzListRestaurantRelCond {
	private String mzListId;
	private String restaurantId;
}
