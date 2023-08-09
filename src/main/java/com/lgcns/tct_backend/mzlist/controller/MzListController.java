package com.lgcns.tct_backend.mzlist.controller;

import static com.lgcns.tct_backend.constants.Constants.SUCCESS;

import com.lgcns.tct_backend.exception.RestException;
import com.lgcns.tct_backend.model.ErrorCode;
import com.lgcns.tct_backend.mzlist.model.MzListReq;
import com.lgcns.tct_backend.mzlist.model.MzListRes;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantEditRes;
import com.lgcns.tct_backend.mzlist.model.MzListRestaurantRes;
import com.lgcns.tct_backend.mzlist.service.MzListService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MzListController {
	private final MzListService mzListService;

	@GetMapping("mzlist/{mzListId}")
	public ResponseEntity<MzListRes> getMzList(
			@PathVariable(name = "mzListId") @NotBlank String mzListId) {
		return ResponseEntity.ok(
				MzListRes.builder()
						.mzListId(mzListId)
						.restaurants(mzListService.getRestaurantListInMzList(mzListId))
						.build());
	}

	@GetMapping("mzlist/{mzListId}/restaurant")
	public ResponseEntity<MzListRestaurantRes> getMzListWithRestaurant(
			@PathVariable(name = "mzListId") @NotBlank String mzListId) {
		return ResponseEntity.ok(
				MzListRestaurantRes.builder()
						.mzListId(mzListId)
						.restaurantListInMzList(mzListService.getRestaurantListInMzList(mzListId))
						.restaurantListNotInMzList(
								mzListService.getRestaurantListNotInMzList(mzListId))
						.build());
	}

	@PutMapping("mzlist/{mzListId}")
	public ResponseEntity<MzListRestaurantEditRes> postMzList(
			@PathVariable(name = "mzListId") @NotBlank String mzListId,
			@RequestBody MzListReq mzListReq) {
		if (mzListReq.getRestaurantInMzList() == null) {
			throw new RestException(ErrorCode.INVALID_REQUEST_BODY);
		}
		String result = mzListService.editMzList(mzListId, mzListReq.getRestaurantInMzList());

		MzListRestaurantEditRes mzListRestaurantEditRes;
		if (SUCCESS.equals(result)) {
			mzListRestaurantEditRes = MzListRestaurantEditRes.ofSuccess();
		} else {
			mzListRestaurantEditRes = MzListRestaurantEditRes.ofFail(result);
		}
		return ResponseEntity.ok(mzListRestaurantEditRes);
	}
}
