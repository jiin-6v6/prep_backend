package com.lgcns.tct_backend.mzlist.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MzListRestaurantEditRes {
	private String result;
	private String message;

	public static MzListRestaurantEditRes ofSuccess() {
		return MzListRestaurantEditRes.builder()
				.result("success")
				.message("success to save mz list")
				.build();
	}

	public static MzListRestaurantEditRes ofFail(String message) {
		return MzListRestaurantEditRes.builder().result("fail").message(message).build();
	}
}
