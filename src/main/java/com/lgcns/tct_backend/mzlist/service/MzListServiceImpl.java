package com.lgcns.tct_backend.mzlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.repository.MzListRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MzListServiceImpl implements MzListService {
    private final MzListRepository mzListRepository;

    @Override
    public List<MzList> getUserMzList(String userId) {
        return mzListRepository.selectUserMzList(userId);
    }
    
}
