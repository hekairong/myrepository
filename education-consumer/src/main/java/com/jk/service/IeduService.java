package com.jk.service;

import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.tree.Tree;
import com.jk.model.Course;
import com.jk.model.Org;
import com.jk.model.SonCourse;
import com.jk.model.StuTree;
import com.jk.model.User;
import com.jk.model.files.File;
import com.jk.model.helpteacher.HelpTeacher;
import com.jk.model.student.Student;
import com.jk.model.subject.Subject;
import com.jk.model.teacher.Teacher;
import com.jk.model.tree.Tree;
import com.jk.model.yunschool.SonYunSchool;
import com.jk.model.yunschool.Xilike;
import com.jk.model.yunschool.YunSchool;
import com.jk.model.zwt.ZwtUser;
import com.mongodb.gridfs.GridFSDBFile;
/** 
 * <pre>项目名称：education-provider    
 * 类名称：IeduServiceWS    
 * 类描述：    
 * 创建人：王硕 3190552680@qq.com    
 * 创建时间：2018年10月29日 下午4:39:35    
 * 修改人：王硕 3190552680@qq.com  
 * 修改时间：2018年10月29日 下午4:39:35    
 * 修改备注：       
 * @version </pre>    
 */
public interface IeduService {

	/** <pre>test(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月29日 下午7:51:50    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月29日 下午7:51:50    
	 * 修改备注： 
	 * @return</pre>    
	 */
	String test();
	/** <pre>getLogin(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月30日 下午4:44:48    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月30日 下午4:44:48    
	 * 修改备注： 
	 * @param username
	 * @param userpassword
	 * @param request 
	 * @return</pre>    
	 */
	HashMap<String, Object> getLogin(String username, String userpassword);
	
	/** <pre>queryTeacherTree(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月30日 下午3:27:35    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月30日 下午3:27:35    
	 * 修改备注： 
	 * @param userid 
	 * @return</pre>    
	 */
	List<Tree> queryTeacherTree(String userid);
	
	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年10月31日 下午2:11:34    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年10月31日 下午2:11:34    
	 * 修改备注： 
	 * @param classroomproject 
	 * @param classroomname 
	 * @return</pre>    
	 */
	Map<String, Object> findclass(Integer pageSize, Integer start, String classroomname, String classroomproject);
	/** <pre>selectcourse(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 上午10:45:35    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 上午10:45:35    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Course> selectcourse(String userid);

	/** <pre>addClassRoom(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月30日 下午10:34:39    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月30日 下午10:34:39    
	 * 修改备注： 
	 * @param yunschool</pre>    
	 */
	void addClassRoom(YunSchool yunschool);

	/** <pre>querySubjectList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:15:27    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:15:27    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Subject> querySubjectList();

	/** <pre>queryTeacherList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:15:31    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:15:31    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Teacher> queryTeacherList();

	/** <pre>queryHelpTeacherList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:15:34    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:15:34    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<HelpTeacher> queryHelpTeacherList();

	/** <pre>queryStudentList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 上午10:15:38    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 上午10:15:38    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Student> queryStudentList();

	/** <pre>myCloudSchool(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 下午8:16:38    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 下午8:16:38    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	List<YunSchool> myCloudSchool(YunSchool yunschool);

	/** <pre>queryYunSchoolById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年10月31日 下午11:18:34    
	 * 修改人：贺凯荣
	 * 修改时间：2018年10月31日 下午11:18:34    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	YunSchool queryYunSchoolById(YunSchool yunschool);

	/** <pre>queryYunSchoolPage(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月1日 上午10:27:09    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月1日 上午10:27:09    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	List<YunSchool> queryYunSchoolPage(YunSchool yunschool);

	/** <pre>selectTree(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 下午4:58:40    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 下午4:58:40    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<StuTree> selectTree();
	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月1日 下午7:44:46    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月1日 下午7:44:46    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List queryType();
	/** <pre>ImgUpload(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 下午11:17:09    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 下午11:17:09    
	 * 修改备注： 
	 * @param file
	 * @return</pre>    
	 */
/*	HashMap<String, Object> ImgUpload(MultipartFile file);*/
	/** <pre>findImgById(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 下午11:17:17    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 下午11:17:17    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
/*	GridFSDBFile findImgById(String id);*/
	/** <pre>addorg(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月1日 下午1:40:17    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月1日 下午1:40:17    
	 * 修改备注： 
	 * @param org
	 * @return</pre>    
	 */
	int addorg(Org org);
	/** <pre>addstudent(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月1日 下午2:11:15    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月1日 下午2:11:15    
	 * 修改备注： 
	 * @param student</pre>    
	 */
	void addstudent(Student student);
	void addteacher(Teacher teacher);
	/** <pre>adduser(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月1日 下午2:14:38    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月1日 下午2:14:38    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void adduser(User user);

	/** <pre>selectTree(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年10月31日 下午4:01:19    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年10月31日 下午4:01:19    
	 * 修改备注： 
	 * @return</pre>    
	 */
	
	
	
	/** <pre>queryUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：张文韬
	 * 创建时间：2018年10月31日 下午8:38:17    
	 * 修改人：张文韬
	 * 修改时间：2018年10月31日 下午8:38:17    
	 * 修改备注： 
	 * @param user
	 * @param offset
	 * @param limit
	 * @return</pre>    
	 */
	JSONObject queryUserList(ZwtUser user, Integer offset, Integer limit);

	/** <pre>queryOneUser(这里用一句话描述这个方法的作用)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月1日 下午4:04:54    
	 * 修改人：张文韬
	 * 修改时间：2018年11月1日 下午4:04:54    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	ZwtUser queryOneUser(ZwtUser user);

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月1日 下午4:10:16    
	 * 修改人：张文韬
	 * 修改时间：2018年11月1日 下午4:10:16    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUser(ZwtUser user);

	/** <pre>deleteUser(这里用一句话描述这个方法的作用)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月1日 下午9:49:11    
	 * 修改人：张文韬
	 * 修改时间：2018年11月1日 下午9:49:11    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void deleteUser(ZwtUser user);
	/** <pre>delclass(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月2日 下午8:43:07    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月2日 下午8:43:07    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void delclass(String classroomid);
	/** <pre>updateclass(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月2日 下午8:43:11    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月2日 下午8:43:11    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void updateclass(String classroomid);
    
	List<Course> querycoursebystudentid(String studentid);
	/** <pre>queryUserEntityByuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月2日 下午2:00:19    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月2日 下午2:00:19    
	 * 修改备注： 
	 * @param userid
	 * @return</pre>    
	 */
	User queryUserEntityByuserid(String userid);
	
    //查询全部的课程
	List<YunSchool> queryKeCheng(YunSchool subject);
   //文件上传
	void Upload(HashMap<String, Object> map);
	//查找文件
	HashMap<String, Object> findMongo(Integer pageSize, Integer start, File file);
	//新增文件
	void addmongo(File file);
	//删除文件
	void deleFile(String did);
	//查看图片
	GridFSDBFile findImgById(String ossName);
	//报表
	List<String> findChart();
	List<LinkedHashMap<String, Object>> findChartUser();
	List<Integer> findUsrByName(String string);
	/** <pre>addMoreClassRoom(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月6日 上午11:19:16    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月6日 上午11:19:16    
	 * 修改备注： 
	 * @param yunschool</pre>    
	 */
	void addMoreClassRoom(YunSchool yunschool);
	/** <pre>queryUser(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午6:47:45    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午6:47:45    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>    
	 */
	HashMap<String, Object> queryUser(Integer page, Integer rows);
	/** <pre>deleteuserbyuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午7:35:39    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午7:35:39    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteuserbyuserid(String id);
	/** <pre>deleteuserbyid(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月5日 下午8:16:46    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月5日 下午8:16:46    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	/** <pre>querySerializecourse(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月6日 上午9:04:29    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月6日 上午9:04:29    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param studentid 
	 * @return</pre>    
	 */
	/** <pre>querySerializecourse(这里用一句话描述这个方法的作用)   
	 * 创建人：杨同隆 565598097@qq.com 
	 * 创建时间：2018年11月6日 上午9:48:08    
	 * 修改人：杨同隆 565598097@qq.com  
	 * 修改时间：2018年11月6日 上午9:48:08    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param studentid
	 * @return</pre>    
	 */
	HashMap<String, Object> querySerializecourse(Integer page, Integer rows, String studentid);

	
	List<SonCourse> querycourseid(String id);
	/** <pre>delclass2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午1:57:43    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午1:57:43    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void delclass2(String classroomid);
	/** <pre>updateclass2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午1:57:47    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午1:57:47    
	 * 修改备注： 
	 * @param classroomid</pre>    
	 */
	void updateclass2(String classroomid);
	/** <pre>querySerializecourse1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午2:49:48    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午2:49:48    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>    
	 */
	HashMap<String, Object> querySerializecourse1(Integer page, Integer rows);
	/** <pre>findclass1(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午3:14:53    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午3:14:53    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param classroomname
	 * @param classroomproject
	 * @param id
	 * @return</pre>    
	 */
	Map<String, Object> findclass1(Integer pageSize, Integer start, String classroomname, String classroomproject,
			String id);
	/** <pre>querySerializecourse2(这里用一句话描述这个方法的作用)   
	 * 创建人：王硕 3190552680@qq.com     
	 * 创建时间：2018年11月7日 下午4:50:21    
	 * 修改人：王硕 3190552680@qq.com     
	 * 修改时间：2018年11月7日 下午4:50:21    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param studentid
	 * @return</pre>    
	 */
	HashMap<String, Object> querySerializecourse2(Integer page, Integer rows, String studentid);
	/** <pre>queryMoreYunSchoolPage(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午3:20:18    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午3:20:18    
	 * 修改备注： 
	 * @param yunschool
	 * @return</pre>    
	 */
	List<Xilike> queryMoreYunSchoolPage(Xilike xilieke);
	/** <pre>queryzikechenglist(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午4:26:19    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午4:26:19    
	 * 修改备注： 
	 * @param sonyunschool
	 * @return</pre>    
	 */
	List<SonYunSchool> queryzikechenglist(SonYunSchool sonyunschool);
	/** <pre>queryMoreYunSchoolById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月6日 下午6:36:52    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月6日 下午6:36:52    
	 * 修改备注： 
	 * @param xilieke
	 * @return</pre>    
	 */
	YunSchool queryMoreYunSchoolById(Xilike xilieke);
}
