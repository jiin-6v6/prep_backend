package com.lgcns.tct_backend.user.model;

import com.lgcns.tct_backend.mzlist.model.MzList;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserMzListRes {
	private String userId;
	private List<MzList> mzList;

	@Builder
	public UserMzListRes(String userId, List<MzList> userMzLists) {
		this.userId = userId;
		if (userMzLists == null || userMzLists.size() == 0) {
			return;
		}

		mzList = new ArrayList<>();
		for (MzList userMzList : userMzLists) {
			mzList.add(userMzList);
		}
	}
}
