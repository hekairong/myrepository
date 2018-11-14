/** 
 * <pre>项目名称:springboot01 
 * 文件名称:IndexController.java 
 * 包名:com.jk.controller 
 * 创建日期:2018年8月6日下午4:40:22 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <pre>项目名称：springboot01    
 * 类名称：IndexController    
 * 类描述：    
 * 创建人：蛋蛋    
 * 创建时间蛋蛋  
 * 修改时间：2018年8月6日 下午4:40:22    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	String toIndex(){
		return "index";
	}
	@RequestMapping("toList")
	String toList(){
		return "list";
	}
	@RequestMapping("toBrokeList")
	String toBrokeList(){
		return "showBroke";
	}
	/*@RequestMapping("update")
	String toUpdate(){
		return "update";
	}*/
}
