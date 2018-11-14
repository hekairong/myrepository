/** 
 * <pre>项目名称:ssm-hkr 
 * 文件名称:User.java 
 * 包名:com.jk.domain.user 
 * 创建日期:2018年9月1日上午9:45:51 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.domain.user;

import java.io.Serializable;

/** 
 * <pre>项目名称：ssm-hkr    
 * 类名称：User    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月1日 上午9:45:51    
 * 修改人：贺凯荣
 * 修改时间：2018年9月1日 上午9:45:51    
 * 修改备注：       
 * @version </pre>    
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 5720444208070394835L;

	private String id;
	
	private String name;
	
	private Integer sex;
	
	private Integer age;
	
	private String birthday;
	
	private Integer userstatus;
	
	private String loginname;
	
	private String userpwd;
	
	private String startDate;
	
	private String endDate;
	
	private String phone;
	
	private String email;
	
	//用户输入验证码
    private String imgCode;
		
	//系统验证码
	private String sysImgCode;
	
	private String userinfo;
	
	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getSysImgCode() {
		return sysImgCode;
	}

	public void setSysImgCode(String sysImgCode) {
		this.sysImgCode = sysImgCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", birthday=" + birthday
				+ ", userstatus=" + userstatus + ", loginname=" + loginname + ", userpwd=" + userpwd + ", startDate="
				+ startDate + ", endDate=" + endDate + ", phone=" + phone + ", email=" + email + ", imgCode=" + imgCode
				+ ", sysImgCode=" + sysImgCode + ", userinfo=" + userinfo + "]";
	}
	
	

}
