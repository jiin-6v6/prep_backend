package com.lgcns.tct_backend.user.service;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.user.model.User;
import java.util.List;

public interface UserService {
	public User getUser(String userId);

	public List<MzList> getUserMzList(String userId);
}
