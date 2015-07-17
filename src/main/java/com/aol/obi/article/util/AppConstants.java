/*
 * AMERICA ONLINE CONFIDENTIAL INFORMATION
 *
 *
 * Copyright (c) 2014 AOL LLC
 *
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 *
 *
 */
package com.aol.obi.article.util;

/**
 *
 * @author jvaidy
 * @version 1.0
 * @since 04/28/2015
 */
public class AppConstants {

    public static final String SUCCESS = "success";
    public static final String ERROR   = "error";
    public static final String MESSAGE = "message";

    /**
     * *************************************************************************
     * MODEL OBJECT NAME
     * ************************************************************************
     */
    public static final String USER           = "user";
    public static final String RESTRICTIONS   = "restrictions";
    public static final String TIMEPERMISSION = "timePermission";
    public static final String APPBLOCKING    = "appBlocking";

    public static final String APPLICATION_USER = "PCONTROL";

    /**
     * *************************************************************************
     * VIEW PAGE MAPPINGS
     * ************************************************************************
     */
    public static final String VIEW_SIGNIN  = "signin";
    public static final String VIEW_SIGNOUT = "signout";
    public static final String VIEW_SINGUP  = "signup";
    public static final String VIEW_FAMILY_MANAGER       = "family_manager";
    public static final String VIEW_FAMILY_MEMBER_SETUP  = "family_member_setup";
    public static final String VIEW_DEVICE_CONFIGURATION = "device_configuration";
    public static final String VIEW_CONTECT_SUPPORT      = "contect_support";
    public static final String VIEW_ADVANCE_CONFIG       = "advance_config";
    public static final String VIEW_FEEDBACK      		 = "feedback";
    public static final String VIEW_CHANGE_PASSWORD		 = "change_password";
    
    /**
     * *************************************************************************
     * ACTION MAPPINGS
     * ************************************************************************
     */
    public static final String ACTION_ROOT                    = "/";
    public static final String ACTION_HOME                    = "home.do";
    public static final String ACTION_SIGNIN                  = "signin.do";
    public static final String ACTION_SIGNOUT                 = "signout.do";
    public static final String ACTION_SIGNUP                  = "signup.do";
    public static final String ACTION_MEMBER_SETUP            = "membersetup.do";
    public static final String ACTION_REGISTER                = "register.do";
    public static final String ACTION_MEMBER_RESTRICTIONS     = "restrictions.do";
    public static final String ACTION_MEMBER_TIME_PERMISSIONS = "time_permissions.do";
    public static final String ACTION_MEMBER_APP_BLOCKING     = "app_blocking.do";
    public static final String ACTION_FAMILY_MANAGER          = "family_manager.do";
    public static final String ACTION_DELETE_FAMILY_MANAGER   = "delete_member.do";
    public static final String ACTION_EDIT_FAMILY_MANAGER     = "edit_member.do";
    public static final String ACTION_DEVICE_CONFIGURATION    = "device_configuration.do";
    public static final String ACTION_CONTECT_SUPPORT         = "contect_support.do";
    public static final String ACTION_ADVANCE_CONFIG          = "advance_config.do";
    public static final String ACTION_DEVICE_CONFIG_MAIL      = "send_device_config_mail.do";
    public static final String ACTION_DEVICE_CONFIG_SMS       = "send_device_config_sms.do";
    public static final String ACTION_FEEDBACK                = "feedback.do";
    public static final String ACTION_CHANGE_PASSWORD         = "change_password.do";
    
    public static final String ENROLL_URL                     = "secure/api/enroll/%s?access_token=%s";
    public static final String AUTH_TOKEN_URL                 = "auth/token";

    public static final String BACKEND_SERVER_ERROR  = "Backend server error, Please try again!";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error, Please try again!";

    private static final String ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~-]";
    private static final String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)+";
    private static final String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
    public static final String EMAIL_PATTERN =  "^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$";
    //public static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public static final String PHONE_NUMBER_PATTERN =  "\\(\\d{3}\\)-\\d{3}-\\d{4}";
    //"\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"
}
