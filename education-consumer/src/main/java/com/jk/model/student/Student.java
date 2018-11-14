/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:Student.java 
 * 包名:com.jk.model.studnet 
 * 创建日期:2018年10月31日上午10:02:16 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.student;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：Student    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年10月31日 上午10:02:16    
 * 修改人：贺凯荣
 * 修改时间：2018年10月31日 上午10:02:16    
 * 修改备注：       
 * @version </pre>    
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 4499718687310839214L;

    private String studentid;
    
    private String studentname;
    
    private String studentpassword;
    
    private String studentaccount;
    
	public String getStudentaccount() {
		return studentaccount;
	}

	public void setStudentaccount(String studentaccount) {
		this.studentaccount = studentaccount;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentpassword="
				+ studentpassword + "]";
	}
    
    

}
