/** 
 * <pre>项目名称:com.jk.2 
 * 文件名称:Interceptor.java 
 * 包名:com.jk.interceptor 
 * 创建日期:2018年7月11日下午4:35:37 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jk.domain.user.User;





/** 
 * <pre>项目名称：com.jk.2    
 * 类名称：Interceptor    
 * 类描述：    
 * 创建人：付换龙 fhl_java@126.com    
 * 创建时间：2018年7月11日 下午4:35:37    
 * 修改人：付换龙 fhl_java@126.com  
 * 修改时间：2018年7月11日 下午4:35:37    
 * 修改备注：       
 * @version </pre>    
 */
public class Interceptor implements HandlerInterceptor{


	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	
		
	}

	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		
		User uu=(User) request.getSession().getAttribute("userInfo");
		
		if(uu != null ){
			System.out.println("11111111111111");
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/");
		
		System.out.println("222222222222");
		return false;
	}
	
	
	
	

}
