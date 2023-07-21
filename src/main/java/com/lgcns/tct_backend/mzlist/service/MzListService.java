package com.lgcns.tct_backend.mzlist.service;

import java.util.List;

import com.lgcns.tct_backend.mzlist.model.MzList;

public interface MzListService {
    public List<MzList> getUserMzList(String userId);
}
