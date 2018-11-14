/** 
 * <pre>项目名称:education-provider 
 * 文件名称:SonYunSchool.java 
 * 包名:com.jk.model.yunschool 
 * 创建日期:2018年11月2日上午11:58:39 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.yunschool;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-provider    
 * 类名称：SonYunSchool    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月2日 上午11:58:39    
 * 修改人：贺凯荣
 * 修改时间：2018年11月2日 上午11:58:39    
 * 修改备注：       
 * @version </pre>    
 */
public class SonYunSchool implements Serializable{
	
	private static final long serialVersionUID = -2215239215865681461L;

	private String classroomid;
	private String soncounrseid;
	
	private String soncoursename;
	
	private String soncoursestarttime;

	public String getSoncounrseid() {
		return soncounrseid;
	}

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public void setSoncounrseid(String soncounrseid) {
		this.soncounrseid = soncounrseid;
	}

	public String getSoncoursename() {
		return soncoursename;
	}

	public void setSoncoursename(String soncoursename) {
		this.soncoursename = soncoursename;
	}

	public String getSoncoursestarttime() {
		return soncoursestarttime;
	}

	public void setSoncoursestarttime(String soncoursestarttime) {
		this.soncoursestarttime = soncoursestarttime;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "SonYunSchool [soncounrseid=" + soncounrseid + ", soncoursename=" + soncoursename
				+ ", soncoursestarttime=" + soncoursestarttime + "]";
	}
}
