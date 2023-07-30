package com.lgcns.tct_backend.user.service;

import com.lgcns.tct_backend.exception.BusinessException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.model.MzList;
import com.lgcns.tct_backend.mzlist.service.MzListService;
import com.lgcns.tct_backend.user.model.User;
import com.lgcns.tct_backend.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.lgcns.tct_backend.constants.Constants.SUCCESS;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	private final MzListService mzListService;

	@Override
	public User getUser(String userId) {
		User user = userRepository.selectUser(userId);

		if (user == null) {
			throw new BusinessException(ErrorCode.INVALID_USER_ID);
		}

		return user;
	}

	@Override
	public List<MzList> getUserMzList(String userId) {
		User user = this.getUser(userId);
		return mzListService.getUserMzList(user.getUserId());
	}

	@Override
	public String addUserMzList(String userId, String mzListName) {
		boolean isAleadyExisted = mzListService.checkUserMzList(userId, mzListName);

		if(isAleadyExisted) {
			return "mz list name (" + mzListName + ") is already existed.";
		}
		mzListService.addUserMzList(userId, mzListName);
		return SUCCESS;
	}
}
