/** 
 * <pre>项目名称:ssm-spring-boot 
 * 文件名称:UserService.java 
 * 包名:com.jk.service 
 * 创建日期:2018年11月12日下午7:21:34 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.model.BookBean;
import com.jk.model.Tree;
import com.jk.model.User;

/** 
 * <pre>项目名称：ssm-spring-boot    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月12日 下午7:21:34    
 * 修改人：贺凯荣
 * 修改时间：2018年11月12日 下午7:21:34    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserService {

	/** <pre>queryUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:22:13    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:22:13    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> queryUserList();

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:22:19    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:22:19    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUser(User user);

	/** <pre>deleteUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:22:22    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:22:22    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteUser(String ids);

	/** <pre>queryUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:22:25    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:22:25    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	User queryUserById(User user);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:22:27    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:22:27    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUser(User user);

	/** <pre>queryTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午7:57:59    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午7:57:59    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Tree> queryTreeList();

	/** <pre>queryBookList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午8:00:32    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月13日 下午8:00:32    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param bookBean
	 * @return</pre>    
	 */
	Map<String, Object> queryBookList(Integer pageSize, Integer start, BookBean bookBean);

	/** <pre>delbook(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午8:00:37    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月13日 下午8:00:37    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void delbook(String id);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午8:00:49    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月13日 下午8:00:49    
	 * 修改备注： 
	 * @param bookBean</pre>    
	 */
	void updateUser(BookBean bookBean);

	/** <pre>queryBookById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午8:00:53    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月13日 下午8:00:53    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	BookBean queryBookById(String id);
	
	/** <pre>queryBookById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月13日 下午8:00:53    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月13日 下午8:00:53    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	void addBook(HashMap<String, Object> hashMap);

}
