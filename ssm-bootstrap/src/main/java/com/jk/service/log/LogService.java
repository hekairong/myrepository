/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:LogService.java 
 * 包名:com.jk.service.log 
 * 创建日期:2018年9月17日下午8:39:17 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.log;

import java.text.ParseException;
import java.util.Map;

import com.jk.aop.LogInfo;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：LogService    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 下午8:39:17    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 下午8:39:17    
 * 修改备注：       
 * @version </pre>    
 */
public interface LogService {

	/** <pre>findLog(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年9月17日 下午8:52:54    
	 * 修改人：贺凯荣
	 * 修改时间：2018年9月17日 下午8:52:54    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param log
	 * @return</pre>    
	 */
	//查询日志
		 Map<String, Object> findLog(Integer pageSize, Integer start, LogInfo log) throws ParseException;

}
