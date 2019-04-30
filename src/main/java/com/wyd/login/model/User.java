package com.wyd.login.model;

import java.util.Date;

public class User {
    private Integer id;

    private String loginId;

    private String passward;
    
    private String userName;

    private String sex;

    private String age;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private String isDeleted;

    private String phoneNumber;

    private String address;
    
    private Date birthday;
    
    
    

    /** 
	* 获取passward 
	* @return passward
	*/
	public String getPassward() {
		return passward;
	}

	/** 
	* 设置passward 
	* @param passward 
	*/
	public void setPassward(String passward) {
		this.passward = passward;
	}

	/** 
	* 获取birthday 
	* @return birthday
	*/
	public Date getBirthday() {
		return birthday;
	}

	/** 
	* 设置birthday 
	* @param birthday 
	*/
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}