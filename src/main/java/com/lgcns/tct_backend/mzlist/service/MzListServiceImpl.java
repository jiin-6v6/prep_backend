package com.lgcns.tct_backend.mzlist.service;

import com.lgcns.tct_backend.exception.BusinessException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.model.MzListCond;
import com.lgcns.tct_backend.mzlist.repository.MzListRepository;
import com.lgcns.tct_backend.restaurant.model.Restaurant;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
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

		if (mzList == null) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST_URL);
		}

		return mzListRepository.selectRestaurantInMzList(mzListId);
	}

	@Override
	public boolean checkUserMzList(String userId, String mzListName) {
		return mzListRepository.selectUserMzListWithMzListName(
				MzListCond.builder().userId(userId).mzListName(mzListName).build());
	}

	@Override
	public int addUserMzList(String userId, String mzListName) {
		return mzListRepository.insertUserMzList(MzListCond.builder().userId(userId).mzListName(mzListName).build());
	}
}
