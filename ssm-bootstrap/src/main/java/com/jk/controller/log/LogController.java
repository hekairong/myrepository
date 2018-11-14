/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:LogController.java 
 * 包名:com.jk.controller.log 
 * 创建日期:2018年9月17日下午8:38:12 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.log;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.aop.LogInfo;
import com.jk.service.log.LogService;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：LogController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 下午8:38:12    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 下午8:38:12    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	//查询日志
	@RequestMapping("findLog")
	@ResponseBody
	public Map<String, Object>  findLog(Integer pageSize ,Integer start,LogInfo log){
		
		try {
             return   logService.findLog(pageSize,start,log);
		} catch (ParseException e) {
			e.printStackTrace();
			//  mongodb 记录错误日志
			return null;
		}
		
	}

}
