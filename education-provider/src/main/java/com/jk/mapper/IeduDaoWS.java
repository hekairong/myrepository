/** 
 * <pre>项目名称:education-provider 
 * 文件名称:IeduDaoWS.java 
 * 包名:com.jk.mapper 
 * 创建日期:2018年10月29日下午4:43:50 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.model.WSmodel;
import com.jk.model.yunschool.YunSchool;
import com.jk.model.zwt.ZwtUser;

/** 
 * <pre>项目名称：education-provider    
 * 类名称：IeduDaoWS    
 * 类描述：    
 * 创建人：王硕 3190552680@qq.com    
 * 创建时间：2018年10月29日 下午4:43:50    
 * 修改人：王硕 3190552680@qq.com  
 * 修改时间：2018年10月29日 下午4:43:50    
 * 修改备注：       
 * @version </pre>    
 */
public interface IeduDaoWS {

	/** <pre>getLogin(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月30日 下午4:54:12    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月30日 下午4:54:12    
	 * 修改备注： 
	 * @param username
	 * @param userpassword
	 * @return</pre>    
	 */
	WSmodel getLogin(@Param("username")String username, @Param("userpassword")String userpassword);

	/** <pre>getLogin1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月30日 下午4:57:04    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月30日 下午4:57:04    
	 * 修改备注： 
	 * @param username
	 * @return</pre>    
	 */
	WSmodel getLogin1(@Param("username")String username);

	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月31日 下午2:12:52    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月31日 下午2:12:52    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List queryType();

	/** <pre>findclass(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月31日 下午8:16:44    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月31日 下午8:16:44    
	 * 修改备注： 
	 * @param classroomproject 
	 * @param classroomname 
	 * @return</pre>    
	 */
	List<WSmodel> findclass(@Param("pageSize")Integer pageSize, @Param("start")Integer start,@Param("classroomname")String classroomname, @Param("classroomproject")String classroomproject);

	/** <pre>findtotal(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月1日 上午10:28:49    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月1日 上午10:28:49    
	 * 修改备注： 
	 * @param classroomproject 
	 * @param classroomname 
	 * @return</pre>    
	 */
	Integer findtotal(@Param("classroomname")String classroomname, @Param("classroomproject")String classroomproject);

	/** <pre>deleteuserbyuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午7:36:39    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午7:36:39    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteuserbyuserid(@Param("id")String id);

	/** <pre>deleteuserbyid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午8:17:43    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午8:17:43    
	 * 修改备注： 
	 * @param id</pre>    
	 */

	/** <pre>updateclass(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月2日 下午8:47:29    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月2日 下午8:47:29    
	 * 修改备注： </pre>    
	 * @param classroomid 
	 */
	void updateclass(@Param("classroomid")String classroomid);

	/** <pre>delclass(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月2日 下午8:47:35    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月2日 下午8:47:35    
	 * 修改备注： </pre>    
	 * @param classroomid 
	 */
	void delclass(@Param("classroomid")String classroomid);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:10:34    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:10:34    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	Long queryUserCount(@Param("user")ZwtUser user);

	/** <pre>queryUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:10:42    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:10:42    
	 * 修改备注： 
	 * @param user
	 * @param offset
	 * @param limit
	 * @return</pre>    
	 */
	List<ZwtUser> queryUserList(@Param("user")ZwtUser user, @Param("offset")Integer offset, @Param("limit")Integer limit);

	/** <pre>queryOneUser(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:10:45    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:10:45    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	ZwtUser queryOneUser(@Param("user")ZwtUser user);

	/** <pre>deleteUser(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:10:53    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:10:53    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void deleteUser(@Param("userid")String string);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午9:26:19    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午9:26:19    
	 * 修改备注： 
	 * @param powerid
	 * @param userid
	 * @param username
	 * @param username2
	 * @param userpassword</pre>    
	 */
	void updateUser(@Param("powerid")String powerid, @Param("userid")String userid, @Param("username")String username, @Param("userpassword")String userpassword);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:11:01    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:11:01    
	 * 修改备注： 
	 * @param user</pre>    
	 */
    //查询全部的课程
	List<YunSchool> queryKeCheng(@Param("subject")YunSchool subject);
   //报表
	List<LinkedHashMap<String, Object>> findChartUser();
	List<String> findUsrByName(@Param("name")String string);
	List<String> findChart();

	/** <pre>addMoreClassRoom(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月6日 上午11:26:38    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月6日 上午11:26:38    
	 * 修改备注： 
	 * @param string1
	 * @param yunschool</pre>    
	 */
	void addMoreClassRoom(@Param("string1")String string1, @Param("yunschool")YunSchool yunschool);

	/** <pre>addMoreClassRoom2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月6日 上午11:26:43    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月6日 上午11:26:43    
	 * 修改备注： 
	 * @param string2
	 * @param soncoursename
	 * @param soncourseendtime 
	 * @param string 
	 * @param soncoursestarttime</pre>    
	 */
	void addMoreClassRoom2(@Param("string2")String string2,@Param("string1")String string1,  @Param("soncoursename")String soncoursename, @Param("soncoursestarttime")String soncoursestarttime, @Param("soncourseendtime")String soncourseendtime);

	/** <pre>delclass2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午1:59:13    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午1:59:13    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void delclass2(String classroomid);

	/** <pre>updateclass2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午1:59:19    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午1:59:19    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void updateclass2(String classroomid);

	/** <pre>findtotal1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午3:16:47    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午3:16:47    
	 * 修改备注： 
	 * @param classroomname
	 * @param classroomproject
	 * @param id
	 * @return</pre>    
	 */
	Integer findtotal1(@Param("classroomname")String classroomname, @Param("classroomproject")String classroomproject, @Param("id")String id);

	/** <pre>findclass1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午3:16:51    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午3:16:51    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param classroomname
	 * @param classroomproject
	 * @param id
	 * @return</pre>    
	 */
	List<WSmodel> findclass1(@Param("pageSize")Integer pageSize, @Param("start")Integer start,@Param("classroomname")String classroomname, @Param("classroomproject")String classroomproject, @Param("id")String id);
    
}
