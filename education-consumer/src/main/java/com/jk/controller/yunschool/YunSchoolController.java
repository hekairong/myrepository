/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:YunSchoolController.java 
 * 包名:com.jk.controller.yunschool 
 * 创建日期:2018年10月30日下午2:56:18 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.yunschool;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.helpteacher.HelpTeacher;
import com.jk.model.student.Student;
import com.jk.model.subject.Subject;
import com.jk.model.teacher.Teacher;
import com.jk.model.tree.Tree;
import com.jk.model.yunschool.SonYunSchool;
import com.jk.model.yunschool.Xilike;
import com.jk.model.yunschool.YunSchool;
import com.jk.service.IeduService;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：YunSchoolController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年10月30日 下午2:56:18    
 * 修改人：贺凯荣
 * 修改时间：2018年10月30日 下午2:56:18    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("yunschool")
public class YunSchoolController {
	
	@Autowired IeduService ieduService;
	
	//查询老师权限
	@RequestMapping("queryTeacherTree")
	@ResponseBody
	public List<Tree> queryTeacherTree(String userid){
		List<Tree> list = ieduService.queryTeacherTree(userid);
		return list;
		
	}
	//查询系列课程
	@RequestMapping("queryMoreYunSchoolById")
	public String queryMoreYunSchoolById(Model model,Xilike xilieke){
		YunSchool moreyunschoollist = ieduService.queryMoreYunSchoolById(xilieke);
		model.addAttribute("hx", moreyunschoollist);
		return "WEB-INF/myCloudschool/morekechenginfo";
		
	}
	
	//查询子课程
	@RequestMapping("queryzikechenglist")
	@ResponseBody
	public HashMap<String, Object> queryzikechenglist(SonYunSchool sonyunschool){
		List<SonYunSchool> sonyunschoollist = ieduService.queryzikechenglist(sonyunschool);
		HashMap<String, Object> mmp = new HashMap<>();
		mmp.put("rows", sonyunschoollist);
		return mmp;
		
	}
	
	//添加课堂
	@RequestMapping("addClassRoom")
	@ResponseBody
	public String addClassRoom(YunSchool yunschool){
		ieduService.addClassRoom(yunschool);
		return "1";
		
	}
	
    //将数据先存入session中
	@RequestMapping("addsessionclassroom")
	public String addsessionclassroom(YunSchool yunschool,HttpServletRequest request){
		request.getSession().setAttribute("yunschool", yunschool);
		return "WEB-INF/myCloudschool/addmore";
		
	}
	
	//添加系列课程
	@RequestMapping("addMoreClassRoom")
	@ResponseBody
	public String addMoreClassRoom(YunSchool yunschool){
		ieduService.addMoreClassRoom(yunschool);
		return "1";
		
	}
	
	
	//查询学科
	@RequestMapping("querySubjectList")
	@ResponseBody
	public List<Subject> querySubjectList(){
		List<Subject> subjectlist = ieduService.querySubjectList();
		return subjectlist;
	}
	
	//查询老师
	@RequestMapping("queryTeacherList")
	@ResponseBody
	public List<Teacher> queryTeacherList(){
		List<Teacher> teacherlist = ieduService.queryTeacherList();
		return teacherlist;
		
	} 
	
	//查询助教
	@RequestMapping("queryHelpTeacherList")
	@ResponseBody
	public List<HelpTeacher> queryHelpTeacherList(){
		List<HelpTeacher> helpteacherlist = ieduService.queryHelpTeacherList();
		return helpteacherlist;
		
	}
	
	//查询学生
	@RequestMapping("queryStudentList")
	@ResponseBody
	public List<Student> queryStudentList(){
		List<Student> studentlist = ieduService.queryStudentList();
		return studentlist;
		
	}
	
	//我的云学堂
	@RequestMapping("myCloudSchool")
	@ResponseBody
	public List<YunSchool> myCloudSchool(YunSchool yunschool){
		List<YunSchool> mycloudschoollist = ieduService.myCloudSchool(yunschool);
		return mycloudschoollist;
	}
	
	//课程详情
	@RequestMapping("queryYunSchoolById")
	public String queryYunSchoolById(Model model,YunSchool yunschool){
		YunSchool yunschoollist = ieduService.queryYunSchoolById(yunschool);
		model.addAttribute("hx", yunschoollist);
		return "WEB-INF/myCloudschool/yunschoolInfoPage";
		
	}
	
	//进入直播
	@RequestMapping("zhibo")
	public String zhibo(Model model,String string){
		model.addAttribute("mvlist", string);
		return "WEB-INF/myCloudschool/mvlist";
	}
	
	
	
}
