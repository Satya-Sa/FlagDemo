package com.mycompany.falg.controller;

import org.springframework.boot.actuate.autoconfigure.cloudfoundry.SecurityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mycompany.falg.exception.DataNotFoundException;

@ControllerAdvice
public class ExceptionController {

	/**
	 * Handle data not found exception.
	 *
	 * @param se the se
	 * @return the security response
	 */
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public SecurityResponse handleDataNotFoundException(DataNotFoundException se) {
		SecurityResponse response = new SecurityResponse(HttpStatus.NOT_FOUND, se.getMessage());
		return response;
	}
}
