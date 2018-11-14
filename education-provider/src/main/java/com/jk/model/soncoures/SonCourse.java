/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:SonCourse.java 
 * 包名:com.jk.model.soncoures 
 * 创建日期:2018年11月1日下午2:34:38 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.soncoures;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：SonCourse    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月1日 下午2:34:38    
 * 修改人：贺凯荣
 * 修改时间：2018年11月1日 下午2:34:38    
 * 修改备注：       
 * @version </pre>    
 */
public class SonCourse implements Serializable{
	
	private static final long serialVersionUID = 373532167179044912L;

	private String soncounrseid;
	
	private String soncoursename;
	
	private String soncoursestarttime;
	
	public String getSoncoursestarttime() {
		return soncoursestarttime;
	}

	public void setSoncoursestarttime(String soncoursestarttime) {
		this.soncoursestarttime = soncoursestarttime;
	}

	public String getSoncounrseid() {
		return soncounrseid;
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

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "SonCourse [soncounrseid=" + soncounrseid + ", soncoursename=" + soncoursename + "]";
	}
}
