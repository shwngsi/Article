package com.aol.obi.article.dto;

import java.security.Principal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * User model object and security principal.
 */
@JsonInclude(Include.NON_NULL)
@ApiModel(value = "User")
public class Article implements Principal {

	@JsonIgnore
	@ApiModelProperty(value = "userUUID", hidden = true)
    private String userUUID;

	@JsonProperty(index=1)
    @ApiModelProperty(value = "username", required = true, position = 1, notes="Username used to authenticate client (min = 6, max = 255)")
    private String username;

	@JsonProperty(index=2)
    @ApiModelProperty(value = "password", required = true, position = 2, notes="User password used to login into application (min = 6, max = 50)")
    private String password;

	@JsonProperty(index=3)
    @ApiModelProperty(value = "firstName", required = true, position = 3, notes="User firstname. (min = 3, max = 60)")
    private String firstName;

	@JsonProperty(index=4)
    @ApiModelProperty(value = "lastName", required = true, position = 4, notes="User lastname. (min = 3, max = 60)")
    private String lastName;

	@JsonProperty(index=5)
    @ApiModelProperty(value = "email", required = true, position = 5, notes="User email address")
    private String email;

	@JsonProperty(index=6)
    @ApiModelProperty(value = "pin", required = true, position = 6, notes="User PIN. (min = 4, max = 10)")
    private String pin;

    @JsonIgnore
	@ApiModelProperty(value = "active", hidden = true)
    private boolean active;
	
    @JsonIgnore
	@ApiModelProperty(value = "createdDate", hidden = true)
    private Date createdDate;
    
    @JsonIgnore
	@ApiModelProperty(value = "createdBy", hidden = true)
	private String createdBy;
	
    @JsonIgnore
	@ApiModelProperty(value = "lastUpdatedDate", hidden = true)
    private Date lastUpdatedDate;
	
    @JsonIgnore
	@ApiModelProperty(value = "lastUpdatedBy", hidden = true)
    private String lastUpdatedBy;
	
    @JsonIgnore
	@ApiModelProperty(value = "updatedDesc", hidden = true)
    private String updatedDesc;

    public Article() {
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return (createdDate != null) ? (Date) createdDate.clone() : null;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? (Date) createdDate.clone() : null;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdatedDate() {
        return (lastUpdatedDate != null) ? (Date) lastUpdatedDate.clone() : null;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = (lastUpdatedDate != null) ? (Date) lastUpdatedDate.clone() : null;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getUpdatedDesc() {
        return updatedDesc;
    }

    public void setUpdatedDesc(String updatedDesc) {
        this.updatedDesc = updatedDesc;
    }


    @Override
    public String getName() {
        return username;
    }
}
