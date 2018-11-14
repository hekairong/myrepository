/** 
 * <pre>项目名称:ssm-spring-boot 
 * 文件名称:UserService.java 
 * 包名:com.jk.service 
 * 创建日期:2018年11月12日下午4:19:22 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jk.mapper.UserMapper;
import com.jk.model.BookBean;
import com.jk.model.Tree;
import com.jk.model.User;

/** 
 * <pre>项目名称：ssm-spring-boot    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月12日 下午4:19:22    
 * 修改人：贺凯荣
 * 修改时间：2018年11月12日 下午4:19:22    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/** <pre>queryUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:54:40    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:54:40    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<User> queryUserList() {
		return userMapper.queryUserList();
	}

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:54:55    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:54:55    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	public void addUser(User user) {
		user.setId(UUID.randomUUID().toString());
		userMapper.addUser(user);
		
	}

	/** <pre>deleteUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:56:26    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:56:26    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	public void deleteUser(String ids) {
		userMapper.deleteUser(ids);
		
	}

	/** <pre>queryUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:56:30    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:56:30    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	public User queryUserById(User user) {
		return userMapper.queryUserById(user);
	}

	/** <pre>updateUser(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年11月12日 下午6:56:33    
	 * 修改人：贺凯荣
	 * 修改时间：2018年11月12日 下午6:56:33    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	public void updateUser(User user) {
		userMapper.updateUser(user);
		
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.tree.TreeService#queryTreeList()    
	 */
	@Override
	public List<Tree> queryTreeList() {
		List<Tree> treeAll =recursionTreed("0");
		System.out.println(treeAll);
		return treeAll;
	}

	private List<Tree> recursionTreed(String pid) {
		//根据id查询子节点列表
        List<Tree> trees = userMapper.recursionTree(pid);
        //判断查询到数据，则循环操作
        if(trees != null && trees.size()>0){
            for (int i = 0; i < trees.size(); i++) {
                //根据当前节点id查询新的子集列表，
                List<Tree> trees2 = recursionTreed(trees.get(i).getId().toString());
//              将列表set到当前树节点对象中
                trees.get(i).setNodes(trees2);
            }
        }
        return trees;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#queryBookList(java.lang.Integer, java.lang.Integer, com.jk.model.BookBean)    
	 */
	@Override
	public Map<String, Object> queryBookList(Integer pageSize, Integer start, BookBean bookBean) {
		Criteria criteriax=new Criteria();
		Query query = new Query();
		/*if(bookBean!=null){
			if(StringUtils.isNotEmpty(bookBean.getBookname())){
				Pattern compile = Pattern.compile("^.*"+bookBean.getBookname()+".*$",Pattern.CASE_INSENSITIVE);
				criteriax.and("bookname").regex(compile);
			}	
			if(bookBean.getMaxtime()!= null && bookBean.getMaxtime()!= "" && bookBean.getMintime()!= null && bookBean.getMintime()!= ""){
				query.addCriteria(Criteria.where("time").gt(bookBean.getMintime()));
			}else if(bookBean.getMaxtime()!= null && bookBean.getMaxtime()!= "" && bookBean.getMintime()!= null && bookBean.getMintime()!= ""){
				query.addCriteria(Criteria.where("time").gt(bookBean.getMaxtime()));
			}else if(bookBean.getMaxtime()!= null && bookBean.getMaxtime()!= "" && bookBean.getMintime()!= null && bookBean.getMintime()!= ""){
				Criteria criteriaMin = Criteria.where("time").gte(bookBean.getMintime());
				Criteria criteriaMax = Criteria.where("time").lt(bookBean.getMaxtime());
				query.addCriteria(criteriax.andOperator(criteriaMin,criteriaMax));
			}
		}*/
		query.addCriteria(criteriax);
		long count = mongoTemplate.count(query,"book");
		List<LinkedHashMap> find = mongoTemplate.find(query.skip(start).limit(pageSize),LinkedHashMap.class,"book");
		for (int i = 0; i < find.size(); i++) {
			HashMap hashMap = find.get(i);
			String type = (String) hashMap.get("type");
			HashMap findOne = mongoTemplate.findOne(new Query(Criteria.where("tid").is(type)),HashMap.class,"typeBean");
			hashMap.put("tname",findOne);
		}
		Map<String, Object> map=new HashMap<>();
		map.put("total",count);
		map.put("rows",find);
		return map;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#delbook(java.lang.String)    
	 */
	@Override
	public void delbook(String id) {
		String[] idss = id.split(",");
		for (int i = 0; i < idss.length; i++) {
			
			mongoTemplate.remove(new Query(Criteria.where("bookid").in(idss[i])),"book");
		}
		
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#updateUser(com.jk.model.BookBean)    
	 */
	@Override
	public void updateUser(BookBean bookBean) {
		mongoTemplate.updateFirst(new Query(Criteria.where("bookid").is(bookBean.getBookid())),new Update().set("bookname",bookBean.getBookname()).set("price",bookBean.getPrice()).set("time", bookBean.getTime()),BookBean.class);
		
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#queryBookById(java.lang.String)    
	 */
	@Override
	public BookBean queryBookById(String id) {
		BookBean book = mongoTemplate.findOne(new Query(Criteria.where("bookid").is(id)),BookBean.class);
		return book;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.UserService#addBook(java.util.HashMap)    
	 */
	@Override
	public void addBook(HashMap<String, Object> hashMap) {
		hashMap.put("bookid",UUID.randomUUID().toString());
		mongoTemplate.insert(hashMap,"book");
		
	}

}
