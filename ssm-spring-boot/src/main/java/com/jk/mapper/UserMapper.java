/** 
 * <pre>项目名称:ssm-spring-boot 
 * 文件名称:UserMapper.java 
 * 包名:com.jk.mapper 
 * 创建日期:2018年11月12日下午3:01:27 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.mapper;

import java.util.List;

import com.jk.model.Tree;
import com.jk.model.User;

/** 
 * <pre>项目名称：ssm-spring-boot    
 * 类名称：UserMapper    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月12日 下午3:01:27    
 * 修改人：贺凯荣
 * 修改时间：2018年11月12日 下午3:01:27    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserMapper{

	/** <pre>queryUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:58:31    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:58:31    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> queryUserList();

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:58:42    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:58:42    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUser(User user);

	/** <pre>deleteUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:58:46    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:58:46    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteUser(String ids);

	/** <pre>queryUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:58:50    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:58:50    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	User queryUserById(User user);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:58:54    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:58:54    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUser(User user);

	/** <pre>recursionTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:59:29    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:59:29    
	 * 修改备注： 
	 * @param pid
	 * @return</pre>    
	 */
	List<Tree> recursionTree(String pid);

}
