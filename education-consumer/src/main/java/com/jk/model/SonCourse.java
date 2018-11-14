/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:SonCourse.java 
 * 包名:com.jk.model 
 * 创建日期:2018年11月6日下午4:09:24 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：SonCourse    
 * 类描述：    
 * 创建人：杨同隆 565598097@qq.com    
 * 创建时间：2018年11月6日 下午4:09:24    
 * 修改人：杨同隆 565598097@qq.com  
 * 修改时间：2018年11月6日 下午4:09:24    
 * 修改备注：       
 * @version </pre>    
 */
public class SonCourse implements Serializable{

	
	private  String soncounrseid;
	private  String parentclassroomid;
	private  String soncoursename;
	private  String soncoursestarttime;
	private  String soncourseendtime;
	public String getSoncounrseid() {
		return soncounrseid;
	}
	public void setSoncounrseid(String soncounrseid) {
		this.soncounrseid = soncounrseid;
	}
	public String getParentclassroomid() {
		return parentclassroomid;
	}
	public void setParentclassroomid(String parentclassroomid) {
		this.parentclassroomid = parentclassroomid;
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
	public String getSoncourseendtime() {
		return soncourseendtime;
	}
	public void setSoncourseendtime(String soncourseendtime) {
		this.soncourseendtime = soncourseendtime;
	}
	   
	/**    
	 * <pre>创建一个新的实例 SonCourse.    
	 *    
	 * @param soncounrseid
	 * @param parentclassroomid
	 * @param soncoursename
	 * @param soncoursestarttime
	 * @param soncourseendtime</pre>    
	 */
	public SonCourse(String soncounrseid, String parentclassroomid, String soncoursename, String soncoursestarttime,
			String soncourseendtime) {
		super();
		this.soncounrseid = soncounrseid;
		this.parentclassroomid = parentclassroomid;
		this.soncoursename = soncoursename;
		this.soncoursestarttime = soncoursestarttime;
		this.soncourseendtime = soncourseendtime;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "SonCourse [soncounrseid=" + soncounrseid + ", parentclassroomid=" + parentclassroomid
				+ ", soncoursename=" + soncoursename + ", soncoursestarttime=" + soncoursestarttime
				+ ", soncourseendtime=" + soncourseendtime + "]";
	}
	   
	/**    
	 * <pre>创建一个新的实例 SonCourse.    
	 *    </pre>    
	 */
	public SonCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
