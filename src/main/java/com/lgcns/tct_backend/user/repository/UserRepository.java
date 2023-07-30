package com.lgcns.tct_backend.user.repository;

import com.lgcns.tct_backend.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	User selectUser(String userId);
}
