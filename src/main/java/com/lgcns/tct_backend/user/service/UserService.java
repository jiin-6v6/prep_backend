package com.lgcns.tct_backend.user.service;

import java.util.List;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.user.model.User;

public interface UserService {
    public User getUser(String userId);

    public List<MzList> getUserMzList(String userId);
}
