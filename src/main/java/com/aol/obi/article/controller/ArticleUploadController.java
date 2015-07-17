/*
 * AMERICA ONLINE CONFIDENTIAL INFORMATION
 *
 *
 * Copyright (c) 2015 AOL LLC
 *
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 *
 *
 */
package com.aol.obi.article.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aol.obi.article.dto.Article;
import com.aol.obi.article.dto.Result;
import com.aol.obi.article.exception.InvalidRequestException;
import com.aol.obi.article.service.ArticleService;
import com.aol.obi.article.util.AppConstants;
import com.aol.obi.article.util.CommonUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "User Registration API")
public class ArticleUploadController {

    private static final Logger LOG = Logger.getLogger(ArticleUploadController.class);

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "Register new user",
            notes = "This API registers a new user account with the user information provided "
            + "in the request body. An error will be returned if the username is already "
            + "taken or any validation fails.")
    @ApiResponses({@ApiResponse(code = 409, message = "User with specified username already exists")})
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Result> register(HttpServletRequest request, @ApiParam(value = "User account information", required = true) @RequestBody Article article, BindingResult bindingResult) {
    	
        //ValidationUtils.invokeValidator(new RegisterUserValidator(), user, bindingResult);
        if (bindingResult.hasErrors()) {
        	LOG.error("Invalid request.....");
            throw new InvalidRequestException("Missing requied fields", bindingResult);
        }

        String feedbackURL = CommonUtils.getAppHostName(request) + AppConstants.ACTION_FEEDBACK;
        LOG.debug("User name: " + article.getName());
        article.setUsername(article.getName());
        Article registered = articleService.register(article, feedbackURL);
        LOG.debug("User has been registred with ID: " + registered.getUserUUID());

        Result result = new Result();
        result.setMessage("Check your mail for more information about Stride");
        result.setUserUUID(registered.getUserUUID());

        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }

}
