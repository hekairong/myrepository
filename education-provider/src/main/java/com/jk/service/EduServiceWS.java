/** 
 * <pre>项目名称:education-provider 
 * 文件名称:EduServiceWS.java 
 * 包名:com.jk.service 
 * 创建日期:2018年10月29日下午5:01:49 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.IeduDaoWS;
import com.jk.mapper.yunschool.YunSchoolMapper;
import com.jk.model.Course;
import com.jk.model.Org;
import com.jk.model.SonCourse;
import com.jk.model.StuTree;
import com.jk.model.User;
import com.jk.model.WSmodel;
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
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

/** 
 * <pre>项目名称：education-provider    
 * 类名称：EduServiceWS    
 * 类描述：    
 * 创建人：王硕 3190552680@qq.com    
 * 创建时间：2018年10月29日 下午5:01:49    
 * 修改人：王硕 3190552680@qq.com  
 * 修改时间：2018年10月29日 下午5:01:49    
 * 修改备注：       
 * @version </pre>    
 */
public class EduServiceWS implements IeduService {
	
	@Autowired
	private YunSchoolMapper yunSchoolMapper;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired IeduDaoWS ieduDaoWS;
	
	//测试链接
	@Override
	public String test() {

		String ff = "哈哈";
		
		return ff;
	}
	//
	@Override
	public void deleteuserbyuserid(String id) {
		// TODO Auto-generated method stub
		yunSchoolMapper.deleteuserbyuserid(id);
	}
	
	//
	@Override
	public List<Tree> queryTeacherTree(String userid) {
		List<Tree> treeAll =recursionTreed("0",userid);
		System.out.println(treeAll);
		return treeAll;
	}
	
	private List<Tree> recursionTreed(String pid, String userid) {
		//根据id查询子节点列表
        List<Tree> trees = yunSchoolMapper.recursionTree(pid,userid);
        //判断查询到数据，则循环操作
        if(trees != null && trees.size()>0){
            for (int i = 0; i < trees.size(); i++) {
                //根据当前节点id查询新的子集列表，
                List<Tree> trees2 = recursionTreed(trees.get(i).getId().toString(),userid);
//              将列表set到当前树节点对象中
                trees.get(i).setNodes(trees2);
            }
        }
        return trees;
	}

	//登录
	@Override
	public HashMap<String, Object> getLogin(String username, String userpassword) {

		HashMap<String, Object> mmp = new HashMap<String, Object>();
		String hh = "";
		
		WSmodel list1 = ieduDaoWS.getLogin1(username);
		
		if(list1!=null){
			String userpassword2 = list1.getUserpassword();
			System.out.println(userpassword2);
			if(userpassword.equals(userpassword2)){
				
				hh = "1";
				
				mmp.put("user", list1);
				mmp.put("n", hh);
				
				return mmp;
				
			}else{
				
				hh = "2";
				mmp.put("user", null);
				mmp.put("n", hh);
				
				return mmp;
				
			}
			
		}else{
			
			hh = "3";
			mmp.put("user", null);
			mmp.put("n", hh);
			
			return mmp;
			
		}

	}

	

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#addClassRoom(com.jk.model.yunschool.YunSchool)    
	 */
	@Override
	public void addClassRoom(YunSchool yunschool) {
		
		String uuidstring = UUID.randomUUID().toString();
		yunschool.setClassroomid(uuidstring);
        String classroomstudent = yunschool.getClassroomstudent();
        String[] split = classroomstudent.split(",");
        for (int i = 0; i < split.length; i++) {
        	String uuidstring1 = UUID.randomUUID().toString();
			
        	yunSchoolMapper.addclassstu(uuidstring1,uuidstring,split[i]);
		}
		yunSchoolMapper.addClassRoom(yunschool);
		
	}

	//
	@Override
	public Map<String, Object> findclass(Integer pageSize, Integer start,String classroomname,String classroomproject) {
		List<WSmodel> list = ieduDaoWS.findclass(pageSize,start,classroomname,classroomproject);
		Integer gg = ieduDaoWS.findtotal(classroomname,classroomproject);
		Map<String, Object> mmp = new HashMap<>();
		mmp.put("rows", list);
		mmp.put("total", gg);
		return mmp;
	}
	//
	@Override
	public Map<String, Object> findclass1(Integer pageSize, Integer start,String classroomname,String classroomproject,String id) {
		List<WSmodel> list = ieduDaoWS.findclass1(pageSize,start,classroomname,classroomproject,id);
		Integer gg = ieduDaoWS.findtotal1(classroomname,classroomproject,id);
		Map<String, Object> mmp = new HashMap<>();
		mmp.put("rows", list);
		mmp.put("total", gg);
		return mmp;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#querySubjectList()    
	 */
	@Override
	public List<Subject> querySubjectList() {
		return yunSchoolMapper.querySubjectList();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryTeacherList()    
	 */
	@Override
	public List<Teacher> queryTeacherList() {
		return yunSchoolMapper.queryTeacherList();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryHelpTeacherList()    
	 */
	@Override
	public List<HelpTeacher> queryHelpTeacherList() {
		return yunSchoolMapper.queryHelpTeacherList();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryStudentList()    
	 */
	@Override
	public List<Student> queryStudentList() {
		return yunSchoolMapper.queryStudentList();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#myCloudSchool(com.jk.model.yunschool.YunSchool)    
	 */
	@Override
	public List<YunSchool> myCloudSchool(YunSchool yunschool) {
		return yunSchoolMapper.myCloudSchool(yunschool);
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryYunSchoolById(com.jk.model.yunschool.YunSchool)    
	 */
	@Override
	public YunSchool queryYunSchoolById(YunSchool yunschool) {
		return yunSchoolMapper.queryYunSchoolById(yunschool);
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryYunSchoolPage(com.jk.model.yunschool.YunSchool)    
	 */
	@Override
	public List<YunSchool> queryYunSchoolPage(YunSchool yunschool) {
		return yunSchoolMapper.queryYunSchoolPage();
	}


	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#selectcourse()    
	 */
	@Override
	public List<Course> selectcourse(String uerid) {
		
		return yunSchoolMapper.selectcourse(uerid);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#selectTree()    
	 */
	@Override
	public List<StuTree> selectTree() {
	
//		String id="0";
//		return getNodes(id);
		return yunSchoolMapper.selectTree();
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.IeduService#queryType()    
	 */
	@Override
	public List queryType() {
		
		List list = ieduDaoWS.queryType();
		
		return list;
	}
	
	//
	@Override
	public JSONObject queryUserList(ZwtUser user, Integer offset, Integer limit) {
		JSONObject json =new JSONObject();
		Long count =ieduDaoWS.queryUserCount(user);
		List<ZwtUser> users=ieduDaoWS.queryUserList(user,offset,limit);
		json.put("total", count);
		json.put("rows",users);
		return json;
	}

	//
	@Override
	public ZwtUser queryOneUser(ZwtUser user) {
		ZwtUser users = ieduDaoWS.queryOneUser(user);
		return users;
	}

	//
	@Override
	public void updateUser(ZwtUser user) {
		ieduDaoWS.updateUser(user.getPowerid(),user.getUserid(),user.getUsername(),user.getUserpassword());
	}

	//
	@Override
	public void deleteUser(ZwtUser user) {
		ieduDaoWS.deleteUser(user.getUserid());
	}

	//管理员删除课程
	@Override
	public void delclass(String classroomid) {
		
		ieduDaoWS.delclass(classroomid);
		
	}

	//管理员审核课程
	@Override
	public void updateclass(String classroomid) {

		ieduDaoWS.updateclass(classroomid);
		
	}
	
	//管理员删除课程
	@Override
	public void delclass2(String classroomid) {
		
		ieduDaoWS.delclass2(classroomid);
		
	}
	
	//管理员审核课程
	@Override
	public void updateclass2(String classroomid) {
		
		ieduDaoWS.updateclass2(classroomid);
		
	}

	//
	@Override
	public List<Course> querycoursebystudentid(String studentid) {
		return yunSchoolMapper.querycoursebystudentid(studentid);
	}

	//
	@Override
	public User queryUserEntityByuserid(String userid) {
		return yunSchoolMapper.queryUserEntityByuserid(userid);
	}

	//
	@Override
	public int addorg(Org org) {
		return 0;
	}

	//
	@Override
	public void addstudent(Student student) {
		yunSchoolMapper.addstudent(student);
	}

	//
	@Override
	public void addteacher(Teacher teacher) {
		yunSchoolMapper.addteacher(teacher);
	}

	//
	@Override
	public void adduser(User user) {
		yunSchoolMapper.adduser(user);
	}
	
    //查询全部课程
	@Override
	public List<YunSchool> queryKeCheng(YunSchool subject) {
	 
		return ieduDaoWS.queryKeCheng(subject);
	}
    //文件上传
	@Override
	public void Upload(HashMap<String, Object> map) {
		mongoTemplate.insert(map,"file");
	}
	//查找文件
	@Override
	public HashMap<String, Object> findMongo(Integer pageSize, Integer start, File file) {
		Query query = new Query();
		if (file != null) {
			//模糊查询
			if (StringUtils.isNotEmpty(file.getFilename())) {
				// 返回 java 正则 ‘^. $’
				Pattern xx = Pattern.compile("^.*" + file.getFilename() + ".*$", Pattern.CASE_INSENSITIVE);
				query.addCriteria(Criteria.where("filename").regex(xx));

			}
		}
		long count = mongoTemplate.count(query, "file");
		List<File> find = mongoTemplate.find(query.skip(start).limit(pageSize),File.class);
		HashMap<String, Object> map=new HashMap<>();
		map.put("total",count);
		map.put("rows",find);
		return  map;
	}
	//新增文件
	@Override
	public void addmongo(File file) {
		file.setFileid(UUID.randomUUID().toString());
		mongoTemplate.insert(file);
		
	}
	//删除文件
	@Override
	public void deleFile(String did) {
		String[] idss = did.split(",");
		for (int i = 0; i < idss.length; i++) {
	 mongoTemplate.remove(new Query(Criteria.where("fileid").in(idss[i])), "file");
		}
		
		
	}
	//查找图片
	@Override
	public GridFSDBFile findImgById(String ossName) {
		DBObject query = new BasicDBObject("ossName", ossName);
		GridFS gridFS = new GridFS(mongoTemplate.getDb());
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		return gridFSDBFile;
	}
   //报表
	@Override
	public List<LinkedHashMap<String, Object>> findChartUser() {
	 
		return ieduDaoWS.findChartUser();
	}
	@Override
	public List<Integer> findUsrByName(String string) {
		
		List<String> hh = ieduDaoWS.findUsrByName(string);
		List<Integer> hhh = hh.stream().map(Integer::parseInt).collect(Collectors.toList());
		return hhh;
	}
	@Override
	public List<String> findChart() {
		 
		return ieduDaoWS.findChart();
	}

	//
	@Override
	public void addMoreClassRoom(YunSchool yunschool) {
		
		String string1 = UUID.randomUUID().toString();
		ieduDaoWS.addMoreClassRoom(string1,yunschool);
		
		List<YunSchool> format = yunschool.getFormat();
		for (int i = 0; i < format.size(); i++) {
			String string2 = UUID.randomUUID().toString();
			ieduDaoWS.addMoreClassRoom2(string2,string1,format.get(i).getSoncoursename(),format.get(i).getSoncoursestarttime(),format.get(i).getSoncourseendtime());
		}
		
	}
	
@Override
public HashMap<String, Object> queryUser(Integer page, Integer rows) {
	HashMap<String, Object> map = new HashMap<>();
	long count=yunSchoolMapper.queryCount();
	List<User> ulist=yunSchoolMapper.queryUser(page-1,rows);
	map.put("total", count);
	map.put("rows", ulist);
	return map;
}
//
@Override
public HashMap<String, Object> querySerializecourse(Integer page, Integer rows,String studentid) {
	HashMap<String, Object> map = new HashMap<>();
	long count=yunSchoolMapper.queryserializeCount(studentid);
	List<YunSchool> ulist=yunSchoolMapper.querySerializecourse(page,rows,studentid);
	map.put("total", count);
	map.put("rows", ulist);
	return map;
}
//
@Override
public HashMap<String, Object> querySerializecourse2(Integer page, Integer rows,String studentid) {
	HashMap<String, Object> map = new HashMap<>();
	long count=yunSchoolMapper.queryserializeCount2(studentid);
	List<YunSchool> ulist=yunSchoolMapper.querySerializecourse2(page,rows,studentid);
	map.put("total", count);
	map.put("rows", ulist);
	return map;
}
//
@Override
public HashMap<String, Object> querySerializecourse1(Integer page, Integer rows) {
	HashMap<String, Object> map = new HashMap<>();
	long count=yunSchoolMapper.queryserializeCount1();
	List<YunSchool> ulist=yunSchoolMapper.querySerializecourse1(page,rows);
	map.put("total", count);
	map.put("rows", ulist);
	return map;
}

//
@Override
public List<SonCourse> querycourseid(String id) {
	return yunSchoolMapper.querycourseid(id);
}
/* (non-Javadoc)    
 * @see com.jk.service.IeduService#queryMoreYunSchoolPage(com.jk.model.yunschool.YunSchool)    
 */
@Override
public List<Xilike> queryMoreYunSchoolPage(Xilike xilieke) {
	return yunSchoolMapper.queryMoreYunSchoolPage(xilieke);
}

/* (non-Javadoc)    
 * @see com.jk.service.IeduService#queryzikechenglist(com.jk.model.yunschool.SonYunSchool)    
 */
@Override
public List<SonYunSchool> queryzikechenglist(SonYunSchool sonyunschool) {
	return yunSchoolMapper.queryzikechenglist(sonyunschool);
}

@Override
public YunSchool queryMoreYunSchoolById(Xilike xilieke) {
	return yunSchoolMapper.queryMoreYunSchoolById(xilieke);
}

}
/*	//
	@Override
	public HashMap<String, Object> ImgUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	//
	@Override
	public GridFSDBFile findImgById(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/

/* (non-Javadoc)    
 * @see com.jk.service.IeduService#queryUser(java.lang.Integer, java.lang.Integer)    
 */