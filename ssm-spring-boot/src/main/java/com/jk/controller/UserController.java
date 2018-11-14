/** 
 * <pre>项目名称:ssm-spring-boot 
 * 文件名称:UserController.java 
 * 包名:com.jk.controller 
 * 创建日期:2018年11月12日下午3:01:40 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.BookBean;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;

/** 
 * <pre>项目名称：ssm-spring-boot    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年11月12日 下午3:01:40    
 * 修改人：贺凯荣
 * 修改时间：2018年11月12日 下午3:01:40    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
//	@RequestMapping("queryTreeList")
//	@ResponseBody
//	public List<Tree> queryTreeList(){
//		List<Tree> list = userService.queryTreeList();
//		return list;
//		
//	}
//	
//	@RequestMapping("queryUserList")
//	@ResponseBody
//	public List<User> queryUserList(){
//		List<User> list = userService.queryUserList();
//		return list;
//	}
//	
//	@RequestMapping("addUser")
//	@ResponseBody
//	public String addUser(User user){
//		userService.addUser(user);
//		return "1";
//	}
//	
//	@RequestMapping("deleteUser")
//	@ResponseBody
//	public String deleteUser(String ids){
//		userService.deleteUser(ids);
//		return "1";
//		
//	}
//	
//	@RequestMapping("queryUserById")
//	public String queryUserById(User user,Model model){
//		User userlist = userService.queryUserById(user);
//		model.addAttribute("hx", userlist);
//		return "edit";
//		
//	}
//	
//	@RequestMapping("updateUser")
//	@ResponseBody
//	public String updateUser(User user){
//		userService.updateUser(user);
//		return "1";
//		
//	}
//	
	// 查询book表
	@RequestMapping("queryBookList")
	@ResponseBody
	public Map<String, Object> queryBookList(Integer pageSize, Integer start, BookBean bookBean) {
		return userService.queryBookList(pageSize, start, bookBean);
	}
	
//	//新增book
//	@RequestMapping("addBook")
//	@ResponseBody
//	public void addBook(BookBean bookBean) {
//		List<BookBean> busList = bookBean.getBusList();
//		try {
//			for (int i = 0; i < busList.size(); i++) {
//				// BusBean busBean = list.get(i);
//				mongoTemplate.save(busList.get(i), "book");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//
//	}
//	
//	// 删除
//	@RequestMapping("delbook")
//	@ResponseBody
//	public String delbook(String id) {
//		userService.delbook(id);
//		return "{}";
//	}
//	
//	//修改
//	@RequestMapping("updateUser")
//	@ResponseBody
//	public String updateUser(BookBean bookBean) {
//		userService.updateUser(bookBean);
//		return "1";
//	}
//
//	// 通过id查询用户信息
//	@RequestMapping("queryBookById")
//	public String queryBookById(String id, Model model) {
//		BookBean booklist = userService.queryBookById(id);
//		model.addAttribute("hx", booklist);
//		return "WEB-INF/book/dialog2";
//	}
	
	

}
