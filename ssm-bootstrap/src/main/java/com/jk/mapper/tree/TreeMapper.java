/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:TreeMapper.java 
 * 包名:com.jk.mapper.tree 
 * 创建日期:2018年9月17日上午10:44:48 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.mapper.tree;

import java.util.List;

import com.jk.domain.tree.Tree;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：TreeMapper    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 上午10:44:48    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 上午10:44:48    
 * 修改备注：       
 * @version </pre>    
 */
public interface TreeMapper {

	/** <pre>recursionTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年9月17日 上午11:52:27    
	 * 修改人：贺凯荣
	 * 修改时间：2018年9月17日 上午11:52:27    
	 * 修改备注： 
	 * @param pid
	 * @return</pre>    
	 */
	List<Tree> recursionTree(String pid);

}
