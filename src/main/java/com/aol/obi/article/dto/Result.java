/*
 * AMERICA ONLINE CONFIDENTIAL INFORMATION
 *
 *
 * Copyright (c) 2010 AOL LLC
 *
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 *
 *
 */
package com.aol.obi.article.dto;

import org.apache.commons.lang.StringUtils;

import com.aol.obi.article.util.AppConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * The Error used to send success status in JSON form
 * 
 * @author jvaidy
 * @version 1.0
 * @since 04/28/2015
 */
@JsonInclude(Include.NON_NULL)
@ApiModel(value = "Result")
public class Result {

	@JsonProperty(index=1)
    @ApiModelProperty(value = "result", required = true, notes="Response ststus: success or error")
	protected String result = AppConstants.SUCCESS;
	
	@JsonProperty(index=2)
    @ApiModelProperty(value = "message", notes="success or error messages")
	private String message = StringUtils.EMPTY;
	
	@JsonProperty(index=3)
    @ApiModelProperty(value = "userUUID", notes="Returns USERUUID on register API call or MEMBERUUID on setup API call")
	private String userUUID;
	
	@JsonProperty(index=4)
    @ApiModelProperty(value = "fieldErrors", notes="API fields validation error messages")
	private List<FieldErrors> fieldErrors;
	
	@JsonProperty(index=4)
    @ApiModelProperty(value = "response", notes="Returns response data from API call. Example: List of family members from /get_members API")
	private Object response;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public List<FieldErrors> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrors> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
