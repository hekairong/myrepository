/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:Teacher.java 
 * 包名:com.jk.model.teacher 
 * 创建日期:2018年10月31日上午10:02:00 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.teacher;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：Teacher    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年10月31日 上午10:02:00    
 * 修改人：贺凯荣
 * 修改时间：2018年10月31日 上午10:02:00    
 * 修改备注：       
 * @version </pre>    
 */
public class Teacher implements Serializable{

	private static final long serialVersionUID = 3965532879086123638L;
	
	private String teacherid;
	
	private String teachername;
	
	private String teacherpassword;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", teachername=" + teachername + ", teacherpassword="
				+ teacherpassword + "]";
	}
}
