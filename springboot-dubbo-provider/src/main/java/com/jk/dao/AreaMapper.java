/** 
 * <pre>项目名称:springboot-dubbo-provider 
 * 文件名称:AreaMapper.java 
 * 包名:com.jk.dao 
 * 创建日期:2018年11月13日下午4:22:11 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jk.model.TreeBean;
import com.jk.model.User;

/** 
 * <pre>项目名称：springboot-dubbo-provider    
 * 类名称：AreaMapper    
 * 类描述：    
 * 创建人： 任智伟
 * 创建时间：2018年11月13日 下午4:22:11    
 * 修改人： 任智伟  
 * 修改时间：2018年11月13日 下午4:22:11    
 * 修改备注：       
 * @version </pre>    
 */
@Mapper
public interface AreaMapper {

	/** <pre>getNodes(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月13日 下午6:46:27    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月13日 下午6:46:27    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	@Select("select id,href as url,text as text,pid from t_tree where pid=#{value}")
	List<TreeBean> getNodes(String id);

	/** <pre>queryUser(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月12日 下午7:20:53    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月12日 下午7:20:53    
	 * 修改备注： 
	 * @return</pre>    
	 */
	@Select(" select * from t_user ")
	List<User> queryUser();

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月12日 下午8:26:38    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月12日 下午8:26:38    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	@Insert(" insert into t_user(userid,username,userpwd,usertype,enabled,qq,email,userphone,loginnumber) "
			+ "values(#{userid},#{username},#{userpwd},#{usertype},#{enabled},#{qq},#{email},#{userphone},#{loginnumber})")
	void addUser(User user);

	/** <pre>updaUser(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月12日 下午8:28:12    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月12日 下午8:28:12    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	@Update(" update t_user set username=#{username},userpwd=#{userpwd},usertype=#{usertype},enabled=#{enabled},qq=#{qq},email=#{email},userphone=#{userphone},loginnumber=#{loginnumber}"
			+ " where userid=#{userid} ")
	void updaUser(User user);

	/** <pre>queryCarById(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月12日 下午8:49:24    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月12日 下午8:49:24    
	 * 修改备注： 
	 * @param userid</pre>    
	 * @return 
	 */
	@Select(" select * from t_user where userid= #{value} ")
	User queryCarById(String userid);

	/** <pre>delUser(这里用一句话描述这个方法的作用)   
	 * 创建人：任智伟
	 * 创建时间：2018年11月12日 下午8:59:03    
	 * 修改人：任智伟      
	 * 修改时间：2018年11月12日 下午8:59:03    
	 * 修改备注： 
	 * @param userid</pre>    
	 */
	@Delete(" delete from t_user where userid =#{value}") 
	void delUser(String userid);
		
}
