package com.lgcns.tct_backend.mzlist.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MzListCond {
	private String userId;
	private String mzListName;
}
