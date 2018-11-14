/** 
 * <pre>项目名称:ssm-maven-hkr 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.jk.service.user 
 * 创建日期:2018年9月12日上午11:28:37 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.mapper.user.UserMapper;

/** 
 * <pre>项目名称：ssm-maven-hkr    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月12日 上午11:28:37    
 * 修改人：贺凯荣
 * 修改时间：2018年9月12日 上午11:28:37    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserSevice{
	
	@Autowired
	private UserMapper userMapper;

}
