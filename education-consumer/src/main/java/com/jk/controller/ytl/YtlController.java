/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:YtlController.java 
 * 包名:com.jk.controller.ytl 
 * 创建日期:2018年10月30日下午2:16:03 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.ytl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Course;
import com.jk.model.Org;
import com.jk.model.SonCourse;
import com.jk.model.StuTree;
import com.jk.model.User;
import com.jk.model.WSmodel;
import com.jk.model.student.Student;
import com.jk.model.teacher.Teacher;
import com.jk.model.yunschool.YunSchool;
import com.jk.service.IeduService;
import com.jk.util.StringUtil;
import com.jk.util.StringUtilEmpty;
import com.mongodb.gridfs.GridFSDBFile;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：YtlController    
 * 类描述：    
 * 创建人：杨同隆 565598097@qq.com    
 * 创建时间：2018年10月30日 下午2:16:03    
 * 修改人：杨同隆 565598097@qq.com  
 * 修改时间：2018年10月30日 下午2:16:03    
 * 修改备注：       
 * @version </pre>   
 *  
 */
@Controller
@RequestMapping("ytl")
public class YtlController {
    
	 @Autowired IeduService ieduService;
	
	 
	 @RequestMapping("deleteuserbyuserid")
	 @ResponseBody
	 public void deleteuserbyuserid(String id){
		 
		 ieduService.deleteuserbyuserid(id);
	 }
	 
	 @RequestMapping("tostu")
	 public String tostu(Model md,HttpServletRequest request){
		    WSmodel attribute = (WSmodel) request.getSession().getAttribute("login");
//		    System.out.println(attribute);
		    String studentid = attribute.getStudentid();
//		  String userid = request.getSession().getAttribute("login").toString();
//		    User userEntity=ieduService.queryUserEntityByuserid(userid);
			List<Course> clist = ieduService.querycoursebystudentid(studentid);
			md.addAttribute("list", clist);
		 return "ytl/front_student";
	 }
	 @RequestMapping("tochat")
	 public String tochat(){
		 
		 
		 return  "ytl/chat";
	 }
	 @RequestMapping("toshenpi")
	 public String toshenpi(){
		 
		 
		 return  "ytl/shenpi";
	 }
	 @RequestMapping("querySerializecourse")
	 @ResponseBody
	 public HashMap<String, Object> querySerializecourse(Integer page,Integer rows,HttpServletRequest request){
		 
			    WSmodel attribute = (WSmodel) request.getSession().getAttribute("login");
			    String studentid = attribute.getStudentid();
		 return  ieduService.querySerializecourse(page,rows,studentid);
	 }
	 @RequestMapping("querySerializecourse2")
	 @ResponseBody
	 public HashMap<String, Object> querySerializecourse2(Integer page,Integer rows,HttpServletRequest request){
		 
		 WSmodel attribute = (WSmodel) request.getSession().getAttribute("login");
		 String studentid = attribute.getTeacherid();
		 return  ieduService.querySerializecourse2(page,rows,studentid);
	 }
	 @RequestMapping("querySerializecourse1")
	 @ResponseBody
	 public HashMap<String, Object> querySerializecourse1(Integer page,Integer rows,HttpServletRequest request){
		 
		 return  ieduService.querySerializecourse1(page,rows);
	 }
	 @RequestMapping("queryUser")
	 @ResponseBody
	 public HashMap<String, Object> queryUser(Integer page,Integer rows){
		 
		  
		 return  ieduService.queryUser(page,rows);
	 }
	 @RequestMapping("uploadPhoto")
 	@ResponseBody
 	public String uploadPhoto(MultipartFile fileimg,HttpServletRequest req) throws Exception{
         //获取原文件名称
         String fileName = fileimg.getOriginalFilename();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         String folderPath = req.getSession().getServletContext().getRealPath("/")+
                 "upload/";
         File file = new File(folderPath);
//         该目录是否已经存在
         if(!file.exists()){
          //   创建文件夹
             file.mkdir();
         }
         String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
         FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
         fos.write(fileimg.getBytes());
         fos.flush();
         fos.close();
         return  "upload/"+onlyFileName;
 	}
	 
	 @RequestMapping("selectcourse")
	 @ResponseBody
	 public List<Course> selectcourse(String userid){
		 
		 return ieduService.selectcourse(userid);
	 }

	 @RequestMapping("tomain")
	 public String tomain(){
		 
		 
		 return "ytl/main";
	 }
	 @RequestMapping("toaddorg")
	 public String toaddorg(){
		 
		 
		 return "ytl/org_add";
	 }
	 @RequestMapping("todeatilstu")
	 public String todeatilstu(HttpServletRequest request,Model md){
		 
		   WSmodel attribute = (WSmodel) request.getSession().getAttribute("login");
//		    System.out.println(attribute);
		    String username = attribute.getUsername();
		    md.addAttribute("username", username);
		 return "ytl/detail_student";
	 }
	 @RequestMapping("toadduser")
	 public String toadduser(){
		 
		 
		 return "ytl/user_add";
	 }
	 @RequestMapping("selectTree")
	 @ResponseBody
	 public List<StuTree> selectTree(){
		 
		 
		 return ieduService.selectTree();
	 }
	 @RequestMapping("addorg")
	 @ResponseBody
	 public String addorg(Org org){
		 String id = StringUtil.getUUID();	
		 org.setOrgid(id);
		int n= ieduService.addorg(org);
		 return n+"";
	 }
	 @RequestMapping("adduser")
	 @ResponseBody
	 public String adduser(Student student,User user,Teacher teacher){
		
		 
		 if(StringUtilEmpty.isNotEmpty(student.getStudentname())){
			 String stuid = StringUtil.getUUID();
			 student.setStudentid(stuid);
			 ieduService.addstudent(student);
			 user.setStudentid(stuid);
			 String userid = StringUtil.getUUID();
			 user.setUserid(userid);
			 ieduService.adduser(user);
		 }
		 if(StringUtilEmpty.isNotEmpty(teacher.getTeachername())){
			 String teaid = StringUtil.getUUID();
			 teacher.setTeacherid(teaid);
			 ieduService.addteacher(teacher);
			 user.setTeacherid(teaid);
			 String userid = StringUtil.getUUID();
			 user.setUserid(userid);
			 ieduService.adduser(user);
		 }
		 return "1";
	 }
	 
	 @RequestMapping("querycoursebystudentid")
		public String querycoursebyuserid(Model model,String studentid){
			List<Course> clist = ieduService.querycoursebystudentid(studentid);
			model.addAttribute("list", clist);
			return "ytl/front_student";
	    }
	 @RequestMapping("querycoursebyid")
	 public String querycoursebyuserid(String id,Model model){
		 model.addAttribute("id", id);
		 return "ytl/son_course";
	 }
	 @RequestMapping("querycourseid")
	 @ResponseBody
	 public HashMap<String, Object> querycourseid(String id,Model model){
		 List<SonCourse> clist = ieduService.querycourseid(id);
		System.out.println(id);
		HashMap<String, Object> mmp = new HashMap<>();
		mmp.put("rows", clist);
		 return mmp;
	 }
//	 @RequestMapping("queryChart")
//		@ResponseBody
//		public  JSONObject  queryChart(HttpServletResponse response,HttpServletRequest request){
//			// 查询所有月份 去重
//			List<String> xlist=ieduService.findChart();
//			
//				JSONObject json=new JSONObject();
//			json.put("Xax", xlist);
//			//  查到所有用户
//			List<LinkedHashMap<String, Object>> findChartUser = ieduService.findChartUser();
//			json.put("userName", findChartUser);
//			
//			for (int i = 0; i < findChartUser.size(); i++) {
//				LinkedHashMap<String, Object> userName= findChartUser.get(i);
//				//查到用户对应的课程
//				List<Course> cou=ieduService.findUsrByName(userName.get("a").toString());
//				json.put("course  "+i, cou);
//			}
//		
//			return json;
//		}
	 
	 
/*	 
	 @RequestMapping("ImgUpload")
     @ResponseBody
     public HashMap<String, Object>  ImgUpload(@RequestParam(value="orgimg" ,required=true)MultipartFile file,
    		   HttpServletRequest request,HttpServletResponse response
    		 ){
    	 return ieduService.ImgUpload(file);
     }
     @RequestMapping("getImg")
     public void  getImg(String id,
    		 HttpServletRequest request,HttpServletResponse response
    		 ){
    	 GridFSDBFile file = ieduService.findImgById(id);
 		
 		try {         
 		if (file != null) {           
             OutputStream sos;
 			sos = response.getOutputStream();
             response.setContentType("application/octet-stream");  
             // 向客户端输出文件  
             file.writeTo(sos);    
             sos.flush();  
             sos.close();  
         }  
 		} catch (IOException e) {
 			e.printStackTrace();
 		} 
     }*/
	 
	 
}
