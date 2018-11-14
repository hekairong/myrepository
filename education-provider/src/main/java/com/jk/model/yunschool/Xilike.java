/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:Xilike.java 
 * 包名:com.jk.model.yunschool 
 * 创建日期:2018年11月6日下午3:42:44 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.yunschool;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：Xilike    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月6日 下午3:42:44    
 * 修改人：贺凯荣
 * 修改时间：2018年11月6日 下午3:42:44    
 * 修改备注：       
 * @version </pre>    
 */
public class Xilike implements Serializable{

	private static final long serialVersionUID = -3994673934405756515L;
	
	private String classroomid;
	
	private String classroomname;
	
	private String classroomgrade;
	
	private String classroomsubject;
	
	private String instructor;
	
	private String classroomstudent;
	
	private String specifyteacher;
	
	private String classroominfo;
	
	private String approvalstatus;
	
    private String teacherid;
	
	private String teachername;
	
    private String helpteacherid;
    
    private String classroomstarttime;
    
    private String coursename;
    
	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getClassroomstarttime() {
		return classroomstarttime;
	}

	public void setClassroomstarttime(String classroomstarttime) {
		this.classroomstarttime = classroomstarttime;
	}

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

	public String getHelpteacherid() {
		return helpteacherid;
	}

	public void setHelpteacherid(String helpteacherid) {
		this.helpteacherid = helpteacherid;
	}

	public String getHelpteachername() {
		return helpteachername;
	}

	public void setHelpteachername(String helpteachername) {
		this.helpteachername = helpteachername;
	}

	private String helpteachername;

	public String getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}

	public String getClassroomname() {
		return classroomname;
	}

	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}

	public String getClassroomgrade() {
		return classroomgrade;
	}

	public void setClassroomgrade(String classroomgrade) {
		this.classroomgrade = classroomgrade;
	}

	public String getClassroomsubject() {
		return classroomsubject;
	}

	public void setClassroomsubject(String classroomsubject) {
		this.classroomsubject = classroomsubject;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getClassroomstudent() {
		return classroomstudent;
	}

	public void setClassroomstudent(String classroomstudent) {
		this.classroomstudent = classroomstudent;
	}

	public String getSpecifyteacher() {
		return specifyteacher;
	}

	public void setSpecifyteacher(String specifyteacher) {
		this.specifyteacher = specifyteacher;
	}

	public String getClassroominfo() {
		return classroominfo;
	}

	public void setClassroominfo(String classroominfo) {
		this.classroominfo = classroominfo;
	}

	public String getApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(String approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Xilike [classroomid=" + classroomid + ", classroomname=" + classroomname + ", classroomgrade="
				+ classroomgrade + ", classroomsubject=" + classroomsubject + ", instructor=" + instructor
				+ ", classroomstudent=" + classroomstudent + ", specifyteacher=" + specifyteacher + ", classroominfo="
				+ classroominfo + ", approvalstatus=" + approvalstatus + ", teacherid=" + teacherid + ", teachername="
				+ teachername + ", helpteacherid=" + helpteacherid + ", helpteachername=" + helpteachername + "]";
	}
}
