/** 
 * <pre>项目名称:springboot-dubbo-consumer 
 * 文件名称:AreaController.java 
 * 包名:com.jk.controller 
 * 创建日期:2018年11月13日下午5:03:25 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.AreaService;

/** 
 * <pre>项目名称：springboot-dubbo-consumer    
 * 类名称：AreaController    
 * 类描述：    
 * 创建人： 贺凯荣
 * 创建时间：2018年11月13日 下午5:03:25    
 * 修改人： 贺凯荣  
 * 修改时间：2018年11月13日 下午5:03:25    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("area")
public class AreaController {

	@Resource
	private AreaService areaService;
	
	
	  @RequestMapping("toIndexPage")
		String toIndexPage(){
			return "index";
		  
	  }
	  
		//(查询树)
		@RequestMapping("getNavTree")
		@ResponseBody
		List<TreeBean> getNavTree(){
			return areaService.getNavTree();
		}
	
		

		@RequestMapping("toListPage")
		String toListPage(){
			return "WEB-INF/user/list";
			
		}
		
		@RequestMapping("queryUser")
		@ResponseBody
		List<User> queryUser(){
			return areaService.queryUser();
		}
		
		
		@RequestMapping("tomongodialog")
		String tomongodialog(String userid,Model model){
			if(userid.equals("undefined")){
				
				return "WEB-INF/user/adduserPage";
				
			}else{
				
				
			User c =	areaService.queryCarById(userid);
			model.addAttribute("c", c);
			return "WEB-INF/user/adduserPage";
			}

		}
		////////////////
		@RequestMapping("addUser")
		@ResponseBody
		void addUser(User user){
		if(user.getUserid().equals("")){
			
			areaService.addUser(user);
			
		}else{
			
			areaService.updaUser(user);
			
		}

			
		}
		@RequestMapping("delUser")
		@ResponseBody	
		String delUser(String userid){
			areaService.delUser(userid);
			return "{}";
			
			
		}
		
		
}
