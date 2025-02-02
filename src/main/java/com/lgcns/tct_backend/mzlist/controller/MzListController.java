package com.lgcns.tct_backend.mzlist.controller;

import com.lgcns.tct_backend.mzlist.model.MzListRes;
import com.lgcns.tct_backend.mzlist.service.MzListService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
						.restaurants(mzListService.getRestaurantsInMzList(mzListId))
						.build());
	}

	@PostMapping("mzlist/{mzListId}")
	public ResponseEntity<MzListRes> postMzList() {
		return null;
	}
}
