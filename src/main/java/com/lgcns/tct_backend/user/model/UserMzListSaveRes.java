package com.lgcns.tct_backend.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMzListSaveRes {
    	private String result;
	private String message;

	public static UserMzListSaveRes ofSuccess() {
		return UserMzListSaveRes.builder().result("success").message("success to message").build();
	}

	public static UserMzListSaveRes ofFail(String message) {
		return UserMzListSaveRes.builder().result("fail").message(message).build();
	}
}
