/** 
 * <pre>项目名称:springboot-dubbo-provider 
 * 文件名称:AreaServiceImpl.java 
 * 包名:com.jk.service 
 * 创建日期:2018年11月13日下午4:21:11 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;



import com.jk.dao.AreaMapper;
import com.jk.model.TreeBean;
import com.jk.model.User;



/** 
 * <pre>项目名称：springboot-dubbo-provider    
 * 类名称：AreaServiceImpl    
 * 类描述：    
 * 创建人： 任智伟
 * 创建时间：2018年11月13日 下午4:21:11    
 * 修改人： 任智伟  
 * 修改时间：2018年11月13日 下午4:21:11    
 * 修改备注：       
 * @version </pre>    
 */

public class AreaServiceImpl implements AreaService {

	
	@Resource
	private AreaMapper areamapper;

	/* (non-Javadoc)    
	 * @see com.jk.service.AreaService#getNavTree()    
	 */
	@Override
	public List<TreeBean> getNavTree() {
	

		String id = "0";
		
		List<TreeBean> nodes = getNodes(id);
		
		return nodes;
	}
	private List<TreeBean> getNodes(String id){
		List<TreeBean> ListNodes = areamapper.getNodes(id);
		
		for (TreeBean nav : ListNodes) {
			
			List<TreeBean> nodes = getNodes(nav.getId());
			
			if(nodes != null && nodes.size() > 0) {
				
				nav.setLeaf(false);
				nav.setSelectable(false);
				nav.setNodes(nodes);
				
			}else {
				
				nav.setLeaf(true);
				nav.setSelectable(true);
				
			}


		}
		
		return ListNodes;
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#queryUser()    
	 */
	@Override
	public List<User> queryUser() {
	
		return areamapper.queryUser();
	}
	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#addUser(com.jk.model.User)    
	 */
	@Override
	public void addUser(User user) {
		user.setUserid(UUID.randomUUID().toString().replaceAll("-", ""));
		areamapper.addUser(user);
	}
	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#updaUser(com.jk.model.User)    
	 */
	@Override
	public void updaUser(User user) {
		areamapper.updaUser(user);
	}
	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#queryCarById(java.lang.String)    
	 */
	@Override
	public User queryCarById(String userid) {
		
		return areamapper.queryCarById(userid);
	
	}
	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#delUser(java.lang.String)    
	 */
	@Override
	public void delUser(String userid) {
		
		areamapper.delUser(userid);
	}


	
	
	
	
}
