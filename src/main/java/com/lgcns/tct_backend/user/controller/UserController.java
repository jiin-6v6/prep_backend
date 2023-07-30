package com.lgcns.tct_backend.user.controller;

import static com.lgcns.tct_backend.util.UserUtility.isUserIdValid;

import com.lgcns.tct_backend.exception.RestException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.user.model.User;
import com.lgcns.tct_backend.user.model.UserMzListReq;
import com.lgcns.tct_backend.user.model.UserMzListRes;
import com.lgcns.tct_backend.user.model.UserMzListSaveRes;
import com.lgcns.tct_backend.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.lgcns.tct_backend.constants.Constants.SUCCESS;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserService userService;

	@GetMapping("user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(name = "userId") @NotBlank String userId) {
		if (!isUserIdValid(userId)) {
			throw new RestException(ErrorCode.INVALID_REQUEST_URL);
		}

		return ResponseEntity.ok(userService.getUser(userId));
	}

	@GetMapping("user/{userId}/mzlist")
	public ResponseEntity<UserMzListRes> getUserMzList(
			@PathVariable(name = "userId") @NotBlank final String userId) {
		if (!isUserIdValid(userId)) {
			throw new RestException(ErrorCode.INVALID_REQUEST_URL);
		}

		return ResponseEntity.ok(
				UserMzListRes.builder()
						.userId(userId)
						.userMzLists(userService.getUserMzList(userId))
						.build());
	}

	@PostMapping("user/{userId}/mzlist")
	public ResponseEntity<UserMzListSaveRes> postUserMzList(@PathVariable(name = "userId") String userId, @RequestBody UserMzListReq userMzListReq) {
		String result = userService.addUserMzList(userId, userMzListReq.getMzListName());

		UserMzListSaveRes userMzListSaveRes;
		if(SUCCESS.equals(result)){
			userMzListSaveRes = UserMzListSaveRes.ofSuccess();
		} else {
			userMzListSaveRes = UserMzListSaveRes.ofFail(result);
		}
		return ResponseEntity.ok(userMzListSaveRes);
	}
}
