package com.lgcns.tct_backend.mzlist.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MzListRestaurantCond {
	private String mzListId;
	private List<String> restaurantIdList;
}
