/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:Index.java 
 * 包名:com.jk.controller.index 
 * 创建日期:2018年9月17日下午7:10:20 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：IndexController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 下午7:10:20    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 下午7:10:20    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("index")
public class IndexController {
	
	//查询log
	@RequestMapping("tofindlog")
	public String tofindlog(){
		return "loglist";
	}
}
