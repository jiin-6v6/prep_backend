package com.lgcns.tct_backend.mzlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lgcns.tct_backend.exception.BusinessException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.repository.MzListRepository;
import com.lgcns.tct_backend.restaurant.model.Restaurant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MzListServiceImpl implements MzListService {
    private final MzListRepository mzListRepository;

    @Override
    public List<MzList> getUserMzList(String userId) {
        return mzListRepository.selectUserMzList(userId);
    }

    @Override
    public List<Restaurant> getRestaurantsInMzList(String mzListId) {
        MzList mzList = mzListRepository.selectMzList(mzListId);

        if(mzList == null) {
            throw new BusinessException(ErrorCode.INVALID_REQUEST_URL);
        }

        return mzListRepository.selectRestaurantInMzList(mzListId);
    }
    
}
