/** 
 * <pre>项目名称:ssm-spring-boot 
 * 文件名称:User.java 
 * 包名:com.jk.model 
 * 创建日期:2018年11月12日下午3:00:50 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;


/** 
 * <pre>项目名称：ssm-spring-boot    
 * 类名称：User    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月12日 下午3:00:50    
 * 修改人：贺凯荣
 * 修改时间：2018年11月12日 下午3:00:50    
 * 修改备注：       
 * @version </pre>    
 */
public class User {
	private String id;
	
	private String username;
	
    private String userpassword;
    
    private String usertype;
    
    private String qq;
    
    private String email;
    
    private String tel;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userpassword=" + userpassword + ", usertype=" + usertype
				+ ", qq=" + qq + ", email=" + email + ", tel=" + tel + "]";
	}
    
}
