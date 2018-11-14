/** 
 * <pre>项目名称:education-provider 
 * 文件名称:YunSchoolMapper.java 
 * 包名:com.jk.mapper.yunschool 
 * 创建日期:2018年10月30日下午3:32:59 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.mapper.yunschool;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.jk.model.yunschool.SonYunSchool;
import com.jk.model.Course;
import com.jk.model.SonCourse;
import com.jk.model.StuTree;
import com.jk.model.User;
import com.jk.model.helpteacher.HelpTeacher;
import com.jk.model.student.Student;
import com.jk.model.subject.Subject;
import com.jk.model.teacher.Teacher;
import com.jk.model.tree.Tree;
import com.jk.model.yunschool.Xilike;
import com.jk.model.yunschool.YunSchool;

/** 
 * <pre>项目名称：education-provider    
 * 类名称：YunSchoolMapper    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年10月30日 下午3:32:59    
 * 修改人：贺凯荣
 * 修改时间：2018年10月30日 下午3:32:59    
 * 修改备注：       
 * @version </pre>    
 */
public interface YunSchoolMapper {

	/** <pre>recursionTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月30日 下午3:39:37    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月30日 下午3:39:37    
	 * 修改备注： 
	 * @param pid
	 * @param userid 
	 * @return</pre>    
	 */
	List<Tree> recursionTree(@Param("pid")String pid, @Param("userid")String userid);

	/** <pre>addClassRoom(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月30日 下午10:36:14    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月30日 下午10:36:14    
	 * 修改备注： 
	 * @param yunschool</pre>    
	 */
	void addClassRoom(YunSchool yunschool);

	/** <pre>querySubjectList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:17:47    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:17:47    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Subject> querySubjectList();

	/** <pre>queryTeacherList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:17:51    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:17:51    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Teacher> queryTeacherList();

	/** <pre>queryHelpTeacherList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:17:54    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:17:54    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<HelpTeacher> queryHelpTeacherList();

	/** <pre>queryStudentList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:17:57    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:17:57    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Student> queryStudentList();

	/** <pre>myCloudSchool(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 下午8:21:36    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 下午8:21:36    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	List<YunSchool> myCloudSchool(YunSchool yunschool);

	/** <pre>queryYunSchoolById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 下午11:21:29    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 下午11:21:29    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	YunSchool queryYunSchoolById(YunSchool yunschool);

	/** <pre>queryYunSchoolPage(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月1日 上午10:28:51    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月1日 上午10:28:51    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<YunSchool> queryYunSchoolPage();
	
	/** <pre>queryMoreYunSchoolPage(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午4:09:38    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午4:09:38    
	 * 修改备注： 
	 * @param xilieke
	 * @return</pre>    
	 */
	List<Xilike> queryMoreYunSchoolPage(Xilike xilieke);

	/** <pre>queryzikechenglist(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午4:27:03    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午4:27:03    
	 * 修改备注： 
	 * @param sonyunschool
	 * @return</pre>    
	 */
	List<SonYunSchool> queryzikechenglist(@Param("sonyunschool")SonYunSchool sonyunschool);

	/** <pre>queryMoreYunSchoolById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午6:38:01    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午6:38:01    
	 * 修改备注： 
	 * @param xilieke
	 * @return</pre>    
	 */
	YunSchool queryMoreYunSchoolById(@Param("xilieke")Xilike xilieke);
	
	/** <pre>selectcourse(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 上午10:47:47    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 上午10:47:47    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Course> selectcourse(@Param("userid")String userid);

	/** <pre>getNode(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 下午4:07:07    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 下午4:07:07    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<StuTree> getNode(@Param("id")String id);

	/** <pre>selectTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月1日 下午5:50:07    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月1日 下午5:50:07    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<StuTree> selectTree();
	/** <pre>addclassstu(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月2日 上午11:27:57    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月2日 上午11:27:57    
	 * 修改备注： 
	 * @param uuidstring
	 * @param split 
	 * @param string</pre>    
	 */
	void addclassstu(@Param("uuidstring1")String uuidstring1, @Param("uuidstring")String uuidstring, @Param("split")String split);

	/** <pre>addstudent(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:12:44    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:12:44    
	 * 修改备注： 
	 * @param student</pre>    
	 */
	void addstudent(Student student);

	/** <pre>addteacher(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:12:47    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:12:47    
	 * 修改备注： 
	 * @param teacher</pre>    
	 */
	void addteacher(Teacher teacher);

	/** <pre>adduser(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月5日 下午4:12:55    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月5日 下午4:12:55    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void adduser(User user);

	/*
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月2日 下午7:38:01    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月2日 下午7:38:01    
	 * 修改备注： 
	 * @param studentid
	 * @return</pre>    
	 */
	List<Course> querycoursebystudentid(@Param("studentid")String studentid);

	/** <pre>queryUserEntityByuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月2日 下午7:38:05    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月2日 下午7:38:05    
	 * 修改备注： 
	 * @param userid
	 * @return</pre>    
	 */
	User queryUserEntityByuserid(@Param("userid")String userid);

	List<String> findChart();

	/** <pre>findUsrByName(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 上午11:37:07    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 上午11:37:07    
	 * 修改备注： 
	 * @param string
	 * @return</pre>    
	 */
	List<Course> findUsrByName(String username);

	/** <pre>queryCount(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午6:53:26    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午6:53:26    
	 * 修改备注： 
	 * @return</pre>    
	 */
	long queryCount();

	/** <pre>queryUser(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午6:54:18    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午6:54:18    
	 * 修改备注： 
	 * @param i
	 * @param rows
	 * @return</pre>    
	 */
	List<User> queryUser(@Param("start")Integer page, @Param("rows")Integer rows);

	/** <pre>deleteuserbyuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午8:27:06    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午8:27:06    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteuserbyuserid(@Param("userid")String id);

	/** <pre>queryserializeCount(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月6日 上午9:06:59    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月6日 上午9:06:59    
	 * 修改备注： 
	 * @param studentid 
	 * @return</pre>    
	 */
	long queryserializeCount(@Param("studentid")String studentid);

	/** <pre>querySerializecourse(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月6日 上午9:07:16    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月6日 上午9:07:16    
	 * 修改备注： 
	 * @param i
	 * @param rows
	 * @param studentid 
	 * @return</pre>    
	 */
	List<YunSchool> querySerializecourse(@Param("start")Integer  page, @Param("rows")Integer rows, @Param("studentid")String studentid);

	/** <pre>querycourseid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月6日 下午3:36:27    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月6日 下午3:36:27    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	List<SonCourse> querycourseid(@Param("id")String id);

	/** <pre>queryserializeCount1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午2:53:36    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午2:53:36    
	 * 修改备注： 
	 * @return</pre>    
	 */
	long queryserializeCount1();

	/** <pre>querySerializecourse1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午2:53:39    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午2:53:39    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>    
	 */
	List<YunSchool> querySerializecourse1(@Param("start")Integer  page, @Param("rows")Integer rows);

	/** <pre>queryserializeCount2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午4:51:30    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午4:51:30    
	 * 修改备注： 
	 * @param studentid
	 * @return</pre>    
	 */
	long queryserializeCount2(@Param("studentid")String studentid);

	/** <pre>querySerializecourse2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午4:51:34    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午4:51:34    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param studentid
	 * @return</pre>    
	 */
	List<YunSchool> querySerializecourse2(@Param("start")Integer  page, @Param("rows")Integer rows, @Param("studentid")String studentid);
	
	
}
