package com.lgcns.tct_backend.mzlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.tct_backend.mzlist.model.MzListRes;
import com.lgcns.tct_backend.mzlist.service.MzListService;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MzListController {
    private final MzListService mzListService;

    @GetMapping("mzlist/{mzListId}")
    public ResponseEntity<MzListRes> getUser(@PathVariable(name = "mzListId") @NotBlank String mzListId) {
        return ResponseEntity.ok(MzListRes.builder().mzListId(mzListId).restaurants(mzListService.getRestaurantsInMzList(mzListId)).build());
    }
}
