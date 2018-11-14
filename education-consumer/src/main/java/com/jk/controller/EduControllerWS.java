 package com.jk.controller;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.WSmodel;
import com.jk.service.IeduService;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：EduControllerWS    
 * 类描述：    
 * 创建人：王硕 3190552680@qq.com    
 * 创建时间：2018年10月29日 下午5:02:33    
 * 修改人：王硕 3190552680@qq.com  
 * 修改时间：2018年10月29日 下午5:02:33    
 * 修改备注：       
 * @version </pre>    
 */
 @Controller
 @RequestMapping("Wscon")
public class EduControllerWS {

	 @Autowired IeduService ieduService;
	 
	 public void test(){
		 
		 String ff = ieduService.test();
		 
		 System.out.println(ff);
	 }
	 
	 @RequestMapping("getLogin")
	 @ResponseBody
	 public String getLogin(@Param("username")String username,String userpassword,HttpServletRequest request){
		 
		 HashMap<String, Object> mmp = ieduService.getLogin(username,userpassword);
		 
		 
		 WSmodel object = (WSmodel) mmp.get("user");
		 request.getSession().setAttribute("login", object);
		 String flag = (String) mmp.get("n");
		 
		 return flag;
	 }
	 
	 @RequestMapping("hhhh")
	 @ResponseBody
	 public String hhhh(HttpServletRequest request){
		 
		 request.getSession().removeAttribute("Xsession");
		 request.getSession().removeAttribute("hhhh");
		 request.getSession().removeAttribute("hhh");
		 
		 return "哈哈哈";
	 }
	 
	 @RequestMapping("findclass")
	 @ResponseBody
	 public Map<String,Object> findclass(Integer pageSize,Integer start,String classroomname,String classroomproject){
		 
		 Map<String,Object> mmp = ieduService.findclass(pageSize,start,classroomname,classroomproject);
		 
		 return mmp;
	 }
	 
	 @RequestMapping("findclass1")
	 @ResponseBody
	 public Map<String,Object> findclass1(Integer pageSize,Integer start,String classroomname,String classroomproject,HttpServletRequest request){
		 
		 WSmodel attribute = (WSmodel) request.getSession().getAttribute("login");
		 String id = attribute.getTeacherid();
		 
		 Map<String,Object> mmp = ieduService.findclass1(pageSize,start,classroomname,classroomproject,id);
		 
		 return mmp;
	 }
	 
	 @RequestMapping("queryType")
	 @ResponseBody
	 public List queryType(){
		 
		 List list = ieduService.queryType();
		 
		 return list;
	 }
	 
	 @RequestMapping("delclass")
	 @ResponseBody
	 public String delclass(String classroomid){
		 
		 ieduService.delclass(classroomid);
		 
		 return "哈哈哈";
	 }
	 
	 @RequestMapping("updateclass")
	 @ResponseBody
	 public String updateclass(String classroomid){
		 
		 ieduService.updateclass(classroomid);
		 
		 return "哈哈哈";
	 }
	 
	 @RequestMapping("delclass2")
	 @ResponseBody
	 public String delclass2(String classroomid){
		 
		 ieduService.delclass2(classroomid);
		 
		 return "哈哈哈";
	 }
	 
	 @RequestMapping("updateclass2")
	 @ResponseBody
	 public String updateclass2(String classroomid){
		 
		 ieduService.updateclass2(classroomid);
		 
		 return "哈哈哈";
	 }
	 
}