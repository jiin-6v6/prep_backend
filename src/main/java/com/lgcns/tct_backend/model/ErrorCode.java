package com.lgcns.tct_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@JsonFormat(shape = Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ErrorCode {
	INVALID_USER_ID(HttpStatus.BAD_REQUEST, "", "Invalid User ID"),
	INVALID_REQUEST_URL(HttpStatus.BAD_REQUEST, "", "Invalid Request URL"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "", "Internal Server Error");

	private HttpStatusCode httpStatus;
	private String code;
	private String message;
}
