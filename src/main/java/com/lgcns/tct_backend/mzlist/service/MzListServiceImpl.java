package com.lgcns.tct_backend.mzlist.service;

import static com.lgcns.tct_backend.constants.Constants.SUCCESS;

import com.lgcns.tct_backend.exception.BusinessException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.model.MzListCond;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantCond;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantRelCond;
import com.lgcns.tct_backend.mzlist.repository.MzListRepository;
import com.lgcns.tct_backend.restaurant.model.Restaurant;
import com.lgcns.tct_backend.restaurant.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MzListServiceImpl implements MzListService {
	private final MzListRepository mzListRepository;

	private final RestaurantService restaurantService;

	private MzList getMzList(String mzListId) {
		MzList mzList = mzListRepository.selectMzList(mzListId);

		if (mzList == null) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST_URL);
		}

		return mzList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MzList> getUserMzList(String userId) {
		return mzListRepository.selectUserMzList(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Restaurant> getRestaurantListInMzList(String mzListId) {
		MzList mzList = getMzList(mzListId);

		return restaurantService.getRestaurantListInMzList(mzList.getListId());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Restaurant> getRestaurantListNotInMzList(String mzListId) {
		MzList mzList = getMzList(mzListId);

		return restaurantService.getRestaurantListNotInMzList(mzList.getListId());
	}

	@Override
	@Transactional(readOnly = true)
	public boolean checkUserMzList(String userId, String mzListName) {
		return mzListRepository.selectUserMzListWithMzListName(
				MzListCond.builder().userId(userId).mzListName(mzListName).build());
	}

	@Override
	@Transactional
	public int addUserMzList(String userId, String mzListName) {
		return mzListRepository.insertUserMzList(
				MzListCond.builder().userId(userId).mzListName(mzListName).build());
	}

	@Override
	@Transactional
	public String editMzList(String mzListId, List<String> restaurantIdList) {
		MzList mzList = getMzList(mzListId);

		if (restaurantIdList.isEmpty()) {
			mzListRepository.deleteAllRestaurantMzList(mzList.getListId());
			return SUCCESS;
		} else {
			mzListRepository.deleteRestaurantMzList(
					MzListRestaurantCond.builder()
							.mzListId(mzListId)
							.restaurantIdList(restaurantIdList)
							.build());
		}

		List<String> alreadyExistRestaurantList =
				restaurantService.getRestaurantListInMzList(mzList.getListId()).stream()
						.map(item -> item.getRestaurantId())
						.toList();

		List<String> addRestaurantList =
				restaurantIdList.stream()
						.filter(item -> !alreadyExistRestaurantList.contains(item))
						.toList();

		// 맛집리스트에 넣으려는 대상 추가하기
		for (String restaurantId : addRestaurantList) {
			mzListRepository.insertRestaurantMzList(
					MzListRestaurantRelCond.builder()
							.mzListId(mzListId)
							.restaurantId(restaurantId)
							.build());
		}
		return SUCCESS;
	}
}
