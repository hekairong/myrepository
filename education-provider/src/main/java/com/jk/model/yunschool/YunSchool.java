/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:YunSchool.java 
 * 包名:com.jk.model.yunschool 
 * 创建日期:2018年10月30日下午3:05:07 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model.yunschool;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：YunSchool    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年10月30日 下午3:05:07    
 * 修改人：贺凯荣
 * 修改时间：2018年10月30日 下午3:05:07    
 * 修改备注：       
 * @version </pre>    
 */
public class YunSchool implements Serializable{
	
	private static final long serialVersionUID = -3775217775771239954L;

	private String classroomid;
	
	private String classroomname;
	
	private String classroomgrade;
	
	private String classroomsubject;
	private String classroomsubject1;
	
	private String instructor;
	
	private String classroomstudent;
	
    private String specifyteacher;
    
    private String classroominfo;
    private String tname;
    
    private String classroomstarttime;
    
    private String classroomendtime;
    
    private String approvalstatus;
    
    private String teachername;
    
    private String coursename;
    
    private String soncoursename;
    
    private String soncoursestarttime;
    private String soncourseendtime;
    
	private String  teacherid;
	private String helpteachername;
	
    public String getHelpteachername() {
		return helpteachername;
	}

	public void setHelpteachername(String helpteachername) {
		this.helpteachername = helpteachername;
	}

	public String getClassroomsubject1() {
		return classroomsubject1;
	}

	public void setClassroomsubject1(String classroomsubject1) {
		this.classroomsubject1 = classroomsubject1;
	}

	public String getSoncourseendtime() {
		return soncourseendtime;
	}

	public void setSoncourseendtime(String soncourseendtime) {
		this.soncourseendtime = soncourseendtime;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
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

	private List<YunSchool> format;
    
	public List<YunSchool> getFormat() {
		return format;
	}

	public void setFormat(List<YunSchool> format) {
		this.format = format;
	}
	public String getClassroomendtime() {
		return classroomendtime;
	}

	
	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setClassroomendtime(String classroomendtime) {
		this.classroomendtime = classroomendtime;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(String approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	public String getClassroomstarttime() {
		return classroomstarttime;
	}

	public void setClassroomstarttime(String classroomstarttime) {
		this.classroomstarttime = classroomstarttime;
	}

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

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "YunSchool [classroomid=" + classroomid + ", classroomname=" + classroomname + ", classroomgrade="
				+ classroomgrade + ", classroomsubject=" + classroomsubject + ", instructor=" + instructor
				+ ", classroomstudent=" + classroomstudent + ", specifyteacher=" + specifyteacher + ", classroominfo="
				+ classroominfo + "]";
	}
    
    
}
