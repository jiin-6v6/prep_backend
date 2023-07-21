package com.lgcns.tct_backend.mzlist.model;

import java.util.List;

import com.lgcns.tct_backend.restaurant.model.Restaurant;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MzListRes {
    private String mzListId;
    private List<Restaurant> restaurantList;

    @Builder
    public MzListRes(String mzListId, List<Restaurant> restaurants) {
        this.mzListId = mzListId;
        restaurantList = !restaurants.isEmpty() ? restaurants : null;
    }
}
