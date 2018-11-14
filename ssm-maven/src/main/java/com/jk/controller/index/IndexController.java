/** 
 * <pre>项目名称:ssm-hkr 
 * 文件名称:IndexController.java 
 * 包名:com.jk.controller.index 
 * 创建日期:2018年9月1日上午10:40:35 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <pre>项目名称：ssm-hkr    
 * 类名称：IndexController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月1日 上午10:40:35    
 * 修改人：贺凯荣
 * 修改时间：2018年9月1日 上午10:40:35    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("index")
public class IndexController {
	
	//用户列表页面
	@RequestMapping("touserlist")
	String touserlist(){
		return "WEB-INF/user/userlist";
		
	}
	
	//用户新增页面
	@RequestMapping("toadduserpage")
	public String toadduserpage(){
		return "WEB-INF/user/adduser";
		
	}
	
}
