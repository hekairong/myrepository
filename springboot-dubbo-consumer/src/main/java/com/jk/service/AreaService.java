/** 
 * <pre>项目名称:springboot-dubbo-consumer 
 * 文件名称:AreaService.java 
 * 包名:com.jk.service 
 * 创建日期:2018年11月13日下午5:04:09 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;

import com.jk.model.TreeBean;
import com.jk.model.User;

/** 
 * <pre>项目名称：springboot-dubbo-consumer    
 * 类名称：AreaService    
 * 类描述：    
 * 创建人： 贺凯荣
 * 创建时间：2018年11月13日 下午5:04:09    
 * 修改人： 贺凯荣  
 * 修改时间：2018年11月13日 下午5:04:09    
 * 修改备注：       
 * @version </pre>    
 */
public interface AreaService {

	/** <pre>getNavTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:45:12    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:45:12    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<TreeBean> getNavTree();

	/** <pre>queryUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:58:50    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:58:50    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> queryUser();

	/** <pre>queryCarById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:58:58    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:58:58    
	 * 修改备注： 
	 * @param userid
	 * @return</pre>    
	 */
	User queryCarById(String userid);

	/** <pre>updaUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:59:04    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:59:04    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updaUser(User user);

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:59:09    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:59:09    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUser(User user);

	/** <pre>delUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午6:59:14    
	 * 修改人：贺凯荣      
	 * 修改时间：2018年11月13日 下午6:59:14    
	 * 修改备注： 
	 * @param userid</pre>    
	 */
	void delUser(String userid);

	
	
}
