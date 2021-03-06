package com.jk.model;

import java.io.Serializable;

public class WSmodel implements Serializable{

	private static final long serialVersionUID = 2260813137612229795L;
	private String userid;
	private String username;
	private String userpassword;
	private String teacherid;
	private String studentid;
	private String powerid;
	private String cousrseid;
	private String coursename;
	private String classroomid;
	private String classroomname;
	private String classroomgrade;
	private String classroomstarttime;
	private String classroomsubject;
	private String instructor;
	private String classroomstudent;
	private String classroomteacher;
	private String classroominfo;
	private String approvalstatus;
	private String specifyteacher;
	
	public String getSpecifyteacher() {
		return specifyteacher;
	}
	public void setSpecifyteacher(String specifyteacher) {
		this.specifyteacher = specifyteacher;
	}
	public String getApprovalstatus() {
		return approvalstatus;
	}
	public void setApprovalstatus(String approvalstatus) {
		this.approvalstatus = approvalstatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getPowerid() {
		return powerid;
	}
	public void setPowerid(String powerid) {
		this.powerid = powerid;
	}
	public String getCousrseid() {
		return cousrseid;
	}
	public void setCousrseid(String cousrseid) {
		this.cousrseid = cousrseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
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
	public String getClassroomstarttime() {
		return classroomstarttime;
	}
	public void setClassroomstarttime(String classroomstarttime) {
		this.classroomstarttime = classroomstarttime;
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
	public String getClassroomteacher() {
		return classroomteacher;
	}
	public void setClassroomteacher(String classroomteacher) {
		this.classroomteacher = classroomteacher;
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
		return "WSmodel [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword
				+ ", teacherid=" + teacherid + ", studentid=" + studentid + ", powerid=" + powerid + ", cousrseid="
				+ cousrseid + ", coursename=" + coursename + ", classroomid=" + classroomid + ", classroomname="
				+ classroomname + ", classroomgrade=" + classroomgrade + ", classroomstarttime=" + classroomstarttime
				+ ", classroomsubject=" + classroomsubject + ", instructor=" + instructor + ", classroomstudent="
				+ classroomstudent + ", classroomteacher=" + classroomteacher + ", classroominfo=" + classroominfo
				+ ", approvalstatus=" + approvalstatus + ", specifyteacher=" + specifyteacher + "]";
	}
	
	
}
