package com.lgcns.tct_backend.user.service;

import com.lgcns.tct_backend.exception.BusinessException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.repository.MzListRepository;
import com.lgcns.tct_backend.user.model.User;
import com.lgcns.tct_backend.user.model.UserMzListRes;
import com.lgcns.tct_backend.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final MzListRepository mzListRepository;

    @Override
    public User getUser(String userId) {
        User user = userRepository.selectUser(userId);

        if(user == null){
            throw new BusinessException(ErrorCode.INVALID_USER_ID);
        }

        return user;
    }

    @Override
    public UserMzListRes getUserMzList(String userId) {
        User user = this.getUser(userId);

        return UserMzListRes.builder()
            .userMzLists(mzListRepository.selectUserMzList(user.getUserId()))
            .userId(user.getUserId())
            .build();
    }
}
